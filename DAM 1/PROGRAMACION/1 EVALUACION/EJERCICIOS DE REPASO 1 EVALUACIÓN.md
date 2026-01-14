## FICHA DE REPASO 1 EVALUACIÓN

### ==Ejercicio 1==

*Realiza un conversor de euros a pesetas. La cantidad de euros que se quiere convertir debe ser introducida por teclado.*


```JAVA 
import java.util.Scanner;

public class re1{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in); 
		
		double euro;
		double pesetas; 
		
		do {

			System.out.print("Escribe una cantidad de euros y te las pasare a pesetas (cerrar programa escribe 0): ");
			euro = teclado.nextDouble();

			pesetas = euro * 166.386;

			System.out.println("Hay en total " + pesetas + " pesetas");

		}while(euro != 0);
	}
}
```

*************


### ==Ejercicio 2==

*Escribe un programa que sume, reste, multiplique y divida dos números introducidos por
teclado.*

```JAVA
import java.util.Scanner;

public class re2{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);

		int N1;
		int N2;
		int OP;
		int resultado = 0;
		boolean seguir = true; 

		do{
			
			System.out.println("................................................................................................");

			System.out.print("Escribe dos números y te daré a elegir si quieres un tipo de operación distinta \n-> Primer número: ");
			N1 = teclado.nextInt();
 
			System.out.print("-> Segundo número: ");
			N2 = teclado.nextInt();

			System.out.println("-----------------------------------------------------------------------");

			System.out.print("Indique que operación quiere realizar: \n1. Suma\n2. Resta\n3. Multiplicación\n4. División\n0. Cerrar el programa \nEscribe la opción: ");
			OP = teclado.nextInt();

			switch (OP){

			case 1: 
	
				resultado = N1 + N2;

				break;

			case 2: 

				resultado = N1 - N2;

				break;

			case 3: 

				resultado = N1 * N2;

				break;
	
			case 4: 

				resultado = N1 / N2;

				break;

			case 0:

				seguir = false;
				
			}
			
			if (OP != 0) System.out.println("el resultado de la operación entre " + N1 + " y " + N2 + " es: " + resultado);
		
		}while(OP != 0);
	}
}
```

*******************


### ==Ejercicio 3==

*Escribe un programa que calcule el área de un rectángulo.*

```JAVA 
import java.util.Scanner;

public class er3{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);

		double base;
		double altura;
		double resultado;

		System.out.print("Escribe los datos que te pido a continuación y te calculare el área de un rectángulo.\n-> Base: ");
		base = teclado.nextDouble();

		System.out.print("-> Altura: "); 
		altura = teclado.nextDouble();

		resultado = base * altura;

		System.out.println("El resultado de del Área del rectángulo es : " + resultado);
	}
}
```

*******************


### ==Ejercicio 4==

*Escribe un programa que calcule el salario semanal de un empleado en base a las horas trabajadas, a razón de 12 euros la hora.*

```JAVA
import java.util.Scanner;

public class er4{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);

		double horas;
		double IRPF;
		double salariobruto;
		double salario;
		double total; 

		do{

			System.out.print("Responde los siguientes datos y te dare como resultado tu sueldo semanal (Para cerrar el programa pulse 0). \n-> Cuantas horas has realizado en está semana? \nR: ");

			horas = teclado.nextDouble();
		
			if (horas != 0){

				System.out.print("-> Cuanto pagas de IRPF?\nR: "); 
		
				IRPF = teclado.nextDouble();
				
				salariobruto = (horas * 12);

				salario = salariobruto * ( IRPF/100 ); 
			
				total = salariobruto - salario;
				
				System.out.println("..............................................................");

				System.out.println("Su sueldo en bruto de esta semana va a ser: " + salariobruto );

				System.out.println("La cantidad que te quitan por el IRPF va a ser: " + salario );
		
				System.out.println("Su sueldo obtenido de esta semana va a ser: " + total );

				System.out.println("..............................................................");

			}
	
		}while (horas != 0);
		
	}
}
```

***********


### ==Ejercicio 5==

*Escribe un programa que calcule la nota que hace falta sacar en el segundo examen de la asignatura Programación para obtener la media deseada. Hay que tener en cuenta que la nota del primer examen cuenta el 12% y la del segundo examen un 28%. 
Nota: Al normalizar sus valores, la nota del primer examen cuenta el 30% y la del segundo el 70%. 
Ejemplo 1: 
Introduce la nota del primer examen: 7 
¿Qué nota quieres sacar en la segunda evaluación? 8.5 
Para tener un 8.5 en la segunda evaluación necesitas sacar un 9.14 en el segundo examen. 
Ejemplo 2: 
Introduce la nota del primer examen: 8 
¿Qué nota quieres sacar en la segunda evaluación? 7 
Para tener un 7 en la segunda evaluación necesitas sacar un 5.61 en el segundo examen.*

```JAVA
import java.util.Scanner; 

public class er5{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);

		double primerexamen;

		double notasegundaeva;

		double segundoexamen;

		System.out.print("Escribe la nota de tu primer examen: ");
		primerexamen = teclado.nextDouble();

		System.out.print("Escribe que nota quieres sacar en la segunda evaluación: ");
		notasegundaeva = teclado.nextDouble();

		segundoexamen = ( notasegundaeva - ( primerexamen * 0.3 )) / 0.7;

		System.out.print("La nota que deberías sacar en el segundo examen es: " + segundoexamen);
	}  
}
```

**************


### ==Ejercicio 6==

*Realiza un programa que pida una hora por teclado y que muestre luego buenos días, buenas tardes o buenas noches según la hora. Se utilizarán los tramos de 6 a 12, de 13 a 20 y de 21 a 5 respectivamente. Sólo se tienen en cuenta las horas, los minutos no se deben introducir por teclado.*

```JAVA
import java.util.Scanner; 

public class er6{

	public static void main(String[] args){

		Scanner teclado = new Scanner (System.in);
		
		int hora; 
		
		System.out.print("Escribe que hora es: ");
		hora = teclado.nextInt();

		if (hora >= 6 && hora <= 12) System.out.println("Hola buenos dias");

		else if (hora >= 13 && hora <= 20)System.out.println("Hola buenas tardes");

		else if (hora >= 21 && hora <= 23)System.out.println("Hola buenas noches");

		else if (hora >= 00 && hora <= 5)System.out.println("Hola buenas noches");
	}  
}
```

