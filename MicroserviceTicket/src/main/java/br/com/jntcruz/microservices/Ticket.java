package br.com.jntcruz.microservices;

import jakarta.persistence.*;

import java.io.Serializable;

@Table(name="TICKETS")
@Entity
public class Ticket implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id//Pk
    @Column(name="TICKETID")
    Integer ticketId;

    @Column(name="NUMEROPREMIADO")
    Integer numeroPremiado;

    @Column(name="STATUS")
    String status;

    @Column(name="PRODUTOID")
    Integer produtoid;

    public Ticket() {
        super();
    }



    @Override
    public String toString() {
        return "Ticket [ticketId=" + ticketId + ", numeroPremiado=" + numeroPremiado + ", status=" + status
                + ", produtoid=" + produtoid + "]";
    }



    public Ticket(Integer ticketId, Integer numeroPremiado, String status, Integer produtoid) {
        super();
        this.ticketId = ticketId;
        this.numeroPremiado = numeroPremiado;
        this.status = status;
        this.produtoid = produtoid;
    }



    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getProdutoid() {
        return produtoid;
    }

    public void setProdutoid(Integer produtoid) {
        this.produtoid = produtoid;
    }

    public Integer getNumeroPremiado() {
        return numeroPremiado;
    }

    public void setNumeroPremiado(Integer numeroPremiado) {
        this.numeroPremiado = numeroPremiado;
    }



}