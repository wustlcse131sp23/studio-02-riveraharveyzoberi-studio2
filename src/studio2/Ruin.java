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
		double losses = 0;
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
				losses++;
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
		double ruinRateSim = losses / totalSimulations;
		double expectedRuinRate = 0;
		double alpha = (1-winChance) / winChance;
		if (winChance == 0.5) {
			expectedRuinRate = 1 - (startAmount / winLimit);
		}
		else {
			expectedRuinRate = (Math.pow(alpha, startAmount) - Math.pow(alpha, winLimit)) / (1 - Math.pow(alpha, winLimit));
		}
		System.out.println("Ruin Rate from Simulation: " + ruinRateSim + " Expected Ruin Rate: " + expectedRuinRate);
		
	}
}
