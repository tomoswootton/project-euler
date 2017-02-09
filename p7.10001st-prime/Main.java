/*
By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.

What is the 10 001st prime number?
*/
import java.util.ArrayList;
class Main {

  static ArrayList<Integer> primes = new ArrayList<Integer>();

  public static void main(String[] args) {

    //add 2 to array so other numbers can be tested.
    primes.add(2);

    int i = 3;
    //do until the length of the list of primes is as large as needed.
    while(primes.size() < 10002) {
      //start at 3 because 2 is already added
      primeFinder(i);
      i++;
    }

    System.out.print("10001th prime is " + primes.get(10000));
  }

  public static void primeFinder(int i) {
    for(int prime: primes) {
      //if i % prime is 0 then the number cannot be prime
      if(i % prime == 0){
        return;
      }
    }
      //for the code to reach this point, all primes less than i cannot be
      //evenly divided into i so i must be prime.
      primes.add(i);
  }
}
