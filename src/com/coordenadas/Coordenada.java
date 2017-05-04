package com.coordenadas;

/**
 * Classe POJO para guardar um ponto(coordenada). O ponto é criado com base em
 * uma linha e coluna.
 * 
 * @author Juliano Montini
 * @since 2017
 */
public class Coordenada {

	public final int linha, coluna;
	private Character elemento;

	/**
	 * Cria coordenadas linha, coluna e elemento. As coordenadas criadas serão armazenadas
	 * em atributos do tipo final int, o elemento da coordenada é armzenada em um Character
	 * 
	 * @param linha numero da linha
	 * @param coluna numero da coluna
	 * @param elemento elemento da posicao
	 */
	public Coordenada(int linha, int coluna, Character elemento) {
		this.linha = linha;
		this.coluna = coluna;
		this.elemento = elemento;
	}
	
	/**
	 * Construtor de copia de coordenada
	 * @param c Coordenada a ser copiada
	 */
	public Coordenada(Coordenada c) {
		this.linha = c.linha;
		this.coluna = c.coluna;
		this.elemento = c.elemento;
	}

	/**
	 * @return Valor x em: (linha,coluna)
	 */
	@Override
	public String toString() {
		return "Valor: " + elemento + " em: " + "(" + this.linha + "," + this.coluna + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == null)
			return false;
		if (o == this)
			return true;
		if (!(o.getClass() == this.getClass()))
			return false;

		Coordenada comparado = (Coordenada) o;

		if (comparado.linha != this.linha)
			return false;

		if (comparado.coluna != this.coluna)
			return false;

		if (comparado.elemento != this.elemento)
			return false;

		return true;
	}

	/**
	 * @return hashCode calculado com base no elementos linha, coluna e
	 *         elemento.
	 */
	@Override
	public int hashCode() {
		int hash = 777;
		hash = hash * 31 + Integer.valueOf(linha).hashCode();
		hash = hash * 31 + Integer.valueOf(coluna).hashCode();
		hash = hash * 31 + elemento.hashCode();
		return hash;
	}
	
	/**
	 * Retorna o Character armazenado na coordenada
	 * @return Character armazenado na coordenada
	 */
	public Character getElemento() {
		return elemento;
	}

	/**
	 * Atualiza o valor do Character na coordenada atual
	 * @param elemento Character a ser colocado na coordenada atual
	 */
	public void setElemento(Character elemento) {
		this.elemento = elemento;
	}
}
