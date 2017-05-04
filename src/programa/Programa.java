package programa;

import java.util.Scanner;

import com.labirinto.Labirinto;
import com.labirinto.PercorredorLabirinto;

public class Programa {

	public static void main(String[] args) {
		try {
			Scanner sc = new Scanner(System.in);
			System.out.println("Digite o caminho do arquivo: ");
			String caminho = sc.nextLine();
			PercorredorLabirinto pl = new PercorredorLabirinto(new Labirinto(caminho));
			System.out.println(pl.percorrerLabirinto());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
