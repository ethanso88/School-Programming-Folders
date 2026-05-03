#Every day, a clerk in the tax office gets a list of properties and has to calculate the tax for each property on the list.
#You’ve been asked to design a program that the clerk can use to perform these calculations.
#Each property is assigned a lot number, and all lot numbers are 1 or greater.
#This means that 0 is the best value for a sentinel value

def main():
    lot = int(input('Enter the lot number: '))
    #get the initial lot number to see if the user wants to run the program
    
    while lot > 0:  #this is the sentinel value if it is 0 or less the loop will end
        #a sentinel value is a value when inputted will cause the loop to end
        #it could also be 'lot != 0' but it will still run with negative lot numbers that way
        
        property_value = int(input('Enter the property value: '))
        #there is a lot number and they have to input the property value
        
        property_tax = property_value * 0.0065
        #the program will calculate the property tax

        print('The property tax is', property_tax)
        #output

        lot = int(input('Enter the lot number: '))
        #see if the program will run again to calculate another lot number

main()

#remember that sentinel values only work with while loops 
