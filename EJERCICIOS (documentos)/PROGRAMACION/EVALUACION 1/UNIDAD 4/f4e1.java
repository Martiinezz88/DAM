import java.util.Scanner;

public class f4e1{

	public static void main(String[] args){

		Scanner teclado = new Scanner(System.in);

		String LT;

		do{
			System.out.print("Escribe una frase de máximo 80 carácteres: ");
			LT = teclado.nextLine();

			if (LT.length() <= 80 ){
				
				System.out.println("-------------------------------------------------------");

				for (int i = 0; LT.length() > i; i++){

					System.out.println(LT.substring(0,i+1));

				}
					System.out.println("-------------------------------------------------------");

			}

			if (LT.length() > 80 )System.out.println("Vuelve a intentarlo, has superado el número de carácteres");

		}while( LT.length() > 80 );
	}
}
