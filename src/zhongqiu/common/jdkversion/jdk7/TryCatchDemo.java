package zhongqiu.common.jdkversion.jdk7;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

//��try catch�쳣��׽�У�һ��catch����д����쳣���ͣ���"|"����
public class TryCatchDemo {
	public static void main(String[] args) {

		// jdk7֮ǰ
		try {
			BufferedReader reader = new BufferedReader(new FileReader(""));
			Connection con = null;
			Statement stmt = con.createStatement();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		// jdk7
		try {
			BufferedReader reader = new BufferedReader(new FileReader(""));
			Connection con = null;
			Statement stmt = con.createStatement();
		} catch (IOException | SQLException e) {
			// �������쳣��e����final���͵� e.printStackTrace();
		}
	}
}
