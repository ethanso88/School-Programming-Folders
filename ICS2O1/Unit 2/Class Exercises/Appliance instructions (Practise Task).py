#This program will display instructions for disassembling a dryer appliance
#but it will display them one at a time so the user can press enter to move to the next step

def main():
    #The main function will displays the tasks for a Dryer disassembling company 
    
    #call step1 which will print the first instruction
    step1()

    #input for the enter key to move onto the next step
    input('Press Enter to move to the next step')
    print()
    
    step2()

    input('Press Enter to move to the next step')
    print()
    
    step3()

    input('Press Enter to move to the next step')
    print()

    step4()

def step1():
    #there is a print function in each step with the intructions
    print('Step 1: Unplug the dryer and move it away from the wall')
 
def step2():
    print('Step 2: Remove the six screws from the back of the dryer')

def step3():
    print('Step 3: Remove the Dryers back panel')

def step4():
    print('Step 4: Pull the top of the dryer straight up')

#don't forget to call your main function for the program to run
main()
