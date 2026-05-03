#This is the program for question 2 by Ethan So
#This program will determine which of three numbers the user inputs is that largest
#It will ask the user to input 3 numbers

def main():
    #brief description for the user
    print('This program will output the largest of three numbers inputted')
    
    #inputs for the three numbers 
    x = int(input('Enter the first number: '))
    y = int(input('Enter the second number: '))
    z = int(input('Enter the third number: '))

    #function to find the largest

    largest(x, y, z)

def largest(x, y, z):

    #if the first number is the largest
    if x > y and x > z:
        print('The first number is the largest number')

    #if the second number is the largest since x would be smaller than 1 of them
    elif y > x and y > z:
        print('The second number is the largest number')

    #if the last number is the largest
    elif z > x and z > y:
        print('The third number is the largest number')

    #the next three are if two numbers are the largest
    elif x == y and x > z:
        print('The first and second numbers are the largest')

    elif x == z and x > y:
        print('The first and third numbers are the largest')

    elif y == z and y > x:
        print('The second and third numbers are the largest')
    
    #if all of them are the same value
    else:
        print('All numbers have the same value so there is no largest number')

main()
