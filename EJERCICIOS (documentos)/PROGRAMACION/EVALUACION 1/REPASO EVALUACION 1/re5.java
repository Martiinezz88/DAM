import java.util.Scanner; 

public class re5{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);

		double primerexamen;

		double notasegundaeva;

		double segundoexamen;

		System.out.print("Escribe la nota de tu primer examen: ");
		primerexamen = teclado.nextDouble();

		System.out.print("Escribe que nota quieres sacar en la segunda evaluación: ");
		notasegundaeva = teclado.nextDouble();

		segundoexamen = ( notasegundaeva - ( primerexamen * 0.3 )) / 0.7;

		System.out.print("La nota que deberías sacar en el segundo examen es: " + segundoexamen);
	}  
}