/**
 * 
 */
/**
 * @author zhongqiu
 * �ο����ϣ�http://www.runoob.com/java/java-stack-class.html
 * ʵ����  http://www.runoob.com/java/java-examples.html
 * java������
 * ��1�������������ͣ�ֵ���ͺ��������ͣ�string�����أ�intern()������stringbuilder
 * ��2�������������a++��++a,��Ԫ�������instanceof�����
 * ��3���쳣��������쳣���쳣��Ϊ����ʱ�쳣�ͷ�����ʱ�쳣
 * ��4��String,StringBuffer,StringBuilder���:stringbuilder�ķ���ʹ��
 * ��5��Number������أ���Ӧ��������
 * ��6���������Math.random():�����������λ�ַ���
 * ��7��������� 
 * ��8������أ�����ع��̣�ԭ��(˫��ί��ģʽ)�������������������ص����ַ�ʽ���Զ���classloader
 * ��9��JVM�ڴ����������ϵͳ(Class loader��ϵͳ��Execution engine(ִ������))��
 *     ��������ֱ���Runtime data area (����ʱ��������)�����Native interface(���ؽӿ�)���
 *     Runtime Data Area�����1��Heap (��)2��Method Area(��������)3��Java Stack(java��ջ��
 *                          4��Program Counter(���������)5��Native method stack(���ط���ջ)������native������������ĵ�ַ
 *     JVM GCԭ�������Ϊ�����(Young)�����ϴ�(Tenured)���־ô�(Perm)���Բ�ͬ�������ڵĶ���ʹ�ò�ͬ���㷨
 *     ����������ϴ�����ָ��JVM��Heap�ռ䣬���־ô�����֮ǰ�ᵽ��Method Area��������Heap��
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * 
 * ��1�������е�List��arrayList��linkedList,vector�������ʹ�ó���
 * ��2�������е�Stack��push��pop��peek��search
 * ��3�������е�Array������Ĵ�����������Ϊ��������Ϊ����ֵ
 * ��4�������е�Arrays��
 * ��5�������е�Set��hashset,treeset,LinkedHashSet
 * ��6�������е�Map��hashmap,treemap,����
 * ��7�������е�Collections�ࣺ�Լ��ϵĸ��ֲ��������ֱ�����ʽ���������򣬽������򣬻��ţ��Զ�������
 * 
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * 
 * ��1��ͬ��Synchronized
 * ��2�����߳�:1�����̵߳�����ʵ�ַ�����2���������һ�����߳�ִ�д��룻3���̵߳ĳ��÷�����4��wait��notify��ʹ�ã�5�����������⣨�����߳̽����ӡ10��ABC��
 * ��3���̳߳� ThreadPoolExecutor
 * ��4��Volatile�ؼ���
 * 
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * 
 * ��1��Date���
 * ��2���������
 * ��3����(Stream)���ļ�(File)��IO
 * ��4�����л� Serialize
 * ��5�������� socket,tcp/ip,http
 * ��6�����ʼ� send mail
 */
package zhongqiu.common.base;