package zhongqiu.common.jdk7;

import java.util.List;

//�ɱ�����Ǿ��廯����ʾ����
public class VarableParameter {
	public static void main(String[] args) {
		
	}

	public static <T> void addToList (List<T> listArg, T... elements) {  
	    for (T x : elements) {  
	      listArg.add(x);  
	    }  
	  }  
}
