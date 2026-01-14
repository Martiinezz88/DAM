/* Escribir un problema en el que tenga que crear varios objetos los cuales son:
- Vestidos 
- Apirina 
- Zanahoria 
- Llave 
- Saxofón 
- Trozo de madera 

con esos objetos lo que se tiene que hacer es crear clases en las que se mencione una breve descripcion para dos observadores y la utlidad que este tiene por ejemplo un "Medico" para un medica la aspirina es resultado de trabajo e investigación, "Musico" para un musico el saxofón es su herramienta de trabajo. Y asi sucesivamente.

@utor: Yo
Fecha: 20260112 

*/

class Vestido {
    private String descripcion = "Prenda de vestir que cubre el cuerpo.";

    public void utilidadParaObservador(String observador) {
        System.out.println("Objeto: Vestido");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Observador: " + observador);

        switch (observador) {
            case "Moda":
                System.out.println("El vestido es una expresión de moda.");
                break;
            case "Teatro":
                System.out.println("El vestido ayuda a caracterizar personajes.");
                break;
            default:
                System.out.println("Observador no reconocido.");
        }
        System.out.println();
    }
}

class Aspirina {
    private String descripcion = "Medicamento utilizado para aliviar dolor y fiebre.";

    public void utilidadParaObservador(String observador) {
        System.out.println("Objeto: Aspirina");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Observador: " + observador);

        switch (observador) {
            case "Medico":
                System.out.println("La aspirina es un analgésico y antiinflamatorio.");
                break;
            case "Paciente":
                System.out.println("La aspirina es una solución rápida para el dolor.");
                break;
            default:
                System.out.println("Observador no reconocido.");
        }
        System.out.println();
    }
}

class Zanahoria {
    private String descripcion = "Hortaliza rica en nutrientes, especialmente vitamina A.";

    public void utilidadParaObservador(String observador) {
        System.out.println("Objeto: Zanahoria");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Observador: " + observador);

        switch (observador) {
            case "Nutricionista":
                System.out.println("La zanahoria es un alimento nutritivo y saludable.");
                break;
            case "Chef":
                System.out.println("La zanahoria es un ingrediente versátil para recetas.");
                break;
            default:
                System.out.println("Observador no reconocido.");
        }
        System.out.println();
    }
}

class Llave {
    private String descripcion = "Objeto metálico que permite abrir cerraduras.";

    public void utilidadParaObservador(String observador) {
        System.out.println("Objeto: Llave");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Observador: " + observador);

        switch (observador) {
            case "Cerrajero":
                System.out.println("La llave es una herramienta de acceso y seguridad.");
                break;
            case "Propietario":
                System.out.println("La llave protege el hogar y permite entrar.");
                break;
            default:
                System.out.println("Observador no reconocido.");
        }
        System.out.println();
    }
}

class Saxofon {
    private String descripcion = "Instrumento musical de viento-metal.";

    public void utilidadParaObservador(String observador) {
        System.out.println("Objeto: Saxofón");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Observador: " + observador);

        switch (observador) {
            case "Musico":
                System.out.println("El saxofón es un medio de expresión artística.");
                break;
            case "Estudiante":
                System.out.println("El saxofón es un instrumento para aprender técnica musical.");
                break;
            default:
                System.out.println("Observador no reconocido.");
        }
        System.out.println();
    }
}

class Madera {
    private String descripcion = "Material natural proveniente de árboles.";

    public void utilidadParaObservador(String observador) {
        System.out.println("Objeto: Madera");
        System.out.println("Descripción: " + descripcion);
        System.out.println("Observador: " + observador);

        switch (observador) {
            case "Carpintero":
                System.out.println("La madera es materia prima para fabricar objetos.");
                break;
            case "Artista":
                System.out.println("La madera es un soporte para tallar o esculpir.");
                break;
            default:
                System.out.println("Observador no reconocido.");
        }
        System.out.println();
    }
}
