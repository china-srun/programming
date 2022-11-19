recursion = {0:1}
def func(num):
    if recursion.get(num):
        return recursion.get(num)
    else:
        recursion[num] = func(num//2)+func(num//3)
        return recursion[num]
n = int(input())
print(func(n))