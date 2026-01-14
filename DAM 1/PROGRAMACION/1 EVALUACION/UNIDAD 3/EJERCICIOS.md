## FICHA 3 

### ==Ejercicio 1==

*Escribir un programa que calcule e imprima la suma de los números enteros comprendidos
entre A y B que deben leerse por teclado y filtrarse para que A<=B. Los valores de A y B no
deben incluirse en la suma *


```JAVA
import java.util.Scanner;
public class problema1 {
	public static void main(String[] args){
	
		Scanner teclado = new Scanner (System.in);
		int A,B,suma = 0;
	
		do {
		
            System.out.print("Introduce el valor de A: ");
			A = teclado.nextInt();

			System.out.print("Introduce el valor de B: ");
			B = teclado.nextInt();

			if ( A >= B) System.out.println("A debe ser menor que B, intentelo de nuevo");

       		} while (A >= B);

			for ( int i = A; i < B; i++ ) suma += i;
			System.out.print("La suma es: " + suma);
	}
}
```

******


### ==Ejercicio 2==

*Leer un número N que debe filtrarse entre 1 y 10 y a continuación calcular y escribir la tabla de multiplicar de ese número con el siguiente formato:*


```JAVA 
import java.util.Scanner;

public class problema2 {
	
	public static void main (String[] args) {

		int numero,resultado = 0;
		Scanner teclado = new Scanner (System.in);

		do {
			System.out.print("Escribe un numero comprendido entre el 1 y el 10: ");
			numero = teclado.nextInt();

			if (numero < 1 || numero > 10) System.out.print("El número es erroneo, vuelve a intentarlo.");
			
		} while (numero < 1 || numero > 10);
		
		System.out.println("TABLA DE MULTIPLICAR DE " + numero);

		for (int i = 1; i <= 10; i++) {

			resultado = numero * i;
			System.out.println( numero + " * " + i + " = " + resultado);

		} 				
	}
}
```

*******


### ==Ejercicio 3==

*Escribir un programa que, una vez que lea un número N por teclado, calcule y escriba los
divisores propios de N por la pantalla (sin incluirse a sí mismo).*

```JAVA
import java.util.Scanner;

public class problema3{

	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);  
		int N = 0;
		int D;
		boolean divisores = false;

		do {
			System.out.print("Escribe un número y te daré como salida sus divisores \n(Para cerrar el programa pulsa 0): ");
			N = teclado.nextInt();

			for(int i = 1; i < N; i++){

				D = N % i;

				if (D == 0){

					divisores = true;

					if (divisores == true) System.out.println( i + " es divisor de " + N);
					
				}
			}


		}while(N > 0);

		if (N <= 0){

			System.out.print("El programa se ha cerrado");

		}
	}
}
```

***********


### ==Ejercicio 4==

*Hacer un programa que lea un número N y nos escriba en la pantalla mediante un mensaje si es o no primo (NOTA: Número primo es aquél que es divisible sólo por sí mismo y por la unidad)

```JAVA
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
```

********


### ==Ejercicio 5==

*Hacer un programa que lea una serie de números por teclado de manera que cuando el número leído sea el cero ya no se introduzcan más; el programa debe calcular y escribir la suma de los números de la serie y cuántos se han introducido en total.*

```JAVA 
import java.util.Scanner;

public class problema5 { 
    public static void main(String[] args) {

        int N = 0;
	int contador = 0;
	int suma = 0;

	Scanner teclado = new Scanner(System.in);

	do {
	
		System.out.print("Escribe números para acomularlos (0 para cerrar programa): ");
		N = teclado.nextInt();
		
		if ( N != 0) {
		
			suma += N; 
			
			contador++;
		}
		

	} while ( N != 0 );

	System.out.println("El número total es: " + suma );

	System.out.print("La cantidad de números introducidos es: " + contador );
    }
}
```

*********


### ==Ejercicio 6==

*Hacer un programa que vaya leyendo números por el teclado hasta que lea el cero, que indicará el fin de la entrada de datos. El programa debe calcular y escribir la suma de los números Introducidos en lugar par y de los introducidos en lugar impar, es decir los introducidos primero, tercero, quinto, etc. y la suma de los introducidos segundo, cuarto, sexto, etc.*

```JAVA
import java.util.Scanner;
	
public class problema6{
	
	public static void main (String[] args){

		int N = 0;
		int par = 0;
		int impar = 0;
		int contador = 1;
		

		Scanner teclado = new Scanner(System.in);

		do {
			System.out.println("--------------------------------------------------------------------------------------");

			System.out.println("Escribe números, se sumará si su posición es par o impar en distintos grupos.");
			System.out.print("Para cerrar el programa pulse 0: ");
			N = teclado.nextInt();
			
			System.out.println("--------------------------------------------------------------------------------------");

			if ( N != 0 ){

				if (contador%2 == 0) par += N;
				if (contador%2 == 1) impar += N;

				contador++;
			}


		}while( N != 0 );
			System.out.println("--------------------------------------------------------------------------------------");

			System.out.println("La suma de los numeros pares es: " + par);
		
			System.out.println("La suma de los numeros impares es: " + impar);
																			
			System.out.println("--------------------------------------------------------------------------------------");



	}
}
```

***********


### ==Ejercicio 7==

*Escribir un programa que lea una secuencia de datos numéricos de longitud indefinida, de
manera que cuando el número sea el cero cesará la entrada de dicha secuencia. El programa debe imprimirnos la media de todos ellos, el mayor y el menor.*

