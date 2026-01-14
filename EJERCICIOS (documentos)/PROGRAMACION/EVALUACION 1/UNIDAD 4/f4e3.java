import java.util.Scanner;
public class f4e3 {

	public static void main (String[] args) {

		Scanner teclado = new Scanner(System.in);
		String frase;
		String palabra;
		int posicion;
		boolean seguir = false;
		
		System.out.print("Escribe una frase: ");
		frase = teclado.nextLine(); 

		System.out.print("Escribe una letra para decirte en que posición está dentro de la frase: ");
		palabra = teclado.nextLine();

		posicion = frase.indexOf(palabra);
		posicion++;

		if (posicion > 0)System.out.println("La posicion de la palabra es: " + posicion);

		if (posicion < 1)System.out.println("La posicion de la palabra es: 0");

	}
}
