package com.brunosan.logistics.domain.service;

import com.brunosan.logistics.domain.exception.NegocioException;
import com.brunosan.logistics.domain.model.Cliente;
import com.brunosan.logistics.domain.repository.ClienteRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@AllArgsConstructor
@Service
public class CatalogoClienteService {

    private ClienteRepository clienteRepository;

    @Transactional
    public Cliente salvar(Cliente cliente) {
        boolean emailEmUso = clienteRepository.findByEmail(cliente.getEmail())
                .stream()
                .anyMatch(clienteRepository -> !clienteRepository.equals(cliente));

        if (emailEmUso) {
            throw new NegocioException("E-mail já cadastrado.");
        }

        return clienteRepository.save(cliente);
    }

    public void excluir(Long clienteId) {
        clienteRepository.deleteById(clienteId);
    }

}