```JAVA
import java.util.Scanner;


public class problema7{

	public static void main(String[] args){

		int N = 0 ;
		int suma = 0;
		double media = 0;
		int numeromayor = 0;
		int numeromenor = 0;
		Scanner teclado = new Scanner(System.in);

		do {
		System.out.println("Escribe una serie de números y te imprimiré la media, su número mayor y menor. ");
		System.out.print("Para cerrar el programa escribe 0: ");
		N = teclado.nextInt();
			if( N != 0 ){
			
				suma += N;
				media = (double)suma/(double)2;
				if ( N != 0){
					if ( N < numeromenor) numeromenor = N;
				}
				if ( N > numeromayor) numeromayor = N;
					
			}

		}while ( N != 0 );
		System.out.println("---------------------------------------------------------------------------------");

		System.out.println("La Media de los números es: " + media);
		System.out.println("El numero mayor es: " + numeromayor);
		System.out.println("El numero menor es: " + numeromenor);

		System.out.println("---------------------------------------------------------------------------------");

	}
}
```

**********


### ==Ejercicio 8==

*Se define el factorial de un número N como N*(N-1)*(N-2)*.......*3*2*1. Hacer un programa que lea un número N filtrando que debe ser mayor que cero y calcule su factorial.*

```JAVA 
import java.util.Scanner;

public class problema8{

	public static void main (String[] args) {

		Scanner teclado = new Scanner(System.in);

		int N = 0;
		int resultado = 0;
		int factorial = 1;
		boolean seguir = true;
	
			System.out.print("Escribe un numero y te dare como salida su factorial (0 para cerrar el programa): ");
			N = teclado.nextInt();

			if ( N > 0 ){
				
				for (int i = 1; N >= i; i++){

					factorial *= i; 		
				}

			System.out.println("El factorial de " + N + " es: " + factorial);

			}
	}
}
```

********


### ==Ejercicio 9==

*Un número se dice que es perfecto cuando la suma de sus divisores propios –todos los divisores a excepción del propio número-, es igual a dicho número. Hacer un programa que lea un número y nos diga si es perfecto o no.*

```JAVA
import java.util.Scanner;
public class problema9{

	public static void main(String[] args){
		
		Scanner teclado = new Scanner(System.in);
		int N = 0;
		double perf = 1;

		System.out.print("Escribe un número que sea mayor a 0 y te diré si es perfecto o no: ");
		N = teclado.nextInt();

		if ( N > 0 ){

			for(int i = 1; perf < N; i++){

				perf = (1 << (i - 1)) * ((1 << i) - 1);
				
				
				
			}
			
				if ( perf == N ) System.out.println("El número "+ N +" es perfecto");

				else if ( perf != N ) System.out.println("El número "+ N +" no es perfecto");
		}

		else System.out.println("Fue introducido un número menor o igual que 0, por lo tanto se cerrara el programa"); 

	}
}
```

*************


### ==Ejercicio 10==

*Dado un numero N leído por teclado encontrar el número P primo mas cercano a él por exceso (o que es mayor).*

```JAVA
import java.util.Scanner;

public class problema10 {

    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        int N = 0;
        int i = 0;

        System.out.print("Escribe un número como entrada y te daré como resultado su número primo en exceso: ");
        N = teclado.nextInt();

        i = N + 1;

        while (true) {
            int divisor = 2;
            boolean esPrimo = true;

            while (divisor <= i / 2) {
                if (i % divisor == 0) {
                    esPrimo = false;
                    break;
                }
                divisor++;
            }

            if (esPrimo) {
                System.out.println("El número primo más cercano por exceso a " + N + " es: " + i);
                break;
            }

            i++;
        }
    }
}
```

**********


### ==Ejercicio 11==

*Dado un número N imprimir la lista de todos los números primos hasta dicho número N.*

```JAVA
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
```

****************************


### ==Ejercicio 12==

*Realizar un programa que elija mediante un menú un tipo de figura:*
* Triángulo
* Cuadrado 
* Rectángulo 
*Una vez elegida la opción nos pida en cada caso los datos necesarios para calcular su área y nos  la muestre.*

```JAVA
import java.util.Scanner;

public class problema12{

	public static void main(String[] args){

		Scanner teclado = new Scanner(System.in);

		int N, B, A, L, R;
		String figura;

		System.out.println("----------------------------------------------------------------------");

		System.out.println("1. Triángulo. \n2. Cuadrado. \n3. Rectángulo. \n0. Para cerrar el programa.");

		System.out.print("Escriba un número y te calcularé el área de cada uno: ");
		N = teclado.nextInt();

		System.out.println("----------------------------------------------------------------------");
		
		switch(N){

			case 1: 
			
				figura = "Triangulo";
				System.out.println("Escribe los siguientes datos para realizar el cálculo del area de el " + figura);

				System.out.print("Base: ");
				B = teclado.nextInt();

				System.out.print("Altura: ");
				A = teclado.nextInt();
				
				R = (B * A) / 2;

				System.out.print("El area del " + figura + " es: " + R);

			case 2: 
			
				figura = "Cuadrado";
				System.out.println("Escribe los siguientes datos para realizar el cálculo del area de el " + figura);

				System.out.print("Lado: ");
				L = teclado.nextInt();
				
				R = (L * L);

				System.out.print("El area del " + figura + " es: " + R);

			case 3: 
			
				figura = "Rectángulo";
				System.out.println("Escribe los siguientes datos para realizar el cálculo del area de el " + figura);

				System.out.print("Base: ");
				B = teclado.nextInt();

				System.out.print("Altura: ");
				A = teclado.nextInt();
				
				R = (B * A);

				System.out.print("El area del " + figura + " es: " + R);
		
			default:


		};
	}
}
```


