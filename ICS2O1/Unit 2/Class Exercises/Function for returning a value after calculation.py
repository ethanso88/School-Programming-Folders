#This program will have a function
#That function will accpet 2 values and return its quotient, product, and power

def math():
    #input
    num1 = int(input('Enter your first number: '))
    num2 = int(input('Enter your second number: '))

    #calculation
    quotient = num1/num2
    product = num1 * num2
    power = num1**num2

    #output
    print('The quotient, product, and power is:\n', int(quotient), '\n', product, '\n', power, sep = '')

#call the function
math()
