import java.io.*;
import java.util.Arrays;

public class Hand {
  String[] hand;
  int[] hand_numbers;
  String hand_type;
  int value_of_winning_card1 = 0;
  int value_of_winning_card2 = 0;


  public Hand(String[] hand) {
    this.hand = hand;
    this.hand_numbers = findCardNumbers(this.hand);
    findHandType();
    // System.out.println("hand = "+Arrays.toString(hand)+"\ntype = "+hand_type+"\nvalue1 = "
    // +value_of_winning_card1+"\nvalue2 = "+value_of_winning_card2);
  }

  public void findHandType() {
    flush();
    if(hand_type != null){
      if(royal()){
        this.hand_type = "royal_flush";
      }
      if(straight()){
        this.hand_type = "straight_flush";
      }
      return;
    }
    straight();
    if(hand_type != null){
      return;
    }
    pair();
    if(hand_type != null){
      if(threeOfAKind()){
        this.hand_type = "full_house";
      }
      return;
    }
    twoPair();
    if(hand_type != null){
      return;
    }
    threeOfAKind();
    if(hand_type != null){
      return;
    }
    fourOfAKind();
    if(hand_type != null){
      return;
    }

    //if no hand type apply high cards
    this.hand_type = "high_card";
    this.value_of_winning_card1 = highCard(hand);
  }

  //HAND LOGIC METHODS

  //takes argument so can be called with less than full hand
  private int[] findCardNumbers(String[] hand) {
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

  private boolean flush() {
    //returns true if flush
    char[] suits = "CSDH".toCharArray();
    int cards_in_suit;
    for(char suit : suits) {
      cards_in_suit = 0;
      for(String card : this.hand) {
        if (card.charAt(1) != suit) {
          break;
        }
        cards_in_suit++;
        if(cards_in_suit == this.hand.length) {
          this.hand_type = "flush";
          return true;
        }
      }

      }
      return false;
  }

  private boolean royal(){
    //returns true if card numbers are T,J,Q,K,A
    for(String card : this.hand) {
      char number = card.charAt(0);
      if (number != 'T' && number != 'J' && number != 'Q' && number != 'K' && number != 'A') {
        return false;
      }
    }
    return true;
  }

  private boolean straight(){
    //if straight return highest card value, else return 0
    if((this.hand_numbers[0]+1 == this.hand_numbers[1]) &&
      (this.hand_numbers[1]+1 == this.hand_numbers[2]) &&
      (this.hand_numbers[2]+1 == this.hand_numbers[3]) &&
      (this.hand_numbers[3]+1 == this.hand_numbers[4])){
      this.hand_type = "straight";
      this.value_of_winning_card1 = this.hand_numbers[4];
      return true;
    }
    return false;
  }

  private boolean fourOfAKind() {
    //return 4 card value, else return 0
    int temp = this.hand_numbers[2];
    //as they number array is ordered
    if((this.hand_numbers[0] == temp && this.hand_numbers[1] == temp && this.hand_numbers[3] == temp)
    || (this.hand_numbers[1] == temp && this.hand_numbers[3] == temp && this.hand_numbers[4] == temp)) {
      this.hand_type = "four_of_a_kind";
      this.value_of_winning_card1 = temp;
      return true;
    }
    return false;
  }

  private boolean threeOfAKind() {
    //also works on four of a kinds so check for four first
    //return 3 card value, else return 0
    if((this.hand_numbers[0] == this.hand_numbers[1] && this.hand_numbers[1] == this.hand_numbers[2])
    || (this.hand_numbers[1] == this.hand_numbers[2] && this.hand_numbers[2] == this.hand_numbers[3])
    || (this.hand_numbers[2] == this.hand_numbers[3] && this.hand_numbers[3] == this.hand_numbers[4])) {
      this.hand_type = "three_of_a_kind";
      this.value_of_winning_card1 = this.hand_numbers[2];
      return true;
    }
    return false;
  }

  private boolean pair() {
    //if one pair found, return value of pair, else return 0
    int pairs = 0;
    int pair_holder = 0;
    for(int number: this.hand_numbers) {
      int count = 0;
      for(int number2: this.hand_numbers) {
        if(number == number2) {
          count++;
        }
      }
      if(count == 2 && pair_holder != number) {
        pair_holder = number;
        pairs++;
      }
    }
    if(pairs == 1) {
      this.hand_type = "one_pair";
      this.value_of_winning_card1 = pair_holder;
      return true;
    }
    return false;
  }

  private boolean twoPair() {
    //if two pair return pair values, else return 0
    int pairs = 0;
    int[] pair_holder = {0,0};
    for(int number: this.hand_numbers) {
      int count = 0;
      for(int number2: this.hand_numbers) {
        if(number == number2) {
          count++;
        }
      }
      if(count == 2 && pair_holder[0] != number && pair_holder[1] != number) {
        pairs++;
        if(pair_holder[0] == 0) {
          pair_holder[0] = number;
        } else {
          pair_holder[1] = number;
        }
      }
    }
    if(pairs == 2) {
      this.hand_type = "two_pair";
      Arrays.sort(pair_holder);
      this.value_of_winning_card1 = pair_holder[1];
      this.value_of_winning_card2 = pair_holder[0];
      return true;
    }
    return false;
  }

  //can be called by outside incase a draw occurs, takes argument so half a hand
  //can be parsed
  public int highCard(String[] hand){
    return findCardNumbers(hand)[hand.length-1];
  }

}
