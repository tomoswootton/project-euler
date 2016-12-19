/*  2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
*/

public class Main {

  public static int x = 20;

  public static void main(String[] args) {
    //check every number until an answer is found.
    for(int i = 1; i>0; i++){
      Main.checkDivision(i);
    }
  }
  public static void checkDivision(int i) {
    //check if first x value evenly divides. if so, recall method with next x value
    if(i % x == 0 && x > 1) {
      x = x-1;
      Main.checkDivision(i);
    //if x equals 0 then all values of x evely divide meaning we have our answer.
  } else if(x == 1){
       System.out.print("The answer is " + i);
       System.exit(0);
    }
    //reset x value for next i value.
    x = 20;
  }
}
