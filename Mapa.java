public class Mapa<K, V> {
    private Nodo<K, V> inicio;

    public void put(K chave, V valor) {
        if (inicio == null) {
            inicio = new Nodo<>(chave, valor);
        } else {
            Nodo<K, V> nodo = inicio;
            while (nodo.getProximo() != null) {
                nodo = nodo.getProximo();
            }
            nodo.setProximo(new Nodo<>(chave, valor));
            nodo.getProximo().setAnterior(nodo);
        }
    }

    public V get(K chave) {
        Nodo<K, V> nodo = inicio;
        while (nodo != null) {
            if (nodo.getChave().equals(chave)) {
                return nodo.getValor();
            }
            nodo = nodo.getProximo();
        }
        return null;
    }

    public void remove(K chave) {
        Nodo<K, V> nodo = inicio;
        while (nodo != null) {
            if (nodo.getChave().equals(chave)) {
                if (nodo.getAnterior() != null) {
                    nodo.getAnterior().setProximo(nodo.getProximo());
                } else {
                    inicio = nodo.getProximo();
                }
                if (nodo.getProximo() != null) {
                    nodo.getProximo().setAnterior(nodo.getAnterior());
                }
                return;
            }
            nodo = nodo.getProximo();
        }
    }

    public boolean containsKey(K chave) {
        Nodo<K, V> nodo = inicio;
        while (nodo != null) {
            if (nodo.getChave().equals(chave)) {
                return true;
            }
            nodo = nodo.getProximo();
        }
        return false;
    }

    public int size() {
        int count = 0;
        Nodo<K, V> nodo = inicio;
        while (nodo != null) {
            count++;
            nodo = nodo.getProximo();
        }
        return count;
    }

    private static class Nodo<K, V> {
        private K chave;
        private V valor;
        private Nodo<K, V> anterior;
        private Nodo<K, V> proximo;

        public Nodo(K chave, V valor) {
            this.chave = chave;
            this.valor = valor;
        }

        public K getChave() {
            return chave;
        }

        public V getValor() {
            return valor;
        }

        public Nodo<K, V> getAnterior() {
            return anterior;
        }

        public void setAnterior(Nodo<K, V> anterior) {
            this.anterior = anterior;
        }

        public Nodo<K, V> getProximo() {
            return proximo;
        }

        public void setProximo(Nodo<K, V> proximo) {
            this.proximo = proximo;
        }
    }
}
