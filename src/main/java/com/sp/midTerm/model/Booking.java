package com.sp.midTerm.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

//import com.sp.midTerm.model.Passenger;
//import com.sp.midTerm.model.TicketDetails;

@Entity
@Table(name="bookingDetails")
public class Booking {
    @Id
    @Column(name="booking_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;
    @ManyToOne
    @JoinColumn(name = "ticket_id")
    private TicketDetails ticket;
    @Column (name="seat_type")
    private String seatType;

    public Booking() {
    }

    public Booking(Long id, Passenger passenger, TicketDetails ticket, String seatType) {
        this.id = id;
        this.passenger = passenger;
        this.ticket = ticket;
        this.seatType = seatType;
    }

    public Booking(Passenger passenger, TicketDetails ticket, String seatType) {
        this.passenger = passenger;
        this.ticket = ticket;
        this.seatType = seatType;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public TicketDetails getTicket() {
        return ticket;
    }

    public void setTicket(TicketDetails ticket) {
        this.ticket = ticket;
    }
    
    public String getSeatType(String seatType) {
    	return seatType;
    }
    
    public void setSeatType(String seatType) {
    	this.seatType=seatType;
    }
}
