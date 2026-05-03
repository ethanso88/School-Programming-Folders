#This program will displays a table of speeds in KPH with their values converted to MPH

def main():
    #this will be the top starting labels for the table 
    print('KPH\tMPH')

    #the starting value of the loop
    start = 60

    #the ending value of the loop (will go up to this value but not include it which is why it is 131 and not 130)
    end = 131

    #the increment between the values
    #each number in the sequence will increase by this increment (or step value)
    increment = 10

    #the start, end, and increment will be put in the range function and will do how they are described if put in that order

    for kph in range(start, end, increment):
        #range can also be written like: range(60, 131, 10)
        mph = kph * 0.6214

        #kph first, tap to format it like a table, and the format function for mph so it is only 1 decimal place, and also the sep so it will be aligned in the table
        print(kph, '\t', format(mph, '.1f'), sep = '')

main()
