package programa;

import com.labirinto.Labirinto;
import com.labirinto.PercorredorLabirinto;

public class Programa {

	public static void main(String[] args) {
		try {
			PercorredorLabirinto pl = new PercorredorLabirinto(new Labirinto("labirinto3.txt"));
			System.out.println(pl.percorrerLabirinto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
