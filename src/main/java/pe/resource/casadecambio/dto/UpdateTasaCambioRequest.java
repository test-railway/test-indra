package pe.resource.casadecambio.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class UpdateTasaCambioRequest {

    @Schema(
            description = "Nueva tasa de cambio",
            example = "3.75"
    )
    @NotNull(message = "La nueva tasa no debe ser nula")
    @Min(value = 1, message = "La nueva tasa debe ser mayor o igual a 0")
    private Double nuevaTasa;

}
