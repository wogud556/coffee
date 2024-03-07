import boto3

s3 = boto3.resource('s3')
bucket = s3.Bucket('todayis')
dynamodb = boto3.resource('dynamodb')


li = []

i=0
for i in range(4):
    li_sub = []
    for obj in bucket.objects.all():
        url = str("https://s3.ap-northeast-2.amazonaws.com/todayis" + obj.key)
        if '.jpg' in url:
            if '_all' in url:
                li_sub.append(url)
                #print(url)
                #print(li_sub)
                break

            else:
                li_sub.append(url)
                #print(url)
    li.append(li_sub)
    i += 1

i=0
j=0
for i in range(len(li)) :
        print(li[i])
        print("\n")



