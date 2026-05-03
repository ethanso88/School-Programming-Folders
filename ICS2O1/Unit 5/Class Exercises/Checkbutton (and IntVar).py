#This program will demonstrate how to use Checkbuttons
import tkinter
import tkinter.messagebox

def main():
    #create root window
    window = tkinter.Tk()

    #Create two frames -- one will be for the Checkbuttons
    #the other will be for the regular Button widgets
    topFrame = tkinter.Frame(window)
    bottomFrame = tkinter.Frame(window)

    topFrame.pack()
    bottomFrame.pack()

    #Create the three IntVar Objects we will associate with the three Checkbuttons we will use
    cbVar1 = tkinter.IntVar()
    cbVar2 = tkinter.IntVar()
    cbVar3 = tkinter.IntVar()

    #set the IntVar object to have an initial value of 0 because we don't know what the user will pick first
    cbVar1.set(0)
    cbVar2.set(0)
    cbVar3.set(0)
    #Checkbuttons can only have a value of 1 or 0 so setting it to 0 means it will be "off"
    
    #create the Checkbutton widget in the topFrame
    #You don't need a value = 1,2,3 because a checkbutton can only have a value of 1 or 0
    cb1 = tkinter.Checkbutton(topFrame, text = 'Pizza', font = 25, variable = cbVar1)
    
    cb2 = tkinter.Checkbutton(topFrame, text = 'Burger', font = 25, variable = cbVar2)

    cb3 = tkinter.Checkbutton(topFrame, text = 'Shawarma', font = 25, variable = cbVar3)

    cb1.pack()
    cb2.pack()
    cb3.pack()


    #This is the call back function for when the user click "OK" after selecting the option
    #Needs to be made before the regular buttons so it can be used by the regular buttons
    def showChoice():
        #create a message string
        message = "You selected:\n"

        #Determine which Checkbuttons are selected and build our message
        #based on the user choice(s)
        if cbVar1.get()==1:
            message = message + "1\n"
        if cbVar2.get()==1:
            message = message + "2\n"
        if cbVar3.get()==1:
            message = message + "3\n"
            
        #now we can actually create the dialog box
        tkinter.messagebox.showinfo("Food Selection", message)

    #Create buttons now and put it on the bottomFrame
    okayButton = tkinter.Button(bottomFrame, text = "OK", font = 25, command = showChoice)

    quitButton = tkinter.Button(bottomFrame, text = "Quit", font = 25, command = window.destroy)

    okayButton.pack(side = 'left')
    quitButton.pack(side = 'left')


    #Enter the tkinter mainloop
    tkinter.mainloop()

main()

