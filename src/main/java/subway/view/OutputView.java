package subway.view;

import static subway.util.PageMessage.*;

public class OutputView {

    public void printMainMenu() {
        System.out.println(MAIN_PAGE);

    }

    public void printStationMenu() {
        System.out.println(STATION_PAGE);
    }

    public void printLineMenu() {
        System.out.println(LINE_PAGE);
    }

    public void printSectionMenu() {
        System.out.println(SECTION_PAGE);
    }
}

