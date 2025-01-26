package pe.resource.casadecambio.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.resource.casadecambio.dto.TipoCambioDTO;
import pe.resource.casadecambio.dto.UpdateTasaCambioRequest;
import pe.resource.casadecambio.dto.mapper.TipoCambioMapper;
import pe.resource.casadecambio.entity.TipoCambio;
import pe.resource.casadecambio.exceptions.BusinessException;
import pe.resource.casadecambio.repository.MonedaRepository;
import pe.resource.casadecambio.repository.TipoCambioRepository;
import pe.resource.casadecambio.service.TipoCambioService;

import java.util.List;

import static pe.resource.casadecambio.util.AppConstants.*;

@Service
@RequiredArgsConstructor
public class TipoCambioServiceImpl implements TipoCambioService {

    private final TipoCambioRepository repository;
    private final MonedaRepository monedaRepository;

    @Override
    @Transactional(readOnly = true)
    public List<TipoCambioDTO> findAll() {
        List<TipoCambioDTO> tipoCambioResponse = repository.findAll().stream()
                .map(TipoCambioMapper::toDto)
                .toList();

        if (tipoCambioResponse.isEmpty()) {
            throw new BusinessException("P-204", HttpStatus.NO_CONTENT, "Lista Vaciá de Tipo Cambio");
        } else {
            return tipoCambioResponse;
        }
    }



    @Override
    @Transactional
    public TipoCambioDTO save(TipoCambioDTO tipoCambioDTO) {
        TipoCambio tipoCambio = TipoCambioMapper.toEntity(tipoCambioDTO);

        tipoCambio.setMonedaOrigen(monedaRepository.findById(tipoCambioDTO.getMonedaOrigen().getId())
                .orElseThrow(() -> new BusinessException(BAD_REQUEST, HttpStatus.NOT_FOUND, BAD_REQUEST_ORIGEN + tipoCambioDTO.getMonedaOrigen().getId())));

        tipoCambio.setMonedaDestino(monedaRepository.findById(tipoCambioDTO.getMonedaDestino().getId())
                .orElseThrow(() -> new BusinessException(BAD_REQUEST, HttpStatus.NOT_FOUND, BAD_REQUEST_DESTINO + tipoCambioDTO.getMonedaDestino().getId())));

        TipoCambio savedTipoCambio = repository.save(tipoCambio);
        return TipoCambioMapper.toDto(savedTipoCambio);
    }


    @Override
    @Transactional
    public TipoCambioDTO updateTasaCambio(Long id, UpdateTasaCambioRequest nuevaTasa) {
        TipoCambio tipoCambioOpt = repository.findById(id)
                .orElseThrow(() -> new BusinessException(BAD_REQUEST, HttpStatus.NOT_FOUND, BAD_REQUEST_TIPO_CAMBIO + id));

        TipoCambio tipoCambio = tipoCambioOpt;
        tipoCambio.setTasaCambio(nuevaTasa.getNuevaTasa());
        TipoCambio updatedTipoCambio = repository.save(tipoCambio);
        return TipoCambioMapper.toDto(updatedTipoCambio);
    }
}
