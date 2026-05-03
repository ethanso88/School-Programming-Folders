import tkinter
import tkinter.messagebox

#Create your own program with a dropdown menu that allows the user to select their name from the menu and when selected a messagebox shows up with their name on it. 
#There will be another menu item that says “Open” and opens a new window


def main():
    #root window
    window = tkinter.Tk()
    window.title("Window Consolidation")
    window.geometry("500x400")

    def Ethan():
        tkinter.messagebox.showinfo("Ethan", "Ethan")

    def open1():
        toplvlWindow = tkinter.Toplevel()
        toplvlWindow.geometry("300x300")
        toplvlWindow.title("New Window")

        toplvlLabel = tkinter.Label(toplvlWindow, text = "This is a new window", font = 30)
        toplvlLabel.pack()

        button = tkinter.Button(toplvlWindow, text = "Exit", font = 30, command = toplvlWindow.destroy) 
        button.pack()
        
        toplvlWindow.mainloop() #also enter into mainloop

    #menubar
    menubar = tkinter.Menu(window)

    #menu
    fileMenu = tkinter.Menu(menubar, tearoff = 0)
    fileMenu.add_command(label = "Ethan", command = Ethan)
    fileMenu.add_command(label = "Open", command = open1)
    fileMenu.add_command(label = "Exit", command = window.destroy)

    #add the name of the Menu to the menubar
    menubar.add_cascade(label = "File", menu = fileMenu)


    #configure menu
    window.config(menu = menubar)

    label = tkinter.Label(window, text = "This is a window with a menubar with two options", font = 25)
    label.pack()


    #Enter into the mainloop
    tkinter.mainloop()

main()
