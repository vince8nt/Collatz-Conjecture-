
// explore patterns of the Collatz conjecture
public class EvenOdd
{
	
	// print function
	public static void outArr(int[] tester)
	{
		System.out.print("[");
		for (int i = 1 - 1; i < tester.length; i++)
		{
			System.out.print(tester[i] + ",");
		}
		System.out.println("]");
	}
	
	// helper function to find all of the instances of a specific number
	public static void indexOf(int[] tester, int num)
	{
		System.out.print("index of " + num + "'s: ");
		for (int i = 0; i < tester.length; i++)
		{
			if (tester[i] == 1)
				System.out.print(i + num + " ");
		}
		System.out.println("]");
	}
	
	// helper function to find all of the gaps between specific numbers
	public static void gapsBetween(int[] tester, int num)
	{
		System.out.print("gaps between " + num + "'s: ");
		int counter = 0;
		for (int i = 0; i < tester.length; i++)
		{
			if (tester[i] == num)
			{
				System.out.print(counter + " ");
				counter = 0;
			}
			counter++;
		}
		System.out.println();
	}
	
	// main method
	public static void main(String args[])
	{
		// length is meant to be changed
		int length = 3000;
		int[] numLine = new int[length];
		int[] tester = new int[length];
		
		for (int i = 0; i < numLine.length; i++)
		{
			numLine[i] = i + 1;
		}
		
		
		
		pass(numLine, 1, tester);
		//outArr(tester);
		
		int[] temp = new int[tester.length];
		for (int i = 0; i < tester.length; i++)
			temp[i] = tester[i];
		
		pass(numLine, 1, tester);
		//outArr(tester);
		
		int finder = 2;
		int counter = 0;
		for (int i = 0; i < temp.length; i++)
		{
			if (temp[i] == finder)
			{ 
				counter++;
				System.out.print(tester[i] + " ");
				if(tester[i] == 8)
					System.out.print("(" + counter + ")");
			}
		}
		System.out.println();
		
		
		
		//System.out.println("gen match: " + Arrays.equals(tester, patternGen1(length)));
		
		//indexOf(tester, 1);
		
		//indexOf(tester, 1);
		//gapsBetween(tester, 2);
		//gapsBetween(tester, 4);
		
		
	}
	
	// brute force generation
	// n = n/2        if n is even
	// n = n*3+1      if n is odd
	public static void pass(int[] numLine, int times, int[] tester)
	{
		if (times > 1)
		{
			for (int i = 0; i < numLine.length; i++)
			{
				if (numLine[i] % 2 == 1)
					numLine[i] = numLine[i] * 3 + 1;
				while (numLine[i] % 2 == 0)
				{
					numLine[i] = numLine[i] / 2;
				}
			}
			pass(numLine, times - 1, tester);
		}
		else if (times == 1)
		{
			for (int i = 0; i < numLine.length; i++)
			{
				int counter = 0;
				if (numLine[i] % 2 == 1)
					numLine[i] = numLine[i] * 3 + 1;
				while (numLine[i] % 2 == 0)
				{
					numLine[i] = numLine[i] / 2;
					counter++;
				}
				tester[i] = counter;
			}
		}
	}
	
	// generation that isn't brute force (only works for 1 cycle)
	public static int[] patternGen1(int length)
	{
		int[] gen = new int[length];
		int maxVal = (int)(Math.log(3 * length + 1) / Math.log(2));
		for (int i = 1; i <= maxVal; i++)
		{
			int place;
			int sep;
			if (i%2 == 0)
			{
				place = (int)(Math.pow(2, i) - 1)/3;
				sep = (int)(Math.pow(2, i + 1) + 1)/3;
			}
			else
			{
				place = (int)Math.pow(2, i);
				sep = (int)(Math.pow(2, i + 1) - 1)/3;
			}
			int rep = (int)(Math.pow(2, i + 1));
			
			while(place - 1 < length)
			{
				if (place - 1 < length)
					gen[place - 1] = i;
				if (place - 1 + sep < length)
					gen[place - 1 + sep] = i;
				
				place += rep;
			}
		}
		return gen;
	}
	
	// generation that isn't brute force (works for any number of cycles)
	public static int[] patternGen(int length, int cycles)
	{
		int[] gen = new int[length];
		return gen;
		//currently unfinished
	}
}
