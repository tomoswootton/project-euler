import java.io.*;
import java.util.Arrays;

public class Main {

  int player1_Score = 0;
  int player2_score = 0;

  public static void main(String[] args) {

  readFile();
  //   String[] test1 = {"2H","5H","3H","6H","4H"};
  //   Hand hand1 = new Hand(test1);
  //   String[] test2 = {"9S","8S","7S","5S","6S"};
  //   Hand hand2 = new Hand(test2);
  //   String[] test3 = {"6S","8S","7D","6S","6H"};
  //   Hand hand3 = new Hand(test3);
  //   String[] test4 = {"AS","8S","7D","AS","6H"};
  //   Hand hand4 = new Hand(test4);
  //   String[] test5 = {"9S","KS","9D","KS","6H"};
  //   Hand hand5 = new Hand(test5);
  }

  public static void readFile() {

    BufferedReader br = null;
		FileReader fr = null;

    String[] hands = {"high_card","one_pair","two_pair","three_of_a_kind",
    "straight","flush","full_house","four_of_a_kind","straight_flush","royal_flush"};;

    int p1_wins = 0;
    int p2_wins = 0;

		try {

			br = new BufferedReader(new FileReader("/home/tomos/work/project-euler/p54.Poker-hands/poker.txt"));

			String sCurrentLine;
      //for each hand
			// while ((sCurrentLine = br.readLine()) != null) {
				// System.out.println(sCurrentLine);
			// }
      sCurrentLine = br.readLine();

      ////// TESTING




      for (int i=0;i<2;i++){

        String[] p1 = {sCurrentLine.substring(0, 2), sCurrentLine.substring(3, 5)
        ,sCurrentLine.substring(6, 8), sCurrentLine.substring(9, 11)
        ,sCurrentLine.substring(12, 14)};

        String[] p2 = {sCurrentLine.substring(15, 17), sCurrentLine.substring(18, 20)
        ,sCurrentLine.substring(21, 23), sCurrentLine.substring(24, 26)
        ,sCurrentLine.substring(27, 29)};

        Hand handp1 = new Hand(p1);
        Hand handp2 = new Hand(p2);

        processRound(handp1,handp2);
        sCurrentLine = br.readLine();
      }

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


  public  static void processRound(Hand p1, Hand p2) {
    System.out.println(Arrays.toString(p1.hand)+Arrays.toString(p2.hand));
    // String p1_hand_type = findHandType(p1);
    // String p2_hand_type = findHandType(p2);
    //
    // if(p1_hand_type == p2_hand_type) {
    //   System.out.println("hands the same");
    // } else if(hands.indexOf(p1_hand_type) > hands.indexOf(p2_hand_type)) {
    //   p1_wins++;
    // } else {
    //   p2_wins++;
    // }
  }







}
