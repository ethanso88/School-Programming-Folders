#this program will tell me how much someone makes in a year

#input
hours = int(input('how many hours did you work in a week? '))
hrlywage = int(input('how much do you make per hour? '))

#calculation
annual = hours * hrlywage * 52

#output
amount = format(annual, ',.2f')
print('You will make $', amount, ' per year', sep = '')
