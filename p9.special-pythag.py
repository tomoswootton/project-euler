# A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
# a^2 + b^2 = c^2
#
# For example, 3^2 + 4^2 = 9 + 16 = 25 = 5^2.
#
# There exists exactly one Pythagorean triplet for which a + b + c = 1000.
# Find the product abc.

#SOLUTION
#rearranging a^2 + b^2 = c^2 and a+b+c=1000 into a = terms of b we get;
#
#   a = ((1000*1000)-(2000*b))/(2000-(2*b)))
#
#finding integer values of a and b which satisfy this equation will give our
#solution.

def find_a(i):
    return(((1000**2)-(2000*i))/(2000-(2*i)))

for i in range(1,1000,1):
    a = find_a(i)
    if a.is_integer() and 0 < a < 1000:
        print('a = %s'%a)
        print('b = %s'%i)
        c = int(a**2 + i**2)**(1/2)
        print('c = %s'%c)
        total = a*i*c
        print('total = %s'%total)
        exit()
