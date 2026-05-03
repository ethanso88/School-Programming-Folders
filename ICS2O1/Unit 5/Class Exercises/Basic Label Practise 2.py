import tkinter as tk

def main():
    #create root window
    mainWindow = tk.Tk()

    mainWindow.title('Practise 2')

    class1 = tk.Label(text = 'math', \
                      bg = "gray", \
                      fg = "pink")
    class1.pack(side = 'left')

    class2 = tk.Label(text = 'comp sci', \
                      bg = "gray", \
                      fg = "pink")
    class2.pack(side = 'left')
    
    class3 = tk.Label(text = 'history', \
                      bg = "gray", \
                      fg = "pink")
    class3.pack(side = 'left')

    class4 = tk.Label(text = 'english', \
                      bg = "gray", \
                      fg = "pink")
    class4.pack(side = 'left')

    #Enter mainloop
    mainWindow.mainloop

main()
