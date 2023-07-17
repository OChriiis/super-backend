package br.com.banco.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.banco.model.Transferencia;
import br.com.banco.service.TransferenciaService;

@Controller // Indica que essa classe é um controlador do Spring
@RestController // Indica que essa classe é um controlador REST do Spring
@RequestMapping("/api/transferencias") // Define o caminho base para as requisições desse controlador
@CrossOrigin // Permite que esse controlador seja acessado por origens diferentes
public class TransferenciaController {

    @Autowired // Injeta uma instância de TransferenciaService nesse atributo
    private TransferenciaService transferenciaService; // O componente que realiza a lógica de negócio com a entidade Transferencia

    @GetMapping // Define que esse método atende a requisições GET no caminho "/api/transferencias"
    public Page<Transferencia> getTransferencias(
            @RequestParam(defaultValue = "1") int pagina, // Recebe um parâmetro opcional chamado "pagina" com valor padrão 1
            @RequestParam(defaultValue = "4") int tamanho // Recebe um parâmetro opcional chamado "tamanho" com valor padrão 4
    ) {

        // Se o valor de 'pagina' for menor que 1, define automaticamente como 1.
        if (pagina < 1) {
            pagina = 1;
        }

        // Chama o método findAllPageable do TransferenciaService que retorna uma página de transferências de acordo com um objeto pageable
        return transferenciaService.findAllPageable(PageRequest.of(pagina - 1, tamanho));
    }
}
