package grafos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
public class Vertice implements Iterable<Vertice> {
  // Identificador único do grafo
  public final int id;

  public String valor;
  // Lista dos vertices que se conecta a partir deste
  // Atravessar todos "for"
  // Adicionar a qualquer momento
  private Set<Vertice> conexoes;

  public Vertice(int id, String valor) {
    this.id = id;
    this.valor = valor;
    this.conexoes = new HashSet<>();
  }

  public void conectar(Vertice v) {
    this.conexoes.add(v);
  }

  @Override
  public int hashCode() {
    return id;
  }

  @Override
  public boolean equals(Object obj) {
    if(obj == null) return false;
    if(!(obj instanceof Vertice)) return false;

    Vertice outro = (Vertice) obj;

    return outro.id == this.id;

  }

  @Override
  public Iterator<Vertice> iterator() {
    return this.conexoes.iterator();
  }

}
