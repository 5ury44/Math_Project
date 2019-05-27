package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class Controller {
   @FXML
    public LineChart linechrto;
    @FXML
    private TextField crv;
@FXML
    private TextField strt;
@FXML
    private TextField Dst;
    @FXML
    private TextField spd_six;
    @FXML
    private TextField spd_one;
    @FXML
    private TextField Ans;

    @FXML
    private LineChart<Number, Number> linechrt;
    public void pressButton(ActionEvent event){

        Double curve = Double.parseDouble(crv.getText());
        Double Distraction = Double.parseDouble(Dst.getText());
        Double straight = Double.parseDouble(strt.getText());
        Double speed_six = Double.parseDouble(spd_six.getText());
        Double speed_one = Double.parseDouble(spd_one.getText());
        Double lnone_curve = curve *203.95/2;
        Double lnsix_curve = curve *237.76/2;
        Double lns_strt = straight *100;
        Double lnone = (lnone_curve + lns_strt) / speed_one;
        Double lnsix= (lnsix_curve + lns_strt)/ speed_six;



        if (lnsix+Distraction>lnone) {
            Double YEE = lnsix + Distraction - lnone;
            System.out.println(curve);
            Ans.setText(Double.toString(YEE)+ " ln 1 wins");
//ln 6
            XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
            series1.setName("Series 1");
            series1.getData().add(new XYChart.Data<>(Distraction, 0));
            series1.getData().add(new XYChart.Data<>(5+Distraction, (speed_six*5)));
            series1.getData().add(new XYChart.Data<>(20+Distraction, speed_six*20));
            series1.getData().add(new XYChart.Data<>(lnsix+Distraction, lnsix_curve+lns_strt));
            linechrt.getData().add(series1);

            XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
            series2.setName("Series 2");
            series2.getData().add(new XYChart.Data<>(0, 0));
            series2.getData().add(new XYChart.Data<>(5, (speed_one*5)));
            series2.getData().add(new XYChart.Data<>(20, speed_one*20));
            series2.getData().add(new XYChart.Data<>(lnone, lnone_curve+lns_strt));
            linechrto.getData().add(series2);
        }
        else{
            Double YEE = lnone- lnsix + Distraction ;
            System.out.println(curve);
            Ans.setText(Double.toString(YEE)+ " ln 6 wins");

            XYChart.Series<Number, Number> series1 = new XYChart.Series<>();
            series1.setName("Series 1");
            series1.getData().add(new XYChart.Data<>(Distraction, 0));
            series1.getData().add(new XYChart.Data<>(5+Distraction, (speed_six*5)));
            series1.getData().add(new XYChart.Data<>(20+Distraction, speed_six*20));
            series1.getData().add(new XYChart.Data<>(lnsix+Distraction, lnsix_curve+lns_strt));
            linechrt.getData().add(series1);

            XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
            series2.setName("Series 2");
            series2.getData().add(new XYChart.Data<>(0, 0));
            series2.getData().add(new XYChart.Data<>(5, (speed_one*5)));
            series2.getData().add(new XYChart.Data<>(20, speed_one*20));
            series2.getData().add(new XYChart.Data<>(lnone, lnone_curve+lns_strt));
            linechrto.getData().add(series2);
        }


    }

}
