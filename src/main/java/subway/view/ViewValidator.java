package subway.view;

import subway.view.constant.ValidationRegex;
import subway.view.constant.ViewErrorMessage;

import java.util.regex.Pattern;

public class ViewValidator {
    public static void validateNonEmptyInput(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }
    }

    public static void validateMainOption(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }

        if (!isValidOption(ValidationRegex.MAIN_MENU.get(), input)) {
            throw new IllegalArgumentException(ViewErrorMessage.INVALID_OPTION.get());
        }
    }

    public static void validateStationOption(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }

        if (!isValidOption(ValidationRegex.STATION_MENU.get(), input)) {
            throw new IllegalArgumentException(ViewErrorMessage.INVALID_OPTION.get());
        }
    }

    public static void validateLineOption(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }

        if (!isValidOption(ValidationRegex.LINE_MENU.get(), input)) {
            throw new IllegalArgumentException(ViewErrorMessage.INVALID_OPTION.get());
        }
    }

    public static void validateSectionOption(String input) {
        if (isEmpty(input)) {
            throw new IllegalArgumentException(ViewErrorMessage.EMPTY.get());
        }

        if (!isValidOption(ValidationRegex.SECTION_MENU.get(), input)) {
            throw new IllegalArgumentException(ViewErrorMessage.INVALID_OPTION.get());
        }
    }

    // TODO: 구간 옵션 입력 유효성 검증
//    public static void

    private static boolean isEmpty(String input) {
        return Pattern.matches(ValidationRegex.EMPTY.get(), input);
    }

    private static boolean isValidOption(String menuRegex, String input) {
        return Pattern.matches(menuRegex, input);
    }

    private static boolean isNumber(String input) {
        return Pattern.matches(ValidationRegex.NUMBER.get(), input);
    }
}
