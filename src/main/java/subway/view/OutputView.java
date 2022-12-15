package subway.view;

import subway.view.constant.Prefix;

import java.util.List;
import java.util.Set;

public class OutputView {
    private static class InstanceHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

    private OutputView(){}

    public static OutputView getInstance() {
        return OutputView.InstanceHolder.INSTANCE;
    }

    public void printStations(Set<String> stations) {
        stations.forEach(this::printInfoPhrase);
    }

    public void printLines(List<String> stations) {
        stations.forEach(this::printInfoPhrase);
    }
    
    public void printInfoPhrase(String phrase) {
        System.out.println(Prefix.INFO.get() + phrase);
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(Prefix.ERROR.get() + errorMessage);
    }

    public void insertLineBreak() {
        System.out.println();
    }
}
