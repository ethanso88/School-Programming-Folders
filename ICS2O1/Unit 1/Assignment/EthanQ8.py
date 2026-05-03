#This program will ask for the base length and hiegh of a right angle triangle
#It will then calculate the area and perimeter and output the results

#Input
base_length = int(input('Enter the base length of the triangle: '))
height = int(input('Enter the height of the triangle: '))

#calculations
area = (base_length * height)/2

c = (base_length**2) + (height**2)

hypotenuse = c**0.5

perimeter = base_length + height + hypotenuse

#Output 
print('The perimeter is:', perimeter, '\n' \
      'The area is:', area)

