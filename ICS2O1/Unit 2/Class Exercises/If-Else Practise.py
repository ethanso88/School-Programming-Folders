#This program will calculate an employee's gorss pay including overtime wages
#Overtime is when the employee has worked more than 40 hours in a week and
#will get the ovetime rate at 1.5x pay per hour over 40 hours

def main():
    #inputs
    hours = int(input('How many hours did you work? '))
    rate = int(input('What is the hourly pay rate? '))

    if hours > 40:
        #overtime calculations
        ot_cal(hours, rate)
    else:
        #regular calculations 
        reg_cal(hours, rate)

def ot_cal(hours, rate):
    #overtime hours  
    ot_hrs = hours - 40

    #calculating regular pay and overtime pay
    gross_pay = 40 * rate + ot_hrs * 1.5 * rate

    print('The gross pay is $', gross_pay, '.', sep = '')

def reg_cal(hours, rate):
    #just calculate normal hours
    #we use hours because hours < 40 is a possibility
    gross_pay = hours * rate

    print('The gross pay is $', gross_pay, '.', sep = '')

#remember to call main function
main()
