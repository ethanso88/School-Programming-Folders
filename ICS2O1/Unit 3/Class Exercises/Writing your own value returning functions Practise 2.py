#There is a retail business where staff work based off of a commission rate
#They get paid once per month and because of this they can get up to $2000 in advance
#When the sales commissions are calculated advanced pay is subtracted from the commission
#If they have borrowed more than they can pay back they have to reimburse the business

#calculation formula for monthly pay: pay = sales x commission rate - advance pay

#Steps in this program
#1. Get the salesperson’s monthly sales
#2. Get the amount of advanced pay
#3. Use the amount of monthly sales to determine the commission rate
#4. Calculate the salesperson’s pay using the formula previously shown. If the amount is negative, indicate that the salesperson must reimburse the company.

def main():
    #get salesperson's monthly sales
    sales = get_sales()

    #get advanced pay
    advance = get_advanced_pay()

    #determinte the commission rate based off of the sales 
    comm_rate = determine_comm_rate(sales)

    #calculation
    calculation(sales, advance, comm_rate)

def get_sales():
    #sales input
    sales = float(input('Enter the monthly sales: '))

    #return the input to the sales variable in the main function
    return sales

def get_advanced_pay():
    #input
    advanced_pay = float(input('Enter the amount of advanced pay received (it can be 0 if none was received): '))

    #return advanced_pay to the advance variable
    return advanced_pay

def determine_comm_rate(sales):
    #The commission rate will differ depending on the sales value

    if sales < 10000:
        #will return a value of 10% to the comm_rate variable in the main function
        return 0.10
    elif sales >= 10000 and sales <= 14999:
        return 0.12
    elif sales >= 15000 and sales <= 17999:
        return 0.14
    elif sales >= 18000 and sales <= 21999:
        return 0.16
    else:
        return 0.18

def calculation(sales, advance, comm_rate):
    pay = sales * comm_rate - advance

    print('Your monthly pay is $', format(pay, '.2f'), sep = '')

    if pay < 0:
        print('The salesperson must reimburse the company')

main()
