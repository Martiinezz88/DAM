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
