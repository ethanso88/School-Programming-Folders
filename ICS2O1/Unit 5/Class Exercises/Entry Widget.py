#This program will allow the user to enter a diatance in kilometers into
#an Entry widget and then click a button to see that distance converted to miles
#The result will be displayed into an info dialog box
#Miles = Kilometers x 0.6214

import tkinter as tk
import tkinter.messagebox

def main():
    #create root window
    window = tk.Tk()
    
    #Create our two frames
    topFrame = tkinter.Frame(window)
    bottomFrame = tkinter.Frame(window)

    #Pack frames
    topFrame.pack()
    bottomFrame.pack()

    #Creaes the widgets to be attached to the topFrame
    #First we need a label to prompt the user
    Label = tkinter.Label(topFrame, text = "Enter the distance in kilometers", font = 25)

    #Next, we create the entry widget for the user
    kilometerEntry = tkinter.Entry(topFrame, width = 15, font = 25)

    #Remember to pack all the topFrame widgets
    Label.pack(side = 'left')
    kilometerEntry.pack(side = 'left')

    #Define the callback function first before creating the convert button which 
    #will be responsible for calculating and converting the given kilometers to the miles
    def convert():
        #Get the value entered by the user using the .get() function
        kilometers = float(kilometerEntry.get()) #This retrieves the data

        #convert km to m
        miles = kilometers * 0.6214
        miles = format(miles, '.2f')

        #put the results in an info dialog box
        tkinter.messagebox.showinfo("Conversion Result", str(kilometers) + " kilometers is equal to " + str(miles) + " miles")
        #you can only use strings in the info dialog box

    #Now I can create the buttons
        #note: the convert callback function does not have the parentheses ()
    convertButton = tkinter.Button(bottomFrame, text = 'Convert', font = 25, command = convert)

    quitButton = tkinter.Button(bottomFrame, text = 'Quit', font = 25, command = window.destroy)

    #pack the buttons
    convertButton.pack(side = 'left')
    quitButton.pack(side = 'left')

    #Enter into the tkinter mainloop
    tkinter.mainloop()

main()
