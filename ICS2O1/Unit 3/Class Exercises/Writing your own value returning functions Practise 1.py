#This program will calculate a retail item’s sales price with 20 percent off discount.
#It will ask the user for the regular price and output the sales price.

def main():
    #retail will take the value of retail_price
    retail = price()

    #calculate the discount
    #discount will take the value of the discounted_price
    discount = calculation(retail)

    #output
    print("The discounted sales price is", discount)

def price():
    #input
    retail_price = float(input('Enter the regular price of the item: '))

    #returning the value of retail_price to the main function
    return retail_price

    
def calculation(retail):
    #calculation
    discounted_price = retail*0.8

    #return discounted_price
    return discounted_price

main()
