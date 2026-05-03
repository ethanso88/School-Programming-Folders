def main():
    for r in range(5):
        #5 rows, will loop 5 times
        for c in range(r+1):
            #will print c with the number of times equal to the row number
            #c will be +1 each time
            print(c + 1, end='')
        print()
main()
