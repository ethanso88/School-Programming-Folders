#This program will determine if a customer will qualify for a loan
#The customer will input their salary and how long they've been employed
#The program will then use this information to find out if they qualify and then display the output

def main():
    #inputs
    salary = int(input('How much do you make per year? '))
    work = int(input('How long have you been employed (in years)? '))

    #have a separate choice function
    choice(salary, work)

def choice(salary, work):

    #if the salary is equal to or greater than 30000
    if salary >= 30000:

        #another if function to find out if they have more than 30000 salary
        #and if they have 2 years of employment
        if work >= 2:
            print('You are qualified for the loan!')

        else:
            print('Sorry but you must have been employed for 2 years to be qualified for a loan')
            
    else:
        print('Sorry but you must earn at least $30000 per year to qualify for the loan')

main()
#call main function
