#This program will calculate retail prices using a while loop
#the formula is: retail price = wholesale cost * 2.5
#This program will also use an input validation loop

def main():

    #the control variable for the while loop
    control = input('Do you want to calculate the retail price for a wholesale cost of a product? ')

    while control == 'yes' or control == 'Yes' or control == 'Y' or control == 'y':
        #find the wholesale cost 
        wholesale = float(input('Enter the wholesale cost: '))

        while wholesale <= 0:   #This is the nested loop for input validation.
            #it doesn't make sense for the wholesale cost to be 0 or less
            
            print('Error. Please input a value that is greater than zero')

            wholesale = float(input('Enter an appropriate wholesale cost: '))
        
        #calculation
        retail = wholesale * 2.5

        #output
        print('Retail price: $', retail, sep = '')

        #another control to decide if the loop wil continue or end
        control = input('Do you want to calculate another retail price for a wholesale cost of a product? ')

main()

#remember that input validations work best for while loops because while loops are condition controlled
