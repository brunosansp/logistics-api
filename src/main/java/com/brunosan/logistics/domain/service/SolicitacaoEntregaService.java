package com.brunosan.logistics.domain.service;

import com.brunosan.logistics.domain.exception.NegocioException;
import com.brunosan.logistics.domain.model.Cliente;
import com.brunosan.logistics.domain.model.Entrega;
import com.brunosan.logistics.domain.model.StatusEntrega;
import com.brunosan.logistics.domain.repository.ClienteRepository;
import com.brunosan.logistics.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.catalog.Catalog;
import java.time.LocalDateTime;

@AllArgsConstructor
@Service
public class SolicitacaoEntregaService {

    private CatalogoClienteService catalogoClienteService;
    private EntregaRepository entregaRepository;

    @Transactional
    public Entrega solicitar(Entrega entrega) {
        Cliente cliente = catalogoClienteService.buscar(entrega.getCliente().getId());

        entrega.setCliente(cliente);
        entrega.setStatus(StatusEntrega.PENDENTE);
        entrega.setDataPedido(LocalDateTime.now());

        return entregaRepository.save(entrega);
    }
}
