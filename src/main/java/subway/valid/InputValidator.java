package subway.valid;

import subway.domain.Line;
import subway.domain.Station;

import java.util.*;

import static subway.controller.SubwayController.stationMap;
import static subway.domain.Line.getEqualLine;
import static subway.domain.LineRepository.lines;
import static subway.domain.StationRepository.stations;
import static subway.util.ErrorMessage.*;

public class InputValidator {
    public String validateMainFunction(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4") || input.equals("Q")) {
            return input;
        }
        throw new IllegalArgumentException(WRONG_FUNCTION);
    }

    public String validateFunction(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("3") || input.equals("B")) {
            return input;
        }
        throw new IllegalArgumentException(WRONG_FUNCTION);
    }

    public String validateSectionFunction(String input) {
        if (input.equals("1") || input.equals("2") || input.equals("B")) {
            return input;
        }
        throw new IllegalArgumentException(WRONG_FUNCTION);
    }

    public String validateRegisterStation(String input) {
        if (stations().contains(new Station(input))) {
            throw new IllegalArgumentException(DUPLICATED);
        }
        return input;
    }

    public String validateDeleteStation(String input) {
        if (!stations().contains(new Station(input))) {
            throw new IllegalArgumentException(NOT_REGISTERED);
        }
        validateExistingStation(input);
        return input;
    }

    private void validateExistingStation(String input) {
        for (Map.Entry<Line, ArrayList<Station>> e : stationMap.entrySet()) {
            ArrayList<Station> list = e.getValue();
            if (list.contains(new Station(input))) {
                throw new IllegalArgumentException(REGISTERED_IN_LINE);
            }
        }
    }

    public String validateRegisterLine(String input) {
        if (lines().contains(new Line(input))) {
            throw new IllegalArgumentException(DUPLICATED);
        }
        return input;
    }

    public String validateDeleteLine(String input) {
        if (!lines().contains(new Line(input))) {
            throw new IllegalArgumentException(NOT_REGISTERED);
        }
        return input;
    }

    public Station validateEndStation(String input) {
        Station station = new Station(input);
        if (!stations().contains(station)) {
            throw new IllegalArgumentException(NOT_REGISTERED);
        }
        return station;
    }

    public String validateSectionStation(String input) {
        if (!stations().contains(new Station(input))) {
            throw new IllegalArgumentException(NOT_REGISTERED);        }
        return input;
    }

    public int validateOrder(String input, String line, String station) {
        int order = convertStringToNum(input);
        checkAlreadyInLine(line, station);
        checkOrderOutOfScope(line, order);
        return order;
    }

    private static void checkOrderOutOfScope(String line, int order) {
        if (order < 1 || order > stationMap.get(new Line(line)).size() + 1) {
            throw new IllegalArgumentException(OUT_OF_SCOPE);
        }
    }

    private static void checkAlreadyInLine(String line, String station) {
        if (stationMap.get(new Line(line)).contains(new Station(station))) {
            throw new IllegalArgumentException(ALREADY_IN_LINE);
        }
    }

    private static int convertStringToNum(String input) {
        int order;
        try {
            order = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER);
        }
        return order;
    }

    public void validateDeleteSection(String line, String station) {
        if (!stationMap.get(new Line(line)).contains(new Station(station))) {
            throw new IllegalArgumentException(NOT_IN_LINE);
        }
        if (stationMap.get(getEqualLine(line)).size() <= 2) {
            throw new IllegalArgumentException(SHORT_LINE);
        }
    }
}
