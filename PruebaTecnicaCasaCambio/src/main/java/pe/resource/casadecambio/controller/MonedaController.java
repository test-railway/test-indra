package pe.resource.casadecambio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.resource.casadecambio.dto.MonedaDTO;
import pe.resource.casadecambio.dto.response.ServiceResponse;
import pe.resource.casadecambio.service.MonedaService;

import java.util.List;

import static pe.resource.casadecambio.util.AppConstants.SUCCESS;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/moneda")
@Tag(name = "MONEDA", description = "Operaciones permitidas sobre la entidad Moneda")
public class MonedaController {

    private final MonedaService service;

    @Operation(summary = "Obtener lista de monedas")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<List<MonedaDTO>>> getAllMonedas() {
        List<MonedaDTO> monedasResponse = service.findAll();
        return new ResponseEntity<>(new ServiceResponse<>(SUCCESS,
                String.valueOf(HttpStatus.OK), monedasResponse), HttpStatus.OK);
    }


}
