package subway.view;

import java.util.Scanner;

import static subway.util.PageMessage.INPUT_FUNCTION;

public class InputView {

    Scanner scanner=new Scanner(System.in);

    public void readFunction(){
        System.out.println(INPUT_FUNCTION);
        String input=scanner.nextLine();
    }
}
