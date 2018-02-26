package life.qbic.model;

import com.vaadin.addon.charts.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasicBarModel extends AModel {

    private final List<Series> series;
    private final PlotOptionsBar options;

    public BasicBarModel(Configuration configuration, String title, String subtitle, AxisTitle xAxisTitle, AxisTitle yAxisTitle,
                         Tooltip tooltip, Legend legend, PlotOptionsBar options){

        super(configuration, title, subtitle, xAxisTitle, yAxisTitle, legend);

        this.configuration.setTooltip(tooltip);

        this.options = options;
        this.options.setDataLabels(new DataLabels(true));
        this.configuration.setPlotOptions(options);

        this.series = new ArrayList<>();
        this.configuration.setSeries(series);

        this.configuration.disableCredits();

    }

    public void addXCategorie(String... cat){
        xAxis.setCategories(cat);
    }

    public void setyMin(int yMin){
        yAxis.setMin(yMin);
    }

    public void addData(ListSeries... listSeries){
        Arrays.stream(listSeries).forEach(l -> this.series.add(l));
    }

    public void clearData(){
        this.series.clear();
    }

}
