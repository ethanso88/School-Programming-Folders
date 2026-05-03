#This program will calculate monthly sales tax for retail companies
#It will ask for an input of sales from the user
#It will then calculate the state and county sales tax
#It will display the state, county and then the stae and county tax combined at the end

#The main function will have the intro for the user
#The calculations
#and the output

#Global variables
STATE_TAX_RATE = 0.04
COUNTY_TAX_RATE = 0.02

def main():
    intro()
    #the intro will tell the user what the program does

    #we need our input of sales
    sales = int(input('Enter the total sales of the month: '))

    tax(sales)
    #to calculate the tax
    #passes the argument (sales) to the function

def intro():
    #The intro will explain what the program does to the user
    input('This program will calculate the monthly sales tax after inputting the total monthly sales\n' \
          'It will calculate the state tax and county tax individually and combined\n' \
          'Please press Enter to continue...')

def tax(sales):
    #calculations
    county_tax = sales * COUNTY_TAX_RATE
    state_tax = sales * STATE_TAX_RATE
    combined_tax = state_tax + county_tax
    
    #output
    print('The state tax is', format(state_tax, '.2f'), '\n' \
          'The county tax is', format(county_tax, '.2f'), '\n' \
          'The combined tax is', format(combined_tax, '.2f'))

#calling the main function
main()
          
