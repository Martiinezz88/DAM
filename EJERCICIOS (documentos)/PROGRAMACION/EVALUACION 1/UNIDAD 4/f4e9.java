import java.util.Scanner;

public class f4e9 {

	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);

		String frase;
		String frasenueva = ""; 
		char letra;
		int contador;
        int saltos; 

		System.out.print("Escribe una frase y te la filtraré en cifrado cesar: ");
		frase = teclado.nextLine(); 
		frase = frase.toUpperCase();

        System.out.println("Escribe la cantidad de desplazamiento que quieres que haga la letra a la siguiente:");
        saltos = teclado.nextInt();

		contador = frase.length();
		
		for(int i = 0; i < contador; i++){
		
			letra = frase.charAt(i);
	
			if (letra >= 'A' && letra <= 'Z'){

				frasenueva += (char)(( letra - 'A' + saltos ) % 26 + 'A');
			}
		}
		
		System.out.println("La frase traducida es: " + frasenueva);
	}
}