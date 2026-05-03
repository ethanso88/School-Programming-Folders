#This program will demonstrate how to use percentages in calculations
#This program will take the price of an item
#then calculate the 20% price of the item
#then subtract the discount from the original price and display it

#First we get the input of the price from the user
#We turn the input into a float because it is related to money 
original_price = float(input("How much is the item? "))

#then we find how much the discount is worth
#we will discount everything at 20%
#0.20 = 20%
discount_amount = original_price * 0.20
#calculating the amount left after the discount 
sale_price = original_price - discount_amount

#display the value with print statement
print('Your item with a 20% discount is now', sale_price)

#you can make a custom discount with discount = float(input("How much is the discount in decimal form? ")
#the next calculation would then look like: discount_amount = original_price * discount
