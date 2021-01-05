package cn.itcast.day05.demo13;

public class Demo01Logger {
    public static void main(String[] args) {
        String mes1= "Hello";
        String mes2= "World";
        String mes3= "Java";

        show(1,()->{
            return mes1+mes2+mes3;
        });
    }
    public static void show(int lever, MessageBulider mb){
        if (lever == 1) {
            System.out.println(mb.buildMessage());
        }
    }
}
