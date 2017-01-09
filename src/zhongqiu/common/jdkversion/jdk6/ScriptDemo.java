package zhongqiu.common.jdkversion.jdk6;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

//�Խű����Ե�֧�֣�script
public class ScriptDemo {
	public static void main(String[] args) {
		ScriptEngineManager manager = new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("ECMAScript");
		try {
			engine.eval(new FileReader("D://test.js"));
			Invocable invocableEngine = (Invocable) engine;
			Object ret = invocableEngine.invokeFunction("test", null);
			System.out.println("The result is :" + (Double) ret);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
