#This program compares strings with the < operator

def main():
    #Get three names from the user
    name1 = input('Enter a name: ')
    name2 = input('Enter another name: ')
    name3 = input('Enter another name: ')
    
    print('These are the names printed alphabetically:')

    #This comparison works because letters have a number value in python
    #The letters that come first will be lesser than the ones that come later 
    if name1 < name2 and name1 < name3:
        if name2 < name3:
            print(name1)
            print(name2)
            print(name3)
        else:
            print(name1)
            print(name3)
            print(name2)
    elif name2 < name1 and name2 < name3:
        if name1 < name3:
            print(name2)
            print(name1)
            print(name3)
        else:
            print(name2)
            print(name3)
            print(name1)
    else:
        if name1 < name2:
            print(name3)
            print(name1)
            print(name2)
        else:
            print(name3)
            print(name2)
            print(name1) 

main()
