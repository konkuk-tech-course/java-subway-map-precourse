package subway.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.valid.InputValidator;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;

import static subway.controller.SubwayController.stationMap;
import static subway.domain.Line.getEqualLine;
import static subway.domain.Station.getEqualStation;
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
            line = inputView.readSectionLine();
            station = inputView.readSectionStation();
            order = inputView.readOrder(line, station);
            ArrayList<Station> list = stationMap.get(getEqualLine(line));
            list.add(order - 1, getEqualStation(station));
            stationMap.put(getEqualLine(line), list);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return;
        }
        System.out.println("[INFO] 구간이 등록되었습니다.");
    }

    public void sectionPage2() {
        String line = "";
        String station = "";
        try {
            line = inputView.readSectionLine();
            station = inputView.readSectionStation();
            inputValidator.validateDeleteSection(line, station);
            ArrayList<Station> list = stationMap.get(getEqualLine(line));
            list.remove(getEqualStation(station));
            stationMap.put(getEqualLine(line), list);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return;
        }
        System.out.println("[INFO] 구간이 삭제되었습니다.");
    }

}
