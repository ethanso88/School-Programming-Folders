#This program creates labels in two different frames
import tkinter

def main():
    #create the window
    window = tkinter.Tk()
    
    #create two frames (one for the top thero ther for the bottom)
    topFrame = tkinter.Frame(window, relief = "groove", borderwidth = 1)
    bottomFrame = tkinter.Frame(window, relief = "raised", borderwidth = 1)
    #assign a variable to a frame for the window

    #create three labels for the topFrame
    label_1 = tkinter.Label(topFrame, text = "Winken", font = 25)
    label_2 = tkinter.Label(topFrame, text = "Blinken", font = 25)
    label_3 = tkinter.Label(topFrame, text = "Nod", font = 25)

    #pack all three labels in the topFrame
    label_1.pack(side = "top")
    label_2.pack(side = "top")
    label_3.pack(side = "top")

    #create three labels for the bottomFrame
    label_4 = tkinter.Label(bottomFrame, text = "Winken", font = 25)
    label_5 = tkinter.Label(bottomFrame, text = "Blinken", font = 25)
    label_6 = tkinter.Label(bottomFrame, text = "Nod", font = 25)

    #pack all three labels in the bottomFrame
    label_4.pack(side = "left")
    label_5.pack(side = "left")
    label_6.pack(side = "left")
    
    #remember to pack the frames too!
    topFrame.pack()
    bottomFrame.pack()

    #enter into the mainloop
    tkinter.mainloop()
main()
