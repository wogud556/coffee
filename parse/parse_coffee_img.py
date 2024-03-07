from bs4 import BeautifulSoup
import requests as rq

url = f"https://www.starbucks.co.kr/menu/drink_list.do?"
espresso = "product_espresso"
coldbrew = "product_cold_brew"
frappuccino = "product_frappuccino"
blended = "product_blended"
refresher = "product_refresher"
fizzio = "product_fizzio"
tea = "product_tea"
etc = "product_etc"
juice = "product_juice"

save1 = []
product = [espresso
               , coldbrew
               , frappuccino
               , blended
               , refresher
               , fizzio
               , tea
               , etc
               , juice]


#for prd_nm in product :
#print(url+prd_nm)

html = rq.get(url , headers= {'User-Agent': 'Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/122.0.0.0 Safari/537.36'})

source = html.content
text = source.decode('utf-8')
soup = BeautifulSoup(text, "lxml")
print(product[0])
img = soup.find("ul", {"class": product[0]})
#img_src = soup.find_all("a", {"class": "img"})
save1.append(img)
li_data = img.find("li")
#all = img[0].get("src")
print(save1)