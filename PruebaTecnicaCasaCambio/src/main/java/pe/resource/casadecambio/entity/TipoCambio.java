package pe.resource.casadecambio.entity;

import javax.persistence.*;

import lombok.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoCambio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Double tasaCambio;

    @ManyToOne
    private Moneda monedaOrigen;

    @ManyToOne
    private Moneda monedaDestino;


}