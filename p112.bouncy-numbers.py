def increasing(num):
    for i in range(0, len(num)-1):
        if num[i] > num[i+1]:
            return False
    return True

def decreasing(num):
    for i in range(0, len(num)-1):
        if num[i] < num[i+1]:
            return False
    return True

def bouncy(num):
    if not(increasing(num)) and not(decreasing(num)):
        return True

num_of_bouncy = 0
num_of_nonbouncy = 99
num = 21780
for i in range(100, num+1):
    i = str(i)
    if bouncy(i):
        num_of_bouncy += 1
    else:
        num_of_nonbouncy += 1
percentage = num_of_bouncy/num
print('percentage with num = 21780 = ' +str(percentage))

while (percentage != 0.99):
    num += 1
    num = str(num)
    if bouncy(num):
        num_of_bouncy += 1
    else:
        num_of_nonbouncy += 1
    num = int(num)
    percentage = num_of_bouncy/num
    print(percentage)
print('bouncy = '+str(num_of_bouncy))
print('nonbouncy = '+str(num_of_nonbouncy))
print('number = '+str(num))
