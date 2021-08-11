package Controller;

import Model.BeerCalculator;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.*;

import java.net.URL;
import java.util.ResourceBundle;

public class CalcController implements Initializable {
    @FXML
    public Slider barrelsSlider;
    public Slider halfKegsSlider;
    public Slider sixtelSlider;
    public Slider cansSlider;
    public TextField halfKegsTxtFld;
    public TextField sixtelTxtFld;
    public TextField cansTxtFld;
    public TextField barrelsTxtFld;
    public Label halfsMax;
    public Label sixtelsMax;
    public Label cansMax;
    public Label availGalLabel;

    BeerCalculator calc;

    public void updateTotals() {
        // Update totals by calling methods and updating UI
        calc.toGals();
        calc.updateAvailableGals();
        sixtelSlider.setValue(calc.getUserSixtels());
        sixtelTxtFld.setText(String.valueOf(calc.getUserSixtels()));
        cansTxtFld.setText(String.valueOf(calc.getComputeCans()));
        cansSlider.setValue(calc.getComputeCans());
        availGalLabel.setText("Available Gallons: " + calc.getAvailableGals());
    }

    public void onSlideBarrels(MouseEvent mouseEvent) {
        calc = new BeerCalculator((int)barrelsSlider.getValue());

        barrelsTxtFld.setText(String.valueOf(calc.getTotalBarrels()));

        // Set max labels
        halfsMax.setText(String.valueOf(calc.getMaxHalfs()));
        halfKegsSlider.setMax(calc.getMaxHalfs());

        sixtelsMax.setText(String.valueOf(calc.getMaxSixtels()));
        sixtelSlider.setMax(calc.getMaxSixtels());

        cansMax.setText(String.valueOf(calc.getMaxCans()));
        cansSlider.setMax(calc.getMaxCans());

        // Update total gallons and total cans
        calc.updateAvailableGals();
        cansTxtFld.setText(String.valueOf(calc.getComputeCans()));
        cansSlider.setValue(calc.getComputeCans());
        availGalLabel.setText("Available Gallons: " + calc.getAvailableGals());
    }

    public void onClickBbls(MouseEvent mouseEvent) {
        onSlideBarrels(mouseEvent);
    }

    public void onMouseRelBbls(MouseEvent mouseEvent) {
        onSlideBarrels(mouseEvent);
    }

    public void onTouchBarrels(TouchEvent touchEvent) {
//        onSlideBarrels(touchEvent);

    }

    public void onEnterBarrels(KeyEvent keyEvent) {
        try {
            calc = new BeerCalculator(Integer.parseInt(barrelsTxtFld.getText()));

            barrelsSlider.setValue(calc.getTotalBarrels());

            // Set max labels
            halfsMax.setText(String.valueOf(calc.getMaxHalfs()));
            halfKegsSlider.setMax(calc.getMaxHalfs());

            sixtelsMax.setText(String.valueOf(calc.getMaxSixtels()));
            sixtelSlider.setMax(calc.getMaxSixtels());

            cansMax.setText(String.valueOf(calc.getMaxCans()));
            cansSlider.setMax(calc.getMaxCans());

            // Update total gallons and total cans
            calc.updateAvailableGals();
            cansTxtFld.setText(String.valueOf(calc.getComputeCans()));
            cansSlider.setValue(calc.getComputeCans());
            availGalLabel.setText("Available Gallons: " + calc.getAvailableGals());
        }

        catch (NumberFormatException e) {
        // Do nothing
        }
    }

    public void onEnterHalfs(KeyEvent keyEvent) {
        try {

            if (calc == null) {
                return;
            }

            calc.setUserHalfs(Integer.parseInt(halfKegsTxtFld.getText()));
            halfKegsSlider.setValue(calc.getUserHalfs());

            updateTotals();

        }
        catch (NumberFormatException e) {
        // Do nothing
        }
    }

    public void onEnterSixtels(KeyEvent keyEvent) {
        try {

            if (calc == null) {
                return;
            }

            // Set Sixtels to user input
            calc.setUserSixtels(Integer.parseInt(sixtelTxtFld.getText()));

            updateTotals();
        }
        catch (NumberFormatException e) {
        // Do nothing
        }
    }

    public void onEnterCans(KeyEvent keyEvent) {

    }

    public void onSlideHalfs(MouseEvent mouseEvent) {

        if (calc == null) {
            return;
        }

        //Set halfs to user slider input
        calc.setUserHalfs((int)halfKegsSlider.getValue());
        halfKegsTxtFld.setText(String.valueOf(calc.getUserHalfs()));

        updateTotals();
    }

    public void onClickHalfs(MouseEvent mouseEvent) {
        onSlideHalfs(mouseEvent);
    }

    public void onMouseRelHalfs(MouseEvent mouseEvent) {
        onSlideHalfs(mouseEvent);
    }

    public void onSlideSixtels(MouseEvent mouseEvent) {

        if (calc == null) {
            return;
        }

        // Set sixtels to user slider input
        calc.setUserSixtels((int)sixtelSlider.getValue());

        updateTotals();
    }

    public void onClickSixtels(MouseEvent mouseEvent) {
        onSlideSixtels(mouseEvent);
    }

    public void onMouseRelSixtels(MouseEvent mouseEvent) {
        onSlideSixtels(mouseEvent);
    }

    public void onSlideCans(MouseEvent mouseEvent) {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
