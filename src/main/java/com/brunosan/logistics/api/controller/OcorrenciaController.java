package com.brunosan.logistics.api.controller;

import com.brunosan.logistics.api.assembler.OcorrenciaResponse;
import com.brunosan.logistics.api.model.OcorrenciaModel;
import com.brunosan.logistics.api.model.request.OcorrenciaRequest;
import com.brunosan.logistics.domain.model.Entrega;
import com.brunosan.logistics.domain.model.Ocorrencia;
import com.brunosan.logistics.domain.service.BuscaEntregaService;
import com.brunosan.logistics.domain.service.RegistroOcorrenciaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/entregas/{entregaId}/ocorrencias")
public class OcorrenciaController {

    private BuscaEntregaService buscaEntregaService;
    private RegistroOcorrenciaService registroOcorrenciaService;
    private OcorrenciaResponse ocorrenciaResponse;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OcorrenciaModel registrar(@PathVariable Long entregaId,
                                     @Valid @RequestBody OcorrenciaRequest ocorrenciaRequest) {

        Ocorrencia ocorrenciaRegistrada = registroOcorrenciaService
                .registrar(entregaId, ocorrenciaRequest.getDescricao());

        return ocorrenciaResponse.toModel(ocorrenciaRegistrada);
    }

    @GetMapping
    public List<OcorrenciaModel> listar(@PathVariable Long entregaId) {
        Entrega entrega = buscaEntregaService.buscar(entregaId);

        return ocorrenciaResponse.toCollectionModel(entrega.getOcorrencias());
    }
}
