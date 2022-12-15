package subway.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {
    private final List<Station> stations;

    public StationRepository() {
        this.stations = LineRepository.getLines().stream()
                .flatMap(line -> line.getStations().stream())
                .distinct()
                .collect(Collectors.toList());
    }

    public List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public List<Station> getStations() {
        return stations;
    }
}
