#This program will be used to get the average of each student's tests scores using nested loops
#The first loop will account for each person in the class and the second loops should account for the number of test score per student

def main():
    #the input for the # of students
    students = int(input('Enter the number of students in the class: '))
    tests = int(input('Enter the number of tests: '))

    #Initialize accumulator value
    total = 0

    #Initialize the total accumulator value 
    total_average = 0
    
    for x in range(1, students + 1):
        for y in range(1, tests + 1):
            #for each student it will calculate the tests average 
            print('Enter the mark for test', y)
            score = int(input())
            total = total + score

        #this is the average of each student
        average = total/tests

        print('The average of student', x, 'is', format(average, '.2f'))

        #this is adding up all of the averages of each student
        total_average = total_average + average

        total = 0

    #This is the average after dividing by the number of students 
    class_average = total_average/students

    print('The class average is', format(class_average, '.2f'))

main()
    
