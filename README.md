# ds256-2020
Course Repository for DS 256 (Jan 2020)

## Giraph Build

Build the Java code by runnning ```mvn clean package``` inside the giraph folder. In order to run the examples, you will need Hadoop-3.1.1 running in distributed mode or pseudo-distributed mode along with YARN.
 
```
hadoop jar Giraph-Tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar org.apache.giraph.GiraphRunner \
in.ds256.Giraph.OutDegreeComputation \
-yj Giraph-Tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar \
-yh 2000 \
-vif org.apache.giraph.io.formats.JsonLongDoubleFloatDoubleVertexInputFormat \
-vip tiny_graph.txt \
-vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-op sample_output -w 1
```

```
hadoop jar Giraph-Tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar org.apache.giraph.GiraphRunner \
in.ds256.Giraph.SSSPComputation \
-yj Giraph-Tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar \
-yh 2000 \
-vif org.apache.giraph.io.formats.JsonLongDoubleFloatDoubleVertexInputFormat \
-vip tiny_graph.txt \
-vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-op sample_output -w 1 \
-ca SimpleShortestPathsVertex.sourceId=0
```

```
hadoop jar Giraph-Tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar org.apache.giraph.GiraphRunner \
in.ds256.Giraph.SimpleMasterComputation \
-mc in.ds256.Giraph.SimpleMaster \
-yj Giraph-Tutorial-1.0-SNAPSHOT-jar-with-dependencies.jar \
-yh 2000 \
-vif org.apache.giraph.io.formats.JsonLongDoubleFloatDoubleVertexInputFormat \
-vip tiny_graph.txt \
-vof org.apache.giraph.io.formats.IdWithValueTextOutputFormat \
-op sample_output -w 1
```

## YARN logs

```
yarn logs --applicationId application_1580462928077_0009
```
Replace ```application_1580462928077_0009``` with your YARN application ID

## Useful Links

[1] https://giraph.apache.org/quick_start.html

[2] https://giraph.apache.org/intro.html

[3] https://giraph.apache.org/aggregators.html

[4] https://giraph.apache.org/options.html

[5] https://github.com/apache/giraph




