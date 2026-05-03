#This program will convert kilometers into miles from the input of the user

def main():
    #input
    km = int(input('Enter the number of kilometers: '))

    conversion(km)

def conversion(km):
    #conversion calculation
    miles = km * 0.6214

    #output
    print(km, 'kilometers in miles is', format(miles, '.4f'), 'miles')

main()
