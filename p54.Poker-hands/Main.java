import java.io.*;
import java.util.Arrays;

public class Main {

  public static void main(String[] args) {

    readFile();

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

      String[] p1 = {"9S","8S","7D","5S","6H"};
      // System.out.println(Arrays.toString(p1));
      System.out.println(straight(p1));



      ///////////////////////
      // String[] p1 = {sCurrentLine.substring(0, 2), sCurrentLine.substring(3, 5)
      // ,sCurrentLine.substring(6, 8), sCurrentLine.substring(9, 11)
      // ,sCurrentLine.substring(12, 14)};

      String[] p2 = {sCurrentLine.substring(15, 17), sCurrentLine.substring(18, 20)
      ,sCurrentLine.substring(21, 23), sCurrentLine.substring(24, 26)
      ,sCurrentLine.substring(27, 29)};

      // System.out.println(Arrays.toString(p1) + Arrays.toString(p2));

      // processRound(p1,p2);



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

  public  static void processRound(String[] p1, String[] p2) {

    // String p1_hand_type = findHandType(p1);
    // String p2_hand_type = findHandType(p2);

  //   if(p1_hand_type == p2_hand_type) {
  //     System.out.println("hands the same");
  //   } else if(hands.indexOf(p1_hand_type) > hands.indexOf(p2_hand_type)) {
  //     p1_wins++;
  //   } else {
  //     p2_wins++;
  //   }
  }

  // public static Object[] findHandType(String[] hand) {
  //
  //   // if(flush(hand)){
  //   //   Object[] flush = {"flush",0};
  //   //   return flush;
  //   // }
  //   // Object[] straight = {"straight",straight(hand)};
  //   // if(straight != 0){
  //   //   return straight;
  //   // }
  //   return "";
  // }


  //HAND LOGIC METHODS

  public static int[] findCardNumbers(String[] hand) {
    //returns array of number values on cards
    char[] card_number = new char[hand.length];
    for (int i = 0; i < hand.length; i++) {
      card_number[i] = hand[i].charAt(0);
    }
    int[] card_number_int = new int[hand.length];
    for (int i = 0; i < card_number.length; i++) {
      char temp = card_number[i];
      switch(temp) {
        case 'T':
          card_number_int[i] = 10;
          break;
        case 'J':
          card_number_int[i] = 11;
          break;
        case 'Q':
          card_number_int[i] = 12;
          break;
        case 'K':
          card_number_int[i] = 13;
          break;
        case 'A':
          card_number_int[i] = 14;
          break;
        case '2': case '3': case '4': case '5': case '6': case '7': case '8': case '9':
          card_number_int[i] = Character.getNumericValue(temp);
          break;
      }
    }
    Arrays.sort(card_number_int);
    return card_number_int;
  }

  public static boolean flush(String[] hand) {
    //returns true if flush
    char[] suits = "CSDH".toCharArray();
    int cards_in_suit;
    for(char suit : suits) {
      cards_in_suit = 0;
      for(String card : hand) {
        if (card.charAt(1) != suit) {
          break;
        }
        cards_in_suit++;
        if(cards_in_suit == hand.length) {
          return true;
        }
      }

      }
      return false;
  }

  public static boolean royal(String[] hand){
    //returns true if card numbers are T,J,Q,K,A
    for(String card : hand) {
      char number = card.charAt(0);
      if (number != 'T' && number != 'J' && number != 'Q' && number != 'K' && number != 'A') {
        return false;
      }
    }
    return true;
  }

  public static int straight(String[] hand){
    //if straight return highest card value, else return 0

    int[] numbers = findCardNumbers(hand);

    if(numbers[0] == numbers[4]-4) {
      return numbers[4];
    }
    return 0;
  }

  public static int fourOfAKind(String[] hand) {
    //return 4 card value, else return 0
    int[] numbers = findCardNumbers(hand);
    System.out.println(Arrays.toString(numbers));
    int temp = numbers[2];
    //as they number array is ordered
    if((numbers[0] == temp && numbers[1] == temp && numbers[3] == temp)
    || (numbers[1] == temp && numbers[3] == temp && numbers[4] == temp)) {
      return temp;
    }
    return 0;
  }

  public static int threeOfAKind(String[] hand) {
    //also works on four of a kinds so check for four first
    //return 3 card value, else return 0
    int[] numbers = findCardNumbers(hand);
    if((numbers[0] == numbers[1] && numbers[1] == numbers[2])
    || (numbers[1] == numbers[2] && numbers[2] == numbers[3])
    || (numbers[2] == numbers[3] && numbers[3] == numbers[4])) {
      return numbers[2];
    }
    return 0;
  }

  public static int pair(String[] hand) {
    //if one pair found, return value of pair, else return 0
    int[] numbers = findCardNumbers(hand);
    int pairs = 0;
    int pair_holder = 0;
    for(int number: numbers) {
      int count = 0;
      for(int number2: numbers) {
        if(number == number2) {
          count++;
        }
      }
      if(count == 2) {
        pair_holder = number;
        pairs++;
      }
    }
    pairs = pairs/2;
    if(pairs == 1) {
      return pair_holder;
    }
    return 0;
  }



  public static int[] twoPair(String[] hand) {
    //if two pair return pair values, else return 0
    int[] numbers = findCardNumbers(hand);
    int pairs = 0;
    int[] pair_holder = {0,0};
    for(int number: numbers) {
      int count = 0;
      for(int number2: numbers) {
        if(number == number2) {
          count++;
        }
      }
      System.out.println("number = "+number+"\nholder = "+pair_holder[0]);
      if(count == 2 && pair_holder[0] != number && pair_holder[1] != number) {
        System.out.println("got here");
        pairs++;
        if(pair_holder[0] == 0) {
          pair_holder[0] = number;
        } else {
          pair_holder[1] = number;
        }
      }
    }
    System.out.println("pairs = "+pairs);
    if(pairs == 2) {
      return pair_holder;
    }
    pair_holder[0] = 0;
    pair_holder[1] = 0;
    return pair_holder;
  }

}
