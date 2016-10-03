import java.util.ArrayList;
import java.util.Arrays;

/**
 * curPuzzle.java
 *
 * @author <a href="https://www.github.com/Siedg">Siedg</a> (Guilherme Nascimento de Lima)
 * @contact siedg104@gmail.com
 * @date 03/10/2016 - 04:47
 * @since GAMMA - 0x3
 */
public class curPuzzle implements State {
  int notFinalPiece = 0;
  int manhattanDist = 0;
  int[] finalState = new int[] {1, 2, 3, 4, 5, 6, 7, 8, 0};
  int[] curPuzzle;



  //Estado Atual.
  public curPuzzle(int[] curPuzzle){
    this.curPuzzle = curPuzzle;
    setManhattanDist(manhattanDist);
    setNotFinalPiece();
  }

  public int[] getFinalState() {
    return finalState;
  }

  public int getManDist() {
    return manhattanDist;
  }

  public int getNotFinalPiece() {
    return notFinalPiece;
  }

  public int[] getCurPuzzle() {
    return curPuzzle;
  }

  public void setCurPuzzle(int[] curPuzzle) {
    this.curPuzzle = curPuzzle;
  }

  public void setFinalState(int[] finalState) {
    this.finalState = finalState;
  }

  public void setManhattanDist(int manhattanDist) {
    int index = -1;

    for (int j = 0 ; j < 3 ; j++) {
      for (int i = 0 ; i < 3 ; i++) {
        index++;
        int aux = curPuzzle[index] - 1;

        if (aux != -1) {
          int line = aux % 3;
          int col = aux / 3;
          manhattanDist += (line - i) + (col - j);
        }
      }
    }
  }

  //Número de peças fora do lugar.
  public void setNotFinalPiece(){
    for (int i = 0 ; i < curPuzzle.length ; i++) {
      if (curPuzzle[i] != finalState[i]){
        notFinalPiece++;
      }
    }
  }

  //Custo para chegar nesse estado.
  public int cost(){
    return 1;
  }

  public boolean equals(State s) {
    curPuzzle aux = (curPuzzle) s;
    if (Arrays.equals(curPuzzle, aux.getCurPuzzle())){
      return true;
    }
    else{
      return false;
    }
  }

  @Override
  public void printState() {
    System.out.println("[" + curPuzzle[0] + ", " + curPuzzle[1] + ", " + curPuzzle[2] + "\n");
    System.out.println("[" + curPuzzle[3] + ", " + curPuzzle[4] + ", " + curPuzzle[5] + "\n");
    System.out.println("[" + curPuzzle[6] + ", " + curPuzzle[7] + ", " + curPuzzle[8] + "\n");
  }

  public boolean isFinal(){
    if (Arrays.equals(curPuzzle, finalState)) {
      return true;
    }
    else{
      return false;
    }
  }

  public int getZero() {
    int zeroIndex = -1;

    for (int i = 0 ; i < 9 ; i++) {
      if (curPuzzle[i] == 0) zeroIndex = i;
    }

    return zeroIndex;
  }

  //Encontra os próximos estados do puzzle.
  ArrayList<State> nextStates(){
    ArrayList<State> nextS = new ArrayList<>();
    int zero = getZero();

    //Caso seja possível mover a peça para a esquerda.
    if (zero != 0 && zero != 3 && zero != 6) {
      swap(zero - 1, zero, nextS);
    }

    //Caso seja possível mover a peça para a direita.
    if (zero != 2 && zero != 5 && zero != 8) {
      swap(zero + 1, zero, nextS);
    }

    //Caso seja possível mover a peça para cima.
    if (zero != 0 && zero != 1 && zero != 2) {
      swap(zero - 3, zero, nextS);
    }

    //Caso seja possível mover a peça para baixo.
    if (zero != 6 && zero != 7 && zero != 8) {
      swap(zero + 3, zero, nextS);
    }

    return nextS;
  }

  public void swap(int index1, int index2, ArrayList<State> s) {
    int[] auxPuzzle = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int aux;

    for(int i = 0 ; i < 9 ; i++) {
      auxPuzzle[i] = curPuzzle[i];
    }

    aux = auxPuzzle[index1];
    auxPuzzle[index1] = curPuzzle[index2];
    auxPuzzle[index2] = aux;

    State auxS = new curPuzzle(auxPuzzle);
    s.add(auxS);
  }


}
