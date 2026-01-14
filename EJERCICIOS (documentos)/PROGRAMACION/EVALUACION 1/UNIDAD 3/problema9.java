import java.util.Scanner;
public class problema9{

	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int N = 0;
		double perf = 1;

		System.out.print("Escribe un número que sea mayor a 0 y te diré si es perfecto o no: ");
		N = teclado.nextInt();

		if ( N > 0 ){

			for(int i = 1; perf < N; i++){

				perf = (1 << (i - 1)) * ((1 << i) - 1);
				
				
				
			}
			
				if ( perf == N ) System.out.println("El número "+ N +" es perfecto");

				else if ( perf != N ) System.out.println("El número "+ N +" no es perfecto");
		}

		else System.out.println("Fue introducido un número menor o igual que 0, por lo tanto se cerrara el programa"); 

	}
}