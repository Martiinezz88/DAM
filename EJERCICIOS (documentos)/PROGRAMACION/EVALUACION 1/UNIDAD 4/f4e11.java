import java.util.Scanner;

public class f4e11 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String frase;
		boolean seguir = false;
		int limite;
		char letra;
		int contadorletraigual = 0;
		int contadorletra = 0;	
		boolean letraigual = false;

		do {
			
			System.out.print("Escribe una frase que no supere los 60 caracteres: ");
			frase = teclado.nextLine();
		
			limite = frase.length();	
			frase = frase.toUpperCase();

			if (limite > 60) System.out.print("Has superado el limite de carácteres, vuelve a intentarlo.");
	

		}while (limite > 60);


		for (char abecedario = 'A'; abecedario <= 'Z' ; abecedario++ ){

			for(int x = 0; x < limite; x++){

 				letra = frase.charAt(x);

				if (letra >= 'A' && letra <= 'Z'){

					if (letra == abecedario) {

						letraigual = true;
 
						if (letraigual) contadorletraigual++;
					}
				}
	
				letraigual = false;
			}

			if (contadorletraigual > 0){

				System.out.println("la letra " + abecedario + " se repite en total: " + contadorletraigual);

				contadorletra++;
				
			}
			

			contadorletraigual = 0;
		}
		
		System.out.println("Hay en total " + contadorletra + " letras diferentes.");

	}
}
