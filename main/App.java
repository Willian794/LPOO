package main;

import java.util.ArrayList;
import java.util.LinkedList;

import model.Castelo;
import model.Europeu;
import model.Japones;
import util.Dado;
import util.Sorteador;

public class App 
{
	public static void main(String[] args)
	{
		LinkedList<Castelo> castelos = new LinkedList<Castelo>();
		preencherLista(castelos);
		int casteloVez = 0;
		ArrayList<Integer> excessoes = new ArrayList<Integer>();
		
		while (castelos.size() > 1)
		{
			excessoes.clear();
			excessoes.add(casteloVez);
			
			int indiceCasteloAtacado = Sorteador.sortear(0, castelos.size() - 1, excessoes);
			
			Castelo casteloAtacado = castelos.get(indiceCasteloAtacado);
			
			Dado dado = new Dado(6);
			dado.girar();
			int face = dado.getFace();
			
			if (face == 0)
			{
				System.out.println("Passou a vez!");
			}
			else 
			{
				casteloAtacado.ataque(face);
				System.out.printf(""
					+ "Player da vez, perdeu %d guerreiros.%n"
					+ "Situação: %s%n"
					, 
					face,
					casteloAtacado.situacao()
				);
			}
			
			if (casteloAtacado.verificarDestruicao())
			{
				castelos.remove(casteloAtacado);
				System.out.printf(""
					+ "SITUACAO: %n"
					+ "%s"
					+ "CASTELO %s DESTRUIDO%n",
					casteloAtacado.situacao(),
					casteloAtacado.getNome()
				);
			}
			
			if (casteloVez == castelos.size() - 1) casteloVez = 0;
			else casteloVez++;
		}
	}
	
	public static void preencherLista(LinkedList<Castelo> castelos)
	{
		castelos.add(new Japones(15, 2, 2, "C1"));
		castelos.add(new Europeu(10, 2, 3, "C2"));
		castelos.add(new Japones(15, 2, 2, "C3"));
		castelos.add(new Europeu(10, 2, 3, "C4"));
	}
}
