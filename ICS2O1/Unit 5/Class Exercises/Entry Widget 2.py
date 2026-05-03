#This program converts fahrenheit to Celsius
#The result will be displayed in an info dialog box
import tkinter as tk
import tkinter.messagebox

def main():
    #create root window
    window = tk.Tk()

    #create two frames 
    topFrame = tk.Frame(window)
    bottomFrame = tk.Frame(window)

    #pack frames
    topFrame.pack()
    bottomFrame.pack()

    #add widgets to topFrame
    promptLabel = tk.Label(topFrame, text = "Enter the temperature in Fahrenheit", font = 25)
    entryFahr = tk.Entry(topFrame, width = 15, font = 25)

    #pack the widgets
    promptLabel.pack(side = 'left')
    entryFahr.pack(side = 'left')

    #create callback function for buttons before creating the buttons and add them to the bottomFrame
    def convert():
        fahrenheit = float(entryFahr.get())
        celsius = (fahrenheit -32)*5/9
        celsius = format(celsius, '.2f')
                
        tkinter.messagebox.showinfo("Conversion Result", str(fahrenheit) + " Fahrenheit is converted to " + str(celsius) + " Celsius.")

    #Create the buttons
        #note: convert callback function won't have the brackets or parentheses
    convertButton = tk.Button(bottomFrame, text = 'Convert', font = 25, command = convert)

    quitButton = tk.Button(bottomFrame, text = 'Quit', font = 25, command = window.destroy)

    #pack the buttons
    convertButton.pack(side = 'left')
    quitButton.pack(side = 'left')

    #Enter into the mainloop
    tk.mainloop()

main()

        
