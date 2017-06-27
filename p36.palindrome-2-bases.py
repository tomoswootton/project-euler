def binary_convert(number):
    n=0
    #find number of columns needed
    while pow(2,n) <= number:
        n = n + 1
    n = n-1
    binary = [0] * (n+1)
    while n>=0:
        if number >= pow(2,n):
            number = number - pow(2,n)
            binary[n] = 1
        n = n-1
    binary.reverse()
    return ''.join(map(str, binary))

def is_palindrome(number):
    number = str(number)
    n = len(number)-1
    m = 0
    while n >= m:
        if number[n] == number[m]:
            n = n-1
            m = m+1
        else:
            break
        if n == m or m > n:
            return True

super_palindromes = []
sum = 0
for i in range (0, 1000000):
    if i % 10000 == 0:
        print(i)
    if is_palindrome(i):
        j = binary_convert(i)
        if is_palindrome(j):
            sum = sum + i
            super_palindromes.append(i)
            super_palindromes.append(j)
print(super_palindromes)
print("sum = ", sum)
