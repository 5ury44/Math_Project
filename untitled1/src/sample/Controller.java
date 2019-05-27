package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;


public class Controller {
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
        }
        else{
            Double YEE = lnone- lnsix + Distraction ;
            System.out.println(curve);
            Ans.setText(Double.toString(YEE)+ " ln 6 wins");
        }


    }

}
