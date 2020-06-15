package in.ds256.twitter;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.JavaRDD;
import java.io.IOException;
import java.net.URI;

public class Count {

    public static void main(String[] args) throws IOException {

        String inputFile = args[0]; // Should be some file on HDFS

        SparkConf sparkConf = new SparkConf().setAppName("Count");
        JavaSparkContext sc = new JavaSparkContext(sparkConf);

        /*
         * Code goes here
         */

        // Open file
        JavaRDD<String> twitterData = sc.textFile(inputFile);

        // Get Hash Count for each tweet
        long noOfTweets = twitterData.count();

        // Print
        System.out.println("Count: " + noOfTweets);

        sc.stop();
        sc.close();
    }

}