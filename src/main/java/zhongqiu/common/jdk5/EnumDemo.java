package zhongqiu.common.jdk5;

import java.util.EnumSet;

//ö��
/*
1����ͨö�٣�ͨ��name��ȡö�٣�ͨ��Ĭ�����ordinal��ȡö��
2���Զ���ö��
3��ö�ٵ�switch�÷�
4��ö��ʵ�ֽӿ�
5��ö�ټ��ϵ�ʹ�á�java.util.EnumSet��java.util.EnumMap������ö�ټ��ϡ�
  EnumSet��֤�����е�Ԫ�ز��ظ���EnumMap�е�key��enum���ͣ���value��������������͡�*/
public class EnumDemo {
    public static void main(String[] args) {
        EnumSwitch();
    }

    //��ͨö��
    public enum Color {
        RED, GREEN, BLANK, YELLOW;

        //ͨ��name��ȡö��
        public static Color getByName(String name) {
            Color color = Color.RED;
            switch (name) {
                case "RED":
                    color = Color.RED;
                    break;
                case "GREEN":
                    color = Color.GREEN;
                    break;
                case "BLANK":
                    color = Color.BLANK;
                    break;
                case "YELLOW":
                    color = Color.YELLOW;
                    break;
                default:
                    color = null;
                    break;
            }
            return color;
        }

        //ͨ��Ĭ�����ordinal��ȡö��
        public static Color valueOf(int ordinal) {
            if (ordinal >= 0 && ordinal < values().length) {
                return values()[ordinal];
            } else {
                throw new IndexOutOfBoundsException("Invalid ordinal");
            }
        }
    }

    // �Զ���ö��
    public enum ColorExt {
        RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLOW("��ɫ", 4);
        // ��Ա����
        private String name;
        private int index;

        // ���췽��
        private ColorExt(String name, int index) {
            this.name = name;
            this.index = index;
        }

        // ��ͨ����
        public static String getName(int index) {
            for (ColorExt c : ColorExt.values()) {
                if (c.getIndex() == index) {
                    return c.name;
                }
            }
            return null;
        }

        // ���Ƿ���
        @Override
        public String toString() {
            return this.index + "_" + this.name;
        }

        // get set ����
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }
    }

    // ö�ٵ�switch�÷�
    public static void EnumSwitch() {
        Color color = Color.RED;
        System.out.println(color);
        switch (color) {
            case RED:
                color = Color.GREEN;
                System.out.println(color);
                break;
            case YELLOW:
                color = Color.RED;
                System.out.println(color);
                break;
            case GREEN:
                color = Color.YELLOW;
                System.out.println(color);
                break;
        }
    }

    // ö��ʵ�ֽӿ�
    public interface Behaviour {
        void print();

        String getInfo();
    }

    public enum ColorImpl implements Behaviour {
        RED("��ɫ", 1), GREEN("��ɫ", 2), BLANK("��ɫ", 3), YELLOW("��ɫ", 4);
        // ��Ա����
        private String name;
        private int index;

        // ���췽��
        private ColorImpl(String name, int index) {
            this.name = name;
            this.index = index;
        }

        // �ӿڷ���
        @Override
        public String getInfo() {
            return this.name;
        }

        // �ӿڷ���
        @Override
        public void print() {
            System.out.println(this.index + ":" + this.name);
        }
    }

    //ö�ټ��ϵ�ʹ�ã�java.util.EnumSet��java.util.EnumMap������ö�ټ��ϡ�
    EnumSet<Color> repayApplyStatus = EnumSet.of(Color.BLANK,Color.GREEN,Color.RED);
}
