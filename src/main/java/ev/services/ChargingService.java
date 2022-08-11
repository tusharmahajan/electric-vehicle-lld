package ev.services;

import ev.models.BookingPeriod;
import ev.models.ChargingStation;
import ev.models.User;

import java.util.List;
import java.util.Map;

public class ChargingService {

    public static boolean checkAvailability(User user, ChargingStation station, Map<String, List<BookingPeriod>> stationBookings) {

        String stationID = station.getStationID();
        int userBookingStartTime = user.getPeriod().getStartTime();
        int userBookingEndTime = user.getPeriod().getEndTime();

        List<BookingPeriod> bookedSlots = stationBookings.get(stationID);
        if(bookedSlots == null) return true;

        boolean canBookStation = true;

        for(BookingPeriod period : bookedSlots){
            if(userBookingStartTime >= period.getStartTime() && userBookingStartTime <= period.getEndTime()
                || userBookingEndTime >= period.getStartTime() && userBookingEndTime <= period.getEndTime()
                || userBookingStartTime < period.getStartTime() && userBookingEndTime >= period.getEndTime()){
                canBookStation = false;
                break;
            }
        }
        return canBookStation;
    }
}
