package subway.service;

import subway.domain.Line;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {
    private static class InstanceHolder {
        private static final SectionService INSTANCE = new SectionService();
    }

    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();

    private SectionService(){}

    public static SectionService getInstance() {
        return SectionService.InstanceHolder.INSTANCE;
    }

    public void registerSection(String lineName, String stationName, int order) {
        Line line = lineRepository.findLineByName(lineName);
        line.addStation(order, stationRepository.findStationByName(stationName));
    }

    public void registerSection(String lineName, String stationName) {
        Line line = lineRepository.findLineByName(lineName);
        line.addStation(stationRepository.findStationByName(stationName));
    }

    public void deleteSection(String lineName, String stationName) {
        Line line = lineRepository.findLineByName(lineName);
        line.deleteStation(stationName);
    }
}
