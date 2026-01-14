import java.util.Scanner;
	
public class problema6{
	
	public static void main (String[] args){

		int N = 0;
		int par = 0;
		int impar = 0;
		int contador = 1;
		

		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("--------------------------------------------------------------------------------------");

			System.out.println("Escribe números, se sumará si su posición es par o impar en distintos grupos.");
			System.out.print("Para cerrar el programa pulse 0: ");
			N = teclado.nextInt();
			
			System.out.println("--------------------------------------------------------------------------------------");

			if ( N != 0 ){

				if (contador%2 == 0) par += N;
				if (contador%2 == 1) impar += N;

				contador++;
			}


		}while( N != 0 );
			System.out.println("--------------------------------------------------------------------------------------");

			System.out.println("La suma de los numeros pares es: " + par);
		
			System.out.println("La suma de los numeros impares es: " + impar);
																			
			System.out.println("--------------------------------------------------------------------------------------");



	}
}