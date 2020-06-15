from pyspark import SparkContext, SparkConf
import sys

sc = SparkContext.getOrCreate()

r = sc.textFile("hdfs://"+sys.argv[1])

print "Count: ", r.count()
