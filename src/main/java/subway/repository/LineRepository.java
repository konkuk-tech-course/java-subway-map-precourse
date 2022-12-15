package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.*;
import java.util.stream.Collectors;

public class LineRepository {
    private static class InstanceHolder {
        private static final LineRepository INSTANCE = new LineRepository();
    }

    private LineRepository(){}

    public static LineRepository getInstance() {
        return LineRepository.InstanceHolder.INSTANCE;
    }

    private final List<Line> lines = new ArrayList<>();

    public Line findLineByName(String name) {
        return lines.stream().filter(line -> name.equals(line.getName()))
                .findAny()
                .orElseThrow();
    }

    public List<String> findAllLines() {
        return lines.stream().map(Line::getName).collect(Collectors.toUnmodifiableList());
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public boolean hasLine(String name) {
        return lines.stream().anyMatch(line -> name.equals(line.getName()));
    }
}
