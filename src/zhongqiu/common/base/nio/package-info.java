/**
 * 
 */
/**
 * @author zhongqiu
 *https://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html
 *һ������״̬������position��limit��capacity��position<=limit,limit<=capacity
 *   buffer.flip(),�ı�position��limit��ֵ��
 *   
 *�������ʷ�����get()��put()
 *   get() �� put() ����Է����;��Է�������Է����ڵ��ú��ı�position��ֵ�����Է�������ı�
 *   
 *������������ʹ�á�FileChannel.read() ��FileChannel. write() ���õõ��˼���ļ򻯣�
 *   ��Ϊ��๤��ϸ�ڶ��ɻ���������ˡ� clear() �� flip() ���������û������ڶ���д֮���л���
 *   
 *�ġ�����������Ͱ�װ�����䣺ByteBuffer.allocate( 1024 )��
 *               ��װ��byte array[] = new byte[1024];
                     ByteBuffer buffer = ByteBuffer.wrap( array );
  
 *�塢
                  
 */
package zhongqiu.common.base.nio;