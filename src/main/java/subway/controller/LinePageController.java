package subway.controller;

import subway.domain.Line;
import subway.domain.Station;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.ArrayList;
import java.util.List;

import static subway.controller.SubwayController.stationMap;
import static subway.domain.LineRepository.*;
import static subway.util.ErrorMessage.ERROR_PREDICATE;

public class LinePageController {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void linePage() {
        try {
            outputView.printLineMenu();
            String lineFunction = inputView.readFunction();
            linePageAction(lineFunction);
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            linePage();
        }
    }

    public void linePageAction(String lineFunction) {
        if (lineFunction.equals("1")) {
            linePage1();
        }
        if (lineFunction.equals("2")) {
            linePage2();
        }
        if (lineFunction.equals("3")) {
            linePage3();
        }
    }

    public void linePage1() {
        String input = "";
        try {
            input = inputView.readRegisterLine();
            Station upEndStation = inputView.readUpEndStation();
            Station downEndStation = inputView.readDownEndStation(upEndStation);
            addLine(new Line(input));
            stationMap.put(new Line(input), new ArrayList<>(List.of(upEndStation, downEndStation)));
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return;
        }
        System.out.println("[INFO] " + input + "이 등록되었습니다.");
    }

    public void linePage2() {
        String input = "";
        try {
            deleteLineByName(inputView.readDeleteLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return;
        }
        System.out.println("[INFO] " + input + "이 삭제되었습니다.");
    }

    public void linePage3() {
        for (int i = 0; i < lines().size(); i++) {
            System.out.print("[INFO] ");
            System.out.println(lines().get(i).getName());
        }
    }
}
