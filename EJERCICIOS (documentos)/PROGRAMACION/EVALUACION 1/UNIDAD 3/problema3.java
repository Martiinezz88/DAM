import java.util.Scanner;

public class problema3{

	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);  
		int N = 0;
		int D;
		boolean divisores = false;

		do {
			System.out.print("Escribe un número y te daré como salida sus divisores \n(Para cerrar el programa pulsa 0): ");
			N = teclado.nextInt();

			for(int i = 1; i < N; i++){

				D = N % i;

				if (D == 0){

					divisores = true;

					if (divisores == true) System.out.println( i + " es divisor de " + N);
					
				}
			}


		}while(N > 0);

		if (N <= 0){

			System.out.print("El programa se ha cerrado");

		}
	}
}