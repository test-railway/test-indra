package pe.resource.casadecambio.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MonedaDTO {
    
    private Long id;
    private String codigo;
    private String nombre;


}
