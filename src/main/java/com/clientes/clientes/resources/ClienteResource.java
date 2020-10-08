package com.clientes.clientes.resources;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

import com.clientes.clientes.models.Cliente;
import com.clientes.clientes.repository.ClienteRepository;

@RestController
@RequestMapping(value="/api")
public class ClienteResource {
	
	@Autowired
	ClienteRepository clienteRepository;
	
	//Retorna todos clientes cadastrados, com paginação
	@GetMapping("/clientes")
	public ResponseEntity<?> listaCliente(Pageable pageable){			
		return new ResponseEntity<>(clienteRepository.findAll(pageable), HttpStatus.OK);		
	}
	
	//Retorna CPF único dentro do Banco
	@GetMapping("clientes/busca/cpf/{cpf}")
	public Cliente listaClienteCpf (@PathVariable (value="cpf") String cpf){			
		return clienteRepository.findByCpf(cpf);		
	}
	
	//Retorna clientes com o nome que você digitou
		@GetMapping("clientes/busca/nome/{nome}")
		public List<Cliente> pesquisar(@PathVariable (value="nome") String nome){
			return clienteRepository.findClienteByNome(nome);		
	}
	
	
	@PostMapping("/clientes")
	public Cliente salvaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
	@DeleteMapping("/clientes")
	public void deletaCliente(@RequestBody Cliente cliente) {
		clienteRepository.delete(cliente);
	}
	
	@PutMapping("/clientes")
	public Cliente atualizaCliente(@RequestBody Cliente cliente) {
		return clienteRepository.save(cliente);
	}
	
}
