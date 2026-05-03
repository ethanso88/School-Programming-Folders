import tkinter as tk

def main():
    #create root window
    mainWindow = tk.Tk()

    #title widget
    mainWindow.title('5 label practise')

    firstLabel = tk.Label(text = "Hello world")
    firstLabel.pack()
    
    secondLabel = tk.Label(text = "My name is Ethan")
    secondLabel.pack()

    thirdLabel = tk.Label(text = "I am in ICS2O1")
    thirdLabel.pack()
    
    fourthLabel = tk.Label(text = "We are learning about GUIs")
    fourthLabel.pack()
    
    fifthLabel = tk.Label(text = "To do this I've added all of these as labels in my code")
    fifthLabel.pack()

    #Enter mainloop so the program will run
    mainWindow.mainloop()

main() #need main function so the function will run
