package arvores;
public class ArvoreBinaria {
    private static class ArvoreNo {
        int valor;
        ArvoreNo esquerda;
        ArvoreNo direita;

        public ArvoreNo(int valor) {
            this.valor = valor;
        }

        public ArvoreNo(int valor, ArvoreNo esquerda, ArvoreNo direita) {
            this.valor = valor;
            this.esquerda = esquerda;
            this.direita = direita;
        }

        public void inserir(int novo) {
            if (novo < valor) {
                if (esquerda != null) {
                    esquerda.inserir(novo);
                } else {
                    esquerda = new ArvoreNo(novo);
                }
            } else {
                if (direita != null) {
                    direita.inserir(novo);
                } else {
                    direita = new ArvoreNo(novo);
                }
            }
        }

    }

    private ArvoreNo raiz;

    public void inserir(int valor) {
        if (raiz == null) {
            raiz = new ArvoreNo(valor);
        } else {
            raiz.inserir(valor);
        }
    }
}