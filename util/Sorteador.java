package util;

import java.util.ArrayList;

public class Sorteador 
{
	public static Integer sortear(int min, int max, ArrayList<Integer> excessoes)
	{
		int num = sortear(min, max);
		while (excessoes.contains(num))
			num = sortear(min, max);
		return num;
	}
	
	public static int sortear(int min, int max)
	{
		return (int) ((max - min + 1) * Math.random() + min);
	}
	
	public static int sortear(int max)
	{
		return (int) ((max + 1) * Math.random());
	}
}
