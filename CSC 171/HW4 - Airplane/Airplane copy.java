

/* 
Name: LAUREL TAY RAEANNE
School Email: LTAY3@U.ROCHESTER.EDU
Assignment Name: HOMEWORK 4, AIRPLANE
Date last modified: MARCH 6TH
 */


import java.util.Scanner;

public class Airplane {
    private String name;
    private double towMin;
    private double towMax;
    private double range;
    private double speed;
    private double hourlyCost;
    private double fuelRate;
    
    public Airplane(String name, double towMin, double towMax, double range, double speed, double hourlyCost, double fuelRate) {
        this.name = name;
        this.towMin = towMin;
        this.towMax = towMax;
        this.range = range;
        this.speed = speed;
        this.hourlyCost = hourlyCost;
        this.fuelRate = fuelRate;
    }
    
    public String getName() {
        return name;
    }
    
    public double getHourlyCost() {
        return hourlyCost;
    }
    
    public double calculateFlightCost(double cargoMass, double distance) {
        double flightTime = distance / speed;
        double totalWeight = cargoMass + towMin;
        double fuelCost = fuelRate * totalWeight * flightTime;
        double flightCost = hourlyCost * flightTime;
        return fuelCost + flightCost;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int numAirplanes = sc.nextInt();
        Airplane[] fleet = new Airplane[numAirplanes];
        for (int i = 0; i < numAirplanes; i++) {
            String name = sc.next();
            double towMin = sc.nextDouble();
            double towMax = sc.nextDouble();
            double range = sc.nextDouble();
            double speed = sc.nextDouble();
            double hourlyCost = sc.nextDouble();
            double fuelRate = sc.nextDouble();
            fleet[i] = new Airplane(name, towMin, towMax, range, speed, hourlyCost, fuelRate);
        }
        
        double totalProfit = 0.0;
        
        
        for (int i = 0; i <= numAirplanes; i++) {            
        	String input = sc.next();
            if (input.equals("quit")) {
                break;
            }
            double cargoMass = Double.parseDouble(input);
            double distance = sc.nextDouble();
            double payment = sc.nextDouble();
            
            Airplane bestAirplane = null;
            double bestProfit = 0.0;
            
            for (Airplane airplane : fleet) {
                if (airplane.towMin + cargoMass <= airplane.towMax && distance <= airplane.range) {
                    double flightCost = airplane.calculateFlightCost(cargoMass, distance);
                    double profit = payment - flightCost;
                    if (profit > bestProfit) {
                        bestAirplane = airplane;
                        bestProfit = profit;
                    }
                }
            }
            
            if (bestAirplane != null) {
                System.out.printf("%s %.2f\n", bestAirplane.getName(), bestProfit);
                totalProfit += bestProfit;
            } else {
                System.out.println("decline");
            }
        }
        
        System.out.printf("Profit: %.2f\n", totalProfit);
    }
}