/**
 * 
 */
/**
 * @author zhongqiu 
 * �ο����ϣ�http://www.cnblogs.com/nayitian/p/3406749.html
 * jdk1.7����
 * ��1��switch�п���ʹ���ִ���
 * ��2�������Զ��ƶ�
 * ��3����ֵ�ɼ��»���
 * ��4��֧�ֶ���������
 * ��5����������С�transferqueue��tryTransfer��transfer��tryTransfer(E e, long timeout, TimeUnit unit)��
 * ��6��ForkJoinTask
 * ��5����try catch�쳣��׽�У�һ��catch����д����쳣���ͣ���"|"����
 * ��6���Զ���Դ����
 *     jdk7֮ǰ���������try{}finally{}��try��ʹ����Դ����finally�йر���Դ������try�еĴ����Ƿ������˳������쳣�˳���
 *     jdk7֮������Բ���Ҫдfinally������ر���Դ��ֻҪ����try()�������ڲ�����Ҫʹ�õ���Դ��
 * ��7���ɱ�����Ǿ��廯ʱ��ʾ����
 * ��8������һЩȡ������Ϣ�Ĺ��߷���
 */
package zhongqiu.common.jdk7;