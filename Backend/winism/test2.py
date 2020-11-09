import pandas as pd
import numpy as np
import math
from ast import literal_eval

def convert(x,food):
    
    if type(x) != float:
        if x.find(food) > 0:
            return 1
        else:
            return 0
    else:
        return 0
    
def alco(x,alcoo):

    if type(x) != float:

        
        receivealco = float(x.split("~")[0].replace("도",""))
        
        if (alcoo + 2 >= receivealco) and (alcoo - 2 <= receivealco):
            return 1
        else:
            return 0
    else:
        return 0
    
    

def readcsv(suger,acid,body,tanin,price,food,alcoo):


    pd.set_option('display.max_columns', 100)



    # 가중치
    userdf = pd.DataFrame({'suger':[suger],'acid':[acid],'body':[body],'tanin':[tanin]})
    # print("============userdf==================")
    # print(userdf)

    
    

    csv = pd.read_csv("C:/Users/git/ssafy_project3/s03p31a208/Backend/winism/wine3.csv")
    
    
    winedf2 = csv.loc[:,['LAESTDEGREE','RECOMMANDATION','COST']]

    # 당도 산도 바디 타닌 값
    winedf = csv.loc[:,['ACIDITY','BODY','SWEETNESS','TANNIN']]

    
    #사용자 당산바타 가중치 곱하기
    result = winedf.to_numpy() * userdf.to_numpy()
    

    
    

    
    
    winedf2["COST"] = np.where(winedf2["COST"] == "가격정보없음",0,winedf2["COST"])
    winedf2["COST"] = winedf2["COST"].replace('[.원]','',regex=True)
    winedf2["COST"] = pd.to_numeric(winedf2["COST"])

    winedf2["COST"] = np.where((winedf2["COST"] > price + 2000) | (winedf2["COST"] < price - 2000),0,winedf2["COST"])
    winedf2["COST"] = np.where((winedf2["COST"] <= price + 2000) & (winedf2["COST"] >= price - 2000),1,winedf2["COST"])

    
    winedf2["LAESTDEGREE"] = winedf2.LAESTDEGREE.apply(lambda x : alco(x,alcoo))
    winedf2["RECOMMANDATION"] = winedf2.RECOMMANDATION.apply(lambda x : convert(x,food))
    

    dataset = pd.DataFrame({'suger': result[:, 2],
                            'body': result[:, 1],
                            'acid': result[:, 0],
                            'tanin': result[:, 3],
                            'alco' : winedf2["LAESTDEGREE"],
                            'food' : winedf2["RECOMMANDATION"],
                            'price' : winedf2["COST"],
                            'name' : csv['ENNAME'],
                            'wid' : csv['wid']
                            })
    dataset["sum"] = dataset["suger"] + dataset["body"] + dataset["acid"] + dataset["tanin"] + dataset["alco"] + dataset["food"] + dataset["price"]
    dataset = dataset.sort_values(by=["sum"],axis = 0,ascending=False)
    
    
    print(dataset["wid"].head(5))


readcsv(1,0.25,0.5,0.25,20000,"ee",19)

