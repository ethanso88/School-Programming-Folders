#This program takes the user's input of the radius
#and then calculates the volume of a sphere

def main():
    intro()
    #explanation for the user

    #input
    radius = int(input('Enter the radius: '))

    calculation(radius)
    #calculation and output

def intro():
    input('This program will calulate the volume of a sphere after the radius is inputted\n' \
          'Please press Enter to continue...')

def calculation(radius):
    volume = (4/3) * 3.14 * (radius**3)

    print('The volume of the sphere is', format(volume, '.2f'))

main()
#remember this
    
