package pe.resource.casadecambio.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import pe.resource.casadecambio.dto.response.ServiceResponse;
import pe.resource.casadecambio.dto.TipoCambioDTO;
import pe.resource.casadecambio.dto.UpdateTasaCambioRequest;
import pe.resource.casadecambio.service.TipoCambioService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

import static pe.resource.casadecambio.util.AppConstants.ID_POSITIVE;
import static pe.resource.casadecambio.util.AppConstants.SUCCESS;

@Validated
@RestController
@RequestMapping("/api/tipos-cambio")
@RequiredArgsConstructor
@Tag(name = "TIPO CAMBIO", description = "Operaciones permitidas sobre la entidad Tipo de Cambio")
public class TipoCambioController {

    private final TipoCambioService service;

    @Operation(summary = "Obtener lista de tipos de cambio")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ServiceResponse<List<TipoCambioDTO>> getAllTiposCambio() {
        List<TipoCambioDTO> tipoCambioResponse = service.findAll();
        return new ResponseEntity<>(new ServiceResponse<>(SUCCESS,
                String.valueOf(HttpStatus.OK), tipoCambioResponse), HttpStatus.OK).getBody();
    }


    @Operation(summary = "Crear tasa de cambio")
    @ApiResponse(responseCode = "201", description = "Tipo de cambio creado exitosamente")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<TipoCambioDTO>> createTipoCambio(@RequestBody @Valid TipoCambioDTO request) {
        TipoCambioDTO tipoCambioDTO = service.save(request);
        return new ResponseEntity<>(new ServiceResponse<>(SUCCESS,
                String.valueOf(HttpStatus.CREATED), tipoCambioDTO), HttpStatus.CREATED);
    }


    @Operation(summary = "Editar tasa de cambio")
    @PutMapping(value = "/{id}/tasa", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<TipoCambioDTO>> updateTasaCambio(@Positive(message = ID_POSITIVE) @PathVariable Long id,
                                                                           @RequestBody @Valid UpdateTasaCambioRequest nuevaTasa) {
        TipoCambioDTO tipoCambioDTO = service.updateTasaCambio(id, nuevaTasa);
        return new ResponseEntity<>(new ServiceResponse<>(SUCCESS,
                String.valueOf(HttpStatus.OK), tipoCambioDTO), HttpStatus.OK);
    }



}









