import enums.SeatStatus;
import models.Seat;
import models.User;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ManagedBean(name = "theatre")
@SessionScoped
public class TheatreManager {


    @EJB(lookup = "java:global/ejb-1.0-SNAPSHOT/SeatsBeanManager")
    private ISeatsBeanManager seatsBeanManager;

    @EJB(lookup = "java:global/ejb-1.0-SNAPSHOT/UsersBeanManager")
    private IUsersBeanManager usersBeanManager;

    private HashMap<Integer, Boolean> checkedSeats = new HashMap<>();

    private HashMap<Integer, Boolean> disabledSeats = new HashMap<>();

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

    public HashMap<Integer, Boolean> getDisabledSeats() {
        return disabledSeats;
    }

    public void setDisabledSeats(HashMap<Integer, Boolean> disabledSeats) {
        this.disabledSeats = disabledSeats;
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

    public String getUsersSeats() {
        if (this.selectedUserToken == null) {
            return "";
        }
        else {
            User user = this.usersBeanManager.getUserByToken(this.selectedUserToken);
            return user.getUserSeatsString();
        }
    }

    public void submit() {
        ArrayList<Seat> seats = this.seatsBeanManager.getSeatsList();
        ArrayList<Seat> userSeats = new ArrayList<>();

        if (this.selectedUserToken == null) {
            return;
        }

        System.out.println(this.selectedUserToken);
        double sum = 0.0;
        for (Map.Entry<Integer, Boolean> entry: this.checkedSeats.entrySet()) {
            boolean isDisabledSeat = this.disabledSeats.getOrDefault(entry.getKey(), false);
            if (entry.getValue() && !isDisabledSeat) {
                Seat seat = seats.get(entry.getKey());
                seat.setStatus(SeatStatus.RESERVED);
                sum += seat.getPrice();
                userSeats.add(seat);
            }
        }
        User user = this.usersBeanManager.getUserByToken(this.selectedUserToken);
        System.out.println(sum);
        if (sum <= user.getBalance()) {
            user = this.seatsBeanManager.buyTicket(userSeats, user);
            user.setSeats(userSeats);
            this.usersBeanManager.setUser(user);
            this.disabledSeats = new HashMap<>(this.checkedSeats);
        } else {
            this.errorMessage = "Masz za mało środków";
            this.checkedSeats = new HashMap<>();
        }
    }

    public void updateUser() {
        System.out.println("AJAX");
        System.out.println(this.selectedUserToken);
    }
}
