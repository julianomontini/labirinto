package com.labirinto;
import com.coordenadas.*;
import com.estruturadados.Fila;
import com.estruturadados.PilhaDinamica;
public class PercorredorLabirinto {

	private Labirinto labirinto;
	private PilhaDinamica<Coordenada> caminho;
	private PilhaDinamica<Fila<Coordenada>> possibilidades;
	private Coordenada atual;

	public PercorredorLabirinto(Labirinto lab){
		this.labirinto = lab;
		this.caminho = new PilhaDinamica<Coordenada>();
		this.possibilidades = new PilhaDinamica<Fila<Coordenada>>();
		this.atual = lab.getEntrada();
	}

	public Labirinto percorrerLabirinto() throws Exception{

		while(haProgressivo(this.atual)){
			percorrerProgressivo(jogadasValidas(this.atual));
		}

		return null;
	}
	
	private void percorrerProgressivo(Fila<Coordenada> jogadasValidas)throws Exception{
		this.atual.setElemento(Character.valueOf('*'));
		this.atual = jogadasValidas.recuperarERemover();
	}

	private boolean haProgressivo(Coordenada atual)throws Exception{
		return !jogadasValidas(atual).estaVazio();
	}

	private Fila<Coordenada> jogadasValidas(Coordenada atual) throws Exception{

		boolean retorno;
		Fila<Coordenada> jogadas = new Fila<Coordenada>(3);

		//cima
		if(atual.linha > 0){
			retorno = labirinto.getPosicoes()[atual.linha-1][atual.coluna]
					.getElemento()
					.equals("P".charAt(0));
			if(retorno)
				jogadas.adicionar(labirinto.getPosicoes()[atual.linha-1][atual.coluna]);
		}

		//baixo
		if(atual.linha < labirinto.getQuantidadeLinhas()){
			retorno = labirinto.getPosicoes()[atual.linha+1][atual.coluna]
					.getElemento()
					.equals("P".charAt(0));
			if(retorno)
				jogadas.adicionar(labirinto.getPosicoes()[atual.linha+1][atual.coluna]);
		}

		//esquerda
		if(atual.coluna > 0){
			retorno = labirinto.getPosicoes()[atual.linha][atual.coluna-1]
					.getElemento()
					.equals("P".charAt(0));
			if(retorno)
				jogadas.adicionar(labirinto.getPosicoes()[atual.linha][atual.coluna-1]);
		}

		//direita
		if(atual.coluna < labirinto.getQuantidadeColunas()){
			retorno = labirinto.getPosicoes()[atual.linha][atual.coluna+1]
					.getElemento()
					.equals("P".charAt(0));
			if(retorno)
				jogadas.adicionar(labirinto.getPosicoes()[atual.linha][atual.coluna+1]);
		}
		
		return jogadas;

	}

}
