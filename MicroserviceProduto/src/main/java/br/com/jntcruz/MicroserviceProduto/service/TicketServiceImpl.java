package br.com.jntcruz.MicroserviceProduto.service;

import br.com.jntcruz.MicroserviceProduto.entity.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TicketServiceImpl  implements TicketService {

    @Autowired
    @LoadBalanced
    RestTemplate restTemplate;

    public Ticket findByProdutoid(Integer produtoId) {
        return restTemplate.getForObject("http://TICKET-SERVICE/ticket/produto/{produtoId}", Ticket.class, produtoId);
    }


}
