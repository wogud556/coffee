import boto3

s3 = boto3.client(
	's3',
    region_name="ap-northeast-2",
	aws_access_key_id="",
	aws_secret_access_key="",
)

# Output the bucket names
print('Existing buckets:')

response = s3.list_objects(Bucket ="hana-coffee-project", MaxKeys =300)

for content in response.get('Contents'):
    print("https://hana-coffee-project.s3.ap-northeast-2.amazonaws.com/" + content.get('Key'))
    print("\n")
