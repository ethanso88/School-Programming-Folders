#This program is a GUI program that gives users the average of their marks
import tkinter as tk
import tkinter.messagebox

def main():
    #root window
    window = tk.Tk()

    #frames
    frame1 = tk.Frame(window)
    frame2 = tk.Frame(window)
    frame3 = tk.Frame(window)
    frame4 = tk.Frame(window)
    frame5 = tk.Frame(window)
    
    frame1.pack()
    frame2.pack()
    frame3.pack()
    frame4.pack()
    frame5.pack()

    #frame1 widgets
    label_1 = tk.Label(frame1, text = "Enter first mark", font = 25)
    entry1 = tk.Entry(frame1, width = 15, font = 25)

    label_1.pack(side = 'left')
    entry1.pack(side = 'left')

    #frame2 widgets
    label_2 = tk.Label(frame2, text = "Enter second mark", font = 25)
    entry2 = tk.Entry(frame2, width = 15, font = 25)

    label_2.pack(side = 'left')
    entry2.pack(side = 'left')

    #frame1 widgets
    label_3 = tk.Label(frame3, text = "Enter third mark", font = 25)
    entry3 = tk.Entry(frame3, width = 15, font = 25)

    label_3.pack(side = 'left')
    entry3.pack(side = 'left')

    #frame1 widgets
    label_4 = tk.Label(frame4, text = "Enter fourth mark", font = 25)
    entry4 = tk.Entry(frame4, width = 15, font = 25)

    label_4.pack(side = 'left')
    entry4.pack(side = 'left')

    #convert callback funtion for the buttons
    def calculate():
        mark1 = float(entry1.get())
        mark2 = float(entry2.get())
        mark3 = float(entry3.get())
        mark4 = float(entry4.get())

        average = (mark1 + mark2 + mark3 + mark4)/4
        average = format(average, '.2f')

        tkinter.messagebox.showinfo("Average Result", "Your total average is " + str(average))

    calcButton = tk.Button(frame5, text = "Calculate", font = 25, command = calculate)
    quitButton = tk.Button(frame5, text = 'Quit', font = 25, command = window.destroy)


    calcButton.pack(side = 'left')
    quitButton.pack(side = 'left')
    
    #Enter into the mainloop
    tk.mainloop()

main()
    
