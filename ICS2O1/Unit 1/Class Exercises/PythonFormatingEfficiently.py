print("one", end = '$')
print("two", end = ' ')
print("three")
#the end argument tells the computer to not create a new line
#it then adds something else or nothing between the lines of data
#it moves prints functiosn that would be on seperate lines to all be on the same line


print() #adds a space between the first program and the new program
        #program and the new program


print('This', 'class', 'is', 'fun')
print('This class is fun')

#you can add a seperator to seperate each of the string arguments or seperate them with nothing
#the seperator sepreates only on the print function it is in
#the end argument affects the next print function
print('This', 'class', 'is', 'fun', sep = '')

#seprator is useful for the $ for money
dollars = 4.00

print('You have $', dollars, ' in the bank', sep = '')


#This program demonstrates how to print out
#Single and double quotation marks using the escape characters
# \" --> prints out "
# \' --> prints out '
print('I said to my enemy,', \
      "\"Go away! I \'hate\' you!\"")
#you can also just do
print('''I said to my enemy, "Go away! I 'hate' you!"''')
print("""I said to my enemy, "Go away! I 'hate' you!\"""")

#The other escape characters are \\ will out put a \
#\n makes a new line
#\t causes the output to skip the next horizontal tab position

#This program demonstrates how to print a single quotation mark
print("I\'m having trouble studying.")

#This program demonstrates how to print a double quotation mark
print("I think that \"ICS201\" is the best!")

#This program demonstrates how to print two backslash characters
print('The path is C:\\\\temp\\\\data.')

#This program demonstrates how to use \n to create seperate new lines
print('one\ntwo\nthree\nfour')

#This program demonstrates how to use \t to create a tab
print('friend\tfriend\tfriend')




amount = 5000.00
monthlyPay = amount/12.0

#formating can decide how something is outputted
print(format(12345.6789, '.2f'))
#the decimal is the precision which would be .67 up above
#you can add a comma before the decimal to add a comma seperator
#you can format to print out something for a:
#float = f
#scientific notation = e
#interger = d
print(format(12345.6789, '.2e'))
print(format(12345.6789, ',.2f'))
print(format(123456, ',d'))

#Format specifier can also include a minimum field width which is the minimum number of spaces that should be used to display the value
print('The number is', format(12345.6789, '12,.2f'))

num1 = 127.899
num2 = 3465.148
num3 = 3.776
print(format(num1, '7.2f'))
print(format(num2, '7.2f'))
print(format(num3, '7.2f'))


#Instead of f, you can use the % symbol to format a floating-point number as a percentage.
print(format(0.5, '%'))
print(format(0.5, '.0%'))



#+ can put two strings together and is not just used for intergers and floats
#don't put commas otherwise it won't work
print('This is ' + 'one string.')
