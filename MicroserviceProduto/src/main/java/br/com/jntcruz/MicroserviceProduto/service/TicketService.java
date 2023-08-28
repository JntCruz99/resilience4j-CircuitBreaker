package br.com.jntcruz.MicroserviceProduto.service;

import br.com.jntcruz.MicroserviceProduto.entity.Ticket;
import io.github.resilience4j.bulkhead.annotation.Bulkhead;
import io.github.resilience4j.circuitbreaker.CallNotPermittedException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Mono;

//@FeignClient(name = "ticket-service")
public interface TicketService {

    @GetMapping(value = "/ticket/produto/{produtoId}")
    Ticket findByProdutoid (@PathVariable("produtoId") Integer produtoId);


}
