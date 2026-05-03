#This is a nested loop program to print a pattern with hashtags
#This pattern will look like a hastag vertical line on the left with a slope to the right

def main():
    for r in range(7): #This is the number of rows
        #There will be 7 rows
        #At the beginning of each row it will print a hashtag
        print('#', end='')
        for c in range(r): #This is what will be printed in the columns
            #The number of loops depends on the row number
            #it will print 0 the first loop because 0 is the starting value for the range
            #it will then print 3 spaces times the row number each time
            #It will print 3 spaces each loop
            print(' ', end='')
            print(' ', end='')
            print(' ', end='')
        #At the end of each row it will print a hashtag
        print('#')

main()
