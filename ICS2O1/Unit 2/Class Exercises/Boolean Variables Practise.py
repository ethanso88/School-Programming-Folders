#Serendipity booksellers has a book club that awards points to its
#customers based on the number of books purchased
#If a customer purchases 0 books, they earn 0 points.								
#If a customer purchases 2 books,  they earn  5 points.
#If a customer purchases 3 books,  they earn 15 points.
#If a customer purchases 4 books,  they earn 30 points.
#If a customer purchases 5 or more books,  they earn  60 points.

#This program asks the user to enter the number of books
#that they purchased this month and displays the number of points awarded

def main():
    print('This program will tell you how many points you earned\n' \
          'after you input the number of books purchased this month')

    books = int(input('How many books did you buy this month? '))

    user_input_validation(books)
    
    points_reward(books)

def user_input_validation(books):
    if books < 0:
        print('Sorry that input is invalid, please input a value greater or equal to 0')

    else:
        print('You are awarded: ')

def points_reward(books):

    if books <= 1 and books >= 0:
        print('0 points.')

    elif books == 2:
        print('5 points.')

    elif books == 3:
        print('15 points.')

    elif books == 4:
        print('30 points.')

    elif books >= 5:
        #this is elif and not else because it will print 60 points if the inputted number of books is negative
        print('60 points!')

main()
