package com.labirinto;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Classe com validador de labirintos. A classe não pode ser instanciada, pois
 * possui um construtor privado e apenas um método publico.
 * 
 * @author Juliano Montini
 * @since 2017
 */
public class ValidadorLabirinto {

	private static final String regexElementos = "^*[^MPES]$";
	private static final String regexEntrada = "[E]";
	private static final String regexSaida = "[S]";
	private static final String regexMuro = "[P]";

	private ValidadorLabirinto() {
	}

	/**
	 * Verifica se as linhas de um labirinto são válidas. O método não possui
	 * nenhum retorno, porém se houver algum dado inválido, uma excessão será
	 * lançada.
	 * 
	 * @param linhasLabirinto
	 *            Lista com as linhas do labirinto ( em forma de String )
	 * @throws Exception
	 *             se a quantidade de elementos por linha for inválida, conter
	 *             elementos que não sejam: E S M P ou, entrada ou saída não
	 *             estiverem nas extremidades.
	 */
	public static void validaLabirinto(List<String> linhasLabirinto) throws Exception {
		verificaDimensoes(linhasLabirinto);
		verificaElementos(linhasLabirinto);
		verificaES(linhasLabirinto);
		verificaMuro(linhasLabirinto);
	}

	private static void verificaDimensoes(List<String> linhasLabirinto) throws Exception {

		int tamanhoLinha;
		int numLinha = 0;

		if (linhasLabirinto.size() < 3)
			throw new Exception("Quantidade de linhas deve ser maior que 2");

		tamanhoLinha = linhasLabirinto.get(0).length();

		if (tamanhoLinha < 3)
			throw new Exception("Quantidade de elementos por linha deve ser maior que 2");

		for (String linha : linhasLabirinto) {
			numLinha++;
			if (linha.length() != tamanhoLinha)
				throw new Exception("Quantidade de elementos por linha incompativel na linha " + numLinha);
		}

	}

	private static void verificaElementos(List<String> linhasLabirinto) throws Exception {

		Pattern padrao;
		Matcher m;

		int contadorEntrada = 0, contadorSaida = 0;

		// Verifica se possui apenas elementos válidos
		padrao = Pattern.compile(regexElementos);
		for (String linha : linhasLabirinto) {
			m = padrao.matcher(linha);
			if (m.find())
				throw new Exception("Apenas os caracteres: E S M P são permitidos");
		}

		// Verifica a quantidade de entradas
		padrao = Pattern.compile(regexEntrada);
		for (String linha : linhasLabirinto) {
			m = padrao.matcher(linha);
			while (m.find()) {
				contadorEntrada++;
			}
		}

		// Verifica a quantidade de saidas
		padrao = Pattern.compile(regexSaida);
		for (String linha : linhasLabirinto) {
			m = padrao.matcher(linha);
			while (m.find()) {
				contadorSaida++;
			}
		}

		if (contadorEntrada != 1 || contadorSaida != 1)
			throw new Exception("Quantidade de entradas/saidas invalida");

	}

	private static void verificaES(List<String> linhasLabirinto) throws Exception {

		Matcher es;
		Pattern padrao;

		for (int i = 1; i < linhasLabirinto.size() - 1; i++) {

			String linha = linhasLabirinto.get(i);
			String substring = linha.substring(1, linha.length() - 1);

			// Procura por entradas no meio do labirinto
			padrao = Pattern.compile(regexEntrada);
			es = padrao.matcher(substring);
			if (es.find())
				throw new Exception("Entradas só podem existir nas extremidades");

			// Procura por saidas no meio do labirinto
			padrao = Pattern.compile(regexSaida);
			es = padrao.matcher(substring);
			if (es.find())
				throw new Exception("Saidas só podem existir nas extremidades");
		}

	}

	private static void verificaMuro(List<String> linhasLabirinto) throws Exception {
		Pattern padrao;
		Matcher m;
		String s;

		padrao = Pattern.compile(regexMuro);

		s = linhasLabirinto.get(0);
		m = padrao.matcher(s);
		if (m.find())
			throw new Exception("Elementos invalidos no muro superior");

		s = linhasLabirinto.get(linhasLabirinto.size() - 1);
		m = padrao.matcher(s);
		if (m.find())
			throw new Exception("Elementos invalidos no muro inferior");

		for (int i = 1; i < linhasLabirinto.size() - 1; i++) {
			String sub;
			s = linhasLabirinto.get(i);

			sub = s.substring(0, 1);
			m = padrao.matcher(sub);
			if (m.find())
				throw new Exception("Elementos invalidos no muro esquerdo");

			sub = s.substring(s.length() - 1, s.length());
			m = padrao.matcher(sub);
			if (m.find())
				throw new Exception("Elementos invalidos no muro direito");
		}
	}

}
