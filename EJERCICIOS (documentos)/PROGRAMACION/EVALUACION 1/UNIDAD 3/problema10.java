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