package com.coordenadas;

/**
 * Classe POJO para guardar um ponto(coordenada).
 * O ponto é criado com base em uma linha e coluna.
 * @author Juliano Montini
 * @since 2017
 */
public class Coordenada {

	public final int linha, coluna;
	
	/**
	 * Cria coordenadas linha e coluna.
	 * As coordenadas criadas serão armazenadas em atributos do tipo final int
	 * @param numero linha
	 * @param numero coluna
	 */
	public Coordenada(int linha, int coluna){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	/**
	 * @return Linha: numeroLinha Coluna: numeroColuna
	 */
	@Override
	public String toString(){
		return "Linha: " + linha + " Coluna: " + coluna;
	}
	
	/**Faz comparação profunda da classe coordenada.
	 *Compara os atributos linha e coluna.
	 *@param Object objeto a ser comparado.
	 *@return igualdade entre esse objeto e objeto recebido.
	 */
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
	/**
	 * @return hashCode calculado com base no elementos linha e coluna
	 */
	@Override
	public int hashCode(){
		int hash = 777;
		hash = hash*31 + Integer.valueOf(linha).hashCode();
		hash = hash*31 + Integer.valueOf(coluna).hashCode();
		return hash;
	}
}
