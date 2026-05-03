#This program will calculate the amount of commision by asking the user for
#The amount of sales and commssion rate.
#This program will also have a while loop for when the user (or another user) wants to calculate again

def main():
    #create a variable to control the while loop (to set the condition)
    #This also makes sure the loop will start at least once 
    keep_going = 'yes'

    #calculate series of commissions
    while keep_going == 'yes' or keep_going == 'Yes': #This is the condition of the while loop
        #it is tested if it is true the statements below will execute
        #It will start over until the condition that is entered is anything other than yes or Yes
        #When the loop condition is false it will end the loop
        
        #variables for input
        sales = int(input('What is the amount of sales? '))
        commission_rate = float(input('What is the commission rate? '))

        #calculation
        commission = sales * commission_rate

        #output
        print('You have earned $', commission, ' commission', sep = '')

        #To decide if the user wants to loop and calculate anothe commission or if they don't 
        keep_going = input('Do you want to calculate another commission? ')

main()
    
