import java.util.Scanner;

public class re2{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);

		int N1;
		int N2;
		int OP;
		int resultado = 0;
		boolean seguir = true; 

		do{
			
			System.out.println("................................................................................................");

			System.out.print("Escribe dos números y te daré a elegir si quieres un tipo de operación distinta \n-> Primer número: ");
			N1 = teclado.nextInt();
 
			System.out.print("-> Segundo número: ");
			N2 = teclado.nextInt();

			System.out.println("-----------------------------------------------------------------------");

			System.out.print("Indique que operación quiere realizar: \n1. Suma\n2. Resta\n3. Multiplicación\n4. División\n0. Cerrar el programa \nEscribe la opción: ");
			OP = teclado.nextInt();

			switch (OP){

			case 1: 
	
				resultado = N1 + N2;

				break;

			case 2: 

				resultado = N1 - N2;

				break;

			case 3: 

				resultado = N1 * N2;

				break;
	
			case 4: 

				resultado = N1 / N2;

				break;

			case 0:

				seguir = false;
				
			}
			
			if (OP != 0) System.out.println("el resultado de la operación entre " + N1 + " y " + N2 + " es: " + resultado);
		
		}while(OP != 0);
	}
}