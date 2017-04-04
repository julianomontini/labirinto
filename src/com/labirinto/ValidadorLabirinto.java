package com.labirinto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidadorLabirinto {
	
	private static final String regexElementos = "^*[^MPES]$";
	private static final String regexEntrada = "[E]";
	private static final String regexSaida = "[S]";
	
	private ValidadorLabirinto(){}

	public static void validaLabirinto(List<String> linhasLabirinto) throws Exception{
		verificaDimensoes(linhasLabirinto);
		verificaElementos(linhasLabirinto);
		verificaES(linhasLabirinto);
	}
	
	private static void verificaDimensoes(List<String> linhasLabirinto) throws Exception{
		
		int tamanhoLinha;
		int numLinha = 0;
		
		if(linhasLabirinto.size() <3)
			throw new Exception("Quantidade de linhas deve ser maior que 2");
		
		tamanhoLinha = linhasLabirinto.get(0).length();
		
		if(tamanhoLinha<3)
			throw new Exception("Quantidade de elementos por linha deve ser maior que 2");
		
		for(String linha : linhasLabirinto){
			numLinha++;
			if(linha.length() != tamanhoLinha)
				throw new Exception("Quantidade de elementos por linha incompativel na linha " + numLinha);
		}
		
	}

	private static void verificaElementos(List<String> linhasLabirinto) throws Exception{
		
		Pattern padrao; 
		Matcher m;
		
		int contadorEntrada = 0, contadorSaida = 0;
		
		//Verifica se possui apenas elementos v�lidos
		padrao = Pattern.compile(regexElementos);
		for(String linha : linhasLabirinto){
			m = padrao.matcher(linha);
			if(m.find())
				throw new Exception("Apenas os caracteres: E S M P s�o permitidos");
		}
		
		//Verifica a quantidade de entradas
		padrao = Pattern.compile(regexEntrada);
		for(String linha : linhasLabirinto){
			m = padrao.matcher(linha);
			while(m.find()){
				contadorEntrada++;
			}
		}
		
		//Verifica a quantidade de saidas
		padrao = Pattern.compile(regexSaida);
		for(String linha : linhasLabirinto){
			m = padrao.matcher(linha);
			while(m.find()){
				contadorSaida++;
			}
		}
		
		if(contadorEntrada != 1 || contadorSaida != 1)
			throw new Exception("Quantidade de entradas/saidas invalida");
		
	}
	
	private static void verificaES(List<String> linhasLabirinto) throws Exception{
		
		Matcher es;
		Pattern padrao;
		
		for(int i = 1; i < linhasLabirinto.size()-1; i++){
			
			String linha = linhasLabirinto.get(i);
			String substring = linha.substring(1, linha.length()-1);
			
			//Procura por entradas no meio do labirinto
			padrao = Pattern.compile(regexEntrada);
			es = padrao.matcher(substring);
			if(es.find())
				throw new Exception("Entradas s� podem existir nas extremidades");
			
			//Procura por saidas no meio do labirinto
			padrao = Pattern.compile(regexSaida);
			es = padrao.matcher(substring);
			if(es.find())
				throw new Exception("Saidas s� podem existir nas extremidades");
		}
		
	}
}