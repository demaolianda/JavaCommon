/*
 * @author zhongqiu
 * jdk5����
 * ��Ҫ���ԣ� 
 * ��1���Զ�װ�������
 * ��2��ö�٣�ö�ٵ�switch���Զ���ö�٣�ö��ʵ�ֽӿ�
 * ��3����̬����:import static java.lang.System.out;��̬������Ǿ�̬����
 * ��4���ɱ������Varargs��: int ... args
 * ��5����ʡ��Introspector��
 * ��6�����ͣ������ࣻ������Ϊ�����Ϳɱ������������Ϊ����ֵ�����ͷ���������ͨ�����extend��super�÷���
 * ��7����ǿ��forѭ��For-Each
 * ��8��Scanner�ࡣ������ȡ�û�������
 * ��9�����У����������С�blockingqueue��add��put��take��offer��poll��contains��remove��drainTo��
 *          ArrayBlockingQueue,LinkedBlockingQueue,,PriorityBlockingQueue
 *          DelayQueue����дgetDelay��compareTo����
 *          SynchronousQueue��ÿ�������������ȴ���һ���̵߳Ķ�Ӧ�Ƴ����� ����֮��Ȼ��ͬ������û���κ��ڲ�������������һ�����е�������û�С�
 * ��10��CountDownLatch��ͬ�������ࣨawait��countDown��getCount����
 *      Ӧ�ó�����������Thread1��Thread2��Thread3��Thread4�����̷ֱ߳�ͳ��C��D��E��F�ĸ��̵Ĵ�С�������̶߳�ͳ����Ͻ���Thread5�߳�ȥ������
 * ��11��ConcurrentHashMap��Ӧ�ó���,ʵ��ԭ��,�����뼼����volatile��Segment����hashtable��������һ�µ�������������Ҫ��
 * ��12��ReentrantLock������Դ�������Ǻܼ��ҵ�����£�Synchronized������Ҫ����ReetrantLock��
 *                    ��������Դ�����ܼ��ҵ�����£�Synchronized�����ܻ��½���ʮ��
 *                    ��ƽ����new RenentrantLock(boolean fair)����synchronizedĬ�Ϲ�ƽ����ReentrantLockĬ�ϲ���ƽ��
 *                    ��ʱ���Ⱥ�(tryLock)�Ϳ��ж����Ⱥ�. lock ������ finally �����ͷ�
 * ��13��ReentrantReadWriteLock����д������synchronized������ʵ��ԭ��Ĳ�ͬ��
 * ��14��Atomic��ԭ���Բ�����addAndGet��getAndAdd��decrementAndGet() ��compareAndSet(int expect, int update)
 * ��15���̳߳�Executors��newCachedThreadPool()��newFixedThreadPool(3)��newSingleThreadExecutor();newScheduledThreadPool(5)
 *                     
 */
package zhongqiu.common.jdk5;