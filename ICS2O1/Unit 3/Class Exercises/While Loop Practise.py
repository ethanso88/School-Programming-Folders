#A substance has to be constantly heated in a vat
#If the temperature exceeds 102.5 degrees celsius then the technician has to turn down the thermostat
#wait 5 minutes and then check the temperature again
#If not then the technician can check the temperature iagain in 15 minutes
#This program will have a loop to give the technician instructions

def main():
    #input
    temperature = float(input('What is the temperature of the substance (in celsius)? '))

    #the following steps repeat when the temperature is greater than 102.5 degrees celsius 
    while temperature > 102.5:
        #The instructions for the technician to follow 
        print('The temperature is about 102.5 degress celsius take the following actions:\n' \
              '1. Turn down the thermostat\n'
              '2. Wait 5 minutes\n'
              '3. Then check the temperature again')

        #need another input of the temperature for the loop to be controlled
        #without this the loop will continue infinitely
        #need another input for the chance for the loop condition to be false and then end
        temperature = float(input('What is the temperature of the substance (in celsius)? '))

    #for when the while loop ends and the temperature is not greater than 102.5 degress celsius 
    print('The temperature is acceptable and check it again in 15 minutes')

main()
