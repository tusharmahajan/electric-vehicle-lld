package ev.models;

import lombok.Getter;

@Getter
public class User {

    private final String userID;
    private final String userName;
    private final BookingPeriod period;

    public User(String userID, String userName, BookingPeriod period) {
        this.userID = userID;
        this.userName = userName;
        this.period = period;
    }
}
