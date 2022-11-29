package lab3_exercise2;

public class AnnualSalary {
	private double salary;
	private static final int allowance = 12500;
	private static final double baseRate = 0.2;
	private static final double higherRate = 0.4;
	private static final int taxThreshold = 50000;
	private static final int maxTax = 7500;
	
	public double getSalary() {
		return salary;
	
	}
	public void setSalary(double salary) {
		this.salary = salary;
		
	}
	
	public AnnualSalary() {
		super();
		
	}
	
	public double calculateTax() {
		if (salary > allowance && salary <= taxThreshold) {
			double taxSalary = (salary - allowance);
			taxSalary *= baseRate;
			
			return(taxSalary);
			
		}
		if (salary > taxThreshold) {
			double taxSalary = (salary - taxThreshold);
			taxSalary *= higherRate;
		
			return(taxSalary + maxTax);
		} else {
			return 0D;
		}
	}
}
