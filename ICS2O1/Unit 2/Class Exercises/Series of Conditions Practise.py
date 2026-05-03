#This program will display the letter grade for
#the inputted score from the user
#Below 60 is an F, 60-69 is a D, 70-79 is a C, 80-89 is a B and 90+ is an A

def main():
    #float typecast because score could be in the decimals
    grade = float(input('What is your test score? '))

    #many nested if-else statements to find out the user's grade
    #each statement checks for the grade until it reaches the right one or the bottom
    #if a number is not greater than 90 then it goes to 80 and then so on
    #this works because it checks for the greatest value and then goes down
    if grade >= 90:
        print('Your letter grade is an A')

    else:
        if grade >= 80:
            print('Your letter grade is a B')

        else:
            if grade >= 70:
                print('Your letter grade is a C')

            else:
                if grade >= 60:
                    print('Your letter grade is a D')

                else:
                    print('Your letter grade is a F')

main()


def alt():
    grade = float(input('What is your test score? '))
    
    if grade >= 90:
        print('Your letter grade is an A')

    elif grade >= 80:
        print('Your letter grade is a B')

    elif grade >= 70:
        print('Your letter grade is a C')

    elif grade >= 60:
        print('Your letter grade is a D')

    else:
        print('Your letter grade is a F')
