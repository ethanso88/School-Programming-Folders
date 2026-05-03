#This is a Non GUI Version of the GUI program for a bomb defusal game
#This is the simplified version meaning that there will be lives/1 life instead of a timer
#This program consists of an intro with instructions
#There will also be a defusal manual
#There will be at least 3 puzzles (to be determined)
#There will be an end function or two end functions for the scenario of a win or loss
import random


def main():
    def intro():
        #intro for the user
        print("This is a bomb defusal game")
        print("Your goal is to defuse the bomb by solving the puzzles")
        print("If you get a puzzle wrong the bomb will explode and the game will end")
        print("You will have to try again if that happens")
        print("Good luck! You will have a manual to help you")
        print()


    def manual():
        #the Manual guide for the user during the game
        print('----------Manual----------')
        print('This is the manual that will help you in the game')
        print('Regarding number order:')
        print('   if the first number is 1 type 1')
        print('   if the second number is 4 type 2')
        print('   if the first and third number are 2 and 3 type 3')
        print('   if the last number is 1 type 5')
        print('   if none of the above type 4')
        print('Regarding calculation:')
        print('   there are 4 numbers')
        print('   multiply the first and second number, this now X')
        print('   multiply the third and fourth number, this now Y')
        print('   divide Y by 2')
        print('   subtract X by Y (X - Y)')
        print('   if the answer is negative type 0')
        #something to add to this puzzle is to make x always greater than Y
        print('Regarding decoding:')
        print('   ! = 1, @ = 2, # = 3, $ = 4, % = 5, ^ = 6, & = 7, * = 8, ( = 9, ) = 0')
        print('   add your decoded answer together')
        #a way to make this puzzle more complex is to match each number with a letter
        #can also do math operations with the numbers
        print()


    def puzzle1():
        #puzzle1
        print('----------puzzle 1----------')
        #the different options:
        def p1_1():
            ans = int(input('1 3 5 2 4: '))
            if ans == 1:
                print('You completed the puzzle!')
                puzzle2()
            else:
                failed()
        def p1_2():
            ans = int(input('3 4 2 1 5: '))
            if ans == 2:
                print('You completed the puzzle!')
                puzzle2()
            else:
                failed()
        def p1_3():
            ans = int(input('2 5 3 1 4: '))
            if ans == 3:
                print('You completed the puzzle!')
                puzzle2()
            else:
                failed()
        def p1_4():
            ans = int(input('5 4 3 2 1: '))
            if ans == 5:
                print('You completed the puzzle!')
                puzzle2()
            else:
                failed()
        def p1_5():
            ans = int(input('2 3 1 4 5: '))
            if ans == 4:
                print('You completed the puzzle!')
                puzzle2()
            else:
                failed()

        #randomize the options
        num = random.randint(1, 5)
        if num == 1:
            p1_1()
        elif num == 2:
            p1_2()
        elif num == 3:
            p1_3()
        elif num == 4:
            p1_4()
        else:
            p1_5()


    def puzzle2():
        print()
        print('----------puzzle 2----------')
        #puzzle 2
        #the random numbers
        num1 = random.randint(1, 20)
        num2 = random.randint(1, 20)
        num3 = random.randint(1, 20)
        num4 = random.randint(1, 20)

        #calculations
        X = num1 * num2
        Y = (num3 * num4)/2
        ans = X - Y

        #user input
        print(num1, num2, num3, num4)
        user_ans = int(input('Enter answer here: '))

        #if the user failed or got it right
        if user_ans == ans:
            print('You completed the puzzle!')
            puzzle3()
        elif ans < 0:
            print('You completed the puzzle!')
            puzzle3()
        else:
            failed()


    def puzzle3():
        print()
        print('----------puzzle 3----------')
        
        num1 = '!'
        num2 = '@' 
        num3 = '#' 
        num4 = '$' 
        num5 = '%' 
        num6 = '^' 
        num7 = '&' 
        num8 = '*' 
        num9 = '(' 
        num10 = ')' 

        num = random.randint(0,9)

        if num == 0:
            print(num10)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
        elif num == 1:
            print(num1)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
        elif num == 2:
            print(num2)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                      
        elif num == 3:
            print(num3)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
        elif num == 4:
            print(num4)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
        elif num == 5:
            print(num5)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
        elif num == 6:
            print(num6)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
        elif num == 7:
            print(num7)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
        elif num == 8:
            print(num8)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
        elif num == 9:
            print(num9)
            num_1 = random.randint(0,9)
            if num_1 == 0:
                print(num10)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 1:
                print(num1)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 2:
                print(num2)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 3:
                print(num3)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 4:
                print(num4)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 5:
                print(num5)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 6:
                print(num6)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 7:
                print(num7)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 8:
                print(num8)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
            elif num_1 == 9:
                print(num9)
                num_2 = random.randint(0,9)
                if num_2 == 0:
                    print(num10)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 1:
                    print(num1)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 2:
                    print(num2)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 3:
                    print(num3)
                    ans = int(input('Enter your answer here: '))
                    if ans ==  + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 4:
                    print(num4)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 5:
                    print(num5)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 6:
                    print(num6)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 7:
                    print(num7)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 8:
                    print(num8)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
                elif num_2 == 9:
                    print(num9)
                    ans = int(input('Enter your answer here: '))
                    if ans == num + num_1 + num_2:
                        won()
                    else:
                        failed()
        
    def failed():
        print("The bomb exploded! Oh no!")
        print("Sorry but you failed the game. Try again?")

    def won():
        print("You successfully defused the bomb!")
        print("You won!")
        

    intro()
    manual()
    puzzle1()

    
main()
