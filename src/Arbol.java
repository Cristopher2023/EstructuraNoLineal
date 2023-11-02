public class Arbol {

    NodoArbol inicial;

    public Arbol() {
        this.inicial = null;
    }

    public void insertar(int valor) {
        if (this.inicial == null) {
            this.inicial = new NodoArbol(valor);
        } else {
            this.inicial.insertar(valor);
        }
    }

    public void ejecutarEnorden() {
        this.Enorden(this.inicial);
    }

    public void Enorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        } else {
            Enorden(nodo.getNodoIzq());
            System.out.print(nodo.getValor() + ", ");
            Enorden(nodo.getNodoDerecho());
        }
    }

    public void ejecutarPreorden() {
        this.Preorden(this.inicial);
    }

    public void Preorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        } else {
            System.out.print(nodo.getValor() + ", ");
            Enorden(nodo.getNodoIzq());
            Enorden(nodo.getNodoDerecho());
        }
    }

    public void ejecutarPostorden() {
        this.Postorden(this.inicial);
    }

    public void Postorden(NodoArbol nodo) {
        if (nodo == null) {
            return;
        } else {
            Enorden(nodo.getNodoIzq());
            Enorden(nodo.getNodoDerecho());
            System.out.print(nodo.getValor() + ", ");
        }
    }

    public void eliminar(int valor) {
        this.inicial = eliminarNodo(this.inicial, valor);
    }

    private NodoArbol eliminarNodo(NodoArbol nodo, int valor) {
        if (nodo == null) {
            return nodo;
        }

        if (valor < nodo.getValor()) {
            nodo.setNodoIzq(eliminarNodo(nodo.getNodoIzq(), valor));
        } else if (valor > nodo.getValor()) {
            nodo.setNodoDerecho(eliminarNodo(nodo.getNodoDerecho(), valor));
        } else {
            // Nodo con un solo hijo o sin hijos
            if (nodo.getNodoIzq() == null) {
                return nodo.getNodoDerecho();
            } else if (nodo.getNodoDerecho() == null) {
                return nodo.getNodoIzq();
            }

            // Nodo con dos hijos: obtener el sucesor inorden (el más pequeño en el subárbol derecho)
            nodo.setValor(minValorNodo(nodo.getNodoDerecho()));

            // Eliminar el sucesor inorden
            nodo.setNodoDerecho(eliminarNodo(nodo.getNodoDerecho(), nodo.getValor()));
        }

        return nodo;
    }

    private int minValorNodo(NodoArbol nodo) {
        int minValor = nodo.getValor();
        while (nodo.getNodoIzq() != null) {
            minValor = nodo.getNodoIzq().getValor();
            nodo = nodo.getNodoIzq();
        }
        return minValor;
    }
    public void mostrarNodoRaiz() {
        if (this.inicial != null) {
            System.out.println("Nodo raíz: " + this.inicial.getValor());
        } else {
            System.out.println("El árbol está vacío.");
        }
    }




}


