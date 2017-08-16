import java.io.*;
import java.util.Arrays;

public class Main {

  static int player1_Score = 0;
  static int player2_score = 0;

  static String[] hands = {"high_card","one_pair","two_pair","three_of_a_kind",
  "straight","flush","full_house","four_of_a_kind","straight_flush","royal_flush"};;

  public static void main(String[] args) {
    readFile();
  }

  public static void readFile() {

    BufferedReader br = null;
		FileReader fr = null;

    int p1_wins = 0;
    int p2_wins = 0;

		try {

			br = new BufferedReader(new FileReader("/home/tomos/work/project-euler/p54.Poker-hands/poker.txt"));

			String sCurrentLine;

      sCurrentLine = br.readLine();

      for (int i=0;i<1000;i++){
        System.out.println("round "+(i+1));
        String[] p1 = {sCurrentLine.substring(0, 2), sCurrentLine.substring(3, 5)
        ,sCurrentLine.substring(6, 8), sCurrentLine.substring(9, 11)
        ,sCurrentLine.substring(12, 14)};

        String[] p2 = {sCurrentLine.substring(15, 17), sCurrentLine.substring(18, 20)
        ,sCurrentLine.substring(21, 23), sCurrentLine.substring(24, 26)
        ,sCurrentLine.substring(27, 29)};

        Hand handp1 = new Hand(p1);
        Hand handp2 = new Hand(p2);

        System.out.println("p1 hand: "+Arrays.toString(handp1.hand_numbers)+" "+handp1.hand_type);
        System.out.println("p2 hand: "+Arrays.toString(handp2.hand_numbers)+" "+handp2.hand_type);

        processRound(handp1,handp2);
        sCurrentLine = br.readLine();
      }

      System.out.println("\n\np1 score = "+player1_Score + "\np2 score = "+player2_score+"\n");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
				if (fr != null)
					fr.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
  }


  public static void processRound(Hand p1, Hand p2) {

    if(p1.hand_type != p2.hand_type) {
      if(findIndexInHandsArray(p1.hand_type) > findIndexInHandsArray(p2.hand_type)){
        System.out.println("p1 wins with " + p1.hand_type);
        player1_Score++;
      } else if(findIndexInHandsArray(p1.hand_type) < findIndexInHandsArray(p2.hand_type)) {
        System.out.println("p2 wins " + p2.hand_type);
        player2_score++;
      }
    } else {
    //hand types even
      if(p1.value_of_winning_card1 > p2.value_of_winning_card1){
        player1_Score++;
        System.out.println("p1 wins with "+p1.hand_type+" and vc1 = "+p1.value_of_winning_card1);
      } else if(p1.value_of_winning_card1 < p2.value_of_winning_card1){
        player2_score++;
        System.out.println("p2 wins with "+p2.hand_type+" and vc1 = "+p2.value_of_winning_card1);
      } else {
        //value_of_winning_card1 even
        if(p1.value_of_winning_card2 > p2.value_of_winning_card2){
          player1_Score++;
          System.out.println("p1 wins with "+p1.hand_type+" and vc2 = "+p1.value_of_winning_card2);
        } else if(p1.value_of_winning_card2 < p2.value_of_winning_card2){
          player2_score++;
          System.out.println("p2 wins with "+p2.hand_type+" and vc2 = "+p2.value_of_winning_card2);
        } else {
          //must find next highest card
          for(int i=p1.hand.length-1;i>=0;i--){
            if(p1.hand_numbers[i]>p2.hand_numbers[i]){
              player1_Score++;
              System.out.println("p1 wins on high card = "+p1.hand_numbers[i]);
              break;
            } else if(p1.hand_numbers[i]<p2.hand_numbers[i]){
              player2_score++;
              System.out.println("p2 wins on high card = "+p2.hand_numbers[i]);
              break;
            }
          }

      }
    }
  }
}

  public static int findIndexInHandsArray(String hand_type) {
    for(int i=0;i<=hands.length-1;i++) {
      if(hand_type == hands[i]) {
        return i;
      }
    }
    return -1;
  }

}
