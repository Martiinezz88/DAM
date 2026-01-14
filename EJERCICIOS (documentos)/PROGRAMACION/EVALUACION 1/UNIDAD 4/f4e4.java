import java.util.Scanner;

public class f4e4{

	public static void main(String[] args){
		Scanner teclado = new Scanner(System.in); 

		String frase;
		int caracter;
		int seleccion;
		boolean seguir = true;

		while(seguir){
			
			System.out.print("Escribe una frase de máximo 80 carácteres: ");
			frase = teclado.nextLine();
		
			caracter = frase.length();
	
			if (caracter < 80){

				System.out.println("-----------------------------------------------------");

				System.out.println("1. Mayúsculas\n2. Minúsculas");

				System.out.println("-----------------------------------------------------");

				System.out.println("Elige a que quieres que convierta la frase: ");
				seleccion = teclado.nextInt(); 

				switch(seleccion){
					
					case 1:	
						System.out.println("La frase en Mayúsculas es:\n-> " + frase.toUpperCase());
						break;

					case 2:
						System.out.println("La frase en Minúsculas es:\n-> " + frase.toLowerCase());
						break;
				}

				seguir = false; 
			}

			else if (caracter > 80){ 
				
				System.out.println("El número excede el limite de carácteres, vuelve a intentarlo");
				
			}
		}
	}
}