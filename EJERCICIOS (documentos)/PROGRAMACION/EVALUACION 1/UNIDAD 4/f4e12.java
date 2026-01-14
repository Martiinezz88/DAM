import java.util.Scanner;

public class f4e12{

	public static void main (String[] args){

		Scanner teclado = new Scanner(System.in);

		String frase; 
		int limite; 
		
		do {

			System.out.print("Escribe una palabra de no más de 20 caracteres: ");

			frase = teclado.nextLine();
			limite = frase.length();

			if ( limite > 20 )System.out.println("Has superado los caracteres permitidos, vuelve a intentarlo");

		}while(limite > 20);

		for (int x = 0; x < limite; x++){
		
			String palabranueva = "";

			for (int i = 0; i < limite; i++){
	
							
					palabranueva += frase.charAt((i+x) % limite);
			}

			System.out.println (palabranueva);
		}
	}
}
