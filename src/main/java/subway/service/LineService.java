package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.constant.DomainErrorMessage;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.List;

public class LineService {
    private static class InstanceHolder {
        private static final LineService INSTANCE = new LineService();
    }

    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();

    private LineService(){}

    public static LineService getInstance() {
        return LineService.InstanceHolder.INSTANCE;
    }

    public void registerLine(String name, String startStationName, String endStationName) {
        validateNewLine(name, startStationName, endStationName);
        Line line = new Line(name);
        line.addStation(new Station(startStationName));
        line.addStation(new Station(endStationName));
        lineRepository.addLine(line);
    }

    private void validateNewLine(String name, String startStationName, String endStationName) {
        validateLineName(name);
        validateStation(startStationName);
        validateStation(endStationName);
    }

    private void validateLineName(String name) {
        if (lineRepository.hasLine(name)) {
            throw new IllegalArgumentException(DomainErrorMessage.DUPLICATE_LINE.get());
        }
    }

    private void validateStation(String stationName) {
        if (!stationRepository.hasStation(stationName)) {
            throw new IllegalArgumentException(DomainErrorMessage.NOT_EXIST_STATION.get());
        }
    }

    public void removeLine(String name) {
        boolean isRemoved = lineRepository.deleteLineByName(name);
        if (!isRemoved) {
            throw new IllegalArgumentException(DomainErrorMessage.NOT_EXIST_Line.get());
        }
    }

    public List<String> loadAllLines() {
        return lineRepository.findAllLines();
    }
}
