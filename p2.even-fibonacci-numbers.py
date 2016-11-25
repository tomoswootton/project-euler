
def gen_fib():
    array.append(array[-2] + array[-1])

def is_even():
    if (array[-1] % 2) == 0:
        even_array.append(array[-1])

array = [1,2]
even_array = [2]

while array[-1] <= 4000000:
    gen_fib()
    is_even()
    #print(" ".join(str(x) for x in array))
    print("Even array = %s"%(" ".join(map(str, even_array))))
    sumtotal = sum(even_array)
    print("sum of even = %s"%sumtotal)
