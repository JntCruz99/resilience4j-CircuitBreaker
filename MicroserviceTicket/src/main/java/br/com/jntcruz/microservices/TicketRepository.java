package br.com.jntcruz.microservices;

import br.com.jntcruz.microservices.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {

    Ticket findTicketByNumeroPremiado(Integer numeroPremiado);

    Ticket findAllByProdutoid(Integer produtoId);


}