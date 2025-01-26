package pe.resource.casadecambio.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.resource.casadecambio.dto.TransaccionDTO;
import pe.resource.casadecambio.entity.Transaccion;
import pe.resource.casadecambio.dto.mapper.TransaccionMapper;
import pe.resource.casadecambio.exceptions.BusinessException;
import pe.resource.casadecambio.repository.TipoCambioRepository;
import pe.resource.casadecambio.repository.TransaccionRepository;
import pe.resource.casadecambio.service.TransaccionService;

import java.util.List;

import static pe.resource.casadecambio.util.AppConstants.*;

@Service
@RequiredArgsConstructor
public class TransaccionServiceImpl implements TransaccionService {

    private final TransaccionRepository repository;
    private final TipoCambioRepository tipoCambioRepository;


    @Override
    @Transactional(readOnly = true)
    public List<TransaccionDTO> findAll() {
        return repository.findAll().stream()
                .map(TransaccionMapper::toDTO)
                .toList();
    }

    @Override
    @Transactional
    public TransaccionDTO updateTransaccion(Long id, TransaccionDTO transaccionDetails) {
        Transaccion transaccion = repository.findById(id)
                .orElseThrow(() -> new BusinessException(BAD_REQUEST, HttpStatus.NOT_FOUND, BAD_REQUEST_TRANSACTION + id));
        transaccion.setMonto(transaccionDetails.getMonto());
        transaccion.setMontoConvertido(transaccionDetails.getMonto() * transaccion.getTipoCambio().getTasaCambio());
        transaccion.setTipoCambio(tipoCambioRepository.findById(transaccionDetails.getTipoCambioId())
                .orElseThrow(() -> new BusinessException(BAD_REQUEST, HttpStatus.NOT_FOUND, BAD_REQUEST_TIPO_CAMBIO + transaccionDetails.getTipoCambioId())));

        Transaccion updatedTransaccion = repository.save(transaccion);
        return TransaccionMapper.toDTO(updatedTransaccion);
    }

    @Override
    @Transactional
    public TransaccionDTO save(TransaccionDTO transaccionDTO) {
        Transaccion transaccion = TransaccionMapper.toEntity(transaccionDTO);
        transaccion.setTipoCambio(tipoCambioRepository.findById(transaccionDTO.getTipoCambioId())
                .orElseThrow(() -> new BusinessException(BAD_REQUEST, HttpStatus.NOT_FOUND, BAD_REQUEST_TIPO_CAMBIO + transaccionDTO.getTipoCambioId())));
        transaccion.setMontoConvertido(transaccion.getMonto() * transaccion.getTipoCambio().getTasaCambio());
        Transaccion savedTransaccion = repository.save(transaccion);
        return TransaccionMapper.toDTO(savedTransaccion);
    }


}