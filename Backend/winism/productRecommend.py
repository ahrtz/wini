# -*- coding: utf-8 -*-

import pandas as pd
import numpy as np
import math
import sys
import json


def foodcov(x,food):
    
    if type(x) != float:
        if x.find(food) > 0:
            return 1
        else:
            return 0
    else:
        return 0
    
def alco(x,alcoo):

    if (type(x) != float)| (alcoo == "None"):
        receivealco = float(x.split("~")[0].replace("도",""))
        
        if (alcoo + 2 >= receivealco) and (alcoo - 2 <= receivealco):
            return 1
        elif (alcoo + 4 >= receivealco) and (alcoo - 4 <= receivealco):
            return 0.7
        elif (alcoo + 6 >= receivealco) and (alcoo - 6 <= receivealco):
            return 0.5
        else:
            return 0
    else:
        return 0
    
def cost(x,price):
    if(x == "가격정보없음") | (price == "가격정보없음") :
        return 0
    else:
        x = int(x)
        if(x < price + 2000) & (x > price - 2000):
            return 1
        elif (x < price + 4000) & (x > price - 4000):
            return 0.7
        elif (x < price + 6000) & (x > price - 6000):
            return 0.7
        else:
            return 0
def acidity(x,acid):
    if x == acid:
        return 1
    elif(x <= acid + 1) & (x >= acid - 1):
        return 0.7
    elif(x <= acid + 2) & (x >= acid - 2):
        return 0.5
    else:
        return 0

def bodycon(x,body):
    
    if x == body:
        return 1
    elif(x <= body + 1) & (x >= body - 1):
        return 0.7
    elif(x <= body + 2) & (x >= body - 2):
        return 0.5
    else:
        return 0

def sweetness(x,suger):

    if x == suger:
        return 1
    elif(x <= suger + 1) & (x >= suger - 1):
        return 0.7
    elif(x <= suger + 2) & (x >= suger - 2):
        return 0.5
    else:
        return 0


def tannin(x,tanin):

    if x == tanin:
        return 1
    elif(x <= tanin + 1) & (x >= tanin - 1):
        return 0.7
    elif(x <= tanin + 2) & (x >= tanin - 2):
        return 0.5
    else:
        return 0


def readcsv(suger,acid,body,tanin,price,food,alcoo,userdata):


    pd.set_option('display.max_columns', 100)

    # 가중치
    userdf = pd.DataFrame({'suger':[suger],'acid':[acid],'body':[body],'tanin':[tanin]})
    # print("============userdf==================")
    # print(userdf)

    
    

    # csv = pd.read_csv("C:/Users/git/ssafy_project3/s03p31a208/Backend/winism/wine.csv")
    csv = pd.read_csv("/home/ubuntu/s03p31a208/Backend/winism/wine.csv")

    

    
    
    winedf2 = csv.loc[:,['ACIDITY','BODY','SWEETNESS','TANNIN','LAESTDEGREE','RECOMMANDATION','COST']]



    winedf2["BODY"] = winedf2.BODY.apply(lambda x : bodycon(x,body))
    winedf2["ACIDITY"] = winedf2.ACIDITY.apply(lambda x : acidity(x,acid))
    winedf2["SWEETNESS"] = winedf2.SWEETNESS.apply(lambda x : sweetness(x,suger))
    winedf2["TANNIN"] = winedf2.TANNIN.apply(lambda x : tannin(x,tanin))

    winedf2["COST"] = winedf2.COST.apply(lambda x : cost(x,price))
    winedf2["LAESTDEGREE"] = winedf2.LAESTDEGREE.apply(lambda x : alco(x,alcoo))
    winedf2["RECOMMANDATION"] = winedf2.RECOMMANDATION.apply(lambda x : foodcov(x,food))
    
    
    dataset = pd.DataFrame({'suger': winedf2["SWEETNESS"],
                            'body': winedf2["BODY"],
                            'acid': winedf2["ACIDITY"],
                            'tanin': winedf2["TANNIN"],
                            'alco' : winedf2["LAESTDEGREE"],
                            'food' : winedf2["RECOMMANDATION"],
                            'price' : winedf2["COST"],
                            'name' : csv['ENNAME'],
                            'wid' : csv['wid']
                            })
    dataset["sum"] = dataset["suger"] + dataset["body"] + dataset["acid"] + dataset["tanin"] + dataset["alco"] + dataset["food"] + dataset["price"]

    

    if(userdata != "null"):
        userdata = userdata. split(",")
        for i in range(len(userdata) - 1):
            dataset["sum"] = np.where(dataset["wid"] == int(userdata[i]),dataset["sum"] + (1 - i * (1/(len(userdata)-1))) ,dataset["sum"])
        

    dataset = dataset.sort_values(by=["sum"],axis = 0,ascending=False)
    # print(dataset.head(10))


    datalist = dataset["wid"].tolist()
    print(datalist[0],datalist[1],datalist[2],datalist[3],datalist[4])
    

# print(sys.argv[2])

print(sys.argv[1])
print(sys.argv[2])
jsonobj = json.loads(sys.argv[1])

alcoo = jsonobj["alcoo"]
if(alcoo == "None"):
    alcoo = 0
price = jsonobj["price"]
if(price == "가격정보없음") | (price == ""):
    price = 0

readcsv(float(jsonobj["suger"]),float(jsonobj["acid"]),float(jsonobj["body"]),float(jsonobj["tanin"]) , float(price) ,jsonobj["food"],float(alcoo),sys.argv[2])


