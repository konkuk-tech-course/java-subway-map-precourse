package subway.domain;

import java.util.Arrays;
import java.util.Objects;

import static subway.domain.LineRepository.lines;
import static subway.util.ErrorMessage.SHORT_NAME;

public class Line {
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    private void validate(String name) {
        if (name.length() < 2) {
            throw new IllegalArgumentException(SHORT_NAME);
        }
    }

/*    public static Line getEqualLine(String line) {
        return lines().stream()
                .filter(coin -> coin.getName().equals(line))
                .findAny()
                .orElseThrow(IllegalArgumentException::new);
    }*/

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Line line = (Line) o;
        return Objects.equals(name, line.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
