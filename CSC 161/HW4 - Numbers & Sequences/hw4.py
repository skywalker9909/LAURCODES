'''Laurel Tay Raeanne, Homework 4: Sequences'''


input = input("Please enter the filename of the financial data: ")
print("")


f = open(input,"r")

data = f.read()

mainlist=data.split()

principal = mainlist[1]

interest = mainlist[3]
floatinterest=float(interest)*100

years = mainlist[5]


print("The initial principal is: " + "${:.2f}".format(float(principal)))
print("Annual percentage rate is: " + "{:3.1f}%".format(floatinterest))
print("Length of the term: " + years)

print("")

print("{} {}" .format("Year","Value"))

print("{:4.0f} ${:.2f}".format(float("0"),float(principal)))
newlist = []
counter = 1
for i in mainlist[6:]:
	x = float(i)
	print("{:4.0f} ${:.2f}".format(counter, x))
	counter += 1

	
