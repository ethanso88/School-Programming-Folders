def main():
    for r in range(5):
        #There will be 5 rows
        #will print a hashtag at the beginning of each line
        print('#', end='') 
        for c in range(r):
            #This allows us to print a space in front of every new row starting from zero spaces
            #the spaces will equal to the one less of the row number creating a staircase when printed
            print(' ', end = '')
        #This already prints a new line at the end
        print('#')
main()
