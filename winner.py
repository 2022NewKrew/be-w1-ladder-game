import sys

if len(sys.argv) != 2:
    print("Usage: {} NUMBER".format(sys.argv[0]))
    exit(1)

n = int(sys.argv[1])

users = None
with open('user.txt') as userfile:
    users = userfile.read().split()

import random
random.shuffle(users)
winner = users[:n]

print('\n간단 뽑기 프로그램\n')

for u in winner:
    print(u)
print('\nThank you\n');
