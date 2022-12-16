package subway.view;

import subway.domain.Station;
import subway.util.Reader;
import subway.view.constant.Prefix;
import subway.view.constant.menu.LineMenu;
import subway.view.constant.menu.MainMenu;
import subway.view.constant.menu.Menu;
import subway.view.constant.menu.StationMenu;
import subway.view.constant.phrase.*;

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
        String input = Reader.readLine().trim();
        ViewValidator.validateMainOption(input);
        return input;
    }

    public String readStationOption() {
        String input = Reader.readLine().trim();
        ViewValidator.validateStationOption(input);
        return input;
    }

    public String readNonEmptyInput() {
        String input = Reader.readLine();
        ViewValidator.validateNonEmptyInput(input);
        return input;
    }

    public String readLineOption() {
        String input = Reader.readLine().trim();
        ViewValidator.validateLineOption(input);
        return input;
    }

    public String readSectionOption() {
        String input = Reader.readLine().trim();
        ViewValidator.validateSectionOption(input);
        return input;
    }

    public int readOrder() {
        String input = Reader.readLine().trim();
        ViewValidator.validateNumberInput(input);
        return Integer.parseInt(input);
    }

    private void insertLineBreak() {
        System.out.println();
    }
}
