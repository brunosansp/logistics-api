package com.brunosan.logistics.domain.service;

import com.brunosan.logistics.domain.exception.NegocioException;
import com.brunosan.logistics.domain.model.Entrega;
import com.brunosan.logistics.domain.model.Ocorrencia;
import com.brunosan.logistics.domain.repository.EntregaRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class RegistroOcorrenciaService {

    private final BuscaEntregaService buscaEntregaService;

    @Transactional
    public Ocorrencia registrar(Long entregaId, String descricao) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);
        return entrega.adicionarOcorrencia(descricao);
    }
}
