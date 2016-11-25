n = int(input("n: "))
total = 0
array = []
for i in range(1000):
    if 3*i < n and 3*i not in array:
        total += 3*i
        print(3*i)
        array.append(3*i)
    if 5*i < n and 5*i not in array:
        total = total + 5*i
        print(5*i)
        array.append(5*i)
print("Total = %s"%total)
