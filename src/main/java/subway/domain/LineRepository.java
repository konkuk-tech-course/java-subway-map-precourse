package subway.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineRepository {
    private static final List<Line> lines = new LinkedList<>();
    static {
        createDefaultLines();
    }
    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }

    public static void addLine(Line line) {
        lines.add(line);
    }

    public static Line createLine(String lineName, List<String> stationNames){
        Line createdLine = new Line(lineName);
        for(String name : stationNames){
            createdLine.putStationToLast(new Station(name));
        }
        return createdLine;

    }
    private static void createDefaultLines(){
        addLine(createLine("2호선", Arrays.asList("교대역","강남역","")));
        addLine(createLine("3호선", Arrays.asList("교대역","남부터미넣역","양재역","매봉역")));
        addLine(createLine("신분당선", Arrays.asList("강남역","양재역","양재시민의숲역")));
    }
    public static boolean isLineExist(String lineName){
        return lines.stream()
                .anyMatch(line -> lineName.equals(line.getName()));
    }
    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

    public static void main(String[] args) {

        for (Line line : LineRepository.lines()){
            System.out.println();
            System.out.println(line.getName());
            for(Station station : line.getStations()){
                System.out.println(station.getName());
            }
        }
    }
}
