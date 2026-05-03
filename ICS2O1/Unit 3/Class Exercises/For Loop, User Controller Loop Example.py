#This program displays a list of numbers
#it is a table that seperates the number and their squared value
#This program has also been modified for the user to be able to input the start and end value of the for loop

def main():
    print('This program displays a list of numbers')
    print('(starting at 1) and their squares.')

    start = int(input('Which value should the program start at? '))  #Gets the starting value
    end = int(input('Which value should the program end at? '))	#Gets the ending limit	

    print()
    print('Number\tSquare')     #labels for the start of the table
    print('------------------')
    for number in range(start, end+1):
        #The end of the range is 'end+1' because it will not include the value the user inputted unless we add +1
        #For example, if the user enters 5 as the highest value, if the range was range(1, end), then the program would only show us the squares from 1 to 4 only and not including 5. 

        square = number**2
        print(number, '\t', square, sep = '')

#Call the main function
main()
