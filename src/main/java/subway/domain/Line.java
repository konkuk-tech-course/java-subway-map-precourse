package subway.domain;

import java.util.List;
import java.util.Objects;

public class Line {
    private final String name;
    private final List<Station> stations;

    public Line(String name,List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }

    // 추가 기능 구현
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(getName(), line.getName()) && Objects.equals(getStations(), line.getStations());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getStations());
    }
}
