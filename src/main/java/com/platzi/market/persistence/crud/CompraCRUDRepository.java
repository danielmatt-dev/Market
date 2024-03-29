package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Compra;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CompraCRUDRepository extends CrudRepository<Compra, Integer> {
    Optional<List<Compra>> findByidCliente(Integer idCliente);
}

