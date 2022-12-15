package subway.controller;

import subway.view.OutputView;

import java.util.function.Supplier;

public class Requester {
    private static final OutputView outputView = OutputView.getInstance();

    public static String requestStringInput(Supplier<String> supplier) {
        try {
            return supplier.get();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
            return requestStringInput(supplier);
        }
    }
}
