import java.util.LinkedList;
import java.util.List;

public class Graph<T> implements GraphADT<T> {
  int order, size;
  LinkedList<T> adjacentList[];
  
  Graph(){
    this.order = this.size = 0;
    
  }

  @Override
  public void addVertex(T vertex) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    if(vertex == null) {
      throw new IllegalArgumentException("Cannot insert null vertex.");
    }
  }

  @Override
  public void removeVertex(T vertex) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    if(vertex == null) {
      throw new IllegalArgumentException("Cannot remove null vertex.");
    }
    
  }

  @Override
  public void addEdge(T vertex1, T vertex2) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    if(vertex1 == null || vertex2 == null) {
      throw new IllegalArgumentException("Cannot add edge to null vertex.");
    }
  }

  @Override
  public void removeEdge(T vertex1, T vertex2) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    if(vertex1 == null || vertex2 == null) {
      throw new IllegalArgumentException("Cannot remove edge from null vertex.");
    }
  }

  @Override
  public List<T> getAllVertices() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public List<T> getAdjacentVerticesOf(T vertex) throws IllegalArgumentException {
    // TODO Auto-generated method stub
    if (vertex == null) {
      throw new IllegalArgumentException("Cannot find adjacent vertices of null verticy");
    }
    return null;
  }

  @Override
  public int size() {
    // TODO Auto-generated method stub
    return size;
  }

  @Override
  public int order() {
    // TODO Auto-generated method stub
    return order;
  }
	// TODO: implement this class
}
