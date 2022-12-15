package subway.domain;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class StationRepository {
    private static final List<Station> stations;

    static {
        stations = LineRepository.getLines().stream()
                .flatMap(line -> line.getStations().stream())
                .distinct().collect(Collectors.toList());
    }

    public static List<Station> stations() {
        return Collections.unmodifiableList(stations);
    }

    public static void addStation(Station station) {
        stations.add(station);
    }

    public static boolean deleteStation(String name) {
        return stations.removeIf(station -> Objects.equals(station.getName(), name));
    }

    public static List<Station> getStations() {
        return stations;
    }
}
