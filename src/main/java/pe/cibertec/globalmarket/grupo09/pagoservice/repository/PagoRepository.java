package pe.cibertec.globalmarket.grupo09.pagoservice.repository;

import pe.cibertec.globalmarket.grupo09.pagoservice.model.Pago;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Repository
public class PagoRepository {

    private final List<Pago> pagos = List.of(
            new Pago(1L, 1L, 1L, "TARJETA_CREDITO", 2600.00,
                    LocalDateTime.now().minusDays(3), "AUT-0001", "APROBADO"),
            new Pago(2L, 2L, 1L, "TRANSFERENCIA", 800.00,
                    LocalDateTime.now().minusDays(2), "AUT-0002", "APROBADO"),
            new Pago(3L, 3L, 2L, "TARJETA_CREDITO", 360.00,
                    LocalDateTime.now().minusDays(1), "AUT-0003", "RECHAZADO")
    );

    public Optional<Pago> buscarPorPedido(Long idPedido) {
        return pagos.stream().filter(p -> p.idPedido().equals(idPedido)).findFirst();
    }

    public List<Pago> buscarPorCliente(Long clienteId) {
        return pagos.stream().filter(p -> p.clienteId().equals(clienteId)).toList();
    }
}
