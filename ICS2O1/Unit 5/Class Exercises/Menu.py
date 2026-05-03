import tkinter
import tkinter.messagebox

#This program will demonstrate how to create a menu/menubar

def main():
    #Define the callback functions for the menu items
    def open1():
        tkinter.messagebox.showinfo("Open", "You clicked open! Wowza!")
    def new():
        tkinter.messagebox.showinfo("New", "You clicked new!")

    #---------Create the root window-------------
    window = tkinter.Tk()
    window.title("Menu Demo") #This sets the title of the window
    window.geometry("500x400") #This allows me to adjust the size of my window
    
    #---------Create the menubar and associate it to the window-------------
    menubar = tkinter.Menu(window)

    #---------Create a menu and associate it to the menubar-----------
    fileMenu = tkinter.Menu(menubar, tearoff = 0) #tearoff = 0 gets rid of the weird line that would be a the top of the menu by default
    #add items to the menu
    fileMenu.add_command(label = "New", command = new)
    fileMenu.add_separator()
    fileMenu.add_command(label = "Open", command = open1)
    fileMenu.add_separator()
    fileMenu.add_command(label = "Exit", command = window.destroy)
    #add the name of the Menu to the Menubar
    menubar.add_cascade(label = "File", menu = fileMenu)

    #---------Configure to display the menu in the window-------------
    #this is the menu's equivalent to packing
    window.config(menu = menubar)
    #menu is already a term/keyword in Python, but the menubar is the name that I named my menubar (the variable)


    #---------Add a Widget so the window isn't awkwardly empty-------------
    label = tkinter.Label(window, text = "Hi", fg = "Light Blue", bg = "Black", font = 25)
    label.pack()
    

    #Enter into the mainloop
    tkinter.mainloop()

main()
