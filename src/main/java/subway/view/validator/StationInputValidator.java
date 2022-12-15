package subway.view.validator;

public class StationInputValidator extends BlankValidator {

    private static final int STANDARD_LENGTH = 3 ;

    public void validateStationName(String inputName){
        super.validate(inputName);
        validateFormat(inputName.trim());
        validateNameLength(inputName.trim());
    }
    private void validateFormat(String inputName){
        if (!inputName.matches("[ㄱ-ㅎ|가-힣]+")) {
            throw new IllegalArgumentException();
        }
    }
    private void validateNameLength(String inputValue){
        if(inputValue.length() != STANDARD_LENGTH){
            throw new IllegalArgumentException();
        }
    }
}
