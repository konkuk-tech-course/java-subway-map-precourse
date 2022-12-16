package subway.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.valid.InputValidator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;

import static subway.controller.SubwayController.stationMap;
import static subway.util.ErrorMessage.ERROR_PREDICATE;

public class SectionPageController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidator inputValidator = new InputValidator();

    public void sectionPage() {
        try {
            outputView.printSectionMenu();
            String sectionFunction = inputView.readSectionFunction();
            sectionPageAction(sectionFunction);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            sectionPage();
        }
    }

    public void sectionPageAction(String sectionFunction) {
        if (sectionFunction.equals("1")) {
            sectionPage1();
        }
        if (sectionFunction.equals("2")) {
            sectionPage2();
        }
    }

    public void sectionPage1() {
        String line = "";
        String station = "";
        int order;
        try {
            setSectionToRegister();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return;
        }
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    private void setSectionToRegister() {
        String line;
        int order;
        String station;
        line = inputView.readSectionLine();
        station = inputView.readSectionStation();
        order = inputView.readOrder(line, station);
        ArrayList<Station> list = stationMap.get(new Line(line));
        list.add(order - 1, new Station(station));
        setMap(line, list);
    }

    private void setMap(String line, ArrayList<Station> list) {
        stationMap.put(new Line(line), list);
    }

    public void sectionPage2() {
        String line = "";
        String station = "";
        try {
            setSectionToDelete();
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return;
        }
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

    private void setSectionToDelete() {
        String station;
        String line;
        line = inputView.readSectionLine();
        station = inputView.readSectionStation();
        inputValidator.validateDeleteSection(line, station);
        ArrayList<Station> list = stationMap.get(new Line(line));
        list.remove(new Station(station));
        setMap(line, list);
    }
}
