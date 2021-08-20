package com.brunosan.logistics.api.controller;

import com.brunosan.logistics.domain.model.Cliente;
import com.brunosan.logistics.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class ClientController {

    private ClienteRepository clienteRepository;

    @GetMapping
    public List<Cliente> listar() {
        return clienteRepository.findAll();
//        return clienteRepository.findByNome("Bruno");
//        return clienteRepository.findByNomeContaining("a");
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
    public Cliente adicioanr(@RequestBody Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente) {
        if (!clienteRepository.existsById(id))
            return ResponseEntity.badRequest().build();

        cliente.setId(id);
        cliente = clienteRepository.save(cliente);

        return ResponseEntity.ok(cliente);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(@PathVariable Long id) {
        if (!clienteRepository.existsById(id))
            return ResponseEntity.badRequest().build();

        clienteRepository.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
