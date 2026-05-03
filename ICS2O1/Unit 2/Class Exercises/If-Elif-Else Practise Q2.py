#This program will ask the user to input two numbers
#The program will then take these numbers and display which of them is larger
#The program will also be able to tell if the numbers are equal

def main():
    intro()
    
    #inputs
    num1 = int(input('What is the first number? '))
    num2 = int(input('What is the second number? '))

    choice(num1, num2)

def intro():
    #this will be the intro for the user
    input('This program will take two numbers and output which of them is greater ' \
          'or if they are equal.\n' \
          'Press enter to continue...')

def choice(num1, num2):
    #will have three lines
    #one to find out if the first is greater one to find out if the second is greater
    #and the third if they are equal
    
    if num1 > num2:
        print(num1, 'is larger than', num2)

    elif num2 > num1:
        print(num2, 'is larger than', num1)

    else:
        print(num1, 'and', num2, 'are equal')

main()
