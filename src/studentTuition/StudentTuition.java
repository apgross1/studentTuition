package studentTuition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentTuition {
	private double APR;
	private double tuition;
	private double perIncr;
	private int loanTerm;
	
	public StudentTuition() {
	//Makes empty instance of class StudentTuition
	//Parameters: N/A
	//Returns: N/A
	}
	
	public int getLoanTerm() {
	//Getter for value of for how long in years the user will pay his loan
	//Parameters: N/A
	//Returns: int, loanTerm 
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
	//Setter for LoanTerm
	//Parameters: LoanTerm, an int
	//Returns: N/A
		this.loanTerm = loanTerm;
	}

	public double getPerIncr() {
	//Getter for the percent the tuition grows per year
	//Parameters: N/A
	//Returns: double, perIncr
		return perIncr;
	}

	public void setPerIncr(double per_incr) {
	//Setter for PerIncr
	//Parameters: per_incr, a double
	//Returns: N/A
		this.perIncr = per_incr;
	}

	public double getTuition() {
	//Getter for starting tuition cost
	//Parameters: N/A
	//Returns: double, tuition
		return tuition;
	}

	public void setTuition(int tuition) {
	//Setter for Tuition
	//Parameters: tuition, an int
	//Returns: N/A
		this.tuition = tuition;
	}

	public double getAPR() {
	//Getter for the annual interest rate of the student loan
	//Parameters: N/A
	//Returns: APR, a double
		return APR;
	}

	public void setAPR(double aPR) {
	//Setter for APR
	//Parameters: aPR, a double
	//Returns: N/A
		APR = aPR;
	}
	
	public double tuitionCost() {
	//Calculates total cost of tuition after 4 years with compounding interest
	//Parameters: N/A
	//Returns: (double) finalTuition, the total cost of tuition with compounding interest
		double finalTuition = this.getTuition();
		double annualTuition = this.getTuition();
		for (int i = 0; i <3; i++) {
			double yearTuition = annualTuition;
			yearTuition *= 1+((this.getPerIncr())/100);
			annualTuition = yearTuition;
			finalTuition += yearTuition;
		}
		return finalTuition;
	}
	
	public double loanAmount() {
	//Calculates the amount per month the user must pay towards their student loans
	//Parameters: N/A
	//Returns: (double) pmt, the dollar value of what the user must pay per month to pay off
	//         their student loans
		double pmt = this.tuitionCost() * (((this.getAPR()/100)/12)/(1-(Math.pow(1+(this.getAPR()/100)/12, -(this.getLoanTerm()*12)))));
		return pmt;
	}
	
	public static void main(String[] args) {
	//Main method that runs the program/asks user for input
	//Parameters: N/A
	//Returns: N/A
		StudentTuition stuTu = new StudentTuition();
		Scanner input = new Scanner(System.in);
		try {
			System.out.println("Enter tuition cost: ");
			stuTu.setTuition(input.nextInt());
			
			System.out.println("Enter rate tuition rises per year: ");
			stuTu.setPerIncr(input.nextDouble());
			
			System.out.println("Enter APR: ");
			stuTu.setAPR((input.nextDouble()));
			
			System.out.println("Enter # loan repayment years: ");
			stuTu.setLoanTerm(input.nextInt());
		}
		catch(InputMismatchException e) {
			//Will close the program if the user inputs the wrong data type in the scanner
			System.out.println("Wrong data type. Please restart and try again.");
			input.close();
			return;
		}
		finally {
			input.close();
		}
		
		
		double totalTuition = stuTu.tuitionCost();
		double loanPay = stuTu.loanAmount();
		System.out.printf("Your total tuition will be $%4.2f.", totalTuition);
		System.out.printf("\nYou will have to pay $%4.2f a month to pay your loans off in %d years.", loanPay, stuTu.getLoanTerm());
	}

}
