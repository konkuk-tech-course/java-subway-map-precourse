package subway.controller;

import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

import static subway.domain.StationRepository.*;
import static subway.util.ErrorMessage.ERROR_PREDICATE;

public class StationPageController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void stationPage() {
        try {
            outputView.printStationMenu();
            String stationFunction = inputView.readFunction();
            stationPageAction(stationFunction);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            stationPage();
        }
    }

    public void stationPageAction(String stationFunction) {
        if (stationFunction.equals("1")) {
            stationPage1();
        }
        if (stationFunction.equals("2")) {
            stationPage2();
        }
        if (stationFunction.equals("3")) {
            stationPage3();
        }
    }

    public void stationPage1() {
        String input = "";
        try {
            input = inputView.readRegisterStation();
            addStation(new Station(input));
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return;
        }
        System.out.println("[INFO] " + input + "이 등록되었습니다.");
    }

    public void stationPage2() {
        String input = "";
        try {
            deleteStation(inputView.readDeleteStation());

        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return;
        }
        System.out.println("[INFO] " + input + "이 삭제되었습니다.");
    }

    public void stationPage3() {
        for (int i = 0; i < stations().size(); i++) {
            System.out.print("[INFO] ");
            System.out.println(stations().get(i).getName());
        }
    }
}
