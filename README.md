# SpringCloudStream
Spring Cloud Stream with multiple binder on the classpath


# 1. run the single-node kafka and rabbitmq binder:
find the docker-compose files for kafka and rabbitmq under resources folder: 
>>run it using command:
docker-compose up

# 2 Make sure both the servers are listening on the respective ports: 
>>run the below commands
$ nc -z localhost 22181
Connection to localhost port 22181 [tcp/*] succeeded!
$ nc -z localhost 29092
Connection to localhost port 29092 [tcp/*] succeeded!

# 3 run the application as spring boot jar: 
>>run the below command
$ gradle bootRun

# 4. Use kafka tool to check kafka brokers dashboard:
>> https://kafkatool.com/download.html

![image](https://user-images.githubusercontent.com/17970459/124080152-e3b2d280-d9fe-11eb-9a63-a6ca71682efd.png)

# 5 use rabbitMq managemnt console to view the management console
>> at http://localhost:15672/ 

![image](https://user-images.githubusercontent.com/17970459/124080197-f3321b80-d9fe-11eb-9317-785960228069.png)
