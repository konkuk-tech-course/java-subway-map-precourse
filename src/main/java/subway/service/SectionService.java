package subway.service;

import subway.repository.LineRepository;
import subway.repository.StationRepository;

public class SectionService {
    private static class InstanceHolder {
        private static final SectionService INSTANCE = new SectionService();
    }

    private final StationRepository stationRepository = StationRepository.getInstance();
    private final LineRepository lineRepository = LineRepository.getInstance();

    private SectionService(){}

    public static SectionService getInstance() {
        return SectionService.InstanceHolder.INSTANCE;
    }

    
}
