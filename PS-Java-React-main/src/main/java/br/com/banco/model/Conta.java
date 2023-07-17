package br.com.banco.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica que essa classe é uma entidade do banco de dados
@Table(name = "conta") // Define o nome da tabela correspondente
@Data // Gera os getters, setters, toString, equals e hashCode automaticamente
@AllArgsConstructor // Gera um construtor com todos os atributos
@NoArgsConstructor // Gera um construtor sem argumentos
public class Conta {

    @Id // Indica que esse atributo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração do valor do atributo
    private Long id; // O identificador único da conta

    private String titular; // O nome do responsável pela conta

}
