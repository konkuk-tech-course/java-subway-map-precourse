package subway.view.util;

import java.util.Scanner;
import subway.view.OutputView;
import subway.view.constant.CommonCommand;
import subway.view.constant.HeadSymbol;
import subway.view.validator.DefaultInputValidator;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final OutputView out = new OutputView();

    private final DefaultInputValidator validator = new DefaultInputValidator();


    public String readSelectFeature(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(CommonCommand.REQUEST_SELECT));
        String selectedFeature ;
        do {
            selectedFeature = read();
        } while (!checkSelection(selectedFeature));
        out.printEmptyLine();
        return selectedFeature;
    }
    private boolean checkSelection(String selected){
        try {
            validator.validateSelect(selected);
            return true;
        }catch (IllegalArgumentException ie){
            out.print(ie.getMessage());
            return false;
        }
    }
    public String read(){
        String readValue = scanner.nextLine();
        out.printEmptyLine();
        return readValue;
    }


}
