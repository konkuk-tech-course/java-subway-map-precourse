package subway.view;

import subway.view.constant.Prefix;
import subway.view.constant.menu.*;
import subway.view.constant.phrase.*;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

public class OutputView {
    private static class InstanceHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    private OutputView(){}

    public static OutputView getInstance() {
        return OutputView.InstanceHolder.INSTANCE;
    }

    public void printStations(Set<String> stations) {
        stations.forEach(this::printInfoPhrase);
    }

    public void printLines(List<String> stations) {
        stations.forEach(this::printInfoPhrase);
    }

    public void printMainScreen() {
        printPhrase(MainPhrase.TITLE.get());
        printMenu(MainMenu.class);
    }

    public void printStationScreen() {
        printPhrase(StationPhrase.TITLE.get());
        printMenu(StationMenu.class);
    }

    public void printLineScreen() {
        printPhrase(LinePhrase.TITLE.get());
        printMenu(LineMenu.class);
    }

    public void printSectionScreen() {
        printPhrase(SectionPhrase.TITLE.get());
        printMenu(SectionMenu.class);
    }

    public void printOptionRequestPhrase() {
        insertLineBreak();
        printPhrase(CommonPhrase.OPTION_INPUT.get());
    }

    public <T extends Menu> void printMenu(Class<T> menu) {
        Arrays.stream(menu.getEnumConstants())
                .map(Menu::getMenu)
                .forEach(System.out::println);
    }

    public void printPhrase(String phrase) {
        System.out.println(Prefix.PHRASE.get() + phrase);
    }
    
    public void printInfoPhrase(String phrase) {
        System.out.println(Prefix.INFO.get() + phrase);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(Prefix.ERROR.get() + errorMessage);
    }

    public void insertLineBreak() {
        System.out.println();
    }
}
