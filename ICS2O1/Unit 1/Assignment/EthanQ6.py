#This program ask for the user for their name, age and the current year
#It then greets the user and tells them the year they were born

#input
name = input('What is your name? ')
age = int(input('How old will you be this year? '))
#the age input is written like this to accurately get the birth year in the output
current_year = int(input('What is the current year? '))

#calculations
birth_year = current_year - age

#output
print('Hello', name, 'you were born in the year', birth_year)
