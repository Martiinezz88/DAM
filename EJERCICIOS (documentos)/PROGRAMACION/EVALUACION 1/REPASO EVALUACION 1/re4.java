import java.util.Scanner;

public class re4{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);

		double horas;
		double IRPF;
		double salariobruto;
		double salario;
		double total; 

		do{

			System.out.print("Responde los siguientes datos y te dare como resultado tu sueldo semanal (Para cerrar el programa pulse 0). \n-> Cuantas horas has realizado en está semana? \nR: ");

			horas = teclado.nextDouble();
		
			if (horas != 0){

				System.out.print("-> Cuanto pagas de IRPF?\nR: "); 
		
				IRPF = teclado.nextDouble();
				
				salariobruto = (horas * 12);

				salario = salariobruto * ( IRPF/100 ); 
			
				total = salariobruto - salario;
				
				System.out.println("..............................................................");

				System.out.println("Su sueldo en bruto de esta semana va a ser: " + salariobruto );

				System.out.println("La cantidad que te quitan por el IRPF va a ser: " + salario );
		
				System.out.println("Su sueldo obtenido de esta semana va a ser: " + total );

				System.out.println("..............................................................");

			}
	
		}while (horas != 0);
		
	}
}