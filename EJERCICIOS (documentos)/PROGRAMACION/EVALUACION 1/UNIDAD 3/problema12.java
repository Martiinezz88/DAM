import java.util.Scanner;

public class problema12{

	public static void main(String[] args){

		Scanner teclado = new Scanner(System.in);

		int N, B, A, L, R;
		String figura;

		System.out.println("----------------------------------------------------------------------");

		System.out.println("1. Triángulo. \n2. Cuadrado. \n3. Rectángulo. \n0. Para cerrar el programa.");

		System.out.print("Escriba un número y te calcularé el área de cada uno: ");
		N = teclado.nextInt();

		System.out.println("----------------------------------------------------------------------");
		
		switch(N){

			case 1: 
			
				figura = "Triangulo";
				System.out.println("Escribe los siguientes datos para realizar el cálculo del area de el " + figura);

				System.out.print("Base: ");
				B = teclado.nextInt();

				System.out.print("Altura: ");
				A = teclado.nextInt();
				
				R = (B * A) / 2;

				System.out.print("El area del " + figura + " es: " + R);

			case 2: 
			
				figura = "Cuadrado";
				System.out.println("Escribe los siguientes datos para realizar el cálculo del area de el " + figura);

				System.out.print("Lado: ");
				L = teclado.nextInt();
				
				R = (L * L);

				System.out.print("El area del " + figura + " es: " + R);

			case 3: 
			
				figura = "Rectángulo";
				System.out.println("Escribe los siguientes datos para realizar el cálculo del area de el " + figura);

				System.out.print("Base: ");
				B = teclado.nextInt();

				System.out.print("Altura: ");
				A = teclado.nextInt();
				
				R = (B * A);

				System.out.print("El area del " + figura + " es: " + R);
		
			default:


		};
	}
}