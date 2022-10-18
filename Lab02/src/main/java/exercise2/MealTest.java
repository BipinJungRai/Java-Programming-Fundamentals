package exercise2;

public class MealTest {

	public static void main(String[] args) {
		Food food1 = new Food("BLT Sandwich", 4.7);
		Food food2 = new Food("Dark Chocolate", 48);
		
		Meal meal1 = new Meal(food1, food2);
		
		System.out.println(meal1.toString());

	}

}
