package grafos;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Grafo implements Iterable<Vertice> {
  // Acessar vertices
  // For atravessar todos
  // Obter um especifico

  // Conectar vertices
  // Conectar vertice X com vertic Y
  // X? Y?

  // Poder adicionar vértices a qualquer momento

  private List<Vertice> vertices; // ArrayList

  public Grafo() {
    this.vertices = new ArrayList<>();
  }

  public int criarVertice(String valor) {
    Vertice v = new Vertice(this.vertices.size(), valor);
    this.vertices.add(v);

    return v.id;
  }

  public void conectar (int idA, int idB) {
    Vertice vA = this.vertices.get(idA);
    Vertice vB = this.vertices.get(idB);

    vA.conectar(vB);
  }

  @Override
  public Iterator<Vertice> iterator() {
    return this.vertices.iterator();
  }

  public void printar() {
    for (Vertice v : vertices) {
      System.out.print(v.id+": "+v.valor+" [");
      for (Vertice conn : v) {
        System.out.print("("+conn.id+":"+conn.valor+"), ");
      }
      System.out.println("]");
    }
  }

  public void travessiaProfundidade(int inicio) {
    _travessiaProfundidadeVertice(
      this.vertices.get(inicio),
      new HashSet<>()
    );

  }

  private void _travessiaProfundidadeVertice(Vertice atual, Set<Integer> visitados) {
    visitados.add(atual.id);
    for (Vertice conn : atual) {
      if(visitados.contains(conn.id)) continue;
      _travessiaProfundidadeVertice(conn, visitados);
    } 
  }

  public static void main(String[] args) {
    Grafo g = new Grafo();

    int idA = g.criarVertice("A");
    int idB = g.criarVertice("B");
    int idC = g.criarVertice("C");
    int idD = g.criarVertice("D");
    int idE = g.criarVertice("E");

    // A
    g.conectar(idA, idB);
    g.conectar(idA, idC);

    // B
    g.conectar(idB, idC);
    g.conectar(idB, idD);

    // C
    g.conectar(idC, idB);
    g.conectar(idC, idD);

    g.printar();
  }
}
