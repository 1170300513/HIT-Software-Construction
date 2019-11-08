package gui;

import java.awt.Font;
import java.io.File;
import java.io.IOException;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.StandardChartTheme;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 * Generate bar chart.
 * 
 * @author chen
 *
 */
public class BarChart {

    /**
     * ����BarChart.
     */
    public void createBarChart(String filePath, DefaultCategoryDataset dataset) {
        try {
            // ����Chart����
            setChartTheme();
            JFreeChart chart = ChartFactory.createBarChart3D("��ͬ����ٶ��������ʺ͹�ƽ�Բ���", "��ͬ����ٶ�", "", dataset,
                    PlotOrientation.VERTICAL, true, true, false);

            ChartUtilities.saveChartAsJPEG(new File(filePath), chart, 800, 300);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * ����ChartFactory���⣬�ɽ����������.
     */
    private void setChartTheme() {
        // ����������ʽ
        StandardChartTheme standardChartTheme = new StandardChartTheme("CN");
        // ���ñ�������
        standardChartTheme.setExtraLargeFont(new Font("����", Font.BOLD, 20));
        // ����ͼ��������
        standardChartTheme.setRegularFont(new Font("����", Font.PLAIN, 15));
        // �������������
        standardChartTheme.setLargeFont(new Font("����", Font.PLAIN, 15));
        // Ӧ��������ʽ
        ChartFactory.setChartTheme(standardChartTheme);
    }

    /**
     * ��ø��ӣ���ϣ�BarChart�����ݼ�.
     * 
     * @return BarChart���ݼ�
     */
    public DefaultCategoryDataset getBarDataSet1(int i) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        if (i == 1) {
            dataset.addValue(1.754, "������", "MV=5");
            dataset.addValue(0.754, "��ƽ��", "MV=5");
            dataset.addValue(1.667, "������", "MV=8");
            dataset.addValue(0.744, "��ƽ��", "MV=8");
            dataset.addValue(1.754, "������", "MV=10");
            dataset.addValue(0.815, "��ƽ��", "MV=10");
            //dataset.addValue(0.588, "������", "t=4");
            //dataset.addValue(0.853, "��ƽ��", "t=4");
            //dataset.addValue(0.472, "������", "t=5");
            //dataset.addValue(0.928, "��ƽ��", "t=5");
        } else {
            dataset.addValue(594, "Strategy1", "file1-O");
            dataset.addValue(1058, "Strategy2", "file1-O");
            dataset.addValue(1637, "Strategy3", "file1-O");
            dataset.addValue(937, "Strategy1", "file2-O");
            dataset.addValue(1689, "Strategy2", "file2-O");
            dataset.addValue(1837, "Strategy3", "file2-O");
            dataset.addValue(959, "Strategy1", "file3-O");
            dataset.addValue(884, "Strategy2", "file3-O");
            dataset.addValue(1772, "Strategy3", "file3-O");
            dataset.addValue(723, "Strategy1", "file4-O");
            dataset.addValue(1646, "Strategy2", "file4-O");
            dataset.addValue(1821, "Strategy3", "file4-O");
        }

        return dataset;
    }


    /**
     * factory.
     */
    public static void factory(String filePath, DefaultCategoryDataset dataset) {
        BarChart piechart = new BarChart();
        piechart.createBarChart(filePath, dataset);
        System.out.println("PieChart file path : " + filePath);
        try {
            Runtime.getRuntime().exec("rundll32 url.dll FileProtocolHandler " + filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * main.
     */
    public static void main(String[] args) {
        BarChart.factory("src/gui/CompareDifferentMV.jpg", new BarChart().getBarDataSet1(1));
        // BarChart.factory("src/io/output.jpg", new BarChart().getBarDataSet1(2));
    }


}
