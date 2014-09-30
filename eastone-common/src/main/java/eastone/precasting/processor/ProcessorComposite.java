/*
 * create:2014年9月28日 下午7:43:09
 * author:wangds  
 */
package eastone.precasting.processor;

import java.util.List;

import eastone.common.composite.AbstractLinkedListComposite;
import eastone.common.processor.Processor;

/**
 * .
 * 
 * @author wangds
 *
 */
public class ProcessorComposite extends AbstractLinkedListComposite<Processor> implements Processor {

    /*
     * @see eastone.common.processor.Processor#process()
     * 
     * @author wangds 2014年9月28日 下午7:43:09.
     */
    @Override
    public void process() throws Exception{

        List<Processor> list = this.listAllComponent();

        for (Processor p : list) {
            p.process();
        }

    }

}
