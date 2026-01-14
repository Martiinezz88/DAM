/* Debemos hacer un programa en donde lea 8 caracteres, los primeros 4 se refiere a el año de nacimiento entre 1990-1995, también el 5 carácter nos diga el sexo, el sexto caracter nos diga el curso, el septimo si es E -> Extranjero o L-> Local, el octavo nos informe si es repetidor o no, en caso de que el programa lea caracteres erroneos lo rechaze, para cerrarlo habrá que colocar 00000000.

debe imprimir un contador de cuantos hombres y mujeres hay matriculados en primero y segundo y el numero de cuantos codigos han sido leidos.

	@utor: Jose Alejandro Díaz 
	fecha: 20251117
*/

import java.util.Scanner;

public class f4e10{

	public static void main(String[] args){

		Scanner teclado = new Scanner(System.in);

		String año; // Que lea entre 1990 y 1995, utiliza las primeras 4 posiciones
		String curso; // Utiliza la posición de 6 carácter
		int contadorhombre1 = 0; 
		int contadorhombre2 = 0; 
		int contadormujer1 = 0 ;
		int contadormujer2 = 0;
		int contadorusuarios = 0;
		String ID = "";
		String sexo; // Utiliza la 5 posición y este nos dice si es H-> Hombre, M-> Mujer
		String repetidor;
		boolean seguir = true;

		while( seguir ){
	 		
			System.out.println("--------------------------------------------------------------------------------");
			
			System.out.print("Para registrarte correctamente tienes que seguir los siguientes pasos. \n-> Los primeros cuatro digitos tiene que ser un año comprendido entre 1990-1995\n-> El quinto digito se coloca H o M para identificar su sexo\n-> El sexto dígito sirve para que nos digas si perteneces al 1 o 2 curso\n-> El septimo nos dirá si eres de origen extranjero (E) o local (L)\n-> Tendrás que colocar si eres repetidor (S) o no (N).\n Registrate aquí: ");
			ID = teclado.nextLine();
			
			if (ID.equals("00000000")) {
				
					seguir = false;

					System.out.println("Has cerrado el programa");

					System.out.println("-----------------------------------------------------------------");

					System.out.println("PRIMER CURSO \n-> Hombres: " + contadorhombre1 + "\n-> Mujeres: " + contadormujer1 +"\nSEGUNDO CURSO \n-> Hombres: " + contadorhombre2 + "\n-> Mujeres: " + contadormujer2 + "\n00ALUMNOS REGISTRADOS \n-> Total: " + contadorusuarios);

					System.out.println("-----------------------------------------------------------------");

				}
				
			else if ( ID.length() == 8 ){

				año = ID.substring(0,4);

				if ( año.equals("1990") || año.equals("1991") || año.equals("1992") ||  año.equals("1993") || año.equals("1994") || año.equals("1995")){
					
					sexo = ID.substring(4,5);

					sexo = sexo.toUpperCase();

					if ( sexo.equals("H") || sexo.equals("M") ){

						curso = ID.substring(5,6);

						if ( curso.equals("1") || curso.equals("2") ){

							String extranjero; 
						
							extranjero = ID.substring(6,7);
								
							extranjero = extranjero.toUpperCase();

							if ( extranjero.equals("E") || extranjero.equals("L") ){
								
								repetidor = ID.substring(7,8);
								
								repetidor = repetidor.toUpperCase();
								if ( repetidor.equals("S") || repetidor.equals("N") ) {
								
									if (curso.equals("1") && sexo.equals("H" )) contadorhombre1++;
									else if (curso.equals("1") && sexo.equals("M")) contadormujer1++;
									else if (curso.equals("2") && sexo.equals("M")) contadormujer2++;
									else if (curso.equals("2") && sexo.equals("H")) contadorhombre2++;
					
									contadorusuarios++;
									
									System.out.println("Se ha registrado correctamente");
								}
								else {

									System.out.println("Hay un error en saber si ha repetido o no, vuelve a intentarlo");

								}	

							}

							else {

							System.out.println("Hay un error en la nacionalidad, vuelve a intentarlo");

							}	
						}
						
						else {

							System.out.println("Hay un error en el curso, vuelve a intentarlo");

						}
					}
	
					}

					else {

					System.out.println("Hay un error en el sexo, vuelve a intentarlo");

					}
				}

				else {

					System.out.println("Hay un error en el año, vuelve a intentarlo");
				}

			if  (ID.length() > 8) System.out.println("Has superado el máximo de caracteres, vuelve a intentarlo.");
			
		}
	}
}
