#This program will be a simple calculator with options
#to pick which type of calculation will be done (ex: multiplication)
import tkinter as tk
import tkinter.messagebox

def main():
    #create root window
    window = tk.Tk()
    #window title
    window.title("Simple Calculator")
    #window size
    window.geometry("1000x700") #1000 pixels by 700 pixels


    #create 4 frames
    topFrame = tk.Frame(window) #labels 
    rbFrame = tk.Frame(window) #radiobutton frame
    entryFrame = tk.Frame(window) #place for entry widget
    outputFrame = tk.Frame(window) #where the output will be
    bottomFrame = tk.Frame(window) #where the buttons will be

    topFrame.pack()
    rbFrame.pack()
    entryFrame.pack()
    outputFrame.pack()
    bottomFrame.pack()

    
    #topFrame
    intro1 = tk.Label(topFrame, text = "This is a simple calculator.", \
                     font = ("Arial", 25))
    intro2 = tk.Label(topFrame, text = "It is able to calculate the 4 math operators with 2 numbers.", \
                      font = ("Arial", 25))

    intro1.pack()
    intro2.pack()


    #rbFrame

    #create the IntVar() Object
    radioVar = tk.IntVar()
    #Set the IntVar() Object to be 1--this calls the radioVar's object's set method
    #to store the integer value 1 in the object
    radioVar.set(1) #this just makes it so option 1 of the radiobuttons is selected by default

    #create the Radiobutton widgets to go in the rbFrame
    #the IntVar() radioVar allows for the radiobuttons to store values of 1,2 or 3 into the object when selected 
    rb1 = tk.Radiobutton(rbFrame, text = 'Addition', font = ("Arial",25), variable = radioVar, value = 1)
    
    rb2 = tk.Radiobutton(rbFrame, text = 'Subtraction', font = ("Arial",25), variable = radioVar, value = 2)

    rb3 = tk.Radiobutton(rbFrame, text = 'Multiplication', font = ("Arial",25), variable = radioVar, value = 3)

    rb4 = tk.Radiobutton(rbFrame, text = 'Division', font = ("Arial",25), variable = radioVar, value = 4)

    rb1.pack()
    rb2.pack()
    rb3.pack()
    rb4.pack()


    #entryFrame
    num1 = tk.Label(entryFrame, text = "Num1:", font = ("Arial", 25))
    entry1 = tk.Entry(entryFrame, width = 15, font = 25)
    num2 = tk.Label(entryFrame, text = "Num2:", font = ("Arial", 25))
    entry2 = tk.Entry(entryFrame, width = 15, font = 25)
    
    num1.pack(side = 'left')
    entry1.pack(side = 'left')
    num2.pack(side = 'left')
    entry2.pack(side = 'left')

    
    #outputFrame
    #Create two labels for the output
    descriptionLabel = tkinter.Label(outputFrame, text = "Calculation: ", font = ("Arial", 25))
    #Create the StringVar Object
    value = tkinter.StringVar()
    #Create the second label and associate it with the StringVar
    #Object so that, any value that is stored in this StringVar Object will be displayed in the label
    calcLabel = tkinter.Label(outputFrame, textvariable = value, font = ("Arial", 25)) #its textvarable because its equal to the StringVar Object

    #pack the ouputFrame widgets
    descriptionLabel.pack(side = 'left')
    calcLabel.pack(side = 'left')


    #bottomFrame
    #Create callback function before the buttons
    #This will be responsible for calculating the calculation
    def calculation():
        #different types of calculation depending on radioVar value:

        #addition
        if int(radioVar.get()) == 1:
            calculation = float(entry1.get()) + float(entry2.get())
            value.set(calculation)

        #subtraction
        elif int(radioVar.get()) == 2:
            calculation = float(entry1.get()) - float(entry2.get())
            value.set(calculation)

        #multiplication
        elif int(radioVar.get()) == 3:
            calculation = float(entry1.get()) * float(entry2.get())
            value.set(calculation)

        #division
        elif int(radioVar.get()) == 4:
            calculation = float(entry1.get()) / float(entry2.get())
            value.set(calculation)

    #Now the buttons can be created
        #note: the convert callback function does not have the parentheses ()
    calcButton = tkinter.Button(bottomFrame, text = 'Calculate', font = ("Arial", 25), command = calculation)

    quitButton = tkinter.Button(bottomFrame, text = 'Quit', font = ("Arial", 25), command = window.destroy)

    #pack the buttons
    calcButton.pack(side = 'left')
    quitButton.pack(side = 'left')

  #Enter into the tkinter mainloop
    tkinter.mainloop()

main()








    
