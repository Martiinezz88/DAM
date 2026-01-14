import java.util.Scanner;


public class problema7{

	public static void main(String[] args){

		int N = 0 ;
		int suma = 0;
		double media = 0;
		int numeromayor = 0;
		int numeromenor = 0;
		Scanner teclado = new Scanner(System.in);

		do {
		System.out.println("Escribe una serie de números y te imprimiré la media, su número mayor y menor. ");
		System.out.print("Para cerrar el programa escribe 0: ");
		N = teclado.nextInt();
			if( N != 0 ){
			
				suma += N;
				media = (double)suma/(double)2;
				if ( N != 0){
					if ( N < numeromenor) numeromenor = N;
				}
				if ( N > numeromayor) numeromayor = N;
					
			}

		}while ( N != 0 );
		System.out.println("---------------------------------------------------------------------------------");

		System.out.println("La Media de los números es: " + media);
		System.out.println("El numero mayor es: " + numeromayor);
		System.out.println("El numero menor es: " + numeromenor);

		System.out.println("---------------------------------------------------------------------------------");

	}
}