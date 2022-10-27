package exercise3;

public class Module {

	private Assessment assessment1;
	private Assessment assessment2;
	
	
	public Module(Assessment assessment1, Assessment assessment2) {
		super();
		this.assessment1 = assessment1;
		this.assessment2 = assessment2;
		
	}

	public double calculateAverage() {
		double average1 = assessment1.getMark();
		average1 = (average1/100) * 20;
		
		double average2 = assessment2.getMark();
		average2 = (average2/100) * 80;
		return (average1 + average2);
	}

public String tostring()  {
	return "COM1027 Average = " + calculateAverage() + "% " + "[Labs(20%) = " + assessment1.getMark() + assessment2.getMark() +"% ]";
	
}



}
