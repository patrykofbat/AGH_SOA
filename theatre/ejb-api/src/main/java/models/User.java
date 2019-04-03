package models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.UUID;

public class User implements Serializable {
    private int index;
    private String name;
    private double balance;
    private ArrayList<Seat> seats;
    private UUID token;

    public User(int index, String name, double balance, ArrayList<Seat> seats, UUID token) {
        this.index = index;
        this.name = name;
        this.balance = balance;
        this.seats = seats;
        this.token = token;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Seat> getSeats() {
        return seats;
    }

    public void setSeats(ArrayList<Seat> seats) {
        this.seats = seats;
    }

    public UUID getToken() {
        return token;
    }

    public void setToken(UUID token) {
        this.token = token;
    }

    public String getUserSeatsString() {
        StringBuilder string = new StringBuilder();
        if (this.seats == null) {
            return "";
        }
        for (Seat s: this.seats) {
            string.append(s.getIndex());
            string.append(" ");
        }
        return string.toString();
    }

}
