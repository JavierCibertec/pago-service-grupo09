package pe.cibertec.globalmarket.grupo09.pagoservice.controller;

import pe.cibertec.globalmarket.grupo09.pagoservice.dto.PagoDTO;
import pe.cibertec.globalmarket.grupo09.pagoservice.service.PagoService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/pagos")
public class PagoController {

    private final PagoService service;

    public PagoController(PagoService service) {
        this.service = service;
    }

    @GetMapping("/pedido/{idPedido}")
    public PagoDTO porPedido(@PathVariable("idPedido") Long idPedido) {
        return service.obtenerPorPedido(idPedido);
    }

    @GetMapping("/cliente/{clienteId}")
    public List<PagoDTO> porCliente(@PathVariable("clienteId") Long clienteId) {
        return service.listarPorCliente(clienteId);
    }
}
