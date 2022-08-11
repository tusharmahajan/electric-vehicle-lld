package ev;

import ev.models.BookingPeriod;
import ev.models.ChargingStation;
import ev.models.User;
import ev.services.ChargingService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChargingStationManager {

    List<ChargingStation> chargingStations;
    Map<String, List<BookingPeriod>> stationBookings;

    public ChargingStationManager() {
        this.chargingStations = new ArrayList<>();
        this.stationBookings = new HashMap<>();
    }

    public void addStations(ChargingStation station){
        this.chargingStations.add(station);
    }

    public List<ChargingStation> getAllStations(){
        return this.chargingStations;
    }

    public void makeBooking(User user){

        for(ChargingStation station : this.chargingStations){
            if(ChargingService.checkAvailability(user, station, stationBookings)){
                System.out.println(user.getUserName() + " has booked charging station: " + station.getStationID());

                if(!this.stationBookings.containsKey(station.getStationID())){
                    this.stationBookings.put(station.getStationID(), new ArrayList<>());
                }
                this.stationBookings.get(station.getStationID()).add(user.getPeriod());
                return;
            }
        }
        System.out.println("Sorry no charging station is available.");
    }

}
