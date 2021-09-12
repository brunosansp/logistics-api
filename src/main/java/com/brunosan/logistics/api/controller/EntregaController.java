package com.brunosan.logistics.api.controller;

import com.brunosan.logistics.domain.model.Cliente;
import com.brunosan.logistics.domain.model.Entrega;
import com.brunosan.logistics.domain.model.StatusEntrega;
import com.brunosan.logistics.domain.repository.ClienteRepository;
import com.brunosan.logistics.domain.service.SolicitacaoEntregaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas")
public class EntregaController {

    private ClienteRepository clienteRepository;
    private SolicitacaoEntregaService solicitacaoEntregaService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Entrega solicitar(@RequestBody Entrega entrega) {
        return solicitacaoEntregaService.solicitar(entrega);
    }
}

// continuar em 3.1 aos 24m50s
