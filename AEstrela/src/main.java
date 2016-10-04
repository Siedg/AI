import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 * main.java
 *
 * @author <a href="https://www.github.com/Siedg">Siedg</a> (Guilherme Nascimento de Lima)
 * @contact siedg104@gmail.com
 * @date 30/09/2016 - 02:16
 * @since GAMMA - 0x3
 */

public class main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    int tmp;
    //int[] vector = {0, 0, 0, 0, 0, 0, 0, 0, 0};
    int[] vector = {2, 3, 1, 0, 5, 6, 4, 7, 8};
    Queue<Node> queue = new LinkedList<Node>();
    int n = 0;


    /*
    for (int i = 0 ; i < 9 ; i++) {
      System.out.println("Peça na posição [" + i + "]: ");
      tmp = scanner.nextInt();
      vector[i] = tmp;
    }
    */

    /*
    for (int i = 0 ; i < 9 ; i++) {
      System.out.println("pos " + i + " = " + vector[i]);
    }
    */

    Node firstNode = new Node(new curPuzzle(vector));
    queue.add(firstNode);

    //Fila não vazia.
    while (!queue.isEmpty()) {

      Node auxNode = queue.poll();

      //Enquanto o estado de auxNode não é o estado final.
      if (!auxNode.getCurState().isFinal()) {
        ArrayList<State> auxNextStates = auxNode.getCurState().nextStates();
        ArrayList<Node> nextStates = new ArrayList<Node>();

        //Passa por todos os próximos estados e calcula os custos.
        for (int i = 0 ; i < auxNextStates.size(); i++) {
          Node node;
          curPuzzle temp = (curPuzzle) auxNextStates.get(i);
          temp.getNotFinalPiece();
          node = new Node(auxNode, temp, auxNode.getGCost() + temp.cost(), temp.getManhattanDist() + temp.getNotFinalPiece());

          nextStates.add(node);
        }


        //Caso a lista de próximos estados não esteja vazia.
        if (nextStates.size() != 0) {
          Node lesserNode = nextStates.get(0);

          //Encontra o node com menor custo F.
          for(int i = 0 ; i < nextStates.size() ; i++) {
            if (lesserNode.getFCost() > nextStates.get(i).getFCost()) {
              lesserNode = nextStates.get(i);
            }
          }

          int lesserFCost = lesserNode.getFCost();

          for (int i = 0 ; i < nextStates.size() ; i++) {
            if (nextStates.get(i).getFCost() == lesserFCost) {
              queue.add(nextStates.get(i));
            }
          }

          n++;
        }
      }

      //Estado final encontrado.
      else {

      }
    }



  }
}
