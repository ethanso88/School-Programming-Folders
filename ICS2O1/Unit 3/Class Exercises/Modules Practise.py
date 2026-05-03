#Importing the data of the modules that I created
#These modules are in the same folder as this file and are also python files

import circle
import rectangle

print('The area of a circle with a radius of 4cm is', circle.area(4))
#This is the output that also contains the area function in the circle module
#It is calling on the area function
#The area function has a parameter in the circle.py file which is radius and it will give radius the value of 4 that we inputted

print('The area of a rectangle with a length of 8cm and width of 4cm is', rectangle.area(8, 4))
#This does the same thing as the previous print function except for the rectangle module 

print('The perimeter of a rectangle with a length of 1cm and width of 2cm is', rectangle.perimeter(1, 2))

print('The circumference of a circle with a radius of 3cm is', circle.circumference(3))
