package zhongqiu.common.jdk5.concurrent;

import java.util.concurrent.*;

/*ThreadPoolExecutor 线程池
* 继承关系：ThreadPoolExecutor extends AbstractExecutorService
*          abstract class AbstractExecutorService implements ExecutorService
*          interface ExecutorService extends Executor
* 方法说明：submit方法带有返回值，用future接收，通过future.get()方法获取返回值。最终调用的execute方法
*          execute方法，没有返回值，执行runnable
*   execute方法说明:如果工作线程数小于核心线程数，addWorker(command, true)。
*                  如果 isRunning(c) && workQueue.offer(command)。
*                  否则 addWorker(command, false) ；否则拒绝任务 reject(command);
*   addWorker方法：通过spin和cas增加workcount，生成封装新thread和firsttask的worker，worker继承了aqs
*                 通过mainLock加锁线程安全的将此worker添加进workers集合中，更新largestPoolSize
*                 启动worker对应的线程，运行runWorker方法。
*                 如果worker创建失败，回滚，将worker从workers集合中删除，并原子性的减少workerCount。
*   runWorker方法：while循环不断的调用 getTask()获取task，直到获取不到为止。
*                 每一次循环内部，获取到task，worker.lock加锁线程安全，
*                 先执行钩子方法 beforeExecute(wt, task)，需要继承ThreadPoolExecutor自己实现
*                 然后执行 task.run()，也就是自己写的run方法
*                 然后执行钩子方法 afterExecute(task, thrown)，需要继承ThreadPoolExecutor自己实现
*                 worker的completedTasks++，worker.unlock 解锁
*                 循环结束执行钩子方法 processWorkerExit(w, completedAbruptly)
*   getTask方法：boolean timed = allowCoreThreadTimeOut || wc > corePoolSize
*               Runnable r = timed ?
                    workQueue.poll(keepAliveTime, TimeUnit.NANOSECONDS) :workQueue.take();
*   processWorkerExit方法：是在worker退出时调用到的钩子函数，而引起worker退出的主要因素如下
　　                       ① 阻塞队列已经为空，即没有任务可以运行了。
                           ② 调用了shutDown或shutDownNow函数
                           mainLock 加锁使线程安全
                           将worker完成的任务添加到总的完成任务中 completedTaskCount += w.completedTasks;
                           从workers集合中移除该worker。workers.remove(w)。mainLock解锁
                           尝试终止线程池 tryTerminate();
* */
public class ThreadPoolExecutorDemo {
    public static void main(String[] args) {
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(10, 10, 60, TimeUnit.SECONDS, blockingQueue);

        //execute方法，没有返回值，执行runnable
        threadPoolExecutor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });

        //submit方法带有返回值，用future接收，通过future.get()方法获取返回值
        Future future = threadPoolExecutor.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("run");
            }
        });
        try {
            future.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}