package br.com.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.banco.model.Transferencia;
import br.com.banco.repository.TransferenciaRepository;

@Service // Indica que essa classe é um componente do Spring que realiza a lógica de negócio
public class TransferenciaService {

    @Autowired // Injeta uma instância de TransferenciaRepository nesse atributo
    private TransferenciaRepository transferenciaRepository; // A interface que permite realizar operações de persistência com a entidade Transferencia

    public List<Transferencia> findAll(){ // Um método público que retorna uma lista de todas as transferências
        return transferenciaRepository.findAll(); // Chama o método findAll do TransferenciaRepository que retorna todas as transferências do banco de dados
    }

    public Page<Transferencia> findAllPageable(Pageable pageable) { // Um método público que retorna uma página de transferências de acordo com um objeto pageable
        return transferenciaRepository.findAll(pageable); // Chama o método findAll do TransferenciaRepository que retorna uma página de transferências do banco de dados
    }

}
