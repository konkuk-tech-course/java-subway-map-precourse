package subway.view;

import subway.view.constant.Prefix;
import subway.view.constant.menu.Menu;
import subway.view.constant.phrase.MainPhrase;

import java.util.Arrays;

public class InputView {
    private static class InstanceHolder {
        private static final InputView INSTANCE = new InputView();
    }

    private InputView(){}

    public static InputView getInstance() {
        return InputView.InstanceHolder.INSTANCE;
    }

    
    public <T extends Menu> void printMenu(Class<T> menu) {
        Arrays.stream(menu.getEnumConstants())
                .map(Menu::getMenu)
                .forEach(System.out::println);
    }
}
