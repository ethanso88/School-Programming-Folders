#This program will calculate the distance for each hour a vehicle has traveled
#based on the number of hours the user inputted and the kph the user has inputted
#It will display the output using a table and a for loop
#formula: distance = speed x time

def main():
    speed = int(input('What is the speed of the vehicle in kph? ')) #speed of the vehicle 
    time = int(input('How many hours has it traveled? ')) #total number of hours the vehicle has traveled

    while speed < 0 or time < 0: #in case the user inputs a negative number
        print('Enter a appropriate speed or time')
        speed = int(input('What is the speed of the vehicle in kph? '))  
        time = int(input('How many hours has it traveled? '))

    print()
    print('Hour', '\t', 'Distance Traveled') #the table header 

    for x in range(1, time + 1):
        distance = x * speed #calculate the distance for each hour
        print(x, '\t', distance) #print the hour number and the distance each time

main()
        
