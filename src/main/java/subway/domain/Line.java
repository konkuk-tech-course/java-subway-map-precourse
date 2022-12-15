package subway.domain;

import java.util.LinkedList;
import java.util.List;

public class Line {
    private static LinkedList<Station> stations = new LinkedList<>();
    private String name;

    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
    public void putStationToLast(Station station){
        stations.addLast(station);
    }
    public void putStationTo(int index, Station station){
        stations.add(index, station);
    }
//    public Station getStartStation(){
//        return stations.getFirst();
//    }
//    public Station getEndStation(){
//        return stations.getLast();
//    }
    public boolean isStationExist(Station station){
        return stations.contains(station);
    }
    public boolean removeStation(Station station){
        return stations.remove(station);
    }
    public List<Station> getStations(){
        return stations;
    }
}
