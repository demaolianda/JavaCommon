/**
 * 
 */
/**
 * @author zhongqiu
 * �ο����ϣ�http://www.runoob.com/java/java-stack-class.html
 * ʵ����  http://www.runoob.com/java/java-examples.html
 * java������
 * ��1�������������ͣ�8���������ͣ�ֵ���ͺ��������ͣ������أ�intern()������stringbuilder
 * ��2�������������a++��++a,��Ԫ�������instanceof�������λ�����
 * ��3���쳣��������쳣���쳣��Ϊ����ʱ�쳣�ͷ�����ʱ�쳣��Throwable��Error��Exception��RuntimeException
 * ��4��String,StringBuffer,StringBuilder���:stringbuilder�ķ���ʹ��
 * ��5��Number������أ���Ӧ�������͵ķ�װ�ࡣ�Ƿ�ʵ���˳����ؼ�������Щʵ���ˣ���Щû��ʵ�֣�����Щ����
 * ��6���������Math.random():�����������λ�ַ���
 * ��7��������� 
 * ��7���ؼ��֣�final��volatile��native��instance of��static��transient  
 * ��8������أ�����ع��̣�ԭ��(˫��ί��ģʽ)�������������������ص����ַ�ʽ���Զ���classloader
 * ��9��JVM�ڴ����������ϵͳ(Class loader��ϵͳ��Execution engine(ִ������))��
 *     ��������ֱ���Runtime data area (����ʱ��������)�����Native interface(���ؽӿ�)���
 *     Runtime Data Area�����1��Heap (��)2��Method Area(��������)3��Java Stack(java��ջ��
 *                          4��Program Counter(���������)5��Native method stack(���ط���ջ)������native������������ĵ�ַ
 *     JVM GCԭ�������Ϊ�����(Young)�����ϴ�(Tenured)���־ô�(Perm)���Բ�ͬ�������ڵĶ���ʹ�ò�ͬ���㷨
 *     ����������ϴ�����ָ��JVM��Heap�ռ䣬���־ô�����֮ǰ�ᵽ��Method Area��������Heap��
 * ��10��object����ط�����equals�ĸ����ԣ��Է����Գƣ�һ�£����ݣ�hashcode������Э������Ҫ��д���龰��getclass��toString��notify��wait
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * 
 * ��1�������е�List��arrayList��linkedList,vector�������ʹ�ó�����linkedlist˫��ѭ������vectorͬ��ʵ��ԭ��syn��
 * ��2�������е�Stack��push��pop��peek��search���̳���vector
 * ��3�������е�Array������Ĵ�����������Ϊ��������Ϊ����ֵ
 * ��4�������е�Arrays�࣬������ĸ��ֲ�����binarySearch��sort��fill��equals��asList��tostring��hashcode��copyof
 * ��5�������е�Set��hashset,LinkedHashSet��treeset�������������Զ�������
 * ��6�������е�Map��hashmap,treemap,����������+����hash�㷨 ����ʼ����(Ͱ)�ͼ������ӣ�rehash����(��������2��)������ַ�������ͻ���������put��delete
 * ��7�������е�Collections�ࣺ�Լ��ϵĸ��ֲ��������ֱ�����ʽ���������򣬽������򣬻��ţ��Զ�������
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * 
 * ��1�����߳� 
 * ��2��Nio
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * 
 * ��1��Date���
 * ��2���������
 * ��3����(Stream)���ļ�(File)��IO
 * ��4�����л� Serialize
 * ��5�������� socket,tcp/ip,http
 * ��6�����ʼ� send mail
 */
package zhongqiu.common.base;