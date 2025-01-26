package pe.resource.casadecambio.service;

import pe.resource.casadecambio.dto.MonedaDTO;

import java.util.List;

public interface MonedaService {
    List<MonedaDTO> findAll();

}
