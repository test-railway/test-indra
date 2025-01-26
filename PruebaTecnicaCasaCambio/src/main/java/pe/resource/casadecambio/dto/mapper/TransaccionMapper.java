package pe.resource.casadecambio.dto.mapper;

import pe.resource.casadecambio.dto.TransaccionDTO;
import pe.resource.casadecambio.entity.TipoCambio;
import pe.resource.casadecambio.entity.Transaccion;

public class TransaccionMapper {

    public static TransaccionDTO toDTO(Transaccion transaccion) {
        return TransaccionDTO.builder()
                .id(transaccion.getId())
                .monto(transaccion.getMonto())
                .montoConvertido(transaccion.getMontoConvertido())
                .tipoCambioId(transaccion.getTipoCambio().getId())
                .tipoCambio(TipoCambioMapper.toDto(transaccion.getTipoCambio()))
                .build();
    }

    public static Transaccion toEntity(TransaccionDTO transaccionDTO) {
        return Transaccion.builder()
                .id(transaccionDTO.getId())
                .monto(transaccionDTO.getMonto())
                .montoConvertido(transaccionDTO.getMontoConvertido())
                .build();
    }
}