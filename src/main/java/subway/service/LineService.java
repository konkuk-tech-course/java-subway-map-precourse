package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.domain.constant.DomainErrorMessage;
import subway.repository.LineRepository;
import subway.repository.StationRepository;

import java.util.List;
import java.util.Map;

public class LineService {
    private static class InstanceHolder {
        private static final LineService INSTANCE = new LineService();
    }

    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();
    // TODO: 적절한 상수 생각해보기
    private final int UNIT = 1;

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
        validateNonExistLineName(name);
        validateStation(startStationName);
        validateStation(endStationName);
    }

    public void validateNonExistLineName(String name) {
        if (lineRepository.hasLine(name)) {
            throw new IllegalArgumentException(DomainErrorMessage.DUPLICATE_LINE.get());
        }
    }

    public void validateExistLineName(String name) {
        if (!lineRepository.hasLine(name)) {
            throw new IllegalArgumentException(DomainErrorMessage.NOT_EXIST_Line.get());
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

    public boolean isCorrectOrderForRegister(String lineName, int order) {
        Line line = lineRepository.findLineByName(lineName);
        return order <= line.getNumberOfStations() + UNIT;
    }

    public boolean isCorrectOrderForRemove(String lineName, int order) {
        Line line = lineRepository.findLineByName(lineName);
        return order <= line.getNumberOfStations();
    }

    public boolean canBeAddedToLine(String lineName, String stationName) {
        Line line = lineRepository.findLineByName(lineName);
        return !line.hasStation(stationName);
    }

    public boolean canBeRemovedFromLine(String lineName, String stationName) {
        Line line = lineRepository.findLineByName(lineName);
        return line.hasStation(stationName);
    }

    public List<String> loadAllLines() {
        return lineRepository.findAllLines();
    }

    public Map<String, List<String>> loadAllLinesInformation() {
        return lineRepository.findAllLinesInformation();
    }
}
