import java.util.Scanner;

public class f4e6 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);

		int cantidad;
		int contadornumero = 0;
		int contadorvocal = 0;
		int contadorconsonante = 0;
		String frase;
		char letra;
		String fraseminuscula;
		boolean seguir = true;
		
		while(seguir) {
		
			System.out.print("Escribe una frase que no supere los 80 carácteres: ");
			frase = teclado.nextLine();
			cantidad = frase.length();

			if ( cantidad < 80 ) {
			
				for (int i = 0; i < cantidad; i++){

					fraseminuscula = frase.toLowerCase();
					letra = fraseminuscula.charAt(i);
				
					if (Character.isLetter(letra)){

						if (letra == 'a' || letra == 'e' || letra == 'i' || letra == 'o' || letra == 'u') contadorvocal++;
						
						else if (letra == 'á' || letra == 'é' || letra == 'í' || letra == 'ó' || letra == 'ú') contadorvocal++; 

						else contadorconsonante++;

					}

					if (Character.isDigit(letra)) contadornumero++;
				}

				System.out.println("Hay en total: \n-> Consonantes: " + contadorconsonante + "\n-> Vocales: " + contadorvocal + "\n-> Números: " + contadornumero);

				seguir = false; 
			}

			if ( cantidad > 80 ) {

				System.out.println("Vuelve a intentarlo");
			}
		}
	}
}