

/* 
Name: LAUREL TAY RAEANNE
School Email: LTAY3@U.ROCHESTER.EDU
Assignment Name: HOMEWORK 2, CALCULATOR
Date last modified: FEB 2ND 2023
 */

import java.util.Scanner;
import java.text.DecimalFormat;

public class CalculatorHW {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat("0.000");
        
        while(true) {
            String inputLine = input.nextLine();
            if (inputLine.isEmpty()) {
                break;
            }
            String[] tokens = inputLine.split("\\s+");
            double value = Double.parseDouble(tokens[0]);
            String unit = tokens[1].toUpperCase();
            String dest = tokens[3].toUpperCase();        
            
            switch (unit) {
            case "M":
                if (dest.equals("FT")) {
                    System.out.println(df.format(value / 0.3048));
                } else {
                    System.out.println("***Unable to convert from "+unit+" to "+dest+"***");
                }
                break;

            case "FT":
                if (dest.equals("M")) {
                    System.out.println(df.format(value * 0.3048));
                } else {
                    System.out.println("***Unable to convert from "+unit+" to "+dest+"***");
                }
                break;
                
            case "C":
                if (dest.equals("F")) {
                    System.out.println(df.format((value * 9 / 5) + 32));
                } else {
                    System.out.println("***Unable to convert from "+unit+" to "+dest+"***");
                }
                break;

            case "F":
                if (dest.equals("C")) {
                    System.out.println(df.format((value - 32) * 5 / 9));
                } else {
                    System.out.println("***Unable to convert from "+unit+" to "+dest+"***");
                }
                break;

            case "H":
                if (dest.equals("MIN")) {
                    System.out.println(df.format(value * 60));
                } else {
                    System.out.println("***Unable to convert from "+unit+" to "+dest+"***");
                }
                break;

	    	case "MIN":
	    		if (dest.equals("H")) {
	    			System.out.print( df.format(value/60));
	    		}
	    			else {
	    				System.out.println("***Unable to convert from "+unit+" to "+dest+"***");
	    		}
	    		break;
	    		
	    	case "KG":
	    		if (dest.equals("LB")) {
	    			System.out.print(df.format(value / 0.453592));
	    		}
	    			else {
	    				System.out.println("***Unable to convert from "+unit+" to "+dest+"***");
	    		}
	    		break;
	    		
	    	case "LB":
	    		if (dest.equals("KG")) {
	    			System.out.print(df.format(value * 0.453592));
	    		}
	    			else {
	    				System.out.println("***Unable to convert from "+unit+" to "+dest+"***");
	    		}
	    		break;
            }
        }
    }
}
