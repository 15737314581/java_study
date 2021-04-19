package test;

public class AnswerTest {
    public static void main(String[] args) {
        // test1();
        // test2();
        test3();
    }
    public static void test3(){
        Dog[] dogs = new Dog[5];
        for (int i = 0; i < 5; i++) {
            Dog dog = new Dog();
            dog.setName("旺财"+(i+1));
            dogs[i] = dog;
        }
        Dog dog = dogs[3];
        dog.changeAge();
        dog.changeAge();
        for (Dog d : dogs) {
            System.out.println("名字："+d.getName()+" ,年龄："+d.getAge());
        }
    }

    public static void test2(){
        int season = 2;
        String content;
        switch (season){
            case 1:
                content = "春";
                break;
            case 2:
                content = "夏";
                break;
            case 3:
                content = "秋";
                break;
            case 4:
                content = "冬";
                break;
            default:
                content = "错误季节";
        }
        System.out.println(content);
    }

    public static void test1() {
        Student[] arry1 = new Student[60];
        int arry1_index = 0;
        Student[] arry2 = new Student[40];
        int arry2_index = 0;
        for (int i = 0; i < 100; i++) {
            int num = i + 1;
            if (num > 60) {
                Student student = new Student();
                student.setId(num);
                arry2[arry2_index] = student;
                arry2_index++;
            } else {
                Student student = new Student();
                student.setId(num);
                arry1[arry1_index] = student;
                arry1_index++;
            }
        }
        for (Student student : arry1) {
            System.out.println(student.getId());
        }
        System.out.println("=====================");
        for (Student student : arry2) {
            System.out.println(student.getId());
        }
    }
}
