import java.util.Scanner; 

public class f4e7 {

	public static void main (String[] args) {

		Scanner teclado = new Scanner(System.in);
		
		int cantidad;  
		int contadormayuscula = 0;
		int contadorminuscula = 0;
		int contadornumero = 0;
		String frase; 
		char letra;

		System.out.print("Escribe una frase y te diré: \n-> Mayúsculas\n-> Minúsculas\n-> Números\nEscribelo aquí: ");
		frase = teclado.nextLine();
		
		cantidad = frase.length();

		for (int i = 0; i < cantidad; i++){

			letra = frase.charAt(i);

			if (Character.isLetter(letra)){

				if ( Character.isUpperCase(letra) ) contadormayuscula++;

				else if (Character.isLowerCase(letra)) contadorminuscula++;
			}

			else if (Character.isDigit(letra)) contadornumero++;
		}
		
		System.out.print("El contador quedará así:\n-> Mayúscula: " + contadormayuscula + "\n-> Minúscula: " + contadorminuscula + "\n-> Numero: " + contadornumero );
	}
}