package com.brunosan.logistics.domain.repository;

import com.brunosan.logistics.domain.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    @Deprecated
    List<Cliente> findByNome(String nome);

    List<Cliente> findByNomeContaining(String nome);

    Optional<Cliente> findById(Long id);
}
