package models;

import enums.SeatStatus;

import java.io.Serializable;

public class Seat implements Serializable {
    private int index;
    private int row;
    private int column;
    private double price;
    private SeatStatus status;

    public Seat(int index, int row, int column, double price, SeatStatus status) {
        this.index = index;
        this.row = row;
        this.column = column;
        this.price = price;
        this.status = status;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
