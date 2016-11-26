
#The prime factors of 13195 are 5, 7, 13 and 29.
#
#What is the largest prime factor of the number 600851475143 ?

#take each number and see if it divides into n. if so, check if it is prime
def find_prime(tester):
    if n % tester == 0:
        check_factor_is_prime(tester)

#prime checker
def check_factor_is_prime(tester):
    #check every possible divisor
    for i in range(2,tester):
        #if divisor is found, break function
        if tester % i == 0:
            return
    #if no divisor found, tester must be prime factor. add tester to array
    prime_factors.append(tester)

###
n = int(input("input n = "))
prime_factors = []
#for every integer up to n
for i in range(2,n):
    find_prime(i)
print(' '.join(map(str, prime_factors)))
