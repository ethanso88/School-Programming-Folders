#This program will contain a function that prints the days of the week in new lines

def days_of_the_week():
    #Defines the function
    print('Monday')
    print('Tuesday')
    print('Wednesday')
    print('Thursday')
    print('Friday')
    print('Saturday')
    print('Sunday')
    #The function when called/excuted will then print the days individually on new lines 

days_of_the_week()
#calling the function

print('----------new program----------')

#This program will have a function that calls on another function

def main():
    #Defining the main function
    print('Welcome')
    message()
    #calling on another function in the function
    print('Goodbye')

def message():
    #have to define the other function in the main function
    print('I hope you had or are having a great day!')

main()
#call on the main function or else there will be no output
#when the function excecutes it will print welcome and then call on the other function
#the it will go to the other function, call/excecute it and then return back to where it was in the main function at message()
#the main function will continue and then end

print('----------new program----------')

#This program will ask the users for their names and then display a personalized greeting
def names():
    #defining the function

    #inputs
    name1 = int(input("Enter first name here: "))
    name2 = int(input("Enter second name here: "))
    name3 = int(input("Enter third name here: "))

    #output
    print("Hello ", name1, ', ', name2,' and ', name3, ". Nice to meet you.", sep = '')

names()
#rememeber to call it
