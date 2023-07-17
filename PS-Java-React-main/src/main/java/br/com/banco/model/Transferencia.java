package br.com.banco.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity // Indica que essa classe é uma entidade do banco de dados
@Table(name = "transferencia") // Define o nome da tabela correspondente
@Data // Gera os getters, setters, toString, equals e hashCode automaticamente
@AllArgsConstructor // Gera um construtor com todos os atributos
@NoArgsConstructor // Gera um construtor sem argumentos
public class Transferencia {

    @Id // Indica que esse atributo é a chave primária da tabela
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Define a estratégia de geração do valor do atributo
    private Long id; // O identificador único da transferência

    private LocalDateTime data; // A data e hora da transferência

    private Double montante; // O valor da transferência

    private String categoria; // O tipo da transferência (entrada ou saída)

    private String operador; // O nome do operador que realizou a transferência

    @ManyToOne // Indica que existe uma relação de muitos para um entre transferência e conta
    @JoinColumn(name = "conta_id", nullable = false) // Define o nome da coluna que referencia a chave primária da conta
    private Conta conta; // A conta associada à transferência

}
