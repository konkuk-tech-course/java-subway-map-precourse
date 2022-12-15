package subway.view.validator;

public class DefaultInputValidator extends BlankValidator{
    public void validateSelect(String inputSelect){
        super.validate(inputSelect);
        validateIsNumber(inputSelect.trim());
    }
    private void validateIsNumber(String inputValue){
        if (!inputValue.matches("\\d")) {
            throw new IllegalArgumentException();
        }
    }

}
