/*
 * create:2015年8月24日 上午11:21:44
 * author:wangds  
 */
package eastone;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.apache.commons.beanutils.converters.IntegerConverter;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;

/**
 * .
 * 
 * @author wangds
 *
 */
public class Test {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        
String txt = StringUtils.join(
"业牵1号线",  "开业线",        "清铁线",
"业郭1号线",  "开图线",        "牛虎线",
"清开1号线",  "新虎线",        "牛铁线",
"调法1号线",  "昌西线",        "调业线",
"郭牵1号线",  "昌郭线",        "昌牵乙线",
"铁新1号线",  "沈铁线",        "昌牵甲线",
"业牵2号线",  "清新线",        "牛牵乙线",
"业郭2号线",  "清昌线",        "牛牵甲线",
"清开2号线",  "清沈线",        "调华乙线",
"调法2号线",  "清牛线",        "调华甲线",
"郭牵2号线",  "清虎线",        "铁调乙线",
"铁新2号线",  "清郭线",        "铁调甲线",

"上八线",
"业庆线",
"东红线",
"亮十线",
"双四线",
"图丰线",
"城宝线",
"城金线",
"城马线",
"宝庆线",
"岗佛线",
"岗懿线",
"岗石线",
"岗莲线",
"平八线",
"开柏线",
"开清线",
"新阿线",
"昌东线",
"昌亮线",
"昌北线",
"昌宝线",
"昌铁线",
"昌闫线",
"松肥线",
"甸岱线",
"石新线",
"西丽线",
"西公线",
"西树线",
"西民线",
"西郜线",
"调柏线",
"调青线",
"铁团线",
"铁开线",
"铁甸线",
"铁莲线",
"阿青线",
"高和线",
"昌亮线",
"昌老线",
"金后线",
"岗地乙线",
"岗地甲线",
"岗祥乙线",
"岗祥甲线",
"开昌丙线",
"开昌乙线",
"开昌甲线",
"开李乙线",
"开李甲线",
"开电乙线",
"开电甲线",
"开西乙线",
"开西甲线",
"调跃乙线",
"调跃甲线",
"铁岗乙线",
"铁岗甲线",
"岗佛线新懿分",
"东红线古榆分线",
"东红线大洼分线",
"城金线亮中分线",
"岗佛线红光分线",
"岗开线业民分线",
"岗开线中固分线",
"岗开线团结分线",
"岗开线平顶分线",
"岗开线开南分线",
"岗开线振兴分线",
"岗石线红光分线",
"开清线东宁分线",
"开清线张相分线",
"开清线松山分线",
"昌东线昌东分线",
"昌东线郭家分线",
"昌北线毛四分线",
"昌北线泉头分线",
"昌北线泵站分线",
"昌北线满井分线",
"昌宝线昌宝分线",
"松肥线靠山分线",
"西丽线安民分线",
"西丽线隆达分线",
"西公线晨光分线",
"西树线和隆分线",
"西民线公合分线",
"西民线晨光分线",
"调青线腰堡分线",
"调青线青双分线",
"金后线大四分线",
"铁团线双安分线",
"铁团线龙首分线",
"铁开线业民分线",
"铁开线中固分线",
"铁开线平顶分线",
"铁开线开南分线",
"铁开线振兴分线",
"铁开线电厂分线",
"铁开线镇西分线",
"铁甸线新李分线",
"铁莲线振兴分线",
"业庆线三家子分线",
"岗地乙线高新分线",
"岗地甲线高新分线",
"开昌丙线马仲分线",
"开昌乙线东宁分线",
"开昌乙线张相分线",
"开昌乙线西丰分线",
"开昌甲线肉牛分线",
"开昌甲线马仲分线",
"开李乙线园区分线",
"开李乙线榆树分线",
"开李甲线园区分线",
"开李甲线榆树分线",
"开柏线金沟子分线",
"开电乙线开东分线",
"开电乙线清河分线",
"开电甲线开东分线",
"开电甲线清河分线",
"开西乙线立新分线",
"开西乙线老城分线",
"开西甲线威远分线",
"开西甲线老城分线",
"昌东线四面城分线",
"昌北线双庙子分线",
"铁岗乙线银南分线",
"铁岗甲线银南分线",
"铁开线左家沟分线",
"开西甲线南城子分线",
"昌亮线十八家子分线",
"丰双线丰三段付家分岐",
"丰双线丰三段平安分岐",
"丰双线丰三段曲家分线",
"铁开线左家沟分线龙首支线"

        );
        Set<Character> set = new TreeSet<Character>();
        for(char c:txt.toCharArray()){
            set.add(c);
        }
        
        System.out.println(set.size());
        for(char c:set){
            System.out.print(c);
            System.out.print(",");
        }
    }

}

