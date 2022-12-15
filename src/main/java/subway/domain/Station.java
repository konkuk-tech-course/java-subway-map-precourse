package subway.domain;

import static subway.domain.LineRepository.lines;
import static subway.domain.StationRepository.stations;
import static subway.util.ErrorMessage.SHORT_NAME;

public class Station {
    private String name;

    public Station(String name) {
        validate(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name){
        if(name.length()<2){
            throw new IllegalArgumentException(SHORT_NAME);
        }
    }

    public static Station getEqualStation(String station) {
        return stations().stream()
                .filter(coin -> coin.getName().equals(station))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }
}
