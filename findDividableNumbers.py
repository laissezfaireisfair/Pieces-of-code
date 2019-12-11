from itertools import permutations

def cort_to_num(cort):
    num = 0
    for i in cort:
        num = num*10 + i
    return num

def is_dvdbl(num):
    for digit in [int(x) for x in str(num)]:
        if (digit == 0 or num % digit != 0):
            return False
    return True

def get_nums_with_diff_digits(len):
    allNums = [cort_to_num(x) for x in permutations({1,2,3,4,5,6,7,8,9}, len)]
    return [num for num in allNums if is_dvdbl(num)]

def main():
    len = int(input())
    nums = get_nums_with_diff_digits(len)
    if (nums != []):
        print(", ".join([str(x) for x in nums]))
    else:
        print("LEJAT+")
main()
