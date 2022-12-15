package subway.view;

import java.util.List;
import java.util.ListIterator;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.constant.HeadSymbol;
import subway.view.constant.command.ScreenNotice;
import subway.view.constant.command.route.RouteCommand;
import subway.view.constant.command.route.RouteDetailMessage;
import subway.view.constant.command.station.StationCommand;
import subway.view.constant.command.station.StationDetatilMessage;
import subway.view.constant.command.station.StationFeature;
import subway.view.util.InputView;
import subway.view.validator.StationInputValidator;

public class StationView {
//    private static InputView in = new InputView();
//    private static OutputView out = new OutputView();
    private final InputView in;
    private final OutputView out;
    private final StationInputValidator validator;
    public StationView(InputView in, OutputView out){
        this.in = in;
        this.out = out;
        this.validator = new StationInputValidator();
    }

    public String readNameToAdd(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(StationDetatilMessage.REQUEST_PUT));
        String name;
        do {
            name = in.read();
        } while (!checkStationName(name));
        out.printEmptyLine();
        return name;
    }
    public String readNameToDelete(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(StationDetatilMessage.REQUEST_DELETE));
        String name;
        do {
            name = in.read();
        } while (!checkStationName(name));
        out.printEmptyLine();
        return name;
    }
    private boolean checkStationName(String name){
        try {
            validator.validateStationName(name);
            return true;
        }catch (IllegalArgumentException ie){
            out.print(ie.getMessage());
            return false;
        }
    }




    public void printStationCommand(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(ScreenNotice.STATION_NOTICE));
        out.print(StationCommand.getCommands());
    }
    public void printAddComplete(){
        out.print(HeadSymbol.INFO.getSymbolMerge(StationDetatilMessage.COMPLETE_PUT));
    }
    public void printDeleteComplete(){
        out.print(HeadSymbol.INFO.getSymbolMerge(StationDetatilMessage.COMPLETE_DELETE));
    }

    public void printStationNames(List<Station> stations){
        ListIterator<Station> stationIterator = stations.listIterator();
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(RouteDetailMessage.VIEW));
        while (stationIterator.hasNext()){
            Station station = stationIterator.next();
            out.print(HeadSymbol.INFO.getSymbolMerge(station.getName()));
        }
        out.printEmptyLine();
    }
}
