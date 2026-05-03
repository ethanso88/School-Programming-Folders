#This program will will take the input of three test scores
#It will then calculate the average
#If they get more than 95 then the program should congratulate them

def main():
    
    #inputs
    test1 = int(input("Enter test 1 score: "))
    test2 = int(input("Enter test 2 score: "))
    test3 = int(input("Enter test 3 score: "))
    
    #calculate the average and display outputs
    #remember that calling functions works like: choice(can enter arguments here)
    choice(test1, test2, test3)
    
def choice(test1, test2, test3):
    #calculate the average from the passed arguments 
    average = (test1 + test2 + test3)/3

    print('Your average mark in the course is', average)
    
    #if average is greater than 95 then it will run the statements below it
    if average > 95:
        print('Congragulations on your high average in the course!')

    #This is extra stuff
    elif average > 80:
        print('You are doing well in the course but you could be doing better!')
    else:
        print('You should improve in the course but you are doing fine.')


main()

    
