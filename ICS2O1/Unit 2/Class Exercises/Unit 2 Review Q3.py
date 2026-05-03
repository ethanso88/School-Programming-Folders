#this program will ask the user to enter a number and will do many things with that information
#the things it will do with the information: 
#Determines if it’s an even or odd number
#Determines if it is divisible by 3
#Determines if it is divisible by 3 or 5
#Determines if it is divisible by both 3 and 5
#Enter two integers and report which is the smallest

def main():
    number = int(input('Enter an interger here: '))

    #to find out if the number is even or odd
    even_or_odd(number)

    #to find out if the number is divisible by 3
    divide3(number)

    #to find out if the number is divisible by 3 or 5
    divide3or5(number)

    #to find out if the number is divisible by 3 and 5
    divide3and5(number)

    #second number input
    number2 = int(input('Enter another interger here: '))

    #to find out which number is smaller
    smallest(number, number2)

def even_or_odd(number):
    if number % 2 == 0:
        print('The number is even')
    else:
        print('The number is odd')

def divide3(number):
    if number % 3 == 0:
        print('The number is divisible by 3')
    else:
        print('The number is not divisible by 3')

def divide3or5(number):
    if number % 3 == 0 or number % 5 == 0:
        print('The number is divisible by 3 or 5')
    else:
        print('The number is not divisible by 3 or 5')

def divide3and5(number):
    if number % 3 == 0 and number % 5 == 0:
        print('The number is divisible by 3 and 5')
    else:
        print('The number is not divisible by 3 and 5')

def smallest(number, number2):
    if number < number2:
        print('The first number is the smallest')
    elif number2 < number:
        print('The second number is the smallest')
    else:
        print('The numbers are equal and there is no smaller number')

main()
