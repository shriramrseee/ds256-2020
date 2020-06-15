from pyspark import SparkContext, SparkConf
import sys

sc = SparkContext.getOrCreate()

r = sc.textFile("hdfs://"+sys.argv[1])

c = r.count()

# Save to file

sc.parallelize([str(c)]).saveAsTextFile("hdfs://"+sys.argv[2])