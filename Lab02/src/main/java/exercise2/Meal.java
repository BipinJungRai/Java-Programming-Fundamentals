package exercise2;

public class Meal {
	
	private Food maincourse;
	private Food dessert;
	
	public Meal(Food maincourse, Food dessert) {
			super();
			this.maincourse = maincourse;
			this.dessert = dessert;
	}

	public double calculateTotalSugarLevel() {
		
		return (maincourse.getAmountOfSugar() + dessert.getAmountOfSugar());
		
		
	}
	public String toString() {
		return "Meal [mainCourse = " + maincourse.getName() + ", dessert = " + dessert.getName() + "]";
		
	}
}
