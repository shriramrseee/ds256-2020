package in.ds256.Giraph;

import org.apache.giraph.aggregators.LongSumAggregator;
import org.apache.giraph.graph.BasicComputation;
import org.apache.giraph.master.DefaultMasterCompute;
import org.apache.giraph.graph.Vertex;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.FloatWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.log4j.Logger;

import java.io.IOException;

/**
 * Demonstrates a computation with a centralized part implemented via a
 * MasterCompute.
 */
public class SimpleMasterComputation extends BasicComputation<LongWritable, DoubleWritable, FloatWritable, DoubleWritable> {

    /** Aggregator to get values from the master to the workers */
    public static final String SMC_AGG = "simplemastercompute.aggregator";

    @Override
    public void compute(Vertex<LongWritable, DoubleWritable, FloatWritable> vertex, Iterable<DoubleWritable> messages) throws IOException {
        this.aggregate(SMC_AGG, new LongWritable(vertex.getId().get()*vertex.getId().get()));
    }


    /**
     * MasterCompute
     */
    public static class SimpleMaster extends DefaultMasterCompute {

        private static final Logger LOG = Logger.getLogger(SimpleMaster.class);

        @Override
        public void compute() {
            Long total = ((LongWritable) getAggregatedValue(SMC_AGG)).get();
            LOG.info("Hello, the total is " + total);
            if (getSuperstep() == 0) {
                haltComputation();
            }
        }

        @Override
        public void initialize() throws InstantiationException,
                IllegalAccessException {
            registerPersistentAggregator(SMC_AGG, LongSumAggregator.class);
        }
    }
}
