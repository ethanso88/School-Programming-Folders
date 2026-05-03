#This is the program for question 3 by Ethan So
#This program will ask for the user's age
#It will then determine the common age name based on the input (ex: "you are a teen")
#If the user is 12 and under it will output "You are a child"
#For 13 to 19 - "You are a teen"
#For 20 to 64 - "You are an adult"
#And 65 and older - "You are a senior citizen"

def main():
    #input
    age = int(input('How old are you? '))

    #function for output
    output(age)

def output(age):
    #child
    if age <= 12 and age >= 0:
        print('You are a child.')

    #teen
    elif age >= 13 and age <= 19:
        print('You are a teen.')

    #adult
    elif age >= 20 and age <= 64:
        print('You are an adult.')

    #Senior citizen
    elif age >= 65:
        print('You are a senior citizen.')

    else:
        print('You have not inputted an number that can be an age, please input a positive number')

main()
    
