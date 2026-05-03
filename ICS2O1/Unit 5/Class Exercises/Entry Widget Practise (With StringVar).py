#We are going to modify the kilometer converter 
#so that the output will be in a label and not on an info dialog box
#We will be using the String Variable Object to do this

import tkinter

def main():
    #create root window
    window = tkinter.Tk()
    
    #Create our three frames
    topFrame = tkinter.Frame(window)
    midFrame = tkinter.Frame(window)
    bottomFrame = tkinter.Frame(window)

    #Pack frames
    topFrame.pack()
    midFrame.pack()
    bottomFrame.pack()

    #Creaes the widgets to be attached to the topFrame
    #First we need a label to prompt the user
    Label = tkinter.Label(topFrame, text = "Enter the distance in kilometers", font = 25)

    #Next, we create the entry widget for the user
    kilometerEntry = tkinter.Entry(topFrame, width = 15, font = 25)

    #Remember to pack all the topFrame widgets
    Label.pack(side = 'left')
    kilometerEntry.pack(side = 'left')

    #Create two labels for the midFrame
    descriptionLabel = tkinter.Label(midFrame, text = "Converted to miles: ", font = 25)
    #Create the StringVar Object
    value = tkinter.StringVar()
    #Create the second label and associate it with the StringVar
    #Object so that, any value that is stored in this StringVar Object will be displayed in the label
    milesLabel = tkinter.Label(midFrame, textvariable = value, font = 25) #its textvarable because its equal to the StringVar Object

    #pack the midFrame widgets
    descriptionLabel.pack(side = 'left')
    milesLabel.pack(side = 'left')

    #Define the callback function first before creating the convert button which 
    #will be responsible for calculating and converting the given kilometers to the miles
    def convert():
        #Get the value entered by the user using the .get() function
        kilometers = float(kilometerEntry.get()) #This retrieves the data

        #convert km to m
        miles = kilometers * 0.6214
        miles = format(miles, '.2f')

        #Display the results in the milesLabel widget
        value.set(miles)
        #sets the value variable to the value of the miles variable
        
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
