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
		this.numSamurai -= p;
		
		if (this.numSamurai < 0)
		{
			if (super.ataque(p))
			{
				this.numSamurai += 15;
				return true;
			}
			return false;
		}
		return true;
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
