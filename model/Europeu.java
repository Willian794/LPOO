package model;

public class Europeu extends Castelo
{
	protected int numPaladino;
	
	public Europeu(int numPaladino, int pontosVida, int defesa, String nome) 
	{
		super(pontosVida, defesa, nome);
		this.numPaladino = numPaladino;
	}

	@Override
	public String situacao()
	{
		return super.situacao() + String.format("Numero Paladinos: %d%n", this.numPaladino);
	}

	@Override
	public boolean ataque(int p)
	{
		this.numPaladino -= p;
		
		if (this.numPaladino < 0) 
		{
			if (super.ataque(p))
			{
				this.numPaladino += 10;
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
			return this.numPaladino <= 0;
		return false;
	}
	
	public int getNumPaladino() 
	{
		return numPaladino;
	}
}
