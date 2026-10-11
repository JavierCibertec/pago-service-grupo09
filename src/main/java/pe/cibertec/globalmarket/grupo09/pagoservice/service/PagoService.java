package pe.cibertec.globalmarket.grupo09.pagoservice.service;

import pe.cibertec.globalmarket.grupo09.pagoservice.dto.PagoDTO;
import pe.cibertec.globalmarket.grupo09.pagoservice.model.Pago;
import pe.cibertec.globalmarket.grupo09.pagoservice.repository.PagoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class PagoService {

    private final PagoRepository repository;

    public PagoService(PagoRepository repository) {
        this.repository = repository;
    }

    public PagoDTO obtenerPorPedido(Long idPedido) {
        return repository.buscarPorPedido(idPedido)
                .map(this::aDTO)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "No existe pago para el pedido " + idPedido));
    }

    public List<PagoDTO> listarPorCliente(Long clienteId) {
        return repository.buscarPorCliente(clienteId).stream().map(this::aDTO).toList();
    }

    private PagoDTO aDTO(Pago p) {
        return new PagoDTO(p.idPago(), p.idPedido(), p.metodoPago(), p.montoPagado(),
                p.fechaPago(), p.codigoAutorizacion(), p.estadoPago());
    }
}
