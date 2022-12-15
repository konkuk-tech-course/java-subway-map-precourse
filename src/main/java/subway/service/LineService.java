package subway.service;

import subway.domain.Line;
import subway.domain.Station;
import subway.repository.LineRepository;

import java.util.List;

public class LineService {
    private static class InstanceHolder {
        private static final LineService INSTANCE = new LineService();
    }

    private final LineRepository lineRepository = LineRepository.getInstance();

    private LineService(){}

    public static LineService getInstance() {
        return LineService.InstanceHolder.INSTANCE;
    }

    public void registerLine(String name, String startStationName, String endStationName) {
        Line line = new Line(name);
        line.addStation(new Station(startStationName));
        line.addStation(new Station(endStationName));
        lineRepository.addLine(line);
    }

}
