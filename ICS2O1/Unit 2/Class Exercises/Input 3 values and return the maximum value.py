#This program will accept 3 values and will then output the maximum of the 3 numbers

def main():
    #inputs
    num1 = int(input('Enter number 1: '))
    num2 = int(input('Enter number 2: '))
    num3 = int(input('Enter number 3: '))

    if num1 > num2 and num1 > num3:
        print('number 1 is the maximum among all')
    elif num2 > num1 and num2 > num3:
        print('number 2 is the maximum among all')
    elif num3 > num1 and num3 > num2:
        print('number 3 is the maximum among all')
    else:
        print('there is no maximum number')

main()
