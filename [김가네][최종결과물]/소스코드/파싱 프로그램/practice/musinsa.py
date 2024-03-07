from bs4 import BeautifulSoup
import requests as rq
import urllib.request
import os
import boto3
import botocore

s3 = boto3.resource('s3')

def musin_street(url, a):

    j = 0
    print("street\n")
    for j in range(len(url)):
        try:
            if not(os.path.isdir(str(j))):
                os.makedirs(os.path.join("clothes/street/level"+ str(a) + "/"+str(j)))
        except OSError as e:
            if e.errno  != e.errno.EEXIST:
                print("fail")
                raise
        URL = "https://store.musinsa.com/app/styles/views/" + str(url[j])
        html = rq.get(URL , headers= {'User-Agent': 'Mozilla/5.0'})

        source = html.content
        text = source.decode('utf-8')
        soup = BeautifulSoup(text, "html.parser")

        img = soup.find_all("img", {"class": "detail_img"})
        img_src = soup.find_all("a", {"class": "img"})

        all = img[0].get("src")
        print(URL)
        i = 0
        for i in range(len(img_src)):
            src = img_src[i].find("img").get("src")
            src_url = "https:"+src
            urllib.request.urlretrieve(src_url, "./clothes/street/level"+ str(a) +"/"+ str(j) +"/" +"Musinsa"+ str(j+1)+"_"+str(i+1) +".jpg")
            i+=1
        urllib.request.urlretrieve(all, "./clothes/street/level"+str(a)+"/"+str(j)+"/" +"Musinsa"+str(j+1)+"_"+"all"+".jpg")
        j+=1

def musin_casual(url, a):

    j = 0
    print("casual\n")
    for j in range(len(url)):
        try:
            if not(os.path.isdir(str(j))):
                os.makedirs(os.path.join("clothes/casual/level"+ str(a) + "/"+str(j)))
        except OSError as e:
            if e.errno  != e.errno.EEXIST:
                print("fail")
                raise
        URL = "https://store.musinsa.com/app/styles/views/" + str(url[j])
        html = rq.get(URL , headers= {'User-Agent': 'Mozilla/5.0'})

        source = html.content
        text = source.decode('utf-8')
        soup = BeautifulSoup(text, "html.parser")

        img = soup.find_all("img", {"class": "detail_img"})
        img_src = soup.find_all("a", {"class": "img"})

        all = img[0].get("src")
        print(URL)
        i = 0
        for i in range(len(img_src)):
            src = img_src[i].find("img").get("src")
            src_url = "https:"+src
            urllib.request.urlretrieve(src_url, "./clothes/casual/level"+ str(a) +"/"+ str(j) +"/" +"Musinsa"+ str(j+1)+"_"+str(i+1) +".jpg")
            i+=1
        urllib.request.urlretrieve(all, "./clothes/casual/level"+str(a)+"/"+str(j)+"/" +"Musinsa"+str(j+1)+"_"+"all"+".jpg")
        j+=1

def musin_classic(url, a):

    j = 0
    print("classic\n")
    for j in range(len(url)):
        try:
            if not(os.path.isdir(str(j))):
                os.makedirs(os.path.join("clothes/classic/level"+str(a)+"/"+str(j)))
        except OSError as e:
            if e.errno  != e.errno.EEXIST:
                print("fail")
                raise
        URL = "https://store.musinsa.com/app/styles/views/" + str(url[j])
        html = rq.get(URL , headers= {'User-Agent': 'Mozilla/5.0'})

        source = html.content
        text = source.decode('utf-8')
        soup = BeautifulSoup(text, "html.parser")

        img = soup.find_all("img", {"class": "detail_img"})
        img_src = soup.find_all("a", {"class": "img"})

        all = img[0].get("src")
        print(URL)
        i = 0
        for i in range(len(img_src)):
            src = img_src[i].find("img").get("src")
            src_url = "https:"+src
            urllib.request.urlretrieve(src_url, "./clothes/classic/level"+ str(a) +"/"+ str(j) +"/" +"Musinsa"+ str(j+1)+"_"+str(i+1) +".jpg")
            i+=1
        urllib.request.urlretrieve(all, "./clothes/classic/level"+str(a)+"/"+str(j)+"/" +"Musinsa"+str(j+1)+"_"+"all"+".jpg")
        j+=1

