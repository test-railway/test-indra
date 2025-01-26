package pe.resource.casadecambio.service;

import pe.resource.casadecambio.dto.TipoCambioDTO;
import pe.resource.casadecambio.dto.UpdateTasaCambioRequest;

import java.util.List;

public interface TipoCambioService {
    List<TipoCambioDTO> findAll();

    TipoCambioDTO save(TipoCambioDTO tipoCambioDTO);
    TipoCambioDTO updateTasaCambio(Long id, UpdateTasaCambioRequest nuevaTasa);


}