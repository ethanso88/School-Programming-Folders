#This program will calculate the distance between two points
#It will ask the user for the first point and then the second point

def main():
    intro()
    #explanation to the user

    #inputs
    x1 = int(input('Enter the value of x1: '))
    y1 = int(input('Enter the value of y1: '))
    x2 = int(input('Enter the value of x2: '))
    y2 = int(input('Enter the value of y2: '))

    calculation(x1, y1, x2, y2)
    #to calculate the distance and also display output

def intro():
    input('This program will calculate the distance between two points\n' \
          'after the user inputs the values for (x1,y1) and (x2, y2)\n' \
          'Press Enter to continue...')

def calculation(x1, y1, x2, y2):
    #distance formula
    distance = ((x2 - x1)**2 + (y2 - y1)**2)**0.5

    #output
    print('The distance between the two points is', distance)

main()
