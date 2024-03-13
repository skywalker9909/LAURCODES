'''Laurel Tay Raeanne, Homework 6: Decision Control'''


def is_leap_year(year):
    if (year%4 == 0 and year%100 != 0) or (year%400 == 0) :
        return True
    else :
        return False



def is_valid_date(month,day,year):
    datevalid = False
    if (month < 13 and month > 0):
        if month in [1,3,5,7,8,10,12]:
            if (day> 0) and (day<32):
                datevalid = True
            else:
                datevalid = False
        else:
            if month in [4,6,9,11]:
                if (day> 0) and (day<31):
                    datevalid = True
                else:
                    datevalid = False
            else:
                if month ==2:
                    if is_leap_year(year)==True:
                        if (day> 0 and day<30):
                            datevalid = True
                        else:
                            datevalid = False
                    else:
                        if is_leap_year(year)==False:
                            if (day> 0 and day<29):
                                datevalid = True
                        else:
                            datevalid = False
                        
    else:
        datevalid = False

    monthstring = str(month)
    daystring = str(day)
    yearstring = str(year)

    date = (monthstring+"/"+daystring+"/"+yearstring)
    
                
    if datevalid == True:
        print(date,"is valid")
    else:
        print(date,"is not valid")

def main():
    date = input(str("Please enter a date (mm/dd/yyyy): "))
    sd = date.split("/")
    is_valid_date(int(sd[0]),int(sd[1]),int(sd[2]))


main()
