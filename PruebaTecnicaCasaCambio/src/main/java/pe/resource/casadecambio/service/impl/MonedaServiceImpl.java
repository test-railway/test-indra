package pe.resource.casadecambio.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.resource.casadecambio.dto.MonedaDTO;
import pe.resource.casadecambio.dto.mapper.MonedaMapper;
import pe.resource.casadecambio.exceptions.BusinessException;
import pe.resource.casadecambio.repository.MonedaRepository;
import pe.resource.casadecambio.service.MonedaService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MonedaServiceImpl implements MonedaService {


    private final MonedaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<MonedaDTO> findAll() {
        List<MonedaDTO> monedas = repository.findAll().stream()
                .map(MonedaMapper::toDto)
                .toList();

        if (monedas.isEmpty()) {
            throw new BusinessException("P-204", HttpStatus.NO_CONTENT, "Lista Vaciá de monedas");
        } else {
            return monedas;
        }
    }


}
