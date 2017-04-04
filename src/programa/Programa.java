package programa;

import com.labirinto.Labirinto;

public class Programa {

	public static void main(String[] args) {
		try {
			Labirinto lab = new Labirinto("labirinto.txt");
			System.out.println(lab.getEntrada());
			System.out.println(lab.getSaida());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
