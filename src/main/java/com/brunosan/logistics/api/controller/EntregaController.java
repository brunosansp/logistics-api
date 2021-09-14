package com.brunosan.logistics.api.controller;

import com.brunosan.logistics.api.assembler.EntregaResponse;
import com.brunosan.logistics.api.model.EntregaModel;
import com.brunosan.logistics.api.model.request.EntregaRequest;
import com.brunosan.logistics.domain.model.Entrega;
import com.brunosan.logistics.domain.repository.EntregaRepository;
import com.brunosan.logistics.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private EntregaRepository entregaRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;
    private EntregaResponse entregaResponse;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public EntregaModel solicitar(@Valid @RequestBody EntregaRequest entregaRequest) {
        Entrega novaEntrega = entregaResponse.toEntity(entregaRequest);

        Entrega entregaSolicitada = solicitacaoEntregaService.solicitar(novaEntrega);
        return entregaResponse.toModel(entregaSolicitada);
//        return entregaResponse.toModel(solicitacaoEntregaService.solicitar(entrega));
    }

    @GetMapping
    public List<EntregaModel> listar() {
        return entregaResponse.toCollectionModel(entregaRepository.findAll());
    }

    @GetMapping("/{entregaId}")
    public ResponseEntity<EntregaModel> buscar(@PathVariable Long entregaId) {
        return entregaRepository.findById(entregaId)
                .map(entrega -> ResponseEntity.ok(entregaResponse.toModel(entrega)))
                .orElse(ResponseEntity.notFound().build());
    }
}
