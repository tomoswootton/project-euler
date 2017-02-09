#A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.
#
#Find the largest palindrome made from the product of two 3-digit numbers.

#1. find palindrome largest first
#2.check if it is the product of 2 3 digit numbers

#check if number is palindrome
def is_palindrome(i):
    if str(i)[-1] == str(i)[0] and str(i)[-2] == str(i)[1] and str(i)[-3] == str(i)[2]:
        return True
#check if number can be written as product of two 3 digit numbers.
def is_product(i):
    for j in range(int("9"*n),2,-1):
        if i % j == 0 and len(str(i/j)) == n:
            print(len(str(j)))
            print("other j = %s"%(str(i/j)))
            print("j = %s"%j)
            print("i = %s"%i)
            return True


n = int(input("number of digits for product numbers: "))
start_from = int("9"*n)*int("9"*n)
#loop through all possible numbers
for i in range(start_from, 0, -1):
    if is_palindrome(i):
        print(i)
        if is_product(i):

            exit()
