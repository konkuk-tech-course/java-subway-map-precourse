package subway.util;

import subway.view.InputView;

import java.lang.reflect.Field;
import java.util.Objects;
import java.util.Scanner;

public class Reader {
    private static Scanner scanner;

    private Reader() {
    }

    public static String readLine() {
        return getInstance().nextLine();
    }

    private static Scanner getInstance() {
        if (Objects.isNull(scanner) || isClosed()) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }

    private static boolean isClosed() {
        try {
            final Field sourceClosedField = Scanner.class.getDeclaredField("sourceClosed");
            sourceClosedField.setAccessible(true);
            return sourceClosedField.getBoolean(scanner);
        } catch (final Exception e) {
            System.out.println("unable to determine if the scanner is closed.");
        }
        return true;
    }
}
