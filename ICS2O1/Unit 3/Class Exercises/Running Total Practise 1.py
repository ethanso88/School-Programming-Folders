#This program will contain a loop that will ask the user to enter a number each iteration
#The loop will keep a running total of the numbers entered and will print to total
#The loop should iterate 10 times

def main():
    total = 0   #total will start at 0 and then will have values added onto it to be a running total
    #make sure total is outside of the loop or else the loop will reset total to 0 everytime and it can't keep track of a running total
    #this variable is the accumulator variable
    
    for x in range(1, 11):  #the x is just a placeholder variable to have the loop run 10 times or 10 iterations
        #it cannot be the num variable because they are for different things. x is just a loop controlled variable
        num = int(input('Enter a number you would like to add to the total: '))

        total += num    #this is the same as writing total = total + num
        #the total will add onto itself to keep a running total

    print(total) #print the final total when the loop ends

main()
