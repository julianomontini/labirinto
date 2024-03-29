package com.labirinto;

import com.coordenadas.Coordenada;
import com.estruturadados.Fila;
import com.estruturadados.PilhaDinamica;

public class PercorredorLabirinto {

	private Labirinto labirinto;
	private PilhaDinamica<Coordenada> caminho;
	private PilhaDinamica<Fila<Coordenada>> possibilidades;
	private Coordenada atual;

	/**
	 * Instancia um novo percorredor de labirinto
	 * @param lab Labirinto a ser percorrido
	 */
	public PercorredorLabirinto(Labirinto lab) {
		this.labirinto = lab;
		this.caminho = new PilhaDinamica<Coordenada>();
		this.possibilidades = new PilhaDinamica<Fila<Coordenada>>();
		this.atual = lab.getEntrada();
	}

	/**
	 * Percorre o labirinto que foi passado no construtor
	 * @return Labirinto percorrido
	 * @throws Exception Caso labirinto nao tenha solucao
	 */
	public Labirinto percorrerLabirinto() throws Exception {

		do {
			while (haProgressivo(this.atual)) {
				percorrerProgressivo(jogadasValidas(this.atual));
			}
			this.atual.setElemento('*');

			if (!this.atual.equals(this.labirinto.getSaida()) && !this.atual.equals(this.labirinto.getEntrada()))
				percorrerRegressivo();
		} while (!this.atual.equals(this.labirinto.getSaida()) && !this.atual.equals(this.labirinto.getEntrada()));

		if (this.atual.linha == this.labirinto.getEntrada().linha
				&& this.atual.coluna == this.labirinto.getEntrada().coluna)
			throw new Exception("O labirinto n�o possui solu��o");

		this.atual.setElemento('*');

		return this.labirinto;
	}

	private void percorrerProgressivo(Fila<Coordenada> jogadasValidas) throws Exception {

		this.atual.setElemento(Character.valueOf('*'));
		this.caminho.adicionar(new Coordenada(this.atual));

		this.atual = jogadasValidas.recuperarERemover();
		this.possibilidades.adicionar(jogadasValidas);

	}

	private boolean haProgressivo(Coordenada atual) throws Exception {
		return !jogadasValidas(atual).estaVazio();
	}

	private Fila<Coordenada> jogadasValidas(Coordenada atual) throws Exception {

		Fila<Coordenada> jogadas = new Fila<Coordenada>(3);

		if (atual.getElemento().equals('S'))
			return jogadas;

		// cima
		if (atual.linha > 0) {
			Character c = labirinto.getPosicoes()[atual.linha - 1][atual.coluna].getElemento();
			if (c.equals('P') || c.equals('S'))
				jogadas.adicionar(labirinto.getPosicoes()[atual.linha - 1][atual.coluna]);
		}

		// baixo
		if (atual.linha < labirinto.getQuantidadeLinhas()) {
			Character c = labirinto.getPosicoes()[atual.linha + 1][atual.coluna].getElemento();
			if (c.equals('P') || c.equals('S'))
				jogadas.adicionar(labirinto.getPosicoes()[atual.linha + 1][atual.coluna]);
		}

		// esquerda
		if (atual.coluna > 0) {
			Character c = labirinto.getPosicoes()[atual.linha][atual.coluna - 1].getElemento();
			if (c.equals('P') || c.equals('S'))
				jogadas.adicionar(labirinto.getPosicoes()[atual.linha][atual.coluna - 1]);
		}

		// direita
		if (atual.coluna < labirinto.getQuantidadeColunas()) {
			Character c = labirinto.getPosicoes()[atual.linha][atual.coluna + 1].getElemento();
			if (c.equals('P') || c.equals('S'))
				jogadas.adicionar(labirinto.getPosicoes()[atual.linha][atual.coluna + 1]);
		}

		return jogadas;

	}

	private void percorrerRegressivo() throws Exception {
		while (!possibilidades.estaVazio() && possibilidades.recuperar().estaVazio()
				&& !this.atual.equals(this.labirinto.getEntrada())) {
			Coordenada c = this.caminho.recuperarERemover();
			this.labirinto.getPosicoes()[c.linha][c.coluna].setElemento('P');
			this.possibilidades.remover();
		}

		if (!possibilidades.estaVazio() && !possibilidades.recuperar().estaVazio()) {
			this.atual.setElemento('P');
			this.atual = possibilidades.recuperar().recuperarERemover();
		}
	}
	
	@Override
	public String toString(){
		String retorno = this.labirinto.toString();
		retorno += "Atual: " + this.atual.toString();
		
		return retorno;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(o == this)
			return true;
		if(o.getClass() != this.getClass())
			return false;
		
		PercorredorLabirinto comparado = (PercorredorLabirinto) o;
		
		if(!comparado.possibilidades.equals(this.possibilidades))
			return false;
		if(!comparado.caminho.equals(this.caminho))
			return false;
		if(!comparado.atual.equals(this.atual))
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode(){
		int retorno = 777;
		
		retorno = retorno*31 + this.possibilidades.hashCode();
		retorno = retorno*31 + this.caminho.hashCode();
		retorno = retorno*31 + this.atual.hashCode();
		
		return retorno;
	}

}