def musin_spoty(url, a):

    j = 0
    print("spoty\n")
    for j in range(len(url)):
        try:
            if not(os.path.isdir(str(j))):
                os.makedirs(os.path.join("clothes/spoty/level"+str(a)+"/"+str(j)))
        except OSError as e:
            if e.errno  != e.errno.EEXIST:
                print("fail")
                raise
        URL = "https://store.musinsa.com/app/styles/views/" + str(url[j])
        html = rq.get(URL , headers= {'User-Agent': 'Mozilla/5.0'})

        source = html.content
        text = source.decode('utf-8')
        soup = BeautifulSoup(text, "html.parser")

        img = soup.find_all("img", {"class": "detail_img"})
        img_src = soup.find_all("a", {"class": "img"})

        all = img[0].get("src")
        print(URL)
        i = 0
        for i in range(len(img_src)):
            src = img_src[i].find("img").get("src")
            src_url = "https:"+src
            urllib.request.urlretrieve(src_url, "./clothes/spoty/level"+ str(a) +"/"+ str(j) +"/" +"Musinsa"+ str(j+1)+"_"+str(i+1) +".jpg")
            i+=1
        urllib.request.urlretrieve(all, "./clothes/spoty/level"+str(a)+"/"+str(j)+"/" +"Musinsa"+str(j+1)+"_"+"all"+".jpg")
        j+=1



def s3_street_upload():
    path_dir = './clothes/street/level'
    i = 1
    j = 0
    for i in range(1, 5):
        for j in range(len(os.listdir(path_dir + str(i)))):
            for a in os.listdir(path_dir + str(i) + '/' + str(j)):
                s3.Bucket('todayis').upload_file('./clothes/street/level' + str(i) + '/' + str(j) + '/' + str(a),
                                                 'street/level' + str(i) + '/' + str(j) + '/' + str(a))
                print(a)
            j+=1
        i += 1

def s3_casual_upload():
    path_dir = './clothes/casual/level'
    i = 1
    j = 0
    for i in range(1, 5):
        for j in range(len(os.listdir(path_dir + str(i)))):
            for a in os.listdir(path_dir + str(i) + '/' + str(j)):
                s3.Bucket('todayis').upload_file('./clothes/casual/level' + str(i) + '/' + str(j) + '/' + str(a),
                                                 'casual/level' + str(i) + '/' + str(j) + '/' + str(a))
                print(a)
            j+=1
        i += 1

def s3_spoty_upload():
    path_dir = './clothes/spoty/level'
    i = 1
    j = 0
    for i in range(1, 5):
        for j in range(len(os.listdir(path_dir + str(i)))):
            for a in os.listdir(path_dir + str(i) + '/' + str(j)):
                s3.Bucket('todayis').upload_file('./clothes/spoty/level' + str(i) + '/' + str(j) + '/' + str(a),
                                                 'spoty/level' + str(i) + '/' + str(j) + '/' + str(a))
                print(a)
            j+=1
        i += 1


def s3_classic_upload():
    path_dir = './clothes/classic/level'
    i = 1
    j = 0
    for i in range(1, 5):
        for j in range(len(os.listdir(path_dir + str(i)))):
            for a in os.listdir(path_dir + str(i) + '/' + str(j)):
                s3.Bucket('todayis').upload_file('./clothes/classic/level' + str(i) + '/' + str(j) + '/' + str(a),
                                                 'classic/level' + str(i) + '/' + str(j) + '/' + str(a))
                print(a)
            j+=1
        i += 1

def get_url(url):
        for i in range(len(url)):
            print('"'+'https://store.musinsa.com/app/styles/views/'+str(url[i])+'"')
        print("\n")


