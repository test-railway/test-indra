package pe.resource.casadecambio.dto.mapper;

import pe.resource.casadecambio.dto.MonedaDTO;
import pe.resource.casadecambio.entity.Moneda;

public class MonedaMapper {

    public static MonedaDTO toDto(Moneda moneda) {
        return MonedaDTO.builder()
                .id(moneda.getId())
                .codigo(moneda.getCodigo())
                .nombre(moneda.getNombre())
                .build();
    }




    public static Moneda toEntity(MonedaDTO monedaDTO) {
        return Moneda.builder()
                .id(monedaDTO.getId())
                .codigo(monedaDTO.getCodigo())
                .nombre(monedaDTO.getNombre())
                .build();
    }


}