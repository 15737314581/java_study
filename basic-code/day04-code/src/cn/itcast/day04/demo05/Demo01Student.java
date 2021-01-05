package cn.itcast.day04.demo05;

public class Demo01Student {
    public static void main(String[] args) {
        Student stu1 = new Student();
        stu1.setName("张三");
        stu1.setAge(15);
        System.out.println("名字：" + stu1.getName() + ", 年龄：" + stu1.getAge());
        Student stu2 = new Student("李四", 20);
        System.out.println("名字：" + stu2.getName() + ", 年龄：" + stu2.getAge());
        stu2.setAge(22);
        System.out.println("名字：" + stu2.getName() + ", 年龄：" + stu2.getAge());
    }
}
