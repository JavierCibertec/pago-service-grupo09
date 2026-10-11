package com.example.pago_service_grupo09.controller;

import com.example.pago_service_grupo09.dto.PagoDTO;
import com.example.pago_service_grupo09.service.PagoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }

    @GetMapping("/pedido/{idPedido}")
    public ResponseEntity<PagoDTO> obtenerPagoPorPedido(
            @PathVariable Long idPedido) {
        PagoDTO pago = pagoService.buscarPorPedido(idPedido);

        if (pago == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(pago);
    }

    @GetMapping("/cliente/{clienteId}")
    public ResponseEntity<List<PagoDTO>> obtenerPagosPorCliente(
            @PathVariable Long clienteId) {

        List<PagoDTO> pagos =
                pagoService.buscarPorCliente(clienteId);

        return ResponseEntity.ok(pagos);
    }
}
