public class ArbolBinario {
    private Nodo raiz;

    public void agregar(int valor) {
        raiz = agregarRecursivo(raiz, valor);
    }

    private Nodo agregarRecursivo(Nodo actual, int valor) {
        if (actual == null) {
            return new Nodo(valor);
        }
        if (valor < actual.valor) {
            actual.izquierdo = agregarRecursivo(actual.izquierdo, valor);
        } else if (valor > actual.valor) {
            actual.derecho = agregarRecursivo(actual.derecho, valor);
        }
        return actual;
    }

    public void preOrden() {
        System.out.print("PreOrden: ");
        preOrdenRec(raiz);
        System.out.println();
    }

    private void preOrdenRec(Nodo nodo) {
        if (nodo != null) {
            System.out.print(nodo.valor + " ");
            preOrdenRec(nodo.izquierdo);
            preOrdenRec(nodo.derecho);
        }
    }

    public void inOrden() {
        System.out.print("InOrden: ");
        inOrdenRec(raiz);
        System.out.println();
    }

    private void inOrdenRec(Nodo nodo) {
        if (nodo != null) {
            inOrdenRec(nodo.izquierdo);
            System.out.print(nodo.valor + " ");
            inOrdenRec(nodo.derecho);
        }
    }

    public void postOrden() {
        System.out.print("PostOrden: ");
        postOrdenRec(raiz);
        System.out.println();
    }

    private void postOrdenRec(Nodo nodo) {
        if (nodo != null) {
            postOrdenRec(nodo.izquierdo);
            postOrdenRec(nodo.derecho);
            System.out.print(nodo.valor + " ");
        }
    }

    public boolean buscar(int valor) {
        return buscarRec(raiz, valor);
    }

    private boolean buscarRec(Nodo nodo, int valor) {
        if (nodo == null) return false;
        if (valor == nodo.valor) return true;
        return valor < nodo.valor ? buscarRec(nodo.izquierdo, valor) : buscarRec(nodo.derecho, valor);
    }

    public int altura() {
        return alturaRec(raiz);
    }

    private int alturaRec(Nodo nodo) {
        if (nodo == null) return 0;
        int izq = alturaRec(nodo.izquierdo);
        int der = alturaRec(nodo.derecho);
        return Math.max(izq, der) + 1;
    }

    public int contarHojas() {
        return contarHojasRec(raiz);
    }

    private int contarHojasRec(Nodo nodo) {
        if (nodo == null) return 0;
        if (nodo.izquierdo == null && nodo.derecho == null) return 1;
        return contarHojasRec(nodo.izquierdo) + contarHojasRec(nodo.derecho);
    }

    public void eliminar(int valor) {
        raiz = eliminarRec(raiz, valor);
    }

    private Nodo eliminarRec(Nodo nodo, int valor) {
        if (nodo == null) return null;
        if (valor < nodo.valor) {
            nodo.izquierdo = eliminarRec(nodo.izquierdo, valor);
        } else if (valor > nodo.valor) {
            nodo.derecho = eliminarRec(nodo.derecho, valor);
        } else {
            if (nodo.izquierdo == null) return nodo.derecho;
            if (nodo.derecho == null) return nodo.izquierdo;
            int menorValor = encontrarMin(nodo.derecho);
            nodo.valor = menorValor;
            nodo.derecho = eliminarRec(nodo.derecho, menorValor);
        }
        return nodo;
    }

    private int encontrarMin(Nodo nodo) {
        while (nodo.izquierdo != null) {
            nodo = nodo.izquierdo;
        }
        return nodo.valor;
    }

    public void vaciar() {
        raiz = null;
    }
}