musinsa_street_url_level_1_num = [8302,7541,7533,7503,7492,3794,3793,3789,3062,3055,3051,2302,7431,7396,8085, 8048, 8035]
musinsa_street_url_level_2_num = [8869,8859,8814,8805,8776,8775,8764,8762,8761,8330,8327,8312,8305,8299,7901,7900,7895,7270, 8749, 8747, 8686, 8639]
musinsa_street_url_level_3_num = [8876,8813,8812,8772,8283,8282,8280,8272,4487,2274,1934,1930,1926,6107,6097,6348,6745,6734, 9219, 9011, 8921]
musinsa_street_url_level_4_num = [5383,5382,5379,5371,5747,5672,5667,5666,5659,5656,5618,6014,5975,5802, 9559, 9564, 9520, 9500, 9449, 9441, 9416]
musinsa_classic_url_level_1_num = [8040,7899,7862,7795,7723,7722,7713,7657,7472,7192,7126,7123,7025,6848,6811,3802,3520,7301]
musinsa_classic_url_level_2_num = [8894,8803,8730,8636,8523,8500,8398,8329,8240,8067,8064,8041,7934,7904,7892,7788,7727,6342,6331, 8662, 8540, 8535]
musinsa_classic_url_level_3_num = [8802,8525,6354,6017,5737,4815,4708,4257,4100,4065,1840,9251, 9547, 9527, 9469, 9470, 9457, 9458, 9454, 9427, 9288]
musinsa_classic_url_level_4_num = [5889,5860,5673,5473,5460,5319,5106,4962,9552, 9521, 9507, 9445, 5100, 4952, 5737, 6081]
musinsa_casual_url_level_1_num = [7852,7849,7959,7955,3562,3469,7461,7206, 8066, 8043, 7966, 7961, 7954, 7936, 7857, 7853]
musinsa_casual_url_level_2_num = [7905,7854,7792,7728,7670,7665,7617,7614,7611,7604,7600,7597,7595,8689,8688,8676,8495,8485,8392,8325]
musinsa_casual_url_level_3_num = [8811,8804,8765,8763,8758,8678,8664,8499,8487,8399,8393,8909,8904,9543,9537,9002,9001,8990,8996,8988,8920]
musinsa_casual_url_level_4_num = [5757,5755,5740,5729,5725,5722,5720,5677,5676,5675,5674,5670,5663,5661,5654,5577,5576,5571,5560,5558,5653,5651,5649,5646,5645,5615,5610,5604,5599,5556,5553,5544,5486]
musinsa_spoty_url_level_1_num = [7536, 7490, 3699, 7623, 7613, 7949, 7938,7802,7756,7718,7011,6984,6982,6968,6855]
musinsa_spoty_url_level_2_num = [7903,7894,8318,4057,4001,3807,7716,8076,8057,8641,8552,8396,8669,8637,8315,8072,7957,6966]
musinsa_spoty_url_level_3_num = [8905,8871,6103,5736,5370,5361,5159,4731,4711,4635,4567,4566,4495,9560,9462,9319,9293,9247,9238,9008,8992]
musinsa_spoty_url_level_4_num = [6009,6001,5756,5743,5735,5650,5642,5574,5555,5554,5547,5543,5252,5101,5098,9289,9245,9162,9052,8993,8987]



get_url(musinsa_casual_url_level_1_num)
get_url(musinsa_casual_url_level_2_num)
get_url(musinsa_casual_url_level_3_num)
get_url(musinsa_casual_url_level_4_num)
get_url(musinsa_classic_url_level_1_num)
get_url(musinsa_classic_url_level_2_num)
get_url(musinsa_classic_url_level_3_num)
get_url(musinsa_classic_url_level_4_num)
get_url(musinsa_spoty_url_level_1_num)
get_url(musinsa_spoty_url_level_2_num)
get_url(musinsa_spoty_url_level_3_num)
get_url(musinsa_spoty_url_level_4_num)
get_url(musinsa_street_url_level_1_num)
get_url(musinsa_street_url_level_2_num)
get_url(musinsa_street_url_level_3_num)
get_url(musinsa_street_url_level_4_num)

#musin_street(musinsa_street_url_level_1_num, 1)
#musin_street(musinsa_street_url_level_2_num, 2)
#musin_street(musinsa_street_url_level_3_num, 3)
#musin_street(musinsa_street_url_level_4_num, 4)
#musin_classic(musinsa_classic_url_level_1_num, 1)
#musin_classic(musinsa_classic_url_level_2_num, 2)
#musin_classic(musinsa_classic_url_level_3_num, 3)
#musin_classic(musinsa_classic_url_level_4_num, 4)
#musin_casual(musinsa_casual_url_level_1_num, 1)
#musin_casual(musinsa_casual_url_level_2_num, 2)
#musin_casual(musinsa_casual_url_level_3_num, 3)
#musin_casual(musinsa_casual_url_level_4_num, 4)
#musin_spoty(musinsa_spoty_url_level_1_num, 1)
#musin_spoty(musinsa_spoty_url_level_2_num, 2)
#musin_spoty(musinsa_spoty_url_level_3_num, 3)
#musin_spoty(musinsa_spoty_url_level_4_num, 4)


#s3_street_upload()
#s3_casual_upload()
#s3_spoty_upload()
#s3_classic_upload()
