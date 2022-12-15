package subway.repository;

import subway.domain.Line;
import subway.domain.Station;

import java.util.*;

public class LineRepository {
    private static class InstanceHolder {
        private static final LineRepository INSTANCE = new LineRepository();
    }

    private LineRepository(){}

    public static LineRepository getInstance() {
        return LineRepository.InstanceHolder.INSTANCE;
    }

    private final List<Line> lines = new ArrayList<>();

    public List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public void addLine(Line line) {
        lines.add(line);
    }

    public boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }
}
