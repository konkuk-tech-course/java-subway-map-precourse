package subway.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class StationTest {
    @ParameterizedTest(name = "{index}) name : {0}")
    @ValueSource(strings = {"양재역", "강남역", "왕십리역"})
    void Station_Name_Validation_Test(String name) {
        assertThatCode(() -> new Station(name)).doesNotThrowAnyException();
    }

    @ParameterizedTest(name = "{index}) name : {0}")
    @ValueSource(strings = {"", "역"})
    void Station_Invalid_Name_Validation_Test(String name) {
        assertThatThrownBy(() -> new Station(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]")
                .hasMessageContaining("2글자 이상");
    }
}
