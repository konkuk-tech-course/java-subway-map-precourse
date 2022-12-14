package subway.service;

import subway.domain.StationRepository;

public class StationService {
    private static class InstanceHolder {
        private static final StationService INSTANCE = new StationService();
    }

    private StationService(){}

    public StationService getInstance() {
        return StationService.InstanceHolder.INSTANCE;
    }
}
