package com.example.pago_service_grupo09.model;

import com.example.pago_service_grupo09.dto.PagoDTO;

public class PagoRegistro {
    private Long clienteId;
    private PagoDTO pago;

    public PagoRegistro(Long clienteId, PagoDTO pago) {
        this.clienteId = clienteId;
        this.pago = pago;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }

    public PagoDTO getPago() {
        return pago;
    }

    public void setPago(PagoDTO pago) {
        this.pago = pago;
    }
}
