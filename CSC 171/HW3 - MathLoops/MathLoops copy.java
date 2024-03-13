
/* 
Name: LAUREL TAY RAEANNE
School Email: LTAY3@U.ROCHESTER.EDU
Assignment Name: HOMEWORK 2, CALCULATOR
Date last modified: FEB 2ND 2023
 */

import static java.lang.Math.sqrt;
import java.util.Scanner;
public class MathLoops {

	
	//method one
    public static boolean prime(long n) {
    	if (n <= 1) {
            return false;
        }
        if (n == 2) {
            return true;
        }
        if (n % 2 == 0) {
            return false;
        }
        long limit = (long) Math.sqrt(n);
        for (long i = 3; i <= limit; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        return true; }
	    
	//method two
    public static String factors(long n) {
        StringBuilder sb = new StringBuilder();
        for (long i = 2; i <= n; i++) {
            while (n % i == 0) {
                sb.append(i).append(" ");
                n /= i;
            }}
        return sb.toString().trim(); }

	    
	 //main method
	 public static void main(String[] args) {
		
		while(true) {
	        
            Scanner input = new Scanner(System.in);
            String y = input.next();
            
            if (y.equals("quit")) {
                break;
            }
            
            long x = input.nextLong();
            
            if (y.equals("prime")) {
                boolean primeornot = prime(x);
                System.out.println(primeornot);
            } else {
                String primeFactors = factors(x);
                System.out.println(primeFactors);
            }
            
        }
        
    }
}