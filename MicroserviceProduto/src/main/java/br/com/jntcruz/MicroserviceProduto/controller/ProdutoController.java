package br.com.jntcruz.MicroserviceProduto.controller;

import br.com.jntcruz.MicroserviceProduto.entity.Produto;
import br.com.jntcruz.MicroserviceProduto.entity.Ticket;
import br.com.jntcruz.MicroserviceProduto.repository.ProdutoRepository;
import br.com.jntcruz.MicroserviceProduto.service.TicketService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    TicketService ticketService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping(value = "/produto")
    public Iterable<Produto> all (){
        return produtoRepository.findAll();
    }

    @GetMapping(value = "/produto/{produtoId}")
    @CircuitBreaker(name = "produtoA", fallbackMethod = "fallback")
    public Produto findByAccountId (@PathVariable Integer produtoId){
        Produto produto = produtoRepository.findByProdutoId(produtoId);

        Ticket ticket = ticketService.findByProdutoid(produtoId);

        produto.setTicket(ticket);

        return produto;
    }

    public Produto fallback(Integer produtoId, Exception e) {
        Produto produto = produtoRepository.findByProdutoId(produtoId);
        return produto;
    }
}

