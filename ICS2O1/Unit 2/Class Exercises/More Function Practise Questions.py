#f_1 is a funtion that will print hello world
#it also will ask the user to input their name
#and print the name as part of the code

def f_1():
    name = input('What is your name? ')
    print('Hello World! Introducing: ', name, '!', sep = '')

f_1()

#f_2 will ask the user to input the date 
#it will call another function print a story with the date inputted by the user

def f_2():
    date = input('what is the current date? ')
    f_3(date)
    #uses an argument and parameter to have the variable pass through to the next function
    #instead of using a global variable

def f_3(date):
    print('Hello there! The day today is', date, "isn't it?")

f_2()
