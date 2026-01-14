import java.util.Scanner; 

public class re6{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);
		
		int hora; 
		
		System.out.print("Escribe que hora es: ");
		hora = teclado.nextInt();

		if (hora >= 6 && hora <= 12) System.out.println("Hola buenos dias");

		else if (hora >= 13 && hora <= 20)System.out.println("Hola buenas tardes");

		else if (hora >= 21 && hora <= 23)System.out.println("Hola buenas noches");

		else if (hora >= 00 && hora <= 5)System.out.println("Hola buenas noches");
	}  
}