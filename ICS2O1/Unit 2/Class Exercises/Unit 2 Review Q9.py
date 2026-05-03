#This program will ask for the monthly costs of a car from the user
#It will then calculate the total monthy cost and the total annual cost

def main():
    #inputs
    print('What are the monthly costs for:')
    Loan_payment = int(input('Loan payment: ')) 
    Insurance = int(input('Insurance: ')) 
    Gas = int(input('Gas: ')) 
    Oil = int(input('Oil: ')) 
    Tires = int(input('Tires: ')) 
    Maintenance = int(input('Maintenance: '))

    #calculation
    cost(Loan_payment, Insurance, Gas, Oil, Tires, Maintenance)

def cost(Loan_payment, Insurance, Gas, Oil, Tires, Maintenance):
    #total monthly cost
    monthly = Loan_payment + Insurance + Gas + Oil + Tires + Maintenance

    #total annual cost
    annual = monthly * 12

    #output
    print('The total monthly cost is $', monthly, \
          ' and the total annual cost is $', annual, ' for a car.', sep = '')

main()
