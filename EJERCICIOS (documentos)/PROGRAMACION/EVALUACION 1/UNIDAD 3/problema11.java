import java.util.Scanner; 
public class problema11{

	public static void main(String[] args){

		Scanner teclado = new Scanner(System.in);
		
		int N = 0;
		int P = 0;
		boolean primo = true; 
		boolean seguir = true; 

		System.out.print("Escribe un número y te daré como salida todos los números primos hasta dicho número: ");
		N = teclado.nextInt();
		
		P = 2;
		while(P < N){

			primo = true;

			for (int i = 2; i < P; i++){
				
				if ( P % i == 0 ){
				
					primo = false;
					break;
				}
			}
			
			if (primo) {

				System.out.println("los números primos antes de " + N + " son: " + P);
				
			}

			P++;
		}
	}	
}