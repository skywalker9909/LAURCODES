/*
Name: Laurel Tay
School Email: ltay3@u.rochester.edu
Date Last Modified the Program: April 26
Name of the Assignment: Homework 4 Airplane
*/

import java.util.Scanner;

public class Airplane {
	
	private String name;
	private double TOW_min;
	private double TOW_max;
	private double range;
	private double speed;
	private double hourly_cost;
	private double fuel_rate;
	private double prof;
	
	//constructor
	public Airplane(String name, double towMin, double towMax, double range, double speed, double cost, double fuelRate){
		this.name = name;
		this.TOW_min = towMin;
		this.TOW_max = towMax;
		this.speed = speed;
		this.range = range;
		this.hourly_cost = cost;
		this.fuel_rate = fuelRate;
		this.prof = 0;
		
	}	
	
	//method for calculating the profit
	private double estimateProf(double distance, double cargoMass, double payment) {
		double takeoffWeight = this.TOW_min + cargoMass;
		if (distance > range || takeoffWeight > TOW_max) {
			this.prof=-1;
			return -1;
		}
		double flightTime = distance / this.speed;
		double fuelCost = fuel_rate * takeoffWeight * flightTime;
		double flightCost = this.hourly_cost * flightTime;
		this.prof=payment-(fuelCost + flightCost);
		return payment-(fuelCost + flightCost);
	}
	
	public static void main(String[] args) {
		double sum = 0;
		Scanner scanner = new Scanner(System.in);
		int airplaneNumber = scanner.nextInt();
		Airplane[] fleet = new Airplane[airplaneNumber];
		
		for (int i = 0; i < fleet.length; i++) {
			String name = scanner.next();
			double towMin = scanner.nextDouble();
			double towMax = scanner.nextDouble();
			double range = scanner.nextDouble();
			double speed = scanner.nextDouble();
			double cost = scanner.nextDouble();
			double fuelRate = scanner.nextDouble();
			fleet[i] = new Airplane (name, towMin, towMax, range, speed, cost, fuelRate);
		}
		
		while(scanner.hasNext()) {
			if(scanner.hasNext("quit")) {	
				System.out.printf("\nProfit" + " " + "%.2f", sum);
				break;
			}
			double cargoMass = scanner.nextDouble();
			double distance = scanner.nextDouble();
			double payment = scanner.nextDouble();
			boolean hasProfit = false;
			for (int i = 0; i < fleet.length ; i++) {
					double profit = fleet[i].estimateProf(distance, cargoMass,payment);
					fleet[i].prof = profit;
					if (profit > 0) {
						hasProfit = true;
						
				}

			}
			
			int temp = 0;
			double max = 0;
			for (int i = 0; i < fleet.length ; i++) {
				if(max < fleet[i].prof) {
					max = fleet[i].prof;
					temp = i;
				}
			}
			
			sum += max;
			
			if(hasProfit == false) {
				System.out.print("\ndecline");
			}else {
				System.out.printf("\n"+fleet[temp].name + " " + "%.2f", max);
			}
		}
	}
}
