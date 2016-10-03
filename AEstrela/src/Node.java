/**
 * Node.java
 *
 * @author <a href="https://www.github.com/Siedg">Siedg</a> (Guilherme Nascimento de Lima)
 * @contact siedg104@gmail.com
 * @date 30/09/2016 - 02:09
 * @since GAMMA - 0x3
 */

public class Node {
  int g_cost;
  int h_cost;
  int f_cost;
  State curState;
  Node parent;

  public Node (State s) {
    curState = s;
    parent = null;
    g_cost = 0;
    h_cost = 0;
    f_cost = 0;
  }

  public Node (Node prev, State s, int g, int h) {
    parent = prev;
    curState = s;
    g_cost = g;
    h_cost = h;
    f_cost = g_cost + h_cost;
  }

  public int getGCost() {
    return g_cost;
  }

  public int getHCost() {
    return h_cost;
  }

  public int getFCost() {
    return f_cost;
  }

  public State getCurState() {
    return curState;
  }

  public Node getParent() {
    return parent;
  }
}
