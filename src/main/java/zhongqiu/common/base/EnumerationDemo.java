package zhongqiu.common.base;

import java.util.Enumeration;

public class EnumerationDemo implements Enumeration{
	 int count; // ������
     int length; //�洢������ĳ���
     Object[] dataArray; // �洢�������������
     //������
     EnumerationDemo(int count,int length,Object[] dataArray){ 
           this.count = count;
           this.length= length;
           this.dataArray=dataArray;
     } 
     public boolean hasMoreElements() { 
           return (count< length);
     }
     public Object nextElement() {
           return dataArray[count++];
     }
}
