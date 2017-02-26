/**
 * 
 */
/**
 * @author zhongqiu
 *https://www.ibm.com/developerworks/cn/education/java/j-nio/j-nio.html
 *��Ҫ���ͨ����������
 *����io������io���������ģ�nio�����򻺳�����
 *
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
  
 *�塢��������Ƭ�����ݹ������������ӻ���������ͬһ���ײ���������
 *   ��Ƭ���ӻ���������buffer.position( 3 );
         buffer.limit( 7 );
         ByteBuffer slice = buffer.slice();    
 *����ֻ����������ͨ�����û������� asReadOnlyBuffer() ���������κγ��滺����ת��Ϊֻ����������
 *   �����������һ����ԭ��������ȫ��ͬ�Ļ�����(�����乲������)��ֻ��������ֻ���ġ�  ���ܽ�ֻ���Ļ�����ת��Ϊ��д�Ļ�������
 *�ߡ�ֱ�Ӻͼ�ӻ������� FastCopyFile.java��ByteBuffer buffer = ByteBuffer.allocateDirect( 1024 );
 *
 *
 */
package zhongqiu.common.base.nio;

import java.nio.ByteBuffer;
