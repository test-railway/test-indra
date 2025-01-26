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
public class TransaccionDTO {
    private Long id;

    @Schema(
            description = "Monto de la transacción",
            example = "100.0"
    )
    @NotNull(message = "El monto no debe ser nulo")
    @Min(value = 1, message = "El monto debe ser mayor o igual a 1")
    private Double monto;


    private Double montoConvertido;

    @Schema(
            description = "ID del tipo de cambio",
            example = "1"
    )
    @NotNull(message = "El ID del tipo de cambio no debe ser nulo")
    private Long tipoCambioId;
    private TipoCambioDTO tipoCambio;


}
