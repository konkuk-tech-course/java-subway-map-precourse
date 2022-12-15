package subway.view.validator;

public class BlankValidator {
    public void validate(String inputValue) {
        validateIsBlank(inputValue);
    }
    private void validateIsBlank(String inputValue){
        if (inputValue.isBlank()) {
            throw new IllegalArgumentException();
        }
    }
}
