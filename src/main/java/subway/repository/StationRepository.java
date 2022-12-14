package subway.repository;

import subway.domain.Station;
import subway.domain.constant.DomainErrorMessage;

import java.util.*;

public class StationRepository {
    private static class InstanceHolder {
        private static final StationRepository INSTANCE = new StationRepository();
    }

    private final Map<String, Station> stations = new HashMap<>();

    private StationRepository(){}

    public static StationRepository getInstance() {
        return StationRepository.InstanceHolder.INSTANCE;
    }

    public Set<String> stations() {
        return Collections.unmodifiableSet(stations.keySet());
    }

    public void addStation(Station station) {
        validate(station.getName());
        stations.put(station.getName(), station);
    }

    private void validate(String name) {
        if (hasStation(name)) {
            throw new IllegalArgumentException(DomainErrorMessage.DUPLICATE_STATION.get());
        }
    }

    public boolean hasStation(String name) {
        return stations.containsKey(name);
    }

    public void deleteStation(String name) {
        if (!hasStation(name)) {
            throw new IllegalArgumentException(DomainErrorMessage.NOT_EXIST_STATION.get());
        }
        stations.remove(name);
    }
}
