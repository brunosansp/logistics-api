package com.brunosan.logistics.api.controller;

import com.brunosan.logistics.domain.model.Cliente;
import com.brunosan.logistics.domain.repository.ClienteRepository;
import com.brunosan.logistics.domain.service.CatalogoClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClientController {

    private ClienteRepository clienteRepository;
    private CatalogoClienteService catalogoClienteService;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cliente> findClienteById(@PathVariable Long id) {
        return clienteRepository.findById(id)
//                .map(cliente -> ResponseEntity.ok(cliente))
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.noContent().build());


        /*Optional<Cliente> cliente = clienteRepository.findById(id);

        if (!cliente.isEmpty()) {
            return ResponseEntity.ok(cliente.get());
        }
        return ResponseEntity.noContent().build();*/
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente adicioanr(@Valid @RequestBody Cliente cliente) {
//        return clienteRepository.save(cliente);
        return catalogoClienteService.salvar(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @Valid @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(id))
            return ResponseEntity.badRequest().build();

        cliente.setId(id);
        cliente = catalogoClienteService.salvar(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long clienteId) {
        if (!clienteRepository.existsById(clienteId))
            return ResponseEntity.badRequest().build();

        catalogoClienteService.excluir(clienteId);
        return ResponseEntity.ok().build();
    }
}
