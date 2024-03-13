# -*- coding: utf-8 -*-

'''Laurel Tay Raeanne, Homework 10: Data Collection'''


class Card():
    rank_tuple = ("Ace", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Jack", "Queen", "King")
    suit_dict = {"d": "Diamonds", "c": "Clubs", "h": "Hearts", "s": "Spades"}

    def __init__(self, rank, suit):
        self.rank = rank
        self.suit = suit

    def get_rank(self):
        return self.rank

    def get_suit(self):
        return self.suit

    def bj_value(self):
        if (self.rank >= 1) and (self.rank <= 10):
            return self.rank
        else:
            return 10

    def __repr__(self):
        r = self.rank
        s = self.suit

        r = Card.rank_tuple[r-1]
        s = Card.suit_dict[s]

        rep = (str(r) + ' of ' + s)
        return rep

def card_val(card):
    suit_dict2 = {"c": 1, "d": 2, "h": 3, "s": 4}
    return suit_dict2[card.get_suit()]*14 + card.get_rank()

    

def main():
    card_list = []
    carddict ={"d":[0,0,0,0,0,0,0,0,0,0,0,0,0,0],
              "c":[0,0,0,0,0,0,0,0,0,0,0,0,0,0],
              "h":[0,0,0,0,0,0,0,0,0,0,0,0,0,0],
              "s":[0,0,0,0,0,0,0,0,0,0,0,0,0,0]}

    while True:
        inputrank = int(input("Enter rank, or 0 to stop: "))
        if inputrank == 0:
            card_list.sort(key = card_val)
            print()
            
            print("Your sorted cards are")
            for i in range(len(card_list)):
                print(card_list[i])
 
            print("\nThe total number of cards of each rank are")
            print("Clubs: " + str(carddict["c"]))
            print("Diamonds: " + str(carddict["d"]))
            print("Hearts: " + str(carddict["h"]))
            print("Spades: " + str(carddict["s"]))
            
            break
            
        else:
            inputsuit = str(input("Enter suit: "))
            c=Card(inputrank, inputsuit)
            card_list.append(c)
            
            carddict[inputsuit][inputrank] += 1
            
            
main()
        
        
        

    

