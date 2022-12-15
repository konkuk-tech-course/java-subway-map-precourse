package subway.view.validator;

public class RouteInputValidator extends BlankValidator {
    private static final int STANDARD_LENGTH = 3 ;
    public void validateLineName(String inputName) {
        super.validate(inputName);
        validateLineFormat(inputName.trim());
    }
    private void validateLineFormat(String inputName) {
        if (!inputName.matches("선$")) {
            throw new IllegalArgumentException();
        }
    }

    public void validateStationName(String inputName){
        super.validate(inputName);
        validateStationFormat(inputName.trim());
        validateNameLength(inputName.trim());
    }
    private void validateStationFormat(String inputName){
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
