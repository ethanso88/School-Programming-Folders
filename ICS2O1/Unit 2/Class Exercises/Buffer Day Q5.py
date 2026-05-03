#This program will accept 3 values
#Return its quotient and sum
#and contain at least 2 functions

def main():
    #function 1
    #three values
    num1 = int(input('Enter number 1: '))
    num2 = int(input('Enter number 2: '))
    num3 = int(input('Enter number 3: '))

    calculate(num1, num2, num3)
    #function 2

def calculate(num1, num2, num3):
    quotient = num1/num2/num3

    sum = num1 + num2 + num3

    print('The quotient is', format(quotient, '.2f'), 'and the sum is', sum)

main()
#call the main function
