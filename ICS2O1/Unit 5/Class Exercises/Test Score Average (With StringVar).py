#This program will take three inputs of test values and then calculate the average
#This program will be in a GUI
#The output will be as an output field using a label
import tkinter as tk

def main():
    #root window
    window = tk.Tk()

    #create frames
    test1_frame = tk.Frame(window)
    test2_frame = tk.Frame(window)
    test3_frame = tk.Frame(window)
    avg_frame = tk.Frame(window)
    button_frame = tk.Frame(window)

    #pack frames
    test1_frame.pack()
    test2_frame.pack()
    test3_frame.pack()
    avg_frame.pack()
    button_frame.pack()


    #test1 frame
    label1 = tk.Label(test1_frame, text = "Enter the score for test 1:", font = 25)
    entry1 = tk.Entry(test1_frame, width = 15, font = 25)

    #pack
    label1.pack(side = 'left')
    entry1.pack(side = 'left')

    
    #test2frame
    label2 = tk.Label(test2_frame, text = "Enter the score for test 2:", font = 25)
    entry2 = tk.Entry(test2_frame, width = 15, font = 25)

    #pack
    label2.pack(side = 'left')
    entry2.pack(side = 'left')


    #test3 frame
    label3 = tk.Label(test3_frame, text = "Enter the score for test 3:", font = 25)
    entry3 = tk.Entry(test3_frame, width = 15, font = 25)

    #pack
    label3.pack(side = 'left')
    entry3.pack(side = 'left')


    #avg frame
    descriptionLabel = tk.Label(avg_frame, text = "Average: ", font = 25)
    #StringVar Object
    value = tk.StringVar()
    #Create the second label and associate it with the StringVar Object
    #so that, any value that is stored in this StringVar Object will be displayed in the label
    averageLabel = tk.Label(avg_frame, textvariable = value, font = 25) #its textvarable because its equal to the StringVar Object

    #pack
    descriptionLabel.pack(side = 'left')
    averageLabel.pack(side = 'left')


    #Define the callback function first before creating the Average button which 
    #will be responsible for calculating the average 
    def calculate():
        #Get the values entered by the user using the .get() function
        test1 = float(entry1.get()) #retrieves the data
        test2 = float(entry2.get())
        test3 = float(entry3.get())

        #calculate average
        average = (test1 + test2 + test3)/3
        average = format(average, '.2f')

        #Display the results in the averageLabel widget
        value.set(average)
        #sets the value variable to the value of the average variable

    
    #Create the buttons in the button frame
        #note: the calculate callback function does not have the parentheses ()
    calculateButton = tk.Button(button_frame, text = "Average", font = 25, command = calculate)
    quitButton = tk.Button(button_frame, text = 'Quit', font = 25, command = window.destroy)

    calculateButton.pack(side = 'left')
    quitButton.pack(side = 'left')

    #Enter into the mainloop
    tk.mainloop()

main()

    




    



        
