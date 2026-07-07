package com.traceledger.gateway.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Event {

    @Id
    private String eventId;

    private String accountId;

    private double balance;

    public Event() {
    }

    public Event(String eventId, String accountId, double balance) {
        this.eventId = eventId;
        this.accountId = accountId;
        this.balance = balance;
    }

    public String getEventId() {
        return eventId;
    }

    public void setEventId(String eventId) {
        this.eventId = eventId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventId='" + eventId + '\'' +
                ", accountId='" + accountId + '\'' +
                ", balance=" + balance +
                '}';
    }
}
