package in.ds256.Giraph;

import org.apache.giraph.graph.BasicComputation;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

/**
 * Demonstrates a computation with a centralized part implemented via a
 * MasterCompute.
 */
public class SimpleMasterComputation extends BasicComputation<LongWritable, DoubleWritable, FloatWritable, DoubleWritable> {

    private static final String SMC_AGG = "simplemastercompute.aggregator";

    @Override
    public void compute(Vertex<LongWritable, DoubleWritable, FloatWritable> vertex, Iterable<DoubleWritable> messages) throws IOException {
        this.aggregate(SMC_AGG, new LongWritable(vertex.getId().get()*vertex.getId().get()));
    }

}
