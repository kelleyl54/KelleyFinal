package pkgTest;

import static org.junit.Assert.*;

import org.junit.Test;

import pkgCore.Retirement;

public class RetirementTest {

	@Test
	public void TestPV() {
		
		int iYearsRetired = 20;
		double dAnnualReturn = 0.02;
		double dExpectedPV = -1454485.55;
		double dSSIAmt = 2642;
		double dRequiredIncome = 10000;
		
		Retirement rt = new Retirement();
		rt.setdAnnualReturnRetired(dAnnualReturn);
		rt.setdMonthlySSI(dSSIAmt);
		rt.setdRequiredIncome(dRequiredIncome);
		rt.setiYearsRetired(iYearsRetired);
		
		assertEquals(dExpectedPV,rt.TotalAmountSaved(), 0.01);
		
	}
	
	@Test
	public void TestPMT() {
		
		int iYearsRetired = 20;
		double dAnnualReturn = 0.02;
		double dSSIAmt = 2642;
		double dRequiredIncome = 10000;
		
		int iYearsWorking = 40;
		double dAnnualReturnWorking = .07;
		double dExpectedPMT = 554.13;
		
		Retirement rt = new Retirement();
		rt.setdAnnualReturnRetired(dAnnualReturn);
		rt.setdMonthlySSI(dSSIAmt);
		rt.setdRequiredIncome(dRequiredIncome);
		rt.setiYearsRetired(iYearsRetired);
		
		rt.setiYearsToWork(iYearsWorking);
		rt.setdAnnualReturnWorking(dAnnualReturnWorking);
		
		assertEquals(dExpectedPMT, rt.AmountToSave(),.01);
		
	}

	
	
	
}
