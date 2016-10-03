import java.util.ArrayList;

/**
 * State.java
 *
 * @author <a href="https://www.github.com/Siedg">Siedg</a> (Guilherme Nascimento de Lima)
 * @contact siedg104@gmail.com
 * @date 30/09/2016 - 02:46
 * @since GAMMA - 0x3
 */

public interface State {
  boolean isFinal();

  int cost();

  public void printState();

  public boolean equals(State s);

  public ArrayList<State> nextStates();

}
