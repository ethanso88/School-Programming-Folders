#This program will have a window with a button that when clicked
#it tells you a fun fact about yourself
#and a button to quit the program
import tkinter as tk
import tkinter.messagebox

def main():
    #create root window
    window = tk.Tk()
    window.title("Button Practise 1") #title

    #create frame
    frame = tk.Frame(window, relief = "groove", borderwidth = 1)
    #relief just changes the design of the frame
    
    #create label
    label = tk.Label(frame, text = "This frame contains buttons that can be clicked!", font = 30)
    
    #create buttons
    button = tk.Button(frame, text = "Click for a fun fact about me!", font = 30, command = action)
    quitButton = tk.Button(frame, text = "Quit", font = 30, command = window.destroy)

    #pack everything
    frame.pack()
    label.pack(side = "top")
    button.pack(side = "left")
    quitButton.pack(side = "left")

    #enter into mainloop so the window will still run and be open
    tk.mainloop()

def action():
    tk.messagebox.showinfo("Fun Fact!", "Chocolate is my favourite flavour of ice cream")

main()
    
