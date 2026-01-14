import java.util.Scanner;

public class re1{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in); 
		
		double euro;
		double pesetas; 
		
		do {

			System.out.print("Escribe una cantidad de euros y te las pasare a pesetas (cerrar programa escribe 0): ");
			euro = teclado.nextDouble();

			pesetas = euro * 166.386;

			System.out.println("Hay en total " + pesetas + " pesetas");

		}while(euro != 0);
	}
}