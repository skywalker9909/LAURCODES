'''Laurel Tay Raeanne, Homework 3: Objects & Graphics'''


from graphics import *

win = GraphWin('House', 500, 500)

llc_text =  Text(Point(250,50),"Click on lower left corner of the house frame.")
llc_text.draw(win)

a = win.getMouse()

llc_text.undraw()

text2 = Text(Point(250,50),"Click upper right corner of the house frame.")
text2.draw(win)

b = win.getMouse()

text2.undraw()

#house

rectangle = Rectangle(a,b)
rectangle.draw(win)

#door

width = (a.getX()-b.getX())/5
halfwidth=width/2

text3 = Text(Point(250,50),"Click on the center of the top of the door.")
text3.draw(win)


c = win.getMouse()

door_tr = Point(c.getX() + halfwidth, c.getY())
door_bl = Point(c.getX() - halfwidth, a.getY())

door = Rectangle(door_tr, door_bl)

door.draw(win)

#doorknob

ycentreofdoorknob =(c.getY()+a.getY())/2
xcentreofdoorknob = c.getX()-(1/3*width)

center = Point(xcentreofdoorknob,ycentreofdoorknob)


doorknob = Circle(center,5)

doorknob.draw(win)


#window

text3.undraw()
text4 = Text(Point(250,50),"Click on the center of the window.")
text4.draw(win)

d = win.getMouse()

text4.undraw()

windowlength = (3/4)*(door_tr.getX()-door_bl.getX())
halfwindowlength = windowlength/2


window_tr = Point(d.getX()+halfwindowlength,d.getY()+halfwindowlength)
window_bl = Point(d.getX()-halfwindowlength,d.getY()-halfwindowlength)

window = Rectangle(window_tr,window_bl)

window.draw(win)

#windowlines

ytopofvline = d.getY()+halfwindowlength
xtopofvline = d.getX()
ybottomofvline = d.getY()-halfwindowlength
xbottomofvline = d.getX()

xleftofhline = d.getX()-halfwindowlength
yleftofhline = d.getY()
xrightofhline = d.getX()+halfwindowlength
yrightofhline = d.getY()

lineone = Line(Point(xtopofvline,ytopofvline),Point(xbottomofvline,ybottomofvline))
linetwo = Line(Point(xleftofhline,yleftofhline), Point(xrightofhline,yrightofhline))

lineone.draw(win)
linetwo.draw(win)

#roof

text5 = Text(Point(250,50),"Click on the peak of the roof.")
text5.draw(win)

e = win.getMouse()

text5.undraw()


difference= a.getX()-b.getX()
lastpointlol=Point(b.getX()+difference,b.getY())

vertices=[e,b,lastpointlol]
triangle = Polygon(vertices)

triangle.draw(win)

text6 = Text(Point(250,50),"Click anywhere to quit.")
text6.draw(win)

win.getMouse()
win.close()
