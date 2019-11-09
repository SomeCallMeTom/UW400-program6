import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;
import org.junit.runners.MethodSorters;

/**
 * JUnit test class to test class Graph that implements GraphADT interface.
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class GraphTest {
  private Graph<String> graph;

  @Rule
  public Timeout globalTimeout = new Timeout(2000, TimeUnit.MILLISECONDS);

  @Before
  public void setUp() throws Exception {
    this.graph = new Graph<String>();
  }

  @After
  public void tearDown() throws Exception {
    this.graph = null;
  }

  @Test
  public final void test00_addNullVertex() {
    try {
      graph.addVertex(null);
      fail("test00: failed - should throw an IllegalArgumentException upon adding a null vertex");
    } catch (IllegalArgumentException e) {
      // test passed
    } catch (Exception e) {
      fail("test00: failed - unexpected exception occurred");
    }
  }

  @Test
  public final void test01_removeNonexistentVertex() {
    try {
      graph.removeVertex("a");
    } catch (Exception e) {
      fail("test01: failed - unexpected exception occurred");
    }
  }

  @Test
  public final void test02_addEdge() {
    try {
      graph.addVertex("a");
      assertEquals("test02: failed - vertex insertion error", true,
          graph.getAllVertices().contains("a"));
      graph.addVertex("b");
      assertEquals("test02: failed - vertex insertion error", true,
          graph.getAllVertices().contains("b"));
      graph.addEdge("a", "b");
      assertEquals("test02: failed - edge insertion error", true,
          graph.getAdjacentVerticesOf("a").contains("b"));
    } catch (Exception e) {
      fail("test02: failed - unexpected exception occurred");
    }
  }

  @Test
  public final void test03_removeVertex() {
    try {
      graph.addVertex("a");
      assertEquals("test03: failed - vertex insertion error", true,
          graph.getAllVertices().contains("a"));
      graph.addVertex("b");
      assertEquals("test03: failed - vertex insertion error", true,
          graph.getAllVertices().contains("b"));
      graph.addEdge("a", "b");
      assertEquals("test03: failed - edge insertion error", true,
          graph.getAdjacentVerticesOf("a").contains("b"));
      graph.removeVertex("b");
      assertEquals("test03: failed - vertex removal error", false,
          graph.getAdjacentVerticesOf("a").contains("b"));
      assertEquals("test03: failed - vertex removal error", false,
          graph.getAllVertices().contains("b"));
    } catch (Exception e) {
      fail("test03: failed - unexpected exception occurred");
    }
  }

  @Test
  public final void test04_removeEdge() {
    try {
      graph.addVertex("a");
      assertEquals("test04: failed - vertex insertion error", true,
          graph.getAllVertices().contains("a"));
      graph.addVertex("b");
      assertEquals("test04: failed - vertex insertion error", true,
          graph.getAllVertices().contains("b"));
      graph.addEdge("a", "b");
      assertEquals("test04: failed - edge insertion error", true,
          graph.getAdjacentVerticesOf("a").contains("b"));
      graph.removeEdge("a", "b");
      assertEquals("test04: failed - edge removal error", false,
          graph.getAdjacentVerticesOf("a").contains("b"));
      assertEquals("test04: failed - edge removal error", true,
          graph.getAllVertices().contains("b"));
    } catch (Exception e) {
      fail("test04: failed - unexpected exception occurred");
    }
  }

  @Test
  public final void test05_size() {
    try {
      graph.addVertex("a");
      assertEquals("test05: failed - vertex insertion error", true,
          graph.getAllVertices().contains("a"));
      graph.addVertex("b");
      assertEquals("test05: failed - vertex insertion error", true,
          graph.getAllVertices().contains("b"));
      graph.addEdge("a", "b");
      assertEquals("test05: failed - edge insertion error", 1, graph.size());
      graph.addVertex("c");
      assertEquals("test05: failed - vertex insertion error", true,
          graph.getAllVertices().contains("c"));
      graph.addEdge("b", "c");
      assertEquals("test05: failed - edge insertion error", 2, graph.size());
      graph.addEdge("a", "c");
      assertEquals("test05: failed - edge insertion error", 3, graph.size());
    } catch (Exception e) {
      fail("test05: failed - unexpected exception occurred");
    }
  }

  @Test
  public final void test06_order() {
    try {
      graph.addVertex("a");
      assertEquals("test06: failed - vertex insertion error", true,
          graph.getAllVertices().contains("a"));
      graph.addVertex("b");
      assertEquals("test06: failed - vertex insertion error", true,
          graph.getAllVertices().contains("b"));
      graph.addEdge("a", "b");
      assertEquals("test06: failed - edge insertion error", 2, graph.order());
      graph.addVertex("c");
      assertEquals("test06: failed - vertex insertion error", true,
          graph.getAllVertices().contains("c"));
      graph.addEdge("b", "c");
      assertEquals("test06: failed - edge insertion error", 3, graph.order());
      graph.addEdge("a", "c");
      assertEquals("test06: failed - edge insertion error", 3, graph.order());
    } catch (Exception e) {
      fail("test05: failed - unexpected exception occurred");
    }
  }
}
