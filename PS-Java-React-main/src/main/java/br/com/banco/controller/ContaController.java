package br.com.banco.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Conta;
import br.com.banco.service.ContaService;

@RestController // Indica que essa classe é um controlador REST do Spring
@RequestMapping("/contas") // Define o caminho base para as requisições desse controlador
public class ContaController {

    @Autowired // Injeta uma instância de ContaService nesse atributo
    private ContaService contaService; // O componente que realiza a lógica de negócio com a entidade Conta

    @GetMapping // Define que esse método atende a requisições GET no caminho "/contas"
    public ResponseEntity<List<Conta>> getAll() { // Um método público que retorna uma resposta HTTP com uma lista de contas
        List<Conta> contas = contaService.findAll(); // Chama o método findAll do ContaService que retorna uma lista de todas as contas
        return ResponseEntity.ok().body(contas); // Cria uma resposta HTTP com status 200 (OK) e corpo com a lista de contas
    }
}
