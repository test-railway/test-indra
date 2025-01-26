package pe.resource.casadecambio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambioDTO {
    private Long id;

    @Schema(
            description = "Tasa de cambio",
            example = "3.75"
    )
    @NotNull(message = "La tasa de cambio no debe ser nula")
    @Min(value = 1, message = "La tasa de cambio debe ser mayor o igual a 1")
    private Double tasaCambio;
    private MonedaDTO monedaOrigen;
    private MonedaDTO monedaDestino;


}