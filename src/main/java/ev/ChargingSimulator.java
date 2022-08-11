package ev;

import ev.models.BookingPeriod;
import ev.models.ChargingStation;
import ev.models.Coordinates;
import ev.models.User;

import java.util.List;
import java.util.Scanner;

public class ChargingSimulator {
    public static void main(String[] args) {
        ChargingStationManager stationManager = new ChargingStationManager();

        // Taking origin as my current position
        stationManager.addStations(new ChargingStation("1", new Coordinates(10,12)));
        stationManager.addStations(new ChargingStation("2", new Coordinates(9,8)));
        stationManager.addStations(new ChargingStation("3", new Coordinates(1,0)));
        stationManager.addStations(new ChargingStation("4", new Coordinates(-2,-9)));
        stationManager.addStations(new ChargingStation("5", new Coordinates(-8,2)));

        Scanner scanner = new Scanner(System.in);
        User user1 = new User("1", "tushar", new BookingPeriod(1,5));
        User user2 = new User("2", "rahul", new BookingPeriod(2,5));
        User user3 = new User("3", "nitin", new BookingPeriod(8,9));
        User user4 = new User("4", "piyush", new BookingPeriod(11,15));

        while(true){
            String command = scanner.nextLine();

            switch(command){
                case "GET":
                    List<ChargingStation> chargingStations = stationManager.getAllStations();
                    for(ChargingStation chargingStation: chargingStations){
                        System.out.println("StationID: " + chargingStation.getStationID() + " is nearby");
                    }
                break;
                case "BOOK":
                    stationManager.makeBooking(user1);
                    stationManager.makeBooking(user2);
                    stationManager.makeBooking(user3);
                    stationManager.makeBooking(user4);


                default:
                    return;
            }
        }

    }
}
