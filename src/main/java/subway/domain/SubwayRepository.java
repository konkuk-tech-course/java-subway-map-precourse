package subway.domain;

import java.util.LinkedList;
import java.util.Map;

public class SubwayRepository {
    private LinkedList<Map<Station,Line>> lines= new LinkedList<Map<Station,Line>> ();
    private String frontStation;
    private String backStation;
}
