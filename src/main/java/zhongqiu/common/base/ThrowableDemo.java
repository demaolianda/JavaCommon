package zhongqiu.common.base;

//�쳣
//http://www.runoob.com/java/java-exceptions.html
public class ThrowableDemo extends Throwable{
	// Throwable�����˴���(Error)���쳣(Exception����)
	// Exception�ְ���������ʱ�쳣(RuntimeException, �ֽзǼ���쳣)�ͷ�����ʱ�쳣(�ֽм���쳣)
	// (1) Error�ǳ����޷�������, ���OutOfMemoryError�ȵ�, ��Щ�쳣����ʱ,java�����һ�����ֹ�߳� .
	// (2) ����ʱ�쳣����RuntimeException�༰������,��
	// NullPointerException��IndexOutOfBoundsException��, ��Щ�쳣�ǲ������쳣,
	// ���ڳ������е�ʱ����ܻᷢ����, ���Գ�����Բ�׽, Ҳ���Բ���׽. ��Щ����һ�����ɳ�����߼����������, ����Ӧ�ô��߼��Ƕ�ȥ��������.
	// (3) ����쳣������ʱ�쳣������쳣, Ҳ��Exception��������, ��Щ�쳣�ӳ���ĽǶ���˵�Ǳ��뾭����׽��鴦���, ������ͨ������.
	// ��IOException��SQLException��
}
