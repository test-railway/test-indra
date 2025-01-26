package pe.resource.casadecambio.service;

import pe.resource.casadecambio.dto.TransaccionDTO;

import java.util.List;

public interface TransaccionService {
    List<TransaccionDTO> findAll();

    TransaccionDTO updateTransaccion(Long id, TransaccionDTO transaccionDTO);
    TransaccionDTO save(TransaccionDTO transaccionDTO);

}