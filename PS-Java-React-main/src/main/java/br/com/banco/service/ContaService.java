package br.com.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.banco.model.Conta;
import br.com.banco.repository.ContaRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor // Gera um construtor com todos os atributos
@Service // Indica que essa classe é um componente do Spring que realiza a lógica de negócio
public class ContaService {
    @Autowired // Injeta uma instância de ContaRepository nesse atributo
    private ContaRepository contaRepository; // A interface que permite realizar operações de persistência com a entidade Conta

    public List<Conta> findAll(){ // Um método público que retorna uma lista de todas as contas
        return contaRepository.findAll(); // Chama o método findAll do ContaRepository que retorna todas as contas do banco de dados
    }
}
