def main():
    #we will have 8 rows 
    for r in range(8):
        #each row will have the same number of columns as the row number
        #there is plus 1 for r because its starting value would be 0 so you need +1
        for c in range(r+1):
            print('*', end='')
        print()
main()
