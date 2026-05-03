#This program will calculate the average based on the midterm marks of 4 courses
#The user will have to input the information of the marks of the 4 courses
#There will also be a while loop if the user wants to calculate the average again or if another user wants to calculate their average

def main():
    #variable to control the condition
    keep_going = 'yes'
    
    while keep_going == 'yes' or keep_going == 'Yes':
        #calculation function
        calculation()

        #to control the condition if the user wants to calculate this again or not
        keep_going = input('Do you want to calculate another average? ')


def calculation():
    
    #inputs
    course1 = int(input('Enter course1 mark: '))
    course2 = int(input('Enter course2 mark: '))
    course3 = int(input('Enter course3 mark: '))
    course4 = int(input('Enter course4 mark: '))

    #calculating the average
    average = (course1 + course2 + course3 + course4)/4

    print('Your midterm average is', average)

main()
