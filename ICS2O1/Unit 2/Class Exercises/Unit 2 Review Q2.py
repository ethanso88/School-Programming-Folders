#This program will output the number of days based on the month number
#the user inputs. The user must input a number from 1-12 to be a month.

def main():
    #input
    month = int(input('Enter the month number here (1-12): '))

    days(month)

def days(month):
    #if the months with 31 days print 31 days 
    if month == 1 or month == 3 or month == 5 or month == 7 or month == 8 or month == 10 or month == 12:
        print('That month has 31 days')
    #months with 30 days
    elif month == 4 or month == 6 or month == 9 or month == 11:
        print('That month has 30 days')
    #Feburary
    elif month == 2:
        print('That month is feburary and it has 28 days or 29 days on a leap year')
    #not a usable number
    else:
        print("You didn't enter a usable number for a month pick a number from 1-12")

main()
