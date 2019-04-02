import enums.SeatStatus;
import models.Seat;
import models.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

@ManagedBean(name = "theatre")
@SessionScoped
public class TheatreManager {


    @EJB(lookup = "java:global/ejb-1.0-SNAPSHOT/SeatsBeanManager")
    private ISeatsBeanManager seatsBeanManager;

    @EJB(lookup = "java:global/ejb-1.0-SNAPSHOT/UsersBeanManager")
    private IUsersBeanManager usersBeanManager;

    private HashMap<Integer, Boolean> checkedSeats = new HashMap<>();

    private String selectedUserToken;

    private String errorMessage;

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getSelectedUserToken() {
        return selectedUserToken;
    }

    public void setSelectedUserToken(String selectedUserToken) {
        this.selectedUserToken = selectedUserToken;
    }

    public ArrayList<User> getUsersList() {
        return this.usersBeanManager.getUsersList();
    }

    public double getUserBalance() {
        if (this.selectedUserToken == null) {
            return 0.0;
        }
        else {
            return this.usersBeanManager.getUserByToken(this.selectedUserToken).getBalance();
        }
    }


    public ArrayList<Seat> getSeats() {
        return seatsBeanManager.getSeatsList();
    }

    public HashMap<Integer, Boolean> getCheckedSeats() {
        return checkedSeats;
    }

    public void setCheckedSeats(HashMap<Integer, Boolean> checkedSeats) {
        this.checkedSeats = checkedSeats;
    }

    public void submit() {
        ArrayList<Seat> seats = this.seatsBeanManager.getSeatsList();
        ArrayList<Seat> userSeats = new ArrayList<>();
        System.out.println(this.selectedUserToken);
        double sum = 0.0;
        for (Map.Entry<Integer, Boolean> entry: this.checkedSeats.entrySet()) {
            if (entry.getValue()) {
                Seat seat = seats.get(entry.getKey());
                seat.setStatus(SeatStatus.RESERVED);
                sum += seat.getPrice();
                userSeats.add(seat);
            }
        }
        User user = this.usersBeanManager.getUserByToken(this.selectedUserToken);
        if (sum <= user.getBalance()) {
            this.seatsBeanManager.buyTicket(userSeats, user);
        } else {
            this.errorMessage = "Masz za mało środków";
        }
    }

    public void updateUser() {
        System.out.println("AJAX");
        System.out.println(this.selectedUserToken);
    }
}
