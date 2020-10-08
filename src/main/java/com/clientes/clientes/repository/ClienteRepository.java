package com.clientes.clientes.repository;

import java.util.List;
import javax.persistence.Entity;
import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clientes.clientes.models.Cliente;


@Repository
public interface ClienteRepository extends 
								   JpaRepository<Cliente, Long>,
								   PagingAndSortingRepository<Cliente, Long>{
		
	Cliente findByCpf(String cpf);	
	
	@Query(value="select * from cliente where cliente.nome like %?1%", nativeQuery=true)
	List<Cliente> findClienteByNome(String nome);
	
	
}
