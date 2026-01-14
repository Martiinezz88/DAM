import java.util.Scanner;

public class problema2 {
	
	public static void main (String[] args) {

		int numero,resultado = 0;
		Scanner teclado = new Scanner (System.in);

		do {
			System.out.print("Escribe un numero comprendido entre el 1 y el 10: ");
			numero = teclado.nextInt();

			if (numero < 1 || numero > 10) System.out.print("El número es erroneo, vuelve a intentarlo.");
			
		} while (numero < 1 || numero > 10);
		
		System.out.println("TABLA DE MULTIPLICAR DE " + numero);

		for (int i = 1; i <= 10; i++) {

			resultado = numero * i;
			System.out.println( numero + " * " + i + " = " + resultado);

		} 				
	}
}