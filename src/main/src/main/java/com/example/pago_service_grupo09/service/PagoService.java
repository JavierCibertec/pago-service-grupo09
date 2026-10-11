package com.example.pago_service_grupo09.service;

import com.example.pago_service_grupo09.dto.PagoDTO;
import com.example.pago_service_grupo09.model.PagoRegistro;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class PagoService {
    private final List<PagoRegistro> pagos = new ArrayList<>();

    public PagoService() {
        pagos.add(
                new PagoRegistro(
                        1L,
                        new PagoDTO(
                                1L,
                                101L,
                                "TARJETA_CREDITO",
                                250.00,
                                LocalDateTime.now(),
                                "AUTH-001",
                                "APROBADO"
                        )
                        )
        );
        pagos.add(
                new PagoRegistro(
                        1L,
                        new PagoDTO(
                                2L,
                                102L,
                                "TRANSFERENCIA",
                                150.00,
                                LocalDateTime.now(),
                                "AUTH-002",
                                "APROBADO"
                        )
                )
        );
        pagos.add(
                new PagoRegistro(
                        2L,
                        new PagoDTO(
                                3L,
                                103L,
                                "TARJETA_CREDITO",
                                500.00,
                                LocalDateTime.now(),
                                "AUTH-003",
                                "RECHAZADO"
                        )
                )
        );
    }

    public PagoDTO buscarPorPedido(final Long idPedido) {
        return pagos.stream()
                .map(PagoRegistro::getPago)
                .filter(pago -> ((PagoDTO) pago).getIdPedido().equals(idPedido))
                .findFirst()
                .orElse(null);
    }

    public List<PagoDTO> buscarPorCliente(final Long clienteId) {
        return pagos.stream()
                .filter(registro -> registro.getClienteId().equals(clienteId))
                .map(PagoRegistro::getPago)
                .toList();
    }
}
