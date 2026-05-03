import tkinter
import tkinter.messagebox

#This program will demonstrate how to create a new window from the root

def main():
    #Create root window
    window = tkinter.Tk()
    window.title("Main Window: Toplevel Window Demo") #This sets the title of the window
    window.geometry("500x400") #This allows me to adjust the size of my window
    
    label = tkinter.Label(window, text = "This is the main window!", font = 50)
    label.pack()

    def toplevel(): #remeber to put this function before the button
        #Create the toplevel window
        toplvlWindow = tkinter.Toplevel()
        toplvlWindow.geometry("300x300")
        toplvlWindow.title("Toplevel Window")
        #add widgets to the toplvlWindow
        toplvlLabel = tkinter.Label(toplvlWindow, text = "This is a toplevel window", font = 30)

        toplvlLabel.pack()
        toplvlWindow.mainloop() #also enter into mainloop

    button = tkinter.Button(window, text = "Open a new window", font = 30, command = toplevel)
    button.pack(side = "bottom")
    

    #Enter into the mainloop
    tkinter.mainloop()

main()
