package com.ytwytw.test2;

import android.app.Fragment;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androidplot.xy.LineAndPointFormatter;
import com.androidplot.xy.SimpleXYSeries;
import com.androidplot.xy.XYPlot;
import com.androidplot.xy.XYSeries;
import com.androidplot.xy.XYStepMode;

import java.util.Arrays;
import java.util.Random;

public class Fragment_Plot extends Fragment {

    public XYPlot plot;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_plot, container, false);
        // initialize our XYPlot reference:
        // initialize our XYPlot reference:
        plot = (XYPlot) rootView.findViewById(R.id.mySimpleXYPlot);


        // Create a couple arrays of y-values to plot:
        Number[] series1Numbers = {ramgen(), ramgen(), ramgen(), ramgen(), ramgen(), ramgen()};
        Number[] series2Numbers = {ramgen(), ramgen(), ramgen(), ramgen(), ramgen(), ramgen()};
        Number[] series3Numbers = {ramgen(), ramgen(), ramgen(), ramgen(), ramgen(), ramgen()};
        Number[] series4Numbers = {ramgen(), ramgen(), ramgen(), ramgen(), ramgen(), ramgen()};
        Number[] series5Numbers = {ramgen(), ramgen(), ramgen(), ramgen(), ramgen(), ramgen()};
//        Number[] series5Numbers = {4, 6, 3, 8, 2, 10};

        // Turn the above arrays into XYSeries':
        XYSeries series1 = new SimpleXYSeries(
                Arrays.asList(series1Numbers),          // SimpleXYSeries takes a List so turn our array into a List
                SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, // Y_VALS_ONLY means use the element index as the x value
                "CH 1");                             // Set the display title of the series

        // same as above
        XYSeries series2 = new SimpleXYSeries(Arrays.asList(series2Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "CH 2");
        XYSeries series3 = new SimpleXYSeries(Arrays.asList(series3Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "CH 3");
        XYSeries series4 = new SimpleXYSeries(Arrays.asList(series4Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "CH 4");
        XYSeries series5 = new SimpleXYSeries(Arrays.asList(series5Numbers), SimpleXYSeries.ArrayFormat.Y_VALS_ONLY, "CH 5");

        // Create a formatter to use for drawing a series using LineAndPointRenderer
        // and configure it from xml:
        LineAndPointFormatter series1Format = new LineAndPointFormatter(Color.RED, Color.YELLOW, null, null);

        // add a new series' to the xy plot:
         plot.addSeries(series1, series1Format);

        // same as above:
        LineAndPointFormatter series2Format = new LineAndPointFormatter(Color.CYAN, Color.YELLOW, null, null);
        plot.addSeries(series2, series2Format);

        LineAndPointFormatter series3Format = new LineAndPointFormatter(Color.BLUE, Color.YELLOW, null, null);
        plot.addSeries(series3, series3Format);

        LineAndPointFormatter series4Format = new LineAndPointFormatter(Color.LTGRAY, Color.YELLOW, null, null);
        plot.addSeries(series4, series4Format);

        LineAndPointFormatter series5Format = new LineAndPointFormatter(Color.MAGENTA, Color.YELLOW, null, null);
        plot.addSeries(series5, series5Format);

        plot.setDomainStep(XYStepMode.INCREMENT_BY_VAL,1.0);


        // reduce the number of range labels
         plot.setTicksPerRangeLabel(3);
         plot.getGraphWidget().setDomainLabelOrientation(-45);
        return rootView;
    }

    public int ramgen(){
        Random random = new Random();
        return (random.nextInt(25)%(25-5+1) + 5);

    }

}
