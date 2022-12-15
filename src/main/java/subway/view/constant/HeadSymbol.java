package subway.view.constant;

public enum HeadSymbol {
    INFO("[INFO]"),
    MSG_HEAD("##"),
    ERROR("[ERROR]");
    private static final String SPACE = " ";
    private final String symbol;
    HeadSymbol(String symbol){
        this.symbol = symbol;
    }
    public String getSymbolMerge(String message){
        return symbol+SPACE+message;
    }
}
