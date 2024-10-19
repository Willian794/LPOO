package model;

public abstract class Castelo 
{
	protected int defesa;
	protected int pontosVida;
	protected String nome;
	
	public Castelo(int pontosVida, int defesa, String nome) 
	{
		this.defesa = defesa;
		this.pontosVida = pontosVida;
		this.nome = nome;
	}

	public String situacao() 
	{
		return  String.format(""
			+ "Defesa: %d%n"
			+ "Pontos de vida: %d%n"
			+ "Nome: %s%n"
			, 
			this.defesa,
			this.pontosVida,
			this.nome
		);
	}
	
	public boolean ataque(int p)
	{
		if (this.defesa > 0)
		{
			this.defesa--;
			return true;
		}
		if (this.pontosVida > 0)
		{
			this.pontosVida--;
			this.defesa = 2;
			return true;
		}
		return false;
	}
	
	public boolean verificarDestruicao() 
	{
		return this.defesa == 0 && this.pontosVida == 0;
	}

	public int getDefesa() 
	{
		return defesa;
	}

	public int getPontosVida() 
	{
		return pontosVida;
	}

	public String getNome() 
	{
		return nome;
	}
}
