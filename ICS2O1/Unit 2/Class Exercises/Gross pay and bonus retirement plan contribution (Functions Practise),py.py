#This program will take the gross pay and bonuses and then calculate the contribution of it
#towards retirement plan savings (5%)
#It will display the contribution of each at the end.

def main():
    intro()
    #intro user greeting telling about the program
    
    gross_pay = float(input('Enter Gross Pay: '))
    bonuses = float(input('Enter Bonuses: '))

    contribution(gross_pay, bonuses)
    #contribution function to calculate and display the answer

def intro():
    input('This program calculates the amount of money contributed towards a retirement plan\n' \
          "It will calculate 5% of a year's gross pay and bonuses that the user inputted and display them at the end")

def contribution(gross_pay, bonuses):
    contribution_rate = 0.05
    
    retirement1 = gross_pay * contribution_rate
    retirement2 = bonuses * contribution_rate

    print('The retirement amount from gross pay is:', format(retirement1, '.2f'))
    print('The retirement amount from bonuses is:', format(retirement2, '.2f'))

main()
