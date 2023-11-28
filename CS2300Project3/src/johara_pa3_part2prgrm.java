import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import Jama.Matrix;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;

import javax.swing.*;

public class johara_pa3_part2prgrm {
    public static void main(String[] args) throws IOException {
        File file = new File("C:\\GitHub\\CS2300\\CS2300Project3\\src\\coordinates.txt");
        Scanner input = new Scanner(file);

        //get all values in 1 place (this alternates as coord1X, coord1Y, coord2X, coord2Y, etc)
        double[] values = {input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble(), input.nextDouble()};

        //create matrix X
        double[] matXvalues = {values[0], values[2], values[4], values[6]};
        Matrix matrixX = new Matrix(new double[][] {
                {1, matXvalues[0]},
                {1, matXvalues[1]},
                {1, matXvalues[2]},
                {1, matXvalues[3]},
        });
        System.out.print("Matrix X:");
        matrixX.print(4, 1);

        //create matrix Y (format from format in above comments)
        double[] matYvalues = {values[1], values[3], values[5], values[7]};
        Matrix matrixY = new Matrix(matYvalues, 4);
        System.out.print("Matrix Y:");
        matrixY.print(4, 1);

        //transpose matrix X
        Matrix matXTransp = matrixX.transpose();
        System.out.print("Matrix X Transpose:");
        matXTransp.print(2, 1);

        //multiply x transpose by x
        Matrix matXTX = matXTransp.times(matrixX);
        System.out.print("Matrix X Transpose Multiplied by Matrix X:");
        matXTX.print(2, 1);

        //multiply x transpose by y
        Matrix matXTY = matXTransp.times(matrixY);
        System.out.print("Matrix X Transpose Multiplied by Matrix Y:");
        matXTY.print(2, 1);

        //inverse of XTX
        Matrix matXTXinv = matXTX.inverse();
        System.out.print("Inverse of Matrix X Transpose Multiplied by Matrix X:");
        matXTXinv.print(2, 1);

        //inverse times XTY
        Matrix matrixA = matXTXinv.times(matXTY);
        System.out.print("Matrix A:");
        matrixA.print(2, 1);

        //sets slope and intercept to be used later
        double intercept = matrixA.get(0, 0);
        double slope = matrixA.get(1, 0);
        System.out.printf("\nOur linear equation is y = %.1fx + %.1f\n", slope, intercept);

        //gets all data points
        XYSeries data = new XYSeries("Data Points");
        for(int i = 0; i < matXvalues.length; i++){
            data.add(matXvalues[i], matYvalues[i]);
        }

        //gets info for line from equation
        XYSeries line = new XYSeries("y = " + slope + "x + " + intercept);
        line.add(25, slope * 25 + intercept);       // beginning of graph
        line.add(40, slope * 40 + intercept);       //end of graph

        //adds data points and line to chart
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(data);
        dataset.addSeries(line);

        //sets up chart
        JFreeChart chart = ChartFactory.createScatterPlot("Least Squares Regression Line", "", "", dataset);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(560, 370));
        XYPlot plot = chart.getXYPlot();       //for lines

        //creates lines on the plot
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(1, true);
        plot.setRenderer(renderer);

        //sets size, location, etc settings for the chart
        JFrame frame = new JFrame("Least Squares Regression Line");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(chartPanel);
        frame.setSize(600, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
