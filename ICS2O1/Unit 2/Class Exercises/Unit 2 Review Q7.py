#This program will take 2 values and output the
#sum, difference, and product in that order

def main():
    #inputs
    num1 = int(input('Enter the first number: '))
    num2 = int(input('Enter the second number: '))

    #to calculate the sum, difference and product
    calculations(num1, num2)

def calculations(num1, num2):
    #sum calculations
    sum = num1 + num2

    #difference calculations
    diff = num1 - num2

    #product
    product = num1 * num2

    print('The sum is', sum, ', the difference is', diff, \
          'and the product is', product)

main()
