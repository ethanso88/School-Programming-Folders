import tkinter

def main():
    #create the root window 
    mainWindow = tkinter.Tk()

    #add title widget
    mainWindow.title('Simple Label')

    #create the label
    simpleLabel = tkinter.Label(text = "This is a label")

    #After we create the label
    #We have to pack the label
    simpleLabel.pack() #pack will automatically put the label in the middle if there is no argument in the brackets 

    moreComplexLabel = tkinter.Label(text = "This is another label", \
                                     fg = "#17cae6", \
                                     bg = "Black", \
                                     height = 10, \
                                     width = 20, \
                                     font = ('Arial', 25, 'bold'))
    moreComplexLabel.pack(side = 'bottom') #this will make the label at the bottom

    thirdLabel = tkinter.Label(text = "This is my third label", \
                               fg = "#CC7FDB", \
                               bg = "Blue", \
                               height = 10, \
                               width = 20, \
                               font = 20)
    thirdLabel.pack(side = 'right')
    
    #Enter the window so the program can run
    tkinter.mainloop()

main()
