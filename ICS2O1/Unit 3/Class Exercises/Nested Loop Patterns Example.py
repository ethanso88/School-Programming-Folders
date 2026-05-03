def main():

    #This is the example for just one row
    for r in range(6):
        print('*', end = '')
    print()
    print()
    
    #This is if you want multiple rows of the example 
    for row in range(8):
        for column in range(6):
            print('*', end = '')
        #this is so you get a new row and so everything isn't all on one row
        print()
main()
