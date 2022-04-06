import sys
input = sys.stdin.readline

for _ in range(int(input())):
    string = input().strip()
    print(string,"=================")
    IsPseudoPalindrome = True
    UseDelete = False
    # Palindrome
    if string == string[::-1]:
        print(0)
        continue

    # Is Psuedo Palindrome?
    # Devide half string
    mid = len(string) // 2
    str1 = string[0:mid]
    str2 = string[mid:]

    print(str1)
    print(str2)


    if IsPseudoPalindrome:
        print(1)
    else:
        print(2)