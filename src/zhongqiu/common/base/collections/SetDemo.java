package zhongqiu.common.base.collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

//set
//Set��List������
//1. Set �ӿ�ʵ���洢��������ģ����ظ������ݡ�List �ӿ�ʵ���洢��������ģ������ظ���Ԫ�ء�
//2. Set����Ч�ʵ��£�ɾ���Ͳ���Ч�ʸߣ������ɾ����������Ԫ��λ�øı� <ʵ������HashSet,TreeSet>��
//3. List���������ƣ����Զ�̬����������ʵ�ʴ洢�����ݵĳ����Զ�����List�ĳ��ȡ�
//   ����Ԫ��Ч�ʸߣ�����ɾ��Ч�ʵͣ���Ϊ����������Ԫ��λ�øı� <ʵ������ArrayList,LinkedList,Vector> ��
public class SetDemo {
	public static void main(String[] args) {

	}

	// HashSet�ఴ�չ�ϣ�㷨����ȡ�����еĶ��󣬴�ȡ�ٶȱȽϿ졣HashSet�໹��һ������LinkedHashSet�࣬������ʵ���˹�ϣ�㷨������ʵ�����������ݽṹ��
	HashSet<String> hSet = new HashSet<>();
	
    LinkedHashSet<String> linkedHashSet=new LinkedHashSet<>();
	// TreeSet��ʵ����SortedSet�ӿڣ����������ܡ�TreeSet֧����������ʽ����Ȼ����Ϳͻ���������Ĭ�������TreeSet������Ȼ����ʽ��
	TreeSet<String> tSet = new TreeSet<>();
}
