import java.util.Scanner;

public class problema5 { 
    public static void main(String[] args) {

        int N = 0;
	int contador = 0;
	int suma = 0;

	Scanner teclado = new Scanner(System.in);

	do {
	
		System.out.print("Escribe números para acomularlos (0 para cerrar programa): ");
		N = teclado.nextInt();
		
		if ( N != 0) {
		
			suma += N; 
			
			contador++;
		}
		

	} while ( N != 0 );

	System.out.println("El número total es: " + suma );

	System.out.print("La cantidad de números introducidos es: " + contador );
    }
}
