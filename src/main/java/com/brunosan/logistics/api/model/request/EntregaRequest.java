package com.brunosan.logistics.api.model.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Getter
@Setter
public class EntregaRequest {

    @Valid
    @NotNull
    private ClienteIdRequest cliente;

    @Valid
    @NotNull
    private DestinatarioRequest destinatario;

    @NotNull
    private BigDecimal taxa;

}
