package subway.view;

import subway.domain.Station;
import subway.util.Reader;
import subway.view.constant.Prefix;
import subway.view.constant.menu.LineMenu;
import subway.view.constant.menu.MainMenu;
import subway.view.constant.menu.Menu;
import subway.view.constant.menu.StationMenu;
import subway.view.constant.phrase.*;

import java.io.Console;
import java.util.Arrays;

public class InputView {
    private static class InstanceHolder {
        private static final InputView INSTANCE = new InputView();
    }

    private InputView(){}

    public static InputView getInstance() {
        return InputView.InstanceHolder.INSTANCE;
    }

    public String readMainOption() {
        printPhrase(MainPhrase.TITLE.get());
        printMenu(MainMenu.class);
        insertLineBreak();
        printPhrase(CommonPhrase.OPTION_INPUT.get());
        String input = Reader.readLine().trim();
        ViewValidator.validateMainOption(input);
        return input;
    }

    public String readStationOption() {
        printPhrase(StationPhrase.TITLE.get());
        printMenu(StationMenu.class);
        insertLineBreak();
        printPhrase(CommonPhrase.OPTION_INPUT.get());
        String input = Reader.readLine().trim();
        ViewValidator.validateStationOption(input);
        return input;
    }

    public String readStationNameToBeRegistered() {
        printPhrase(StationPhrase.REGISTER.get());
        return readNonEmptyInput();
    }

    public String readStationNameToBeDeleted() {
        printPhrase(StationPhrase.DELETE.get());
        return readNonEmptyInput();
    }

    private String readNonEmptyInput() {
        String input = Reader.readLine();
        ViewValidator.validateNonEmptyInput(input);
        return input;
    }

    public String readLineOption() {
        printPhrase(LinePhrase.TITLE.get());
        printMenu(LineMenu.class);
        insertLineBreak();
        printPhrase(CommonPhrase.OPTION_INPUT.get());
        String input = Reader.readLine().trim();
        ViewValidator.validateLineOption(input);
        return input;
    }

    public String readLineNameToBeRegistered() {
        printPhrase(LinePhrase.REGISTER.get());
        return readNonEmptyInput();
    }

    public String readStartStationName() {
        printPhrase(LinePhrase.REGISTER_START_STATION.get());
        return readNonEmptyInput();
    }

    public String readEndStationName() {
        printPhrase(LinePhrase.REGISTER_END_STATION.get());
        return readNonEmptyInput();
    }

    public String readLineNameToBeDeleted() {
        printPhrase(LinePhrase.DELETE.get());
        return readNonEmptyInput();
    }

    public String readSectionOption() {
        printPhrase(StationPhrase.TITLE.get());
        printMenu(StationMenu.class);
        insertLineBreak();
        printPhrase(CommonPhrase.OPTION_INPUT.get());
        String input = Reader.readLine().trim();
        ViewValidator.validateSectionOption(input);
        return input;
    }

    public String readLineNameToBeEdited() {
        printPhrase(SectionPhrase.REGISTER_LINE_INPUT.get());
        return readNonEmptyInput();
    }

    public String readStationNameToBeAdded() {
        printPhrase(SectionPhrase.REGISTER_STATION_INPUT.get());
        return readNonEmptyInput();
    }

    public void printPhrase(String phrase) {
        System.out.println(Prefix.PHRASE.get() + phrase);
    }

    public <T extends Menu> void printMenu(Class<T> menu) {
        Arrays.stream(menu.getEnumConstants())
                .map(Menu::getMenu)
                .forEach(System.out::println);
    }

    private void insertLineBreak() {
        System.out.println();
    }
}
