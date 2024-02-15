package org.example.Entity;

public class Ticket {
    private String ticketId;
    private String registerationNumber;

    public Ticket(String ticketId, String registerationNumber) {
        this.ticketId = ticketId;
        this.registerationNumber = registerationNumber;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public String getRegisterationNumber() {
        return registerationNumber;
    }

    public void setRegisterationNumber(String registerationNumber) {
        this.registerationNumber = registerationNumber;
    }
}
