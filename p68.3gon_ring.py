# magic 3-gon ring
# https://projecteuler.net/problem=68

def find_string(spokes):
    print(spokes)
    externalNodes = [x[0] for x in spokes]
    startIndex = externalNodes.index(min(externalNodes))
    string = ""
    for i in range(startIndex, startIndex + 5):
        string += "".join(str(x) for x in spokes[i % 5])
    return string

def generate_spoke(total, nums, known, first_spoke=False):
    total -= known
    for first in nums:
        second = total - first
        if first==second or second not in nums:
            continue
        remaining = nums - {first, second}
        if first_spoke:
            yield [known, first, second], remaining
        else:
            yield [first, known, second], remaining


greatest_spoke_string=''
for total in range(14,19):
    print('-----------------------', total, '------------------')
    for spoke1, remaining in generate_spoke(total, {1,2,3,4,5,6,7,8,9}, 10, True):
        print(spoke1, ' | ', remaining)
        for spoke2, remaining, in generate_spoke(total, remaining, spoke1[2]):
            print(spoke1, spoke2, ' | ', remaining)
            for spoke3, remaining, in generate_spoke(total, remaining, spoke2[2]):
                print(spoke1, spoke2, spoke3, ' | ', remaining)
                for spoke4, remaining, in generate_spoke(total, remaining, spoke3[2]):
                    print(spoke1, spoke2, spoke3, spoke4, ' | ', remaining)
                    spoke5 = [list(remaining)[0], spoke4[2], spoke1[1]]
                    if sum(spoke5)!=total:
                        continue
                    print(spoke1, spoke2, spoke3, spoke4, spoke5)
                    spokes = [spoke1, spoke2, spoke3, spoke4, spoke5]
                    spoke_string = find_string(spokes)
                    if spoke_string>greatest_spoke_string:
                        greatest_spoke_string = spoke_string

print('THE GREATEST SPOKE STIRNG THING IS:')
print(greatest_spoke_string)
