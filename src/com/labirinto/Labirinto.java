package com.labirinto;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Labirinto {
	
	private Character posicoes[][];
	private int quantidadeLinhas;
	private int quantidadeColunas;

	/**
	 * Recebe o caminho de um arquivo txt, valida se é um labirinto valido, então devolve a instancia de um labirinto
	 * @param caminho caminho do arquivo texto no sistema
	 */
	public Labirinto(String caminho)throws Exception{
		
		this.posicoes = carregaLabirinto(caminho);
		
	}
	
	private Character[][] carregaLabirinto(String caminho)throws Exception{
		
		List<String> linhasLabirinto = new ArrayList<String>();
		File file = new File(caminho);
		Scanner scan = new Scanner(file);
		char[][] arrayPosicoes;
		Character[][] retorno;
		
		while(scan.hasNextLine()){
			linhasLabirinto.add(scan.nextLine());
		}
		
		scan.close();
		
		ValidadorLabirinto.validaLabirinto(linhasLabirinto);
		
		this.quantidadeLinhas = linhasLabirinto.size();
		this.quantidadeColunas = linhasLabirinto.get(0).length();
		
		arrayPosicoes = new char[this.quantidadeLinhas][this.quantidadeColunas];
		retorno = new Character[this.quantidadeLinhas][this.quantidadeColunas];
		
		for(int i = 0; i < linhasLabirinto.size(); i++){
			arrayPosicoes[i] = linhasLabirinto.get(i).toCharArray();
		}
		
		for(int i = 0; i < arrayPosicoes.length; i++){
			for(int j = 0; j < arrayPosicoes[i].length; j++){
				retorno[i][j] = Character.valueOf(arrayPosicoes[i][j]);
			}
		}
		
		return retorno;
	}
	
	public Character[][] getPosicoes() {
		return posicoes;
	}

	public int getQuantidadeLinhas() {
		return quantidadeLinhas;
	}

	public int getQuantidadeColunas() {
		return quantidadeColunas;
	}
	
	@Override
	public String toString(){
		
		String retorno = "Labirinto " + quantidadeLinhas + "x" + quantidadeColunas + "\n";
		retorno += "Elementos: \n";
		
		for(int i = 0; i < quantidadeLinhas; i++){
			for(int j = 0; j < quantidadeColunas; j++){
				retorno += this.posicoes[i][j];
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
