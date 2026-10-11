package pe.cibertec.globalmarket.grupo09.pagoservice.dto;

import java.time.LocalDateTime;

public record PagoDTO(
        Long idPago,
        Long idPedido,
        String metodoPago,
        Double montoPagado,
        LocalDateTime fechaPago,
        String codigoAutorizacion,
        String estadoPago
) {
}
