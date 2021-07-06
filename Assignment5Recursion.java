//Name: Mario Luja
//Date: July 6,2020
public class Assignment5Recursion {

	//Uses the puzzle formula
	public static int puzzleFormula(int n)
	{
		//2n^2+2n+1
		double firstPoly = 2* Math.pow(n, 2);
		int secondPoly = 2*n;
		int squaredPoly = (int) firstPoly;
		int formula = (squaredPoly + secondPoly +1);
		return formula;
	}
	
	//Loops through the puzzle
	public static int puzzleLoop(int n)
	{
		int firstPart = (2*n) +1;
		int summation = 0;
		for(int i =1; i <= n; i++)
		{
			summation += (2*i) -1;
		}
		
		int equation = firstPart + (2*summation);
		return equation;
	}
	
	//Uses recursion to get the number of squares
	public static int puzzleRecurse(int n)
	{
		int numOfSquares = 0;

		if(n == 0)
		{
			return 1;
		}
		
		if(n >= 1)
		{
			numOfSquares += (puzzleRecurse(n-1)) + (4*n);
			n--;
		}
		
		return numOfSquares;
	}
}
