package br.com.jntcruz.microservices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class TicketController {

    @Autowired
    TicketRepository ticketRepository;


    @GetMapping(value = "/ticket")
    public Iterable<Ticket> all (){
        return ticketRepository.findAll();
    }


    @RequestMapping(value = "/ticket/{numeroticket}/",method=RequestMethod.GET)
    public Ticket findByTicketId (@PathVariable Integer numeroticket){
        return ticketRepository.findTicketByNumeroPremiado(numeroticket);
    }

    @GetMapping(value = "/ticket/produto/{produtoId}")
    public Ticket findByTicketProduto (@PathVariable Integer produtoId){
        return ticketRepository.findAllByProdutoid(produtoId);
    }

}
