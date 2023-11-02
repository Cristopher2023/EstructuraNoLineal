
public class Main {
    public static void main(String[] args) {
        Arbol arbol = new Arbol();

        arbol.insertar(6);
        arbol.insertar(4);
        arbol.insertar(3);
        arbol.insertar(5);
        arbol.insertar(8);
        arbol.insertar(7);
        arbol.insertar(9);
        arbol.insertar(2);
        arbol.insertar(10);
        System.out.println("EN ORDEN:");
        arbol.ejecutarEnorden();
        System.out.println("");
        System.out.println("EN PRE-ORDEN:");
        arbol.ejecutarPreorden();
        System.out.println("");
        System.out.println("EN POST-ORDEN:");
        arbol.ejecutarPostorden();
        System.out.println("");
        System.out.println("ELIMINANDO 9");
        arbol.eliminar(9);
        arbol.ejecutarEnorden();
        System.out.println("");
        System.out.println("NODO RAIZ");
        arbol.mostrarNodoRaiz();




    }
}
