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
import pe.resource.casadecambio.dto.TransaccionDTO;

import pe.resource.casadecambio.service.TransaccionService;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

import static pe.resource.casadecambio.util.AppConstants.ID_POSITIVE;
import static pe.resource.casadecambio.util.AppConstants.SUCCESS;

@Validated
@RestController
@RequestMapping("/api/transacciones")
@RequiredArgsConstructor
@Tag(name = "TRANSACCIONES", description = "Operaciones permitidas sobre la entidad Transaccion")
public class TransaccionController {

    private final TransaccionService service;

    @Operation(summary = "Obtener lista de transacciones")
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<List<TransaccionDTO>>> getAllTransacciones() {
        List<TransaccionDTO> transaccionResponse = service.findAll();
        return new ResponseEntity<>(new ServiceResponse<>(SUCCESS,
                String.valueOf(HttpStatus.OK), transaccionResponse), HttpStatus.OK);    }


    @ApiResponse(responseCode = "201", description = "Transaccion creada exitosamente")
    @PostMapping(value = "/create", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<TransaccionDTO>> createTransaccion(@RequestBody @Valid TransaccionDTO request) {
        TransaccionDTO transaccionDTO = service.save(request);
        return new ResponseEntity<>(new ServiceResponse<>(SUCCESS,
                String.valueOf(HttpStatus.CREATED), transaccionDTO), HttpStatus.CREATED);
    }

    @Operation(summary = "Actualizar transaccion")
    @PutMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ServiceResponse<TransaccionDTO>> updateTransaccion(@Positive(message = ID_POSITIVE) @PathVariable Long id,
                                                                             @RequestBody @Valid TransaccionDTO request) {

        TransaccionDTO tipoCambioDTO = service.updateTransaccion(id, request);
        return new ResponseEntity<>(new ServiceResponse<>(SUCCESS,
                String.valueOf(HttpStatus.OK), tipoCambioDTO), HttpStatus.OK);
    }


}
