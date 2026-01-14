import java.util.Scanner;
public class problema4 {

	public static void main (String[] args){
		
		int N = 0,producto = 0;
		Scanner teclado = new Scanner(System.in);
		boolean seguir = true;
		
		while (seguir) {
		
		System.out.print("Escribe un número y te diré si es primo o no, para cerrar el programa pulsa 0: ");
		N = teclado.nextInt(); 
		
			for ( int i = 2; (i <= N) && (seguir == true) ; i++ ) {

           			 producto = N%i;
            
           			 if ( (producto == 0) && (i != N) ) seguir = false;

        		}
	
        		if (seguir == true) System.out.println("El número " + N + " SI es primo.");
        		if (seguir == false) System.out.println("El número " + N + " NO es primo.");

 


		}
	}	 
}
