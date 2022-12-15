package subway.controller;

import java.util.List;
import subway.domain.Line;
import subway.domain.LineRepository;
import subway.domain.Station;
import subway.domain.StationRepository;

public class SubwayProgram {
    private List<Station> stationRepository = StationRepository.stations();
    private LineRepository lineRepository;
    public SubwayProgram(){

    }
    private void initProgram(){
    }

    public static void main(String[] args) {
        SubwayProgram program = new SubwayProgram();

    }
}
