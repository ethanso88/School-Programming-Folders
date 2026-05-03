#This program will ask the user to input a password
#If the password is the saved password it will output that it has been accepted
#If it is the wrong password it will let the user know that it is wrong

def main():
    #take input
    password = input('What is the password? ')

    #the if for if they got the password right
    if password == 'I am tired':
        print('That is the correct password')

    #the else if they got it wrong
    else:
        print('That was an incorrect password')

main()
