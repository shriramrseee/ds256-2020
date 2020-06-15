package in.ds256.Giraph;

import org.apache.giraph.aggregators.LongSumAggregator;
import org.apache.giraph.master.DefaultMasterCompute;
import org.apache.hadoop.io.LongWritable;
import org.apache.log4j.Logger;

/**
 * MasterCompute
 */
public class SimpleMaster extends DefaultMasterCompute {

    private static final String SMC_AGG = "simplemastercompute.aggregator";

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
