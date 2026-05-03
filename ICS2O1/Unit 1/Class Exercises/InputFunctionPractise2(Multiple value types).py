#this next program will show how to use input functions to return
#input value as a different type of value than a string
#this specific example will ask the user for their name, age and income
#it then displays the data that they entered

#the normal input function with the input value as a string
name = input('What is your name? ')

#this input function calls the value from the keyboard
#the value (a string) is passed as an argument to the int function
#the int value from the int function will be the one assigned to the variable (age)
age = int(input('What is your age? '))

#this is the same as the interger example up above except with a float
income = float(input('What is your income? '))

print()
print('Here is the data that you entered:')
print()
print('Name: ', name)
print()
print('Age: ', age)
print()
print('Income: $', income)
