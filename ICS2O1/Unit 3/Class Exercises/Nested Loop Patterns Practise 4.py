def main():
    for r in range(5, 0, -1):
        #5 rows, will loop 5 times
        #will loop with 1 less each time for r
        for c in range(r):
            #c will print from 5 minus one number each time
            #will be 1 less on each row because r will be one less
            print(c + 1, end='')
        print()
main()
