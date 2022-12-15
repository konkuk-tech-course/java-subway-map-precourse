package subway.view;

import subway.util.Reader;
import subway.view.constant.Prefix;
import subway.view.constant.menu.Menu;
import subway.view.constant.phrase.MainPhrase;

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

    public int readMainOption() {
        printPhrase(MainPhrase.TITLE.get());
        String input = Reader.readLine().trim();
        ViewValidator.validateMainOption(input);
        return Integer.parseInt(input);
    }

    public void printPhrase(String phrase) {
        System.out.println(Prefix.PHRASE.get() + phrase);
    }

    public <T extends Menu> void printMenu(Class<T> menu) {
        Arrays.stream(menu.getEnumConstants())
                .map(Menu::getMenu)
                .forEach(System.out::println);
    }
}
