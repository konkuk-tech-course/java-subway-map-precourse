package subway.service;

import subway.domain.Station;
import subway.repository.StationRepository;

import java.util.Set;

public class StationService {
    private static class InstanceHolder {
        private static final StationService INSTANCE = new StationService();
    }

    private final StationRepository stationRepository = StationRepository.getInstance();

    private StationService(){}

    public static StationService getInstance() {
        return StationService.InstanceHolder.INSTANCE;
    }

    public void registerStation(String name) {
        stationRepository.addStation(new Station(name));
    }

    public void removeStation(String name) {
        stationRepository.deleteStation(name);
    }

    public Set<String> loadAllStations() {
        return stationRepository.findAllStations();
    }
}
