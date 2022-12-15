package subway.domain;

import java.util.*;

public class LineRepository {
    private static final List<Line> lines;

    static {
        List<Line> defaultLine = List.of(
                new Line("2호선", Arrays.asList(
                        new Station("교대역"),
                        new Station("강남역"),
                        new Station("역삼역"))),
                new Line("3호선", Arrays.asList(
                        new Station("교대역"),
                        new Station("남부터미널역"),
                        new Station("양재역"),
                        new Station("매봉역"))),
                new Line("신분당선",Arrays.asList(
                        new Station("강남역"),
                        new Station("양재역"),
                        new Station("양재시민의숲역")))
        );
        lines = new ArrayList<>(defaultLine);
    }

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static List<Line> getLines() {
        return lines;
    }
}
