import java.util.Scanner;
public class problema1 {
	public static void main(String[] args){
	
		Scanner teclado = new Scanner (System.in);
		int A,B,suma = 0;
	
		do {
		
            System.out.print("Introduce el valor de A: ");
			A = teclado.nextInt();

			System.out.print("Introduce el valor de B: ");
			B = teclado.nextInt();

			if ( A >= B) System.out.println("A debe ser menor que B, intentelo de nuevo");

       		} while (A >= B);

			for ( int i = A; i < B; i++ ) suma += i;
			System.out.print("La suma es: " + suma);
	}
}