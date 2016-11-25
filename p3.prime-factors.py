#find all primes
def primes_of(i):
    global array_index
    while array_index < len(prime_array):
        if i % prime_array[array_index] != 0:
            array_index += 1
        else:
            return      #leave function if i%prime == 0
        prime_array.append(i)
        prime_factors(i)

#find all prime factors
def prime_factors(i):
    if n % i == 0:
        array_factors.append(i)
        print(i)

n = int(input("input n: "))
prime_array = [2, 3]
array_factors = []
for i in range(4, n+1):
    array_index = 0
    #find all prime numbers under n
    primes_of(i)#


#print(" ".join(map(str, prime_array)))
print(" ".join(map(str,array_factors)))
