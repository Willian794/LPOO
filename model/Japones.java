package model;

public class Japones extends Castelo 
{
	protected int numSamurai;

	public Japones(int numSamurai, int pontosVida, int defesa, String nome) 
	{
		super(pontosVida, defesa, nome);
		this.numSamurai = numSamurai;
	}

	@Override
	public String situacao() 
	{
		return super.situacao() + String.format("Numero Samurais: %d%n", this.numSamurai);
	}

	@Override
	public boolean ataque(int p) 
	{
		if (p > this.numSamurai)
		{
			if (super.ataque(p))
			{
				this.numSamurai += 15;
				return true;
			}
			return false;
		}
		
		else 
		{
			this.numSamurai -= p;
			return false;
		}
	}
	
	@Override
	public boolean verificarDestruicao() 
	{
		if (super.verificarDestruicao())
			return this.numSamurai <= 0;
		return false;
	}

	public int getNumSamurai() 
	{
		return numSamurai;
	}
}
