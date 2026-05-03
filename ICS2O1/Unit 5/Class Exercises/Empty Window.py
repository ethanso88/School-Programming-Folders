import tkinter as tk
#will replace the first tkinter.something to just tk.something 

#This program demonstrates how to creat an
#empty windw using Tkinter on Python

#This is necessary for creating a root window
#all GUI application require you to create a root window

def main():
    mainWindow = tk.Tk()
    #Tk() Displays the root window and manages all other components of the application. Can initialize it by assigning a variable to it

    #changes the title of the window using a widget
    #this adds the title to the root window
    #this won't work without the root window
    mainWindow.title("My First Program")
    
    #Enter the mainloop so the program can run
    tk.mainloop()
    #Allows for the window to keep running until the user chooses to close it. You’ll notice no other code is accepted in the shell.
    

main()
