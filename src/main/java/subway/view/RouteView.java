package subway.view;

import java.util.List;
import java.util.ListIterator;
import subway.domain.Line;
import subway.domain.Station;
import subway.view.constant.CommonCommand;
import subway.view.constant.HeadSymbol;
import subway.view.constant.command.ScreenNotice;
import subway.view.constant.command.route.RouteCommand;
import subway.view.constant.command.route.RouteDetailMessage;
import subway.view.util.InputView;
import subway.view.validator.RouteInputValidator;

public class RouteView {
    private final InputView in;
    private final OutputView out;
    private final RouteInputValidator validator;
    RouteView(InputView in, OutputView out){
        this.in = in;
        this.out = out;
        this.validator = new RouteInputValidator();
    }

    public String readNameToAdd(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(RouteDetailMessage.REQUEST_PUT));
        String name;
        do {
            name = in.read();
        } while (!checkLineName(name));
        out.printEmptyLine();
        return name;
    }
    public String readNameToDelete(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(RouteDetailMessage.REQUEST_DELETE));
        String name;
        do {
            name = in.read();
        } while (!checkLineName(name));
        out.printEmptyLine();
        return name;
    }
    private boolean checkLineName(String name){
        try {
            validator.validateLineName(name);
            return true;
        }catch (IllegalArgumentException ie){
            out.print(ie.getMessage());
            return false;
        }
    }

    public String readStartStation(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(RouteDetailMessage.REQUEST_TOP));
        String name;
        do {
            name = in.read();
        } while (!checkStationName(name));
        out.printEmptyLine();
        return name;
    }
    public String readEndStation(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(RouteDetailMessage.REQUEST_BOTTOM));
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


    public void printRouteCommand(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(ScreenNotice.ROUTE_NOTICE));
        out.print(RouteCommand.getCommands());
    }
    public void printAddComplete(){
        out.print(HeadSymbol.INFO.getSymbolMerge(RouteDetailMessage.COMPLETE_PUT));
    }
    public void printDeleteComplete(){
        out.print(HeadSymbol.INFO.getSymbolMerge(RouteDetailMessage.COMPLETE_DELETE));
    }

    public void printLineNames(List<Line> lines){
        ListIterator<Line> lineIterator = lines.listIterator();
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(RouteDetailMessage.VIEW));
        while (lineIterator.hasNext()){
            Line line = lineIterator.next();
            out.print(HeadSymbol.INFO.getSymbolMerge(line.getName()));
        }
        out.printEmptyLine();
    }

    public void printSubwayLines(List<Line> lines){
        ListIterator<Line> lineIterator = lines.listIterator();
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(ScreenNotice.SUBWAY_NOTICE));
        while (lineIterator.hasNext()){
            Line line = lineIterator.next();
            out.print(HeadSymbol.INFO.getSymbolMerge(line.getName()));
            out.print(HeadSymbol.INFO.getSymbolMerge(CommonCommand.CONTOUR));
            for(Station station : line.getStations()){
                out.print(HeadSymbol.INFO.getSymbolMerge(station.getName()));
            }
        }
        out.printEmptyLine();
    }
}
