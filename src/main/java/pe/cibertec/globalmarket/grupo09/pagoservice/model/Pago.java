package pe.cibertec.globalmarket.grupo09.pagoservice.model;

import java.time.LocalDateTime;

public record Pago(
        Long idPago,
        Long idPedido,
        Long clienteId,
        String metodoPago,
        Double montoPagado,
        LocalDateTime fechaPago,
        String codigoAutorizacion,
        String estadoPago
) {
}
