#This is the program for question 1 by Ethan So
#This program will ask the user where they are from
#Based on the input of the user the program will either tell something about the province or country inputted or
#will have a generic answer saying something like "I don't know anything about that region"

def main():
    #input
    place = input('Where are you from? ')

    #function for the possible responses to the input
    response(place)

def response(place):
    #three different regions with information

    #if ontario
    if place == 'Ontario' or place == 'ontario':
        print('Ontario has some of the only land that can be used for farming in Canada')

    #if quebec
    elif place == 'Quebec' or place == 'quebec':
        print("Quebec's language is french and is known for their poutine and smoked meat")

    #if British Columbia 
    elif place == 'British Columbia' or place == 'British columbia' or place == 'british columbia':
        print('The weather in BC can be not so great and it is close to the rocky mountains')

    else:
        print("I don't know anything about", place)

main()
