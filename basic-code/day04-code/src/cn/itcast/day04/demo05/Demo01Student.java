package cn.itcast.day04.demo05;

public class Demo01Student {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("����");
        stu1.setAge(15);
        System.out.println("���֣�" + stu1.getName() + ", ���䣺" + stu1.getAge());
        Student stu2 = new Student("����", 20);
        System.out.println("���֣�" + stu2.getName() + ", ���䣺" + stu2.getAge());
        stu2.setAge(22);
        System.out.println("���֣�" + stu2.getName() + ", ���䣺" + stu2.getAge());
    }
}
