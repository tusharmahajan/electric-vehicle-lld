package ev.models;

import lombok.Getter;

@Getter
public class ChargingStation {

    private final String stationID;
    private final Coordinates position;

    public ChargingStation(String stationID, Coordinates position) {
        this.stationID = stationID;
        this.position = position;
    }
}
