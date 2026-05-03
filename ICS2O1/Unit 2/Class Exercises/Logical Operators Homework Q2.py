#This program that tells users whether they are eligible for an after school program
#Only students aged 12-18 are eligible to be part of the afterschool program

def main():
    #information for the user
    print('This program will tell you if you are eligible to be part of the afterschool program\n' \
          'You will have to input your age to find out if you are eligible')

    #input
    age = int(input('What is your age? '))

    eligible(age)

def eligible(age):
    if age >= 12 and age <=18:
        #if 12, 18 or between 12 and 18 then are eligible
        print('You are eligible for the afterschool program')

    else:
        #if not then not eligible
        print('You not are eligible for the afterschool program')

main()
