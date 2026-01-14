import java.util.Scanner;

public class f4e8 {

	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);

		String frase;
		String frasenueva = ""; 
		char letra;
		int contador;

		System.out.print("Escribe una frase y te la filtraré en cifrado cesar: ");
		frase = teclado.nextLine(); 
		frase = frase.toUpperCase();

		contador = frase.length();
		
		for(int i = 0; i < contador; i++){
		
			letra = frase.charAt(i);
	
			if (letra >= 'A' && letra <= 'Z'){

				frasenueva += (char)(( letra - 'A' + 3 ) % 26 + 'A');
			}
		}
		
		System.out.println("La frase traducida es: " + frasenueva);
	}
}