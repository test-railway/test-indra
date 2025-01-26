package pe.resource.casadecambio.util;

import lombok.experimental.UtilityClass;

@UtilityClass
public class AppConstants {


    // PRODUCTS ERRORS
    public static final String BAD_REQUEST = "P-404";
    public static final String BAD_REQUEST_ORIGEN = "Moneda origen not found for id: ";
    public static final String BAD_REQUEST_DESTINO = "Moneda destino not found for id: ";
    public static final String BAD_REQUEST_TRANSACTION = "Transaccion not found for this id :: ";
    public static final String BAD_REQUEST_TIPO_CAMBIO = "Tipo de cambio not found for this id :: ";

    //MESSAGE CONTROLLER
    public static final String SUCCESS = "Operación exitosa";
    public static final String ID_POSITIVE = "el ID solo acepta numeros positivos";



}
