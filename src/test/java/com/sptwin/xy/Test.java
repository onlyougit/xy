package com.sptwin.xy;

import com.alibaba.fastjson.JSON;
import com.sptwin.xy.entity.Contract;
import com.sptwin.xy.utils.JsonFormatTool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {
    public static void main(String[] args){
        /*ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 16, 1000, TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(5));*/


        //使用LinkedBlockingQueue，没有指定队列大小，所以队列默认值Integer.MAX_VALUE
        //ThreadPoolExecutor(nThreads,nThreads,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>())
        /*运行结果:
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-2
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-2
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-2
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-2*/
        //ExecutorService executor = Executors.newFixedThreadPool(2);


        //先查看池中有没有以前建立的线程
        //ThreadPoolExecutor(0, Integer.MAX_VALUE,60L, TimeUnit.SECONDS,new SynchronousQueue<Runnable>())
        /*运行结果:
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-2
        线程名称：pool-1-thread-3
        线程名称：pool-1-thread-4
        线程名称：pool-1-thread-5
        线程名称：pool-1-thread-6
        线程名称：pool-1-thread-7
        线程名称：pool-1-thread-8*/
        //ExecutorService executor = Executors.newCachedThreadPool();


        //定时及周期性任务执行
        //ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(5);


        //new FinalizableDelegatedExecutorService(new ThreadPoolExecutor(1, 1,0L, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<Runnable>()))
        /*运行结果:
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-1
        线程名称：pool-1-thread-1*/
        ExecutorService executor = Executors.newSingleThreadExecutor();

        for(int i=0;i<8;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
            /*System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());*/
        }
        executor.shutdown();
    }
    public static String getString(){
        List<Contract> list = new ArrayList<>();
        Contract contract = new Contract();
        contract.setId(1l);
        contract.setCommodityNo("test");
        contract.setContractName("测试");
        contract.setContractNo("test");
        contract.setMainContract(1);
        list.add(contract);
        Contract contract2 = new Contract();
        contract2.setId(2l);
        contract2.setCommodityNo("test");
        contract2.setContractName("测试");
        contract2.setContractNo("test");
        contract2.setMainContract(1);
        list.add(contract2);
        Contract contract3 = new Contract();
        contract3.setId(3l);
        contract3.setCommodityNo("test");
        contract3.setContractName("测试");
        contract3.setContractNo("test");
        contract3.setMainContract(1);
        list.add(contract3);
        Contract contract4 = new Contract();
        contract4.setId(4l);
        contract4.setCommodityNo("test");
        contract4.setContractName("测试");
        contract4.setContractNo("test");
        contract4.setMainContract(1);
        list.add(contract4);
        Contract contract5 = new Contract();
        contract5.setId(5l);
        contract5.setCommodityNo("test");
        contract5.setContractName("测试");
        contract5.setContractNo("test");
        contract5.setMainContract(1);
        list.add(contract5);
        String json = JSON.toJSONString(list);
        String jsonFormat = JsonFormatTool.formatJson(json);
        return jsonFormat;
    }


}
