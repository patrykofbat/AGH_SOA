import enums.SeatStatus;
import models.Seat;
import models.User;

import javax.ejb.Lock;
import javax.ejb.Remote;
import javax.ejb.Singleton;
import java.util.ArrayList;

@Singleton
@Remote(IRemoteSeatsBeanManager.class)
public class SeatsBeanManager implements ISeatsBeanManager{
    private ArrayList<Seat> seats;

    public SeatsBeanManager() {
        this.seats = this.loadSeats();
    }

    @Override
    @Lock
    public ArrayList<Seat> getSeatsList() {
        return this.seats;
    }

    @Override
    @Lock
    public double getSeatPrice(Seat seat) {
        int indexOfSeat = this.seats.indexOf(seat);
        return this.seats.get(indexOfSeat).getPrice();
    }

    @Override
    @Lock
    public void buyTicket(ArrayList<Seat> seats, User user) {
        for (Seat seat: seats) {
            this.setSeatStatus(seat.getIndex(), SeatStatus.RESERVED);
            user.setBalance(user.getBalance() - seat.getPrice());
        }
    }

    @Lock
    public void setSeatStatus(int index, SeatStatus status) {
        Seat seat = this.seats.get(index);
        seat.setStatus(status);
        this.seats.set(index, seat);
    }

    private ArrayList<Seat> loadSeats() {
        ArrayList<Seat> seats = new ArrayList<>();
        int index = 0;
        for (int i = 1; i <= 5; i++) {
            for (int j = 1; j <= 14; j++) {
                Seat seat = new Seat(index, i, j, 20.0, SeatStatus.FREE);
                seats.add(seat);
                index++;
            }
        }
        return seats;
    }
}
