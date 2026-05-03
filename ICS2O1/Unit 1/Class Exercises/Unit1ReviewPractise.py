#Questions 1, 2, and 3 are on the unit 1 review document but do not require code as an answer


#Question 4 on the document

print('Name', 'Is', 'James', sep = '**')


#Question 5
print('----------new program----------')

num = 458.541315

print(format(num, '.2f'))


#Question 6
print('----------new program----------')

name = input('What is your name? ')
age = input('What is your age? ')
address = input('What is your address? ')

print('Your name is', name, ', your age is', age \
      ,'and your address is', address)


#Question 7
print('----------new program----------')

#This program will calculate the area and perimeter of any rectangle
#with the given dimensions that it will ask for

#inputs
length = int(input('What is the length of the rectangle? '))
width = int(input('What is the width of the rectangle? '))

#calculations
area = length * width
perimeter = (2 * length) + (2 * width)

print(area, perimeter)


#Question 8
print('----------new program----------')

print('"To be or not to be, that is the question."')


#Question 9
print('----------new program----------')

#Program to calculate the monthly phone bill

#input
minutes = int(input('How many minutes do you long distance call? '))

#Calculations
monthly_rate = 27
total = 27 + minutes * 0.55

#Output
print('Your total monthly phone bill will be $', total, '.', sep = '')


