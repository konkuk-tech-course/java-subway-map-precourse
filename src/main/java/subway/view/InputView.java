package subway.view;

import subway.domain.Station;
import subway.valid.InputValidator;

import java.util.Scanner;

import static subway.util.ErrorMessage.*;
import static subway.util.PageMessage.*;

public class InputView {

    Scanner scanner = new Scanner(System.in);
    InputValidator inputValidator = new InputValidator();

    public String readMainFunction() {
        try {
            System.out.println(INPUT_FUNCTION);
            return inputValidator.validateMainFunction(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return readMainFunction();
        }
    }

    public String readFunction() {
        try {
            System.out.println(INPUT_FUNCTION);
            return inputValidator.validateFunction(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return readFunction();
        }
    }

    public String readSectionFunction() {
        try {
            System.out.println(INPUT_FUNCTION);
            return inputValidator.validateSectionFunction(scanner.nextLine());
        } catch (IllegalArgumentException e) {
            System.out.println(ERROR_PREDICATE + e.getMessage());
            return readFunction();
        }
    }

    public String readRegisterStation() {
        System.out.println(INPUT_REGISTER_STATION);
        return inputValidator.validateRegisterStation(scanner.nextLine());
    }

    public String readDeleteStation() {
        System.out.println(INPUT_DELETE_STATION);
        return inputValidator.validateDeleteStation(scanner.nextLine());
    }

    public String readRegisterLine() {
        System.out.println(INPUT_REGISTER_LINE);
        return inputValidator.validateRegisterLine(scanner.nextLine());
    }

    public String readDeleteLine() {
        System.out.println(INPUT_DELETE_LINE);
        return inputValidator.validateDeleteLine(scanner.nextLine());
    }

    public Station readUpEndStation() {
        System.out.println(INPUT_UP_END_STATION);
        return inputValidator.validateEndStation(scanner.nextLine());
    }

    public Station readDownEndStation(Station upEndStation) {
        System.out.println(INPUT_DOWN_END_STATION);
        Station downEndStation = inputValidator.validateEndStation(scanner.nextLine());
        if (downEndStation.equals(upEndStation)) {
            throw new IllegalArgumentException(SAME_WITH_UP_END_STATION);
        }
        return downEndStation;
    }

    public String readSectionLine() {
        System.out.println(INPUT_SECTION_LINE);
        return inputValidator.validateDeleteLine(scanner.nextLine());
    }

    public String readSectionStation() {
        System.out.println(INPUT_SECTION_STATION);
        return inputValidator.validateSectionStation(scanner.nextLine());
    }

    public int readOrder(String line, String station) {
        System.out.println(INPUT_ORDER);
        return inputValidator.validateOrder(scanner.nextLine(), line, station);
    }
}


