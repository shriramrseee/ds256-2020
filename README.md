# ds256-2020
Course Repository for DS 256 (Jan 2020)

## Java Build and Submission

Build the Java code by runnning ```mvn package``` inside the java folder.
 
```
spark-submit --class in.ds256.twitter.Count --master yarn --num-executors 2 --driver-memory 512m \
--executor-memory 2G --executor-cores 4 /home/shriramr/ds256-2020/java/target/twitter-1.0-SNAPSHOT-jar-with-dependencies.jar \
/user/ds256/twitter-tweets/tweets-999_1478472260018.txt
```

```
spark-submit --class in.ds256.twitter.CountToFile --master yarn --num-executors 2 --driver-memory 512m \
--executor-memory 2G --executor-cores 4 /home/shriramr/ds256-2020/java/target/twitter-1.0-SNAPSHOT-jar-with-dependencies.jar \
/user/ds256/twitter-tweets/tweets-999_1478472260018.txt output
```

## Python Submission

```
spark-submit --master yarn --deploy-mode cluster --driver-memory 512m \
--num-executors 2 --executor-cores 4 --executor-memory 2G  \
/home/shriramr/ds256-2020/python/Count.py \
/user/ds256/twitter-tweets/tweets-999_1478472260018.txt
```

## YARN logs

```
yarn logs --applicationId application_1580462928077_0009
```
Replace ```application_1580462928077_0009``` with your YARN application ID

## Twitter Data

[1] https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/tweet-object.html

[2] https://developer.twitter.com/en/docs/tweets/data-dictionary/overview/user-object




