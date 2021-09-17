package com.brunosan.logistics.domain.service;

import com.brunosan.logistics.domain.exception.EntidadeNaoEncontradaException;
import com.brunosan.logistics.domain.exception.NegocioException;
import com.brunosan.logistics.domain.model.Entrega;
import com.brunosan.logistics.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BuscaEntregaService {

    private EntregaRepository entregaRepository;

    public Entrega buscar(Long entregaId) {
        return entregaRepository.findById(entregaId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException("Entrega não encontrada."));
    }
}
