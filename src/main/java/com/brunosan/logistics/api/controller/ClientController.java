package com.brunosan.logistics.api.controller;

import com.brunosan.logistics.domain.model.Cliente;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clientes")
    public List<Cliente> listar() {
        Cliente cliente1 = new Cliente();
        cliente1.setId(1L);
        cliente1.setNome("Bruno");
        cliente1.setEmail("bruno@gmail.com");
        cliente1.setTelefone("11 98989-5656");

        Cliente cliente2 = new Cliente();
        cliente2.setId(2L);
        cliente2.setNome("Talita");
        cliente2.setEmail("talita@gmail.com");
        cliente2.setTelefone("11 95656-8989");

        return Arrays.asList(cliente1, cliente2);

    }
}
