#Ethan So ICS2O1-07

#this program will perform calculations for the equation for kinetic energy
#it will take the inputs for the variables
#and then calculate when all the information is provided

#input for the value of the mass
m = int(input('What is the mass? '))
#input for the value of velocity
v = int(input('What is the velocity? '))

#creating an equation with the inputs to perform a calculation
#1/2 = 0.5
k = 0.5 * m * (v**2)

#display the answer
print(k)
