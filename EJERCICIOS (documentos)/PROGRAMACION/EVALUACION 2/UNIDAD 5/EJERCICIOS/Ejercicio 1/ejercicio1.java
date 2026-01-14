import java.util.Scanner;
public class ejercicio1 {
    public static void main(String[] args) {

        // Vestido
        Vestido vestido = new Vestido();
        System.out.println("Vestido:");
        vestido.utilidadParaObservador("Moda");
        vestido.utilidadParaObservador("Teatro");
        System.out.println();

        // Aspirina
        Aspirina aspirina = new Aspirina();
        System.out.println("Aspirina:");
        aspirina.utilidadParaObservador("Medico");
        aspirina.utilidadParaObservador("Paciente");
        System.out.println();

        // Zanahoria
        Zanahoria zanahoria = new Zanahoria();
        System.out.println("Zanahoria:");
        zanahoria.utilidadParaObservador("Nutricionista");
        zanahoria.utilidadParaObservador("Chef");
        System.out.println();

        // Llave
        Llave llave = new Llave();
        System.out.println("Llave:");
        llave.utilidadParaObservador("Cerrajero");
        llave.utilidadParaObservador("Propietario");
        System.out.println();

        // Saxofón
        Saxofon saxofon = new Saxofon();
        System.out.println("Saxofón:");
        saxofon.utilidadParaObservador("Musico");
        saxofon.utilidadParaObservador("Estudiante");
        System.out.println();

        // Madera
        Madera madera = new Madera();
        System.out.println("Madera:");
        madera.utilidadParaObservador("Carpintero");
        madera.utilidadParaObservador("Artista");
        System.out.println();
    }
}
