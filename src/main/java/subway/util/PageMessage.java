package subway.util;

public class PageMessage {
    public static final String MAIN_PAGE="\n## 메인 화면\n" +
            "1. 역 관리\n" +
            "2. 노선 관리\n" +
            "3. 구간 관리\n" +
            "4. 지하철 노선도 출력\n" +
            "Q. 종료";

    public static final String STATION_PAGE="\n## 역 관리 화면\n" +
            "1. 역 등록\n" +
            "2. 역 삭제\n" +
            "3. 역 조회\n" +
            "B. 돌아가기";

    public static final String LINE_PAGE="\n## 노선 관리 화면\n" +
            "1. 노선 등록\n" +
            "2. 노선 삭제\n" +
            "3. 노선 조회\n" +
            "B. 돌아가기";

    public static final String SECTION_PAGE="\n## 구간 관리 화면\n" +
            "1. 구간 등록\n" +
            "2. 구간 삭제\n" +
            "B. 돌아가기";

    public static final String INPUT_REGISTER_STATION= "\n## 등록할 역 이름을 입력하세요.";

    public static final String INPUT_DELETE_STATION= "\n## 삭제할 역 이름을 입력하세요.";

    public static final String INPUT_REGISTER_LINE= "\n## 등록할 노선 이름을 입력하세요.";

    public static final String INPUT_DELETE_LINE= "\n## 삭제할 노선 이름을 입력하세요.";
    public static final String INPUT_FUNCTION= "\n## 원하는 기능을 선택하세요.";
    public static final String INPUT_UP_END_STATION= "\n## 등록할 노선의 상행 종점역 이름을 입력하세요.";
    public static final String INPUT_DOWN_END_STATION= "\n## 등록할 노선의 하행 종점역 이름을 입력하세요.";
    public static final String INPUT_SECTION_LINE= "\n## 노선을 입력하세요.";
    public static final String INPUT_SECTION_STATION= "\n## 역이름을 입력하세요.";
    public static final String INPUT_ORDER= "\n## 순서를 입력하세요.";
}
