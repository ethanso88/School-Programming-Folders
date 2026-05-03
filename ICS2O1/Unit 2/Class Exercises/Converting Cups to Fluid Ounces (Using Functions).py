#This program will convert cups to fluid ounces
#it will display and introductory screen
#and then display the converted amount

def main():
    #the function to run the other functions
    intro()
    #This function will be the intro display
    
    cups = int(input('Enter the number of cups: '))
    #the input for the # of cups

    cups_to_ounces(cups)
    #will pass the argument "cups" so it will go to the cups_to_ounces function instead of it being local to main()
    #An argument is a piece of data that are sent into a function 
    #cups_to_ounces will convert and display the conversion

def intro():
    input('This program will convert cups to fluid ounces\n' \
          'Simply press enter to send the next line that will ask for the # of cups')

def cups_to_ounces(cups):
    #need the "cups" in the brackets so the variable can pass through
    #It is a parameter variable: A special variable that is assigned the value of an argument when a function is called.

    #calculation
    fluid_ounces = cups * 8
    
    print('The converted amount of fluid ounces is:', fluid_ounces)

main()
#call the main function
