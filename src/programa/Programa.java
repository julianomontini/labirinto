package programa;

import com.labirinto.Labirinto;

public class Programa {

	public static void main(String[] args) {
		try {
			Labirinto lab = new Labirinto("labirinto.txt");
			Labirinto lab2 = new Labirinto("labirinto.txt");
			
			System.out.println(lab.hashCode());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
