package main;

import java.util.ArrayList;
import java.util.LinkedList;

import model.Castelo;
import model.Europeu;
import model.Japones;
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
			
			int face = Sorteador.sortear(0, 10); // Faz de conta que é um dado de 11 faces, de 0 até 10 (Não fiz um objeto Dado porque um dado não tem face 0)
			
			if (face == 0)
			{
				System.out.println("Passou a vez!\n");
			}
			else 
			{
				casteloAtacado.ataque(face);
				System.out.printf(""
					+ "%s perdeu %d guerreiros.%n"
					+ "Situação: %n"
					+ "%s%n"
					, 
					casteloAtacado.getNome(),
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
					+ "CASTELO %s DESTRUIDO%n%n",
					casteloAtacado.situacao(),
					casteloAtacado.getNome()
				);
			}
			
			if (casteloVez == castelos.size() - 1) casteloVez = 0;
			else casteloVez++;
		}
		
		Castelo vencedor = castelos.getFirst();
		
		System.out.printf(""
			+ "SITUACAO: %n"
			+ "%s"
			+ "CASTELO %s VENCEDOR%n%n",
			vencedor.situacao(),
			vencedor.getNome()
		);
	}
	
	public static void preencherLista(LinkedList<Castelo> castelos)
	{
		castelos.add(new Japones(15, 2, 2, "C1"));
		castelos.add(new Europeu(10, 2, 3, "C2"));
		castelos.add(new Japones(15, 2, 2, "C3"));
		castelos.add(new Europeu(10, 2, 3, "C4"));
	}
}
