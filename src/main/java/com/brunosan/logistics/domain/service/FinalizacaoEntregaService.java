package com.brunosan.logistics.domain.service;

import com.brunosan.logistics.domain.model.Entrega;
import com.brunosan.logistics.domain.model.StatusEntrega;
import com.brunosan.logistics.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class FinalizacaoEntregaService {

    private EntregaRepository entregaRepository;
    private BuscaEntregaService buscaEntregaService;

    public void finalizar(Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        entrega.finalizar();

        entregaRepository.save(entrega);
    }
}
