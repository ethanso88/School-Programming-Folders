#This program will contain a function within a function
#pass an argument between functions
#and contain a global constant

#global constant
HELLO = 'hello there'

def main():
    print('This is a statement')
    
    value = 7

    print('This is a value', value)
    
    print('We will now move to the next function with the value')

    message(value = 77)

    print('This program is now finished and the value in the main is', value)

def message(value):
    print('I changed the value to', value)

main()
#Don't forget
