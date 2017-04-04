package com.labirinto;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Labirinto {

	/**
	 * Recebe o caminho de um arquivo txt, valida se é um labirinto valido, então devolve a instancia de um labirinto
	 * @param caminho caminho do arquivo texto no sistema
	 */
	public Labirinto(String caminho)throws Exception{
	
	}
	
	private String[][] carregaLabirinto(String caminho)throws Exception{
		
		List<String> linhasLabirinto = new ArrayList<String>();
		File file = new File(caminho);
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine()){
			linhasLabirinto.add(scan.nextLine());
		}
		
		verificaDimensoes(linhasLabirinto);
		
		return null;
	}
	
	private void verificaDimensoes(List<String> linhasLabirinto) throws Exception{
		
		int tamanhoLinha;
		int numLinha = 0;
		
		if(linhasLabirinto.size() <3)
			throw new Exception("Quantidade de linhas deve ser maior que 2");
		
		tamanhoLinha = linhasLabirinto.get(0).length();
		
		for(String linha : linhasLabirinto){
			numLinha++;
			if(linha.length() != tamanhoLinha)
				throw new Exception("Quantidade de elementos por linha incompativel na linha " + numLinha);
		}
		
	}
}
