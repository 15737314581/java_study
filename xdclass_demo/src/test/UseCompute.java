package test;

public class UseCompute {
    public static void compute(ICompute compute, int num1, int num2){
        int result = compute.compute(num1, num2);
        System.out.println(result);
    }

    public static void main(String[] args) {
        UseCompute.compute(new AddOper(), 10, 2);
        UseCompute.compute(new SubOper(), 10, 2);
        UseCompute.compute(new MulOper(),10,2);
        UseCompute.compute(new DivideOper(),10,2);


    }
}
