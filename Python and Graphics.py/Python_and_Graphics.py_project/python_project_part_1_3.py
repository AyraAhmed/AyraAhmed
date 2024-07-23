from graphics import *

## Setting the pass, fail, trailer, and exclude students to 0
PassCredits = 0
ExcludeCredits = 0
TrailerCredits = 0
RetrieverCredits = 0

## List to store the scores and categories
AllScores = []

TotalScores = 0 ## all of the scores start as 0

QuitInput = ""
QuitInputLower = QuitInput.lower()

def ScoreInputCheck(CheckScore): ## this function will check all of the data the user inputs
    try:
        CheckScore = int(CheckScore) ## check if the inputted data is an integer 
        if 0 <= CheckScore <= 120: ## check if in range between 0 and 120
            if CheckScore % 20 == 0: ## check if it is a multiple of 20
                return CheckScore
            else:
                 print("Enter multiple of 20") ## print this if not multiple of twenty 
                 return 0
        else:
            print("out of range") ## print this if not in range between 0 and 120
            return 0
    except:
        print("Integer Required: Please enter an integer.") ## print this if not an integer 
        return 0

## ask the user if they want to continue or not 
while QuitInputLower != "q":
    QuitInput = input("Do you want to continue, enter y for yes or q to quit: ")  

    ## break if user enters q 
    if QuitInput == "q":
        break 
    elif QuitInput == "y": ## run the while loop if user enters y 

        while True:
            PassScore = input("Enter your pass mark: ") ## ask the user to enter their pass mark 
            PassScore = ScoreInputCheck(PassScore) ## once entered program will go through the function 

            DeferScore = input("Enter your defer mark: ") ## ask the user to enter their defer mark
            DeferScore = ScoreInputCheck(DeferScore) ## once entered program will go through the function 

            FailScore = input("Enter your fail mark: ") ## ask the user to enter their fail mark 
            FailScore = ScoreInputCheck(FailScore) ## once entered program will go through the function

            if PassScore + DeferScore + FailScore == 120: ## check if PassScore, DeferScore and FailScore add up to 120
                print("Correct Total") ## print this if it does 
                break
            else:
                print("Incorrect Total, please try again") ## print this if it does not 

        TotalScores += PassScore ## add PassScore to TotalScores
        TotalScores += DeferScore ## add DeferScore to TotalScores
        TotalScores += FailScore ## add FailScore to TotalScores

        if FailScore >= 80:
            ## if FailScore is 80 or higher, student is exlcuded 
            print("Exclude")
            ExcludeCredits += 25 ## increment ExcludeCredits by 25
            ## Record the scores and category in AllScores list 
            AllScores.append(("Exclude", f"{FailScore}, {DeferScore}, {PassScore}"))

        elif PassScore == 120:
            ## if PassScore is 120, student has progressed 
            print("Progress")
            PassCredits += 25 ## increment PassCredits by 25 
            ## Record the scores and category in AllScores list 
            AllScores.append(("Progress", f"{PassScore}, {DeferScore}, {FailScore}"))

        elif PassScore == 100:
            ## if PassScore is 100, student is in progress module trailer 
            print("Progress Module trailer")
            TrailerCredits += 25 ## increment TrailerCredits by 25 
            ## Record the scores and category in AllScores list
            AllScores.append(("Progress (module trailer)", f"{PassScore}, {DeferScore}, {FailScore}"))

        elif PassScore <= 80:
            ## if PassScore is less than or equal to 80, student is in module retriever
            print("Module Retriever")
            RetrieverCredits += 25 ## increment RetrieverCredits by 25
            ## Record the scores and category in AllScores list 
            AllScores.append(("Module Retriever", f"{PassScore}, {DeferScore}, {FailScore}"))

## Display results for each student 
for category, scores in AllScores:
    print("".join([f"{category} - {scores}\n"]))
    ## write results to a file named DataList.txt
    f=open("DataList.txt", "w")
    for category, scores in AllScores:
        f.write(f"{category, scores},\n")

    
## making the histogram 
window = GraphWin("My Histogram", 400,450) ## my window for the histogram 

Rectangle1 = Rectangle(Point(20,400 - PassCredits), Point(60,400)) ## points of my first bar in the histogram 
Rectangle1.setFill("Red") ## bar will be in the colour red 
Rectangle1.draw(window) ## will draw it in the histogram 
text1 = Text(Point(30,410),"Pass") ## this is the heading for the bar 
text1.draw(window)

Rectangle2 = Rectangle(Point(120,400 - TrailerCredits), Point(160,400)) ## points of my second bar in the histogram 
Rectangle2.setFill("green") ## bar will be green 
Rectangle2.draw(window)
text2 = Text(Point(130, 410), "Trailer") ## this is the heading for the bar 
text2.draw(window)

Rectangle3 = Rectangle(Point(220,400 - RetrieverCredits), Point(260,400)) ## points of my third bar in the histogram 
Rectangle3.setFill("blue") ## bar will be blue 
Rectangle3.draw(window)
text3 = Text(Point(230, 410),"Retriever") ## this is the heading for the bar 
text3.draw(window)

Rectangle4 = Rectangle(Point(320,400 - ExcludeCredits), Point(360,400)) ## points of my fourth bar in the histogram 
Rectangle4.setFill("purple") ## bar will be purple 
Rectangle4.draw(window)
text4 = Text(Point(330, 410),"Exclude") ## this is the heading for the bar 
text4.draw(window)

## Calculate and display the total on top of each bar
total1 = PassCredits // 25 ## each credit represents one student 
total2 = TrailerCredits // 25
total3 = RetrieverCredits // 25
total4 = ExcludeCredits // 25

## displaying the caculated total and positioning them on top of each bar 
TotalText1 = Text(Point(30, 390 - PassCredits), str(total1)) ## Total1 ontop of bar 1 
TotalText1.draw(window)

TotalText2 = Text(Point(130, 390 - TrailerCredits), str(total2)) ## Total2 on top of bar 2 
TotalText2.draw(window)

TotalText3 = Text(Point(230, 390 - RetrieverCredits), str(total3)) ## Total3 on top of bar 3 
TotalText3.draw(window)

TotalText4 = Text(Point(330, 390 - ExcludeCredits), str(total4)) ## Total4 on top of bar 4 
TotalText4.draw(window)

## add up all of the students who have entered their mark and dvide it by 25 
TotalCredits = int((PassCredits + ExcludeCredits + TrailerCredits + RetrieverCredits) /25) 

## Total number of students to be shown on the top left of the histogram 
TotalText = f"Total Credit Outcomes = {TotalCredits}" 
TotalLabel = Text(Point(300,30), TotalText)
TotalLabel.draw(window)


input() ## to make sure the window stays open 
    
