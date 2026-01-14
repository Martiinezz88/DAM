import java.util.Scanner;

public class f4e5 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner (System.in);
		
		int numero;
		int operacion;
		String frase;
		boolean seguir = true;
		
		while(seguir) {

			System.out.println("Escribe una frase que no supere los 80 caracteres:");
			frase = teclado.nextLine();
			
			numero = frase.length();

			if (numero < 80){

				System.out.print("Las letras impares son: ");

				for (int i = 0; i < numero; i++){
					
					operacion = i % 2;

					if (operacion == 0) {
					
						System.out.print(frase.charAt(i) + ",");
					}
				}

				System.out.print("\nLas letras pares son: ");

				for (int i = 0; i < numero; i++){

					operacion = i % 2;

					if (operacion != 0) {
					
						System.out.print(frase.charAt(i) + ",");
					}

				}

				seguir = false; 
			} 

			else if (numero > 80){
			
				System.out.println("Escribe la frase de nuevo, has superado los 80 caracteres.");

				seguir = true;
			}
		}
	}
}