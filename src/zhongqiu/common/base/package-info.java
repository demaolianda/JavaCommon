/**
 * 
 */
/**
 * @author zhongqiu
 * �ο����ϣ�http://www.runoob.com/java/java-stack-class.html
 * ʵ����  http://www.runoob.com/java/java-examples.html
 * java������
 * ��1�������������ͣ�8���������ͣ�ֵ���ͺ��������ͣ������أ�intern()������stringbuilder
 * ��2�������������a++��++a,��Ԫ�������instanceof�������λ�����,&&��&������
 * ��3���쳣��������쳣���쳣��Ϊ����ʱ�쳣�ͷ�����ʱ�쳣��Throwable��Error��Exception��RuntimeException
 * ��4��String,StringBuffer,StringBuilder����:stringbuilder�ķ���ʹ��
 * ��5��Number������أ���Ӧ�������͵ķ�װ�ࡣ�Ƿ�ʵ���˳����ؼ�������Щʵ���ˣ���Щû��ʵ�֣�����Щ����.������.class�ļ��У��������ڱ�JVMװ�أ����ҿ�������
 * ��6���������Math.random():�����������λ�ַ���
 * ��7��������� 
 * ��7���ؼ����÷���final��volatile��native��static��transient,break,continue
 * ��8������أ�����ع��̣�ԭ��(˫��ί��ģʽ)�������������������ص����ַ�ʽ���Զ���classloader
 * ��9��JVM�ڴ����������ϵͳ(Class loader��ϵͳ��Execution engine(ִ������))��
 *     ��������ֱ���Runtime data area (����ʱ��������)�����Native interface(���ؽӿ�)���
 *     Runtime Data Area�����1��Heap (��)2��Method Area(��������)3��Java Stack(java��ջ��
 *                          4��Program Counter(���������)5��Native method stack(���ط���ջ)������native������������ĵ�ַ
 *     JVM GCԭ�������Ϊ�����(Young)�����ϴ�(Tenured)���־ô�(Perm)���Բ�ͬ�������ڵĶ���ʹ�ò�ͬ���㷨
 *     ����������ϴ�����ָ��JVM��Heap�ռ䣬���־ô�����֮ǰ�ᵽ��Method Area��������Heap��
 *     �ڴ�й¶���ֶ������ɵ����ö����м������Ϊnull������أ������ã�JVM���� 
 *     �ڴ��⹤�ߣ�jconsole��JProfiler
 * ��10��object����ط�����equals�ĸ����ԣ��Է����Գƣ�һ�£����ݣ�hashcode������Э������Ҫ��д���龰��getclass��toString��notify��wait
 * ��11���ڲ��ࡣ�����ڲ���,��̬�ڲ���,˽���ڲ���,�ֲ��ڲ���,�����ڲ���,�ڲ����еı���������ʽ
 *  *  *  *  *  *  *  *  *  *  *  *  *  *  *  * 
 * ��1�����߳� 
 * ��2��Nio
 * ��3������
 * ��1��Date���
 * ��2���������
 * ��4�����л� Serialize
 * ��5�������� socket,tcp/ip,http
 * ��6�����ʼ� send mail
 */
package zhongqiu.common.base;