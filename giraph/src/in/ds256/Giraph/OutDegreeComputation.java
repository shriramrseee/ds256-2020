package in.ds256.Giraph;

import org.apache.giraph.Algorithm;
import org.apache.giraph.graph.BasicComputation;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

/**
 * Simple function to return the out degree for each vertex.
 */
@Algorithm(
        name = "Outdegree Count"
)
public class OutDegreeComputation extends BasicComputation<
        LongWritable, DoubleWritable, FloatWritable, DoubleWritable> {

    @Override
    public void compute(Vertex<LongWritable, DoubleWritable, FloatWritable> vertex, Iterable<DoubleWritable> messages) throws IOException {
        DoubleWritable vertexValue = vertex.getValue();
        vertexValue.set(vertex.getNumEdges());
        vertex.setValue(vertexValue);
        vertex.voteToHalt();
    }
}
