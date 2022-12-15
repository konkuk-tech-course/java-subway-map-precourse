package subway.domain;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private String name;
    private List<Station> stations = new LinkedList<>();

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addStation(Station station) {
        stations.add(station);
    }

    public void addStation(int order, Station station) {
        stations.add(orderToIndex(order), station);
    }

    private int orderToIndex(int order) {
        return --order;
    }

    public List<String> findAllStations() {
        return stations.stream().map(Station::getName)
                .collect(Collectors.toList());
    }
}
