package studio2;

import java.util.Scanner;

public class Ruin {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Start Amount?");
		double startAmount = in.nextDouble();
		System.out.println("Win Chance?");
		double winChance = in.nextDouble();
		System.out.println("Win Limit?");
		double winLimit = in.nextDouble();
		double currentAmount = startAmount;
		System.out.println("Total Simulations?");
		int totalSimulations = in.nextInt();

		int dailyPlays = 0;  
		for (int i = 0; i < totalSimulations; i ++)
		{
			while ((currentAmount>0) && (currentAmount<winLimit)) 
			{
				boolean win = (Math.random()< winChance);
				if (win) 
				{
					currentAmount++;
					dailyPlays++;
				}
				else 
				{
					currentAmount--;
					dailyPlays++;
				}
			}
			if (currentAmount==0) 
			{
				System.out.println("Ruin!");
				System.out.println("Simultion day: " + i);
				System.out.println("Daily plays: " + dailyPlays);
				currentAmount = startAmount; 
				}
			if (currentAmount==winLimit) 
			{
				System.out.println("Win!");
				System.out.println("Simultion day: " + i);
				System.out.println("Daily plays: " + dailyPlays);
				currentAmount = startAmount; 
			}
		}
	}
}
