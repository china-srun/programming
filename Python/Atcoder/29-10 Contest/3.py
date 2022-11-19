from itertools import combinations


r=[]
a=[]
for i in range(9):
    r.append(input())
    
for i in range(len(r)):
    for j in range(9):
        if r[i][j] == "#":
            a.append([i+1,j+1])


def find_square(a):
    result = []
    for (bl, tl, br, tr) in zip(a, a[1:], a[2:], a[3:]):
        if bl[0] == tl[0] and br[0] == tr[0] and \
           bl[1] == br[1] and tl[1] == tr[1] and \
           br[0] - bl[0] == tl[1] - bl[1]:
           result.append(tr)
    return result
print(find_square(a))