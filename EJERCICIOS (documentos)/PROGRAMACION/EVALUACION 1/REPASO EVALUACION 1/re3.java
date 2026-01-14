import java.util.Scanner;

public class re3{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);

		double base;
		double altura;
		double resultado;

		System.out.print("Escribe los datos que te pido a continuación y te calculare el área de un rectángulo.\n-> Base: ");
		base = teclado.nextDouble();

		System.out.print("-> Altura: "); 
		altura = teclado.nextDouble();

		resultado = base * altura;

		System.out.println("El resultado de del Área del rectángulo es : " + resultado);
	}
}