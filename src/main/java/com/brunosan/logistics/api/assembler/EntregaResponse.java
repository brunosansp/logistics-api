package com.brunosan.logistics.api.assembler;

import com.brunosan.logistics.api.model.EntregaModel;
import com.brunosan.logistics.api.model.request.EntregaRequest;
import com.brunosan.logistics.domain.model.Entrega;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class EntregaResponse {

    private ModelMapper modelMapper;

    public EntregaModel toModel(Entrega entrega) {
        return modelMapper.map(entrega, EntregaModel.class);
    }

    public List<EntregaModel> toCollectionModel(List<Entrega> entregas) {
        return entregas.stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    public Entrega toEntity(EntregaRequest entregaRequest) {
        return modelMapper.map(entregaRequest, Entrega.class);
    }

}
