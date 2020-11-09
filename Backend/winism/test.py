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


    print("pandas version: ", pd.__version__)
    pd.set_option('display.max_columns', 100)



    # 가중치
    userdf = pd.DataFrame({'suger':[suger],'acid':[acid],'body':[body],'tanin':[tanin]})
    # print("============userdf==================")
    # print(userdf)
    

    csv = pd.read_csv("C:/Users/git/ssafy_project3/s03p31a208/Backend/winism/wine.csv")
    
    
    winedf2 = csv.loc[:,['알코올도수','추천음식','가격']]

    # 당도 산도 바디 타닌 값
    winedf = csv.loc[:,['산도','바디','당도','타닌']]
    
    # print("============winedf==================")
    # print(winedf.head(5))
    # print("==============================")
    

    #사용자 당산바타 가중치 곱하기
    result = winedf.to_numpy() * userdf.to_numpy()
    
    print(winedf)
    
    

    
    
    winedf2["가격"] = np.where(winedf2["가격"] == "가격정보없음",0,winedf2["가격"])
    winedf2["가격"] = winedf2["가격"].replace('[.원]','',regex=True)
    winedf2["가격"] = pd.to_numeric(winedf2["가격"])

    winedf2["가격"] = np.where((winedf2["가격"] > price + 2000) | (winedf2["가격"] < price - 2000),0,winedf2["가격"])
    winedf2["가격"] = np.where((winedf2["가격"] <= price + 2000) & (winedf2["가격"] >= price - 2000),1,winedf2["가격"])

    
    winedf2["알코올도수"] = winedf2.알코올도수.apply(lambda x : alco(x,alcoo))
    winedf2["추천음식"] = winedf2.추천음식.apply(lambda x : convert(x,food))
    

    dataset = pd.DataFrame({'suger': result[:, 2],
                            'body': result[:, 1],
                            'acid': result[:, 0],
                            'tanin': result[:, 3],
                            'alco' : winedf2["알코올도수"],
                            'food' : winedf2["추천음식"],
                            'price' : winedf2["가격"],
                            'name' : csv['와인이름(영어)']
                            })
    dataset["sum"] = dataset["suger"] + dataset["body"] + dataset["acid"] + dataset["tanin"] + dataset["alco"] + dataset["food"] + dataset["price"]
    dataset = dataset.sort_values(by=["sum"],axis = 0,ascending=False)
    
    
    print(dataset.head(5))


readcsv(1,0.25,0.5,0.25,20000,"삼겹살",19)

