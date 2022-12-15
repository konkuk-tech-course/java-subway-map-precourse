package subway.view;

import subway.view.constant.HeadSymbol;
import subway.view.constant.command.ScreenNotice;
import subway.view.constant.command.route.RouteDetailMessage;
import subway.view.constant.command.section.SectionCommand;
import subway.view.constant.command.section.SectionDetailMessage;
import subway.view.constant.command.station.StationCommand;
import subway.view.constant.command.station.StationDetatilMessage;
import subway.view.util.InputView;

public class SectionView {
    private final InputView in;
    private final OutputView out;
    SectionView(InputView in, OutputView out){
        this.in = in;
        this.out = out;
    }

    public String readRouteNameToAdd(){
        out.print(SectionDetailMessage.REQUEST_ADD_ROUTE);
        String name = in.read();
        out.printEmptyLine();
        return name;
    }
    public String readStationNameToAdd(){
        out.print(SectionDetailMessage.REQUEST_ADD_STATION);
        String name = in.read();
        out.printEmptyLine();
        return name;
    }
    public String readIndexToAdd(){
        out.print(SectionDetailMessage.REQUEST_ADD_INDEX);
        String name = in.read();
        out.printEmptyLine();
        return name;
    }
    public String readRouteNameToDelete(){
        out.print(SectionDetailMessage.REQUEST_DELETE_ROUTE);
        String name = in.read();
        out.printEmptyLine();
        return name;
    }
    public String readStationNameToDelete(){
        out.print(SectionDetailMessage.REQUEST_DELETE_STATION);
        String name = in.read();
        out.printEmptyLine();
        return name;
    }





    public void printSectionCommand(){
        out.print(HeadSymbol.MSG_HEAD.getSymbolMerge(ScreenNotice.SECTION_NOTICE));
        out.print(SectionCommand.getCommands());
    }
    public void printAddComplete(){
        out.print(HeadSymbol.INFO.getSymbolMerge(SectionDetailMessage.COMPLETE_ADD));
    }
    public void printDeleteComplete(){
        out.print(HeadSymbol.INFO.getSymbolMerge(SectionDetailMessage.COMPLETE_DELETE));
    }
}
