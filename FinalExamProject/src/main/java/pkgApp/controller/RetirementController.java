package pkgApp.controller;

import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import pkgApp.RetirementApp;
import pkgCore.InterestRateException;
import pkgCore.Retirement;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;

public class RetirementController implements Initializable {

	private RetirementApp mainApp = null;

	@FXML
	private TextField txtYearsToWork;

	@FXML
	private TextField txtAnnualReturn;

	@FXML
	private TextField txtYearsRetired;

	@FXML
	private TextField txtRetiredReturn;

	@FXML
	private TextField txtRequiredIncome;

	@FXML
	private TextField txtMonthlySSI;

	@FXML
	private Label txtMonthlySave;

	@FXML
	private Label txtTotalSave;

	public RetirementApp getMainApp() {
		return mainApp;
	}

	public void setMainApp(RetirementApp mainApp) {
		this.mainApp = mainApp;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	@FXML
	public void btnClear(ActionEvent event) {
		// System.out.println("Clear pressed");

		txtMonthlySave.setText("0.00");
		txtYearsToWork.setText("");
		txtAnnualReturn.setText("");
		txtTotalSave.setText("0.00");
		txtYearsRetired.setText("");
		txtRetiredReturn.setText("");
		txtRequiredIncome.setText("");
		txtMonthlySSI.setText("");

	}

	@FXML
	public void btnCalculate(ActionEvent event) {

		try {
			Retirement rt = new Retirement();
			rt.setiYearsToWork(Integer.parseInt((txtYearsToWork.getText())));
			rt.setdAnnualReturnWorking(Double.parseDouble(txtAnnualReturn.getText()));
			rt.setiYearsRetired(Integer.parseInt(txtYearsRetired.getText()));
			rt.setdAnnualReturnRetired(Double.parseDouble(txtRetiredReturn.getText()));
			rt.setdRequiredIncome(Double.parseDouble(txtRequiredIncome.getText()));
			rt.setdMonthlySSI(Double.parseDouble(txtMonthlySSI.getText()));
			
			if(rt.getdAnnualReturnRetired()>.03||rt.getdAnnualReturnWorking()>.2) {
				JOptionPane.showMessageDialog(null, "While acceptable, these interest values are not realistic");
			}
			else if (rt.getdAnnualReturnRetired()<0||rt.getdAnnualReturnWorking()<0) {
				JOptionPane.showMessageDialog(null, "You cannot enter a negative interest value!");
			}
			else {
			Double amountToSave = Math.round(rt.AmountToSave() * 100.0) / 100.0;
			Double totalAmountSaved = (Math.round(rt.TotalAmountSaved() * 100.0) / 100.0) * -1;

			txtTotalSave.setText(totalAmountSaved.toString());
			txtMonthlySave.setText(amountToSave.toString());
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,
					"Incorrectly formatted number entered. Please fix number formatting and try again!");
		}

	}

}
