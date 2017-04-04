package programa;

import com.estruturadados.PilhaDinamica;
import com.labirinto.Labirinto;

public class Programa {

	public static void main(String[] args) {
		try {
			
			PilhaDinamica<Integer> pilha = new PilhaDinamica<Integer>();
			pilha.adicionar(Integer.valueOf(10));
			pilha.adicionar(Integer.valueOf(20));
			pilha.adicionar(Integer.valueOf(30));
			pilha.adicionar(Integer.valueOf(40));
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
