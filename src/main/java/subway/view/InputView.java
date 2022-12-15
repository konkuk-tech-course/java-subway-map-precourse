package subway.view;

import subway.util.Validator;

import java.util.Scanner;

public class InputView {

    private final Scanner scanner;
    private final Validator validator;

    public InputView() {
        this.scanner = new Scanner(System.in);
        this.validator = new Validator();
    }

    public String readFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();
        validator.validateWhenTotalOptionsAreFive(input);
        return input;
    }

    public String readStationFunction(){
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();
        validator.validateWhenTotalOptionsAreFour(input);
        return input;
    }

    public String readStationToRegister(){
        System.out.println("## 등록할 역 이름을 입력하세요.");
        String input = scanner.nextLine();
        // TODO : VALIDATE 사항추가 (중복 및 2글자 이상 VALIDATE)
        return input;
    }

    public String readStationToRemove() {
        System.out.println("## 삭제할 역 이름을 입력하세요.");
        String stationToRemove = scanner.nextLine();
        return stationToRemove;
    }

    // ---------------노선관리----------------
    public String readLineFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();
        validator.validateWhenTotalOptionsAreFour(input);
        return input;
    }

    public String readLineToRegister(){
        System.out.println("## 등록할 노선 이름을 입력하세요.");
        String input = scanner.nextLine();
        // TODO : VALIDATE 사항추가 (중복 및 2글자 이상 VALIDATE)
        return input;
    }

    public String readUpStopStationName() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String upStopStationName = scanner.nextLine();
        // TODO : VALIDATE
        return upStopStationName;
    }

    public String readDownStopStationName() {
        System.out.println("## 등록할 노선의 상행 종점역 이름을 입력하세요.");
        String downStopStationName = scanner.nextLine();
        // TODO : VALIDATE
        return downStopStationName;
    }

    public String readLineToRemove() {
        System.out.println("## 삭제할 노선 이름을 입력하세요.");
        String lineToRemove = scanner.nextLine();

        return lineToRemove;
    }

    // -------------- 구간 관리 ------------
    public String readSectionFunction() {
        System.out.println("## 원하는 기능을 선택하세요.");
        String input = scanner.nextLine();
        validator.validateWhenTotalOptionsAreThree(input);
        return input;
    }

    public String readLineToRegisterInSection() {
        System.out.println("## 노선을 입력하세요.");
        String input = scanner.nextLine();
        // TODO: VALIDATE
        return input;
    }
    public String readStationToRegisterInSection() {
        System.out.println("## 역이름을 입력하세요.");
        String input = scanner.nextLine();
        // TODO: VALIDATE
        return input;
    }
    public int readOrderToRegisterInSection() {
        System.out.println("## 순서를 입력하세요.");
        String input = scanner.nextLine();
        // TODO: VALIDATE
        int order = Integer.parseInt(input);
        return order;
    }
}
