#This program will keep a running total for the number of bugs collected
#by a bug collector for seven days
#after the loop is finished it will display the final total of the loop

def main():
    total = 0   #accumulator for the running total

    for x in range(1,8):    #variable to control the loop. The loop will have 7 iterations.
        print('Enter the number of bugs collected on day', x, 'below:')
        bugs = int(input()) #input for the number of bugs collected for each day

        total += bugs   #total = total + bugs, to add to the total for each day

    print('The total number of bugs collected is:', total)   #print the final total when the loop ends

main()
        

