from pyspark import SparkContext, SparkConf

sc = SparkContext.getOrCreate()

r = sc.textFile("hdfs://"+sys.argv[1])

print "Count: ", r.count()
