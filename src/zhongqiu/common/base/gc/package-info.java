/**
 * 
 */
/**
 * @author wanghzongqiu
 * ��1�������.�����classload��
 * ��2��JVM�ڴ�ṹ��������ϵͳ(Class loader��ϵͳ��Execution engine(ִ������))��
 *     ��������ֱ���Runtime data area (����ʱ��������)�����Native interface(���ؽӿ�)���
 *     Runtime Data Area�����1��Heap (��)2��Method Area(��������)3��Java Stack(java��ջ��
 *                          4��Program Counter(���������)5��Native method stack(���ط���ջ)������native������������ĵ�ַ
 *     ��������Method Area��,��Java��һ�����Ǹ����̹߳�����ڴ����������ڴ洢�ѱ���������ص�����Ϣ����������̬��������ʱ�����������Ĵ�������ݡ�
 *     ����������ϴ�����ָ��JVM��Heap�ռ䣬���־ô�����֮ǰ�ᵽ��Method Area��������Heap��
 *     ���Ʋ���
		-Xms���öѵ���С�ռ��С��
		-Xmx���öѵ����ռ��С��
		-XX:NewSize������������С�ռ��С��
		-XX:MaxNewSize�������������ռ��С��
		-XX:PermSize�������ô���С�ռ��С��
		-XX:MaxPermSize�������ô����ռ��С��
		-Xss����ÿ���̵߳Ķ�ջ��С��
 * ��3�� GC�㷨 �������գ������Ϊ�����(Young)�����ϴ�(Tenured)���־ô�(Perm)���Բ�ͬ�������ڵĶ���ʹ�ò�ͬ���㷨.
 *     ���ϴ�ʹ�ñ��-ѹ���㷨���߱��-ɾ���㷨�������ʹ�ø����㷨
                    �����ռ�����ѡ��GCCollector
 *     �ڴ�й¶���ֶ������ɵ����ö����м������Ϊnull������أ�������
 * ��4��GC���� �������
 *     �ڴ��⹤�ߣ�jconsole��JProfiler
 */
package zhongqiu.common.base.gc;