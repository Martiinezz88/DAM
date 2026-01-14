## FICHA 4

### ==Ejercicio 1== 

*Leer una frase de máximo 80 caracteres y escribirla progresivamente es decir si la frase es:
“ciervo”, el programa debe imprimir
c
ci
cie
cier
cierv
ciervo*

```JAVA
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
```

************


### ==Ejercicio 2== 

*Dada una frase de no más de 80 caracteres hacer un programa que busque cuántas mayúsculas minúsculas tiene y lo imprima.*

```JAVA
import java.util.Scanner;

public class f4e2{

    public static void main(String[] args){

        Scanner teclado = new Scanner(System.in);

        int mi = 0;
        int ma = 0;
        String LT;

        System.out.print("Escribe una frase y te diré la cantidad de mayúsculas y minúsculas: ");
        LT = teclado.nextLine();

        do{

            if (LT.length() > 80 ){

                System.out.print("Has superado el máximo de caracteres, vuelve a intentarlo: ");
                LT = teclado.nextLine();
            }

            for (int i = 1; i < LT.length(); i++){

                if (Character.isUpperCase(LT.charAt(i))) ma++;
                if (Character.isLowerCase(LT.charAt(i))) mi++;
            }

        }while(LT.length() > 80);

        System.out.print("Hay en total \nMayusculas: "+ ma + "\nMinusculas: " + mi);
    }
}
```

******************


### ==Ejercicio 3== 

*Programa que lea una frase y una palabra y que nos diga la posición de dicha palabra en la frase y si no la encuentra devuelva un cero.*

```JAVA
import java.util.Scanner;
public class f4e3 {

	public static void main (String[] args) {

		Scanner teclado = new Scanner(System.in);
		String frase;
		String palabra;
		int posicion;
		boolean seguir = false;
		
		System.out.print("Escribe una frase: ");
		frase = teclado.nextLine(); 

		System.out.print("Escribe una letra para decirte en que posición está dentro de la frase: ");
		palabra = teclado.nextLine();

		posicion = frase.indexOf(palabra);
		posicion++;

		if (posicion > 0)System.out.println("La posicion de la palabra es: " + posicion);

		if (posicion < 1)System.out.println("La posicion de la palabra es: 0");

	}
}
```

***************


### ==Ejercicio 4== 

*Leer una cadena de hasta 80 caracteres y pasarla en función de una variable de opción a mayúsculas ó a minúsculas e imprimir la cadena resultante.*

```JAVA
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
```

****************


### ==Ejercicio 5== 

*Leer una frase por teclado (máximo 80 car) y construir otras dos cadenas de forma que una
contenga los caracteres en posición par y la otra los caracteres en posición impar.*

```JAVA 
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
```

***************


### ==Ejercicio 6== 

*Leer una frase por teclado (máximo 80) y a continuación escribir cuantas vocales, consonantes y caracteres numéricos posee.*

```JAVA
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
```

*************


### ==Ejercicio 7== 

*Leer una frase por teclado y escribir a continuación cuantas mayúsculas, minúsculas y úmeros contiene.*

```JAVA
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
```

************


### ==Ejercicio 8== 

*Leer una frase filtrándola a que todos sus caracteres sean mayúsculas, una vez filtrada, hacer un cifrado por sustitución (denominado cifrado CESAR) de la frase de modo que cada carácter se transforme en 3 códigos ASCII más; es decir: Frase inicial PROGRAMACION resultado SURJUDPDFLRQ.*

```JAVA
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
```

********

### ==Ejercicio 9==

*Modificar el/los programa/s anterior/es para que, leido un número del 1 al 10. Realice la
sustitución usando dicho número.*

```JAVA
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
```

****************


### ==Ejercicio 10==

*Escribir un programa que lea códigos de personas de 8 caracteres de modo que los cuatro
primeros sean numéricos y contenidos entre 1990-1995 (un año), el quinto carácter sea solo (H ó M) sexo, el sexto un número que representa el curso 1 ó 2 y los caracteres séptimo y octavo pueden tener cualquier valor. Deben rechazarse los códigos que no cumplan estas condiciones.

La finalización de entrada de códigos se produce cuando se introduce el código “00000000”.

Al final, el programa debe sacar un informe indicando cuántos hombres y mujeres hay
matriculados en primero y segundo y cuántos códigos correctos han sido leídos*

```JAVA
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
```

*************

### ==Ejercicio 11==

*Escribir un programa que lea una frase (máximo 60 caracteres) y diga cuántas letras distintas tiene y la frecuencia de las mismas, para homogeneizar el conjunto de letras  debemos trabajar solo con mayúsculas. Indica cuáles son los ficheros de entrada y salida del compilador.*

```JAVA
import java.util.Scanner;

public class f4e11 {

	public static void main(String[] args) {

		Scanner teclado = new Scanner(System.in);
		String frase;
		boolean seguir = false;
		int limite;
		char letra;
		int contadorletraigual = 0;
		int contadorletra = 0;	
		boolean letraigual = false;

		do {
			
			System.out.print("Escribe una frase que no supere los 60 caracteres: ");
			frase = teclado.nextLine();
		
			limite = frase.length();	
			frase = frase.toUpperCase();

			if (limite > 60) System.out.print("Has superado el limite de carácteres, vuelve a intentarlo.");
	

		}while (limite > 60);


		for (char abecedario = 'A'; abecedario <= 'Z' ; abecedario++ ){

			for(int x = 0; x < limite; x++){

 				letra = frase.charAt(x);

				if (letra >= 'A' && letra <= 'Z'){

					if (letra == abecedario) {

						letraigual = true;
 
						if (letraigual) contadorletraigual++;
					}
				}
	
				letraigual = false;
			}

			if (contadorletraigual > 0){

				System.out.println("la letra " + abecedario + " se repite en total: " + contadorletraigual);

				contadorletra++;
				
			}
			

			contadorletraigual = 0;
		}
		
		System.out.println("Hay en total " + contadorletra + " letras diferentes.");

	}
}
```

*************


### ==Ejercicio 12==

*Hacer un programa para que pida una palabra de no más de 20 caracteres y efectúe todas las
rotaciones posibles de dicha palabra de forma que el último carácter pase al primero y los
demás corran un espacio; es decir, si la palabra fuera “HOLA”, el resultado debería ser:

*Programación Ejercicios tema 4 Página 2 de 2

HOLA
AHOL
LAHO
OLAH

*Observad que una palabra de n caracteres tiene n rotaciones.*

```JAVA
import java.util.Scanner;

public class f4e12{

	public static void main (String[] args){

		Scanner teclado = new Scanner(System.in);

		String frase; 
		int limite; 
		
		do {

			System.out.print("Escribe una palabra de no más de 20 caracteres: ");

			frase = teclado.nextLine();
			limite = frase.length();

			if ( limite > 20 )System.out.println("Has superado los caracteres permitidos, vuelve a intentarlo");

		}while(limite > 20);

		for (int x = 0; x < limite; x++){
		
			String palabranueva = "";

			for (int i = 0; i < limite; i++){
	
							
					palabranueva += frase.charAt((i+x) % limite);
			}

			System.out.println (palabranueva);
		}
	}
}
```
