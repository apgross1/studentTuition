package studentTuition;

public class StudentTuition {
	private double APR;
	private int tuition;
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

	public int getTuition() {
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
		
	}
	
	public static void main(String[] args) {
		StudentTuition test = new StudentTuition();
		test.setTuition(12520);
		test.setPerIncr(4.5);
		System.out.println(test.tuitionCost());

	}





	

}
