package com.sp.midTerm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ticket")
public class TicketDetails {
    @Id
    @Column(name="ticket_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="ticket_name")
    private String name;
    private String ticket_date;
    

    public TicketDetails() {
    }

    public TicketDetails(Long id) {
        this.id = id;
    }

    public TicketDetails(String name, String ticket_date) {
        this.name = name;
        this.ticket_date = ticket_date;
        
    }

    public TicketDetails(Long id, String name, String ticket_date) {
        this.id = id;
    	this.name = name;
        this.ticket_date = ticket_date;
        
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTicket_date() {
		return ticket_date;
	}

	public void setTicket_date(String ticket_date) {
		this.ticket_date = ticket_date;
	}


   
}
