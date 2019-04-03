import enums.SeatStatus;
import models.Seat;
import models.User;

import java.util.ArrayList;

public interface ISeatsBeanManager {
    ArrayList<Seat> getSeatsList();
    double getSeatPrice(Seat seat);
    User buyTicket(ArrayList<Seat> seats, User user);
    void setSeatStatus(int index, SeatStatus status);
}
