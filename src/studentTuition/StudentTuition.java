package studentTuition;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentTuition {
	private double APR;
	private double tuition;
	private double perIncr;
	private int loanTerm;
	
	public StudentTuition() {
		
	}
	
	public int getLoanTerm() {
		return loanTerm;
	}

	public void setLoanTerm(int loanTerm) {
		this.loanTerm = loanTerm;
	}

	public double getPerIncr() {
		return perIncr;
	}

	public void setPerIncr(double per_incr) {
		this.perIncr = per_incr;
	}

	public double getTuition() {
		return tuition;
	}

	public void setTuition(int tuition) {
		this.tuition = tuition;
	}

	public double getAPR() {
		return APR;
	}

	public void setAPR(double aPR) {
		APR = aPR;
	}
	
	public double tuitionCost() {
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
		double pmt = this.tuitionCost() * (((this.getAPR()/100)/12)/(1-(Math.pow(1+(this.getAPR()/100)/12, -(this.getLoanTerm()*12)))));
		return pmt;
	}
	
	public static void main(String[] args) {
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
