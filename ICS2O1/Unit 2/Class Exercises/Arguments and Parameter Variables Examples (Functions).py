def main():
	print('The sum of 12 and 45 is')
	show_sum(12, 45)
	
def show_sum(num1, num2):
	result = num1 + num2
	print(result)
	
main()


print('----------new program----------')


def main2():
	first_name = input('Enter your first name: ')
	last_name = input('Enter your last name: ')
	print('Your name reversed is')
	reverse_name(first_name, last_name)
	
def reverse_name(first, last):
	print(last, first)
	
main2()
