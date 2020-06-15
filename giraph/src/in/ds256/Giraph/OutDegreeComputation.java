package in.ds256.Giraph;

import org.apache.giraph.Algorithm;
import org.apache.giraph.graph.BasicComputation;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.LongWritable;

import java.io.IOException;

/**
 * Simple function to return the out degree for each vertex.
 */
@Algorithm(
        name = "Outdegree Count"
)
public class OutDegreeComputation extends BasicComputation<
        LongWritable, LongWritable, DoubleWritable, DoubleWritable> {

    @Override
    public void compute(Vertex<LongWritable, LongWritable, DoubleWritable> vertex, Iterable<DoubleWritable> messages) throws IOException {
        LongWritable vertexValue = vertex.getValue();
        vertexValue.set(vertex.getNumEdges());
        vertex.setValue(vertexValue);
        vertex.voteToHalt();
    }
}
