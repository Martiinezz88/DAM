import java.util.Scanner;

public class problema8{

	public static void main (String[] args) {

		Scanner teclado = new Scanner(System.in);

		int N = 0;
		int resultado = 0;
		int factorial = 1;
		boolean seguir = true;
	
			System.out.print("Escribe un numero y te dare como salida su factorial (0 para cerrar el programa): ");
			N = teclado.nextInt();

			if ( N > 0 ){
				
				for (int i = 1; N >= i; i++){

					factorial *= i; 		
				}

			System.out.println("El factorial de " + N + " es: " + factorial);

			}
	}
}