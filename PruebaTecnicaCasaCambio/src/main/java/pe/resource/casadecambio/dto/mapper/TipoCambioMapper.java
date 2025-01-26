package pe.resource.casadecambio.dto.mapper;

import pe.resource.casadecambio.dto.TipoCambioDTO;
import pe.resource.casadecambio.entity.TipoCambio;

public class TipoCambioMapper {

    public static TipoCambioDTO toDto(TipoCambio tipoCambio) {
        return TipoCambioDTO.builder()
                .id(tipoCambio.getId())
                .tasaCambio(tipoCambio.getTasaCambio())
                .monedaOrigen(MonedaMapper.toDto(tipoCambio.getMonedaOrigen()))
                .monedaDestino(MonedaMapper.toDto(tipoCambio.getMonedaDestino()))
                .build();
    }

    public static TipoCambio toEntity(TipoCambioDTO tipoCambioDTO) {
        return TipoCambio.builder()
                .id(tipoCambioDTO.getId())
                .tasaCambio(tipoCambioDTO.getTasaCambio())
                .monedaOrigen(MonedaMapper.toEntity(tipoCambioDTO.getMonedaOrigen()))
                .monedaDestino(MonedaMapper.toEntity(tipoCambioDTO.getMonedaDestino()))
                .build();
    }

}
