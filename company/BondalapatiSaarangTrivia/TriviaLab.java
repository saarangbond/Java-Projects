import java.util.Scanner;
import java.util.Random;

public class TriviaLab{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		Random rand = new Random();
		int score = 0;
		
		System.out.println("Category 1: Math Formulas");
		System.out.println("Category 2: Geography");
		System.out.println("Enter 1 for Math or 2 for Geography");
		int choose = s.nextInt();
		int num1;
		int num2;
		
		if(choose == 1){
			System.out.println("Math Formula's");
			System.out.println();
			
			//Area of a triangle
			num1 = rand.nextInt(9) + 1;
			num2 = rand.nextInt(9) + 1;
			System.out.println("The base of a triangle is " + num1 + " and the height is " + num2 + ", find the area of the triangle.");
			double ans = s.nextInt();
			if(ans == 0.5 * num1 * num2){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Your score is: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer.");
				System.out.println();
				System.out.println("Your score is: " + score);
			}
			
			//Area of rectangle
			num1 = rand.nextInt(9) + 1;
			num2 = rand.nextInt(9) + 1;
			System.out.println("The width of a rectange is " + num1 + " and the length is " + num2 + ". Find the area of the rectangle.");
			double ans2 = s.nextInt();
			if(ans2 == num1 * num2){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Your score is: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer.");
				System.out.println();
				System.out.println("Your score is: " + score);
			}
			
			//Perimeter of Square
			num1 = rand.nextInt(14) + 1;
			num2 = rand.nextInt(9) + 1;
			System.out.println("One side of a square is " + num1 + ". Find its perimeter.");
			double ans3 = s.nextInt();
			if(ans3 == num1 * 4){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Your score is: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer.");
				System.out.println();
				System.out.println("Your score is: " + score);
			}
			
			//Parallelogram
			num1 = rand.nextInt(9) + 1;
			num2 = rand.nextInt(9) + 1;
			System.out.println("The base of a parallelogram is " + num1 + " and the height is " + num2 + ". Find its area.");
			double ans4 = s.nextInt();
			if(ans4 == num1 * num2){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Your score is: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer.");
				System.out.println();
				System.out.println("Your score is: " + score);
			}
			
			//Perimeter of a nonagon
			num1 = rand.nextInt(9) + 1;
			num2 = rand.nextInt(9) + 1;
			System.out.println("One side of a regular nonagon is " + num1 + ". Find its perimeter.");
			int ans5 = s.nextInt();
			if(ans5 == num1 * 9){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				
				System.out.println("Your score is: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer.");
				System.out.println();
				System.out.println("Your score is: " + score);
			}
			
			//Perimeter of a rectangle
			num1 = rand.nextInt(4) + 1;
			num2 = rand.nextInt(6) + 4;
			System.out.println("Two sides of a rectangle are " + num1 + " and " + num2 + ". Find its perimeter.");
			int ans6 = s.nextInt();
			if(ans6 == 2 * num1 + 2 * num2){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				
				System.out.println("Your score is: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer.");
				System.out.println();
				System.out.println("Your score is: " + score);
			}
			
			
		}else if(choose == 2){
			System.out.println();
			System.out.println("Geography");
			System.out.println();
			
			System.out.println("What is the capital of England?");
			String answer1 = s.next();
			if(answer1.equals("London") || answer1.equals("london") ){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Score: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
				System.out.println("Score: " + score);
				System.out.println();
			}
			
			System.out.println("What is the largest country (by land mass) in the world?");
			String answer2 = s.next();
			if(answer2.equals("Russia") || answer2.equals("russia")){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Score: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
				System.out.println("Score: " + score);
				System.out.println();
			}
			
			System.out.println("What is the capital of Texas?");
			String answer3 = s.next();
			if(answer3.equals("Austin") || answer3.equals("austin")){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Score: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
				System.out.println("Score: " + score);
				System.out.println();
			}
			
			System.out.println("What is the capitol of Spain?");
			String answer4 = s.next();
			if(answer4.equals("Madrid") || answer4.equals("madrid")){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Score: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
				System.out.println("Score: " + score);
				System.out.println();
			}
			
			System.out.println("What is the capitol of California?");
			String answer5 = s.next();
			if(answer5.equals("Sacramento") || answer5.equals("sacramento")){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Score: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
				System.out.println("Score: " + score);
				System.out.println();
			}
			
			System.out.println("What is the capital of Belgium?");
			String answer6 = s.next();
			if(answer6.equals("Brussels") || answer6.equals("brussels")){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Score: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
				System.out.println("Score: " + score);
				System.out.println();
			}
			
			System.out.println("What is the capital of Romania?");
			String answer7 = s.next();
			if(answer7.equals("Bucharest") || answer7.equals("bucharest")){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Score: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
				System.out.println("Score: " + score);
				System.out.println();
			}
			
			System.out.println("What is the capital of Canada?");
			String answer8 = s.next();
			if(answer8.equals("Ottawa") || answer8.equals("ottawa")){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Score: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
				System.out.println("Score: " + score);
				System.out.println();
			}
			
			System.out.println("What is the capital of Italy?");
			String answer9 = s.next();
			if(answer9.equals("Rome") || answer9.equals("rome")){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
				System.out.println("Score: " + score);
				System.out.println();
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
				System.out.println("Score: " + score);
				System.out.println();
			}
			
			System.out.println("What is the capital of Japan?");
			String answer10 = s.next();
			if(answer10.equals("Tokyo") || answer10.equals("tokyo")){
				System.out.println();
				System.out.println("Great Job!");
				System.out.println();
				score ++;
			}else{
				System.out.println();
				System.out.println("Sorry, wrong answer!");
				System.out.println();
			}
			
			System.out.println("");
			System.out.println("You finished with  a score of: " + score + "/10");
			
		}else{
			System.out.println("That is not a valid category!");
		}
	}
}