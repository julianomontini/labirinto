package com.coordenadas;

public class Coordenada {

	public final int linha, coluna;
	
	/**
	 * Cria coordenadas x e y que serão armazenadas em variáveis membros do tipo int final
	 * @param linha coordenada x
	 * @param coluna coordenada y
	 */
	public Coordenada(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	@Override
	public String toString(){
		return "Linha: " + linha + " Coluna: " + coluna;
	}
	
	@Override
	public boolean equals(Object o){
		if(o == null)
			return false;
		if(o == this)
			return true;
		if(!(o.getClass() == this.getClass()))
			return false;
		
		Coordenada comparado = (Coordenada)o;
		
		if(comparado.linha != this.linha)
			return false;
		
		if(comparado.coluna != this.coluna)
			return false;
		
		return true;
	}
	
	@Override
	public int hashCode(){
		int hash = 777;
		hash = hash*31 + Integer.valueOf(linha).hashCode();
		hash = hash*31 + Integer.valueOf(coluna).hashCode();
		return hash;
	}
}
