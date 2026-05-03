#This program demonstrates how to add button widgets
#and how to use a message dialog box
#and how to create a quit button that will destroy the GUI once clicked by the user
import tkinter
import tkinter.messagebox

def main():
    #create root window
    window = tkinter.Tk()

    #create a Button widget
    button = tkinter.Button(window, text = "click me!", font = 30, command = doSomething)
    #doSomething() is the callback function and command is what allows it to happen

    #create a Quit button widget
    quitButton = tkinter.Button(window, text = "Quit", font = 30, command = window.destroy)
    
    #pack the buttons
    button.pack()
    quitButton.pack()

    #enter into the mainloop
    tkinter.mainloop()

def doSomething():
    #I will display information in an info dialog box
    #as the action that happens once the user clicks the button
    #This info dialog box takes TWO arguments--
    #1) is the title of the box
    #2) is the message you want
    #So this is the general format for an infor dialog box
    #tkinter.messagebox.showinfo("title", "message")
    tkinter.messagebox.showinfo("title", "Thanks for clicking the button!")

#call main function
main()
