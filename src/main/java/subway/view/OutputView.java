package subway.view;

import subway.domain.Line;
import subway.domain.Station;

import java.util.List;

public class OutputView {

    private static final String LIST_FORMAT = "[INFO] %s\n";

    public void printMainMessage() {
        System.out.println("## 메인 화면\n" +
                "1. 역 관리\n" +
                "2. 노선 관리\n" +
                "3. 구간 관리\n" +
                "4. 지하철 노선도 출력\n" +
                "Q. 종료  ");
    }

    public void printStationManagement() {
        System.out.println("## 역 관리 화면\n" +
                "1. 역 등록\n" +
                "2. 역 삭제\n" +
                "3. 역 조회\n" +
                "B. 돌아가기");
    }

    public void printLineManagement() {
        System.out.println("## 노선 관리 화면\n" +
                "1. 노선 등록\n" +
                "2. 노선 삭제\n" +
                "3. 노선 조회\n" +
                "B. 돌아가기\n");
    }

    public void printSectionManagement() {
        System.out.println("## 구간 관리 화면\n" +
                "1. 구간 등록\n" +
                "2. 구간 삭제\n" +
                "B. 돌아가기");
    }

    public void printWhenStationRegisteredSuccessfully(){
        System.out.println("[INFO] 지하철 역이 등록되었습니다.");
    }

    public void printWhenStationRemovedSuccessfully() {
        System.out.println("[INFO] 지하철 역이 삭제되었습니다.");
    }

    public void printStationList(List<Station> stations) {
        System.out.println("## 역 목록");
        stations.forEach(station -> System.out.printf(LIST_FORMAT, station));
    }

    public void printLineList(List<Line> lines) {
        System.out.println("## 노선 목록");
        lines.forEach(line -> System.out.printf(LIST_FORMAT, line));
    }

    public void printWhenSectionRegisteredSuccessfully() {
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }
    public void printSubwayLineMap(List<Line> defaultLines) {
        System.out.println("## 지하철 노선도");
        for (Line defaultLine : defaultLines) {
            System.out.printf(LIST_FORMAT, defaultLine.getName());
            System.out.printf(LIST_FORMAT, "---");
            defaultLine.getStations().forEach(i -> System.out.printf(LIST_FORMAT, i.getName(4)));
            System.out.println();
        }
    }

}
