package zhongqiu.common.jdk6;

//����ʽע�⴦��api
public class AnnotationDemo {
	/*
	 * ����ʽע�⴦��API(JSR 269)�ṩһ�ױ�׼API������Annotations.JSR 269��Annotation
	 * Processor���ڱ����ڼ�����������ڼ䴦��Annotation, Annotation Processor�൱�ڱ�������һ�����,
	 * 
	 * ���Գ�Ϊ����ʽע�⴦��.���Annotation
	 * Processor����Annotationʱ(ִ��process����)�������µ�Java����,���������ٵ���һ��Annotation
	 * Processor,����ڶ��δ������´������,�ͻ���ŵ���Annotation
	 * Processor,ֱ��û���´������Ϊֹ.ÿִ��һ��process()��������Ϊһ��"round",��������Annotation
	 * processing���̿��Կ�����һ��round������.
	 * �ٸ����ӣ����뽨��һ�׻���Annotation�ĵ�Ԫ���Կ��(��TestNG),�ڲ�����������Annotation����ʶ�����ڼ���Ҫִ�еĲ��Է���
	 */
	public @interface TestMethod {

	}
	@TestMethod
	 public void testCheckName(){  
	       //do something here  
	 }
}
