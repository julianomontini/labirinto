package programa;

import com.coordenadas.Coordenada;
import com.estruturadados.Fila;
import com.labirinto.Labirinto;

public class Programa {

	public static void main(String[] args) {
		try {
			Labirinto lab = new Labirinto("labirinto.txt");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
