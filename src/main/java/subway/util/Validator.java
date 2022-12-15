package subway.util;

public class Validator {
    public void validateWhenTotalOptionsAreFive(String input) {
        if (!isValidFiveOptions(input)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }

    private boolean isValidFiveOptions(String input) {
        return input.equals("Q") || input.equals("1") || input.equals("2") || input.equals("3") || input.equals("4");
    }

    public void validateWhenTotalOptionsAreFour(String input) {
        if (!isValidFourOptions(input)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }

    private boolean isValidFourOptions(String input) {
        return input.equals("1") || input.equals("2") || input.equals("3") || input.equals("B");
    }


    public void validateWhenTotalOptionsAreThree(String input) {
        if (!isValidThreeOptions(input)) {
            throw new IllegalArgumentException("[ERROR] 선택할 수 없는 기능입니다.");
        }
    }

    private boolean isValidThreeOptions(String input) {
        return input.equals("1") || input.equals("2") || input.equals("B");
    }
}
