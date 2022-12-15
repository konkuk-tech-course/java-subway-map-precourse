package subway.service;

public class LineService {
    private static class InstanceHolder {
        private static final LineService INSTANCE = new LineService();
    }

    private LineService(){}

    public static LineService getInstance() {
        return LineService.InstanceHolder.INSTANCE;
    }
}
