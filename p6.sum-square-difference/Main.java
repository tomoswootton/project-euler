/*
The sum of the squares of the first ten natural numbers is,
12 + 22 + ... + 102 = 385

The square of the sum of the first ten natural numbers is,
(1 + 2 + ... + 10)2 = 552 = 3025

Hence the difference between the sum of the squares of the first ten natural numbers and the square of the sum is 3025 − 385 = 2640.

Find the difference between the sum of the squares of the first one hundred natural numbers and the square of the sum.
*/

class Main {

  public static int nValue = 100;

  public static void main(String[] args) {
    System.out.print("The answer is " + findDifference());
  }

  public static int findDifference() {
    return squareOfSums(nValue) - sumOfSquares(nValue);
  }

  public static int sumOfSquares(int n) {
    int total = 0;
    for(int i=1; i<=n; i++){
      total += i*i;
    }
    return total;
  }

  public static int squareOfSums(int n) {
    int total = 0;
    for (int i=1; i<=n; i++) {
      total += i;
    }
    return total*total;
  }
}
