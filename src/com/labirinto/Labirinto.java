package com.labirinto;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.coordenadas.Coordenada;

public class Labirinto {
	
	private Coordenada posicoes[][];
	private int quantidadeLinhas;
	private int quantidadeColunas;
	private Coordenada entrada;
	private Coordenada saida;

	/**
	 * Recebe o caminho de um arquivo txt, valida se � um labirinto valido, ent�o devolve a instancia de um labirinto
	 * @param caminho caminho do arquivo texto no sistema
	 */
	public Labirinto(String caminho)throws Exception{
		
		this.posicoes = carregaLabirinto(caminho);
		
	}
	
	/**
	 * Carrega um labirinto de acordo com o caminho passado e verifica se ele � valido.
	 * @param caminho Caminho aonde o labirinto est�
	 * @return Labirinto instanciado e validado
	 * @throws Exception Caso o arquivo nao exista ou caso nao seja um labirinto valido
	 */
	private Coordenada[][] carregaLabirinto(String caminho)throws Exception{
		
		List<String> linhasLabirinto = new ArrayList<String>();
		File file = new File(caminho);
		Scanner scan = new Scanner(file);
		char[][] arrayPosicoes;
		Coordenada[][] retorno;
		
		while(scan.hasNextLine()){
			linhasLabirinto.add(scan.nextLine());
		}
		
		scan.close();
		
		ValidadorLabirinto.validaLabirinto(linhasLabirinto);
		
		this.quantidadeLinhas = linhasLabirinto.size();
		this.quantidadeColunas = linhasLabirinto.get(0).length();
		
		arrayPosicoes = new char[this.quantidadeLinhas][this.quantidadeColunas];
		retorno = new Coordenada[this.quantidadeLinhas][this.quantidadeColunas];
		
		for(int i = 0; i < linhasLabirinto.size(); i++){
			arrayPosicoes[i] = linhasLabirinto.get(i).toCharArray();
		}
		
		for(int i = 0; i < arrayPosicoes.length; i++){
			for(int j = 0; j < arrayPosicoes[i].length; j++){
				retorno[i][j] = new Coordenada(i,j,Character.valueOf(arrayPosicoes[i][j]));
				if(arrayPosicoes[i][j] == "E".charAt(0))
					this.entrada = retorno[i][j];
				if(arrayPosicoes[i][j] == "S".charAt(0))
					this.saida = retorno[i][j];
			}
		}
		
		return retorno;
	}
	
	/**
	 * Getter de Array de coordenadas referente ao labirinto
	 * @return Array de coordenadas
	 */
	public Coordenada[][] getPosicoes() {
		return posicoes;
	}

	/**
	 * Quantidade de linhas do labirinto definida no momento da cria��o
	 * @return quantidade de linhas do labirinto
	 */
	public int getQuantidadeLinhas() {
		return quantidadeLinhas;
	}

	/**
	 * Quantidade de colunas definida no momento da cria��o
	 * @return quantidade de colunas do labirinto
	 */
	public int getQuantidadeColunas() {
		return quantidadeColunas;
	}
	
	/**
	 * Getter para entrada do labirinto
	 * @return Coordenada referente a entrada do labirinto
	 */
	public Coordenada getEntrada() {
		return entrada;
	}

	/**
	 * Getter para saida do labirinto
	 * @return Coordenada referente a saida do labirinto
	 */
	public Coordenada getSaida() {
		return saida;
	}

	@Override
	public String toString(){
		
		String retorno = "Labirinto " + quantidadeLinhas + "x" + quantidadeColunas + "\n";
		retorno += "Elementos: \n";
		
		for(int i = 0; i < quantidadeLinhas; i++){
			for(int j = 0; j < quantidadeColunas; j++){
				retorno += this.posicoes[i][j].getElemento();
			}
			retorno += "\n";
		}
		return retorno;
	}
	
	@Override
	public int hashCode(){
		
		int hash = 777;
		
		hash = hash*31 + Arrays.deepHashCode(this.posicoes);
		
		return hash;
	}
	
	@Override
	public boolean equals(Object o){
		
		if(o == null)
			return false;
		
		if(o == this)
			return true;
		
		if(!(o.getClass() == this.getClass()))
			return false;
		
		Labirinto comparado = (Labirinto)o;
		
		if(comparado.quantidadeColunas != this.quantidadeColunas)
			return false;
		
		if(comparado.quantidadeLinhas != this.quantidadeLinhas)
			return false;
		
		for(int i = 0; i < quantidadeLinhas; i++){
			for(int j = 0; j < quantidadeColunas; j++){
				if(!(this.posicoes[i][j].equals(comparado.posicoes[i][j])))
					return false;
			}
		}
		
		return true;
		
	}
	
}
