package subway.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class StationRepository {
    private static class InstanceHolder {
        private static final StationRepository INSTANCE = new StationRepository();
    }

    private static final List<Station> stations = new ArrayList<>();
    
    private StationRepository(){}

    public static StationRepository getInstance() {
        return StationRepository.InstanceHolder.INSTANCE;
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
}
