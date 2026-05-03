#input
rows = int(input('Enter the base size (rows) for your printed pattern: '))

#processing

for r in range(1, rows + 1):
    for c in range(r):
        #Output
        print('*', end = '')
    #ending line after each row
    print()



