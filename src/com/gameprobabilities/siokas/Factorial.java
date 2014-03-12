package com.gameprobabilities.siokas;


import java.math.*;

public class Factorial
{
	public static BigInteger fact(int x)
	{
		BigInteger n = BigInteger.ONE;
        for (int i=1; i<x+1; i++) {
            n = n.multiply(BigInteger.valueOf(i));
        }
        return n;	
	}
	public static double combin (int x, int y)
	{
		BigInteger n1 = BigInteger.ONE; 
		n1 = fact(x);
		
		BigInteger n2 = BigInteger.ONE; 
		n2 = fact(y);
		
		BigInteger n3 = BigInteger.ONE; 
		n3 = fact(x-y);
		
		BigInteger mm = BigInteger.ONE; 
		mm = n2.multiply(n3);
		
		
		double res = n1.doubleValue()/mm.doubleValue();
		
		return res;
	}
}
