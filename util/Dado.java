package util;

public class Dado
{
	private int faces;

	public Dado(int faces) 
	{
		this.faces = faces;
	}
	
	public void girar()
	{
		this.faces = (int) (this.faces * Math.random() + 1);
	}

	public int getFace() 
	{
		return faces;
	}
}
