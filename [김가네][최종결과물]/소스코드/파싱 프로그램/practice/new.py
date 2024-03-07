import boto3

s3 = boto3.resource('s3')
bucket = s3.Bucket('todayis')

li_sub = []
for obj in bucket.objects.all():
    url = "https://s3.ap-northeast-2.amazonaws.com/todayis/"+obj.key
    print(url)
    if '_all' in url:
        print("\n")
