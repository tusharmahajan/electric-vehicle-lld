package ev.models;

import lombok.Getter;

@Getter
public class BookingPeriod {

    private final int startTime;
    private final int endTime;

    public BookingPeriod(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
