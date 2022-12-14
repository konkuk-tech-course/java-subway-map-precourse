package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import subway.repository.StationRepository;

import java.util.Set;

public class StationRepositoryTest {
    static StationRepository stationRepository = StationRepository.getInstance();

    @BeforeEach
    void beforeEach() {
        stationRepository.addStation(new Station("양재역"));
        stationRepository.addStation(new Station("강남역"));
    }

    @AfterEach
    void afterEach() {
        stationRepository.clear();
    }

    @Test
    void Find_All_Station_Name_Test() {
        Set<String> stations = Set.of("양재역", "강남역");
        assertThat(stationRepository.findAllStations()).isEqualTo(stations);
    }

    @Test
    void Delete_Station_Test() {
        stationRepository.deleteStation("양재역");
        Set<String> stations = Set.of("강남역");
        assertThat(stationRepository.findAllStations()).isEqualTo(stations);
    }

    @Test
    void Delete_Not_Exist_Station_Test() {
        assertThatThrownBy(() -> stationRepository.deleteStation("왕십리역"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("해당 역은 존재하지 않습니다.");
    }
}
