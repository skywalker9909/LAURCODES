
'''Laurel Tay Raeanne, Homework 9: Classes'''


class Card():
    def __init__(self,rank,suit):
        self.rank = rank
        self.suit = suit
        
    def get_rank(self): 
        return self.rank
    
    def get_suit(self):
        return self.suit
    
    def bj_value(self):
        if (self.rank >= 1) and (self.rank<= 10):
            return self.rank
        else:
            return 10
    
    def __repr__(self):
        r = self.rank
        s = self.suit
        
        if (r == 1):
            r = "Ace"
        if (r == 2):
            r = "Two"
        if (r == 3):
            r = "Three"
        if (r == 4):
            r = "Four"
        if (r == 5):
            r = "Five"
        if (r == 6):
            r = "Six"
        if (r == 7):
            r = "Seven"
        if (r == 8):
            r = "Eight"
        if (r == 9):
            r = "Nine"
        if (r == 10):
            r = "Ten"
        if (r == 11):
            r = "Jack"
        if (r == 12):
            r = "Queen"
        if (r == 13):
            r = "King"
        
        if (s=="d"):
            s = "Diamonds"
        if (s=="c"):
            s = "Clubs"
        if (s=="h"):
            s = "Hearts"
        if (s=="s"):
            s = "Spades"
        
        rep = (str(r) + ' of '+ s)
        return rep