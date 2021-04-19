package test;

public class AddOper implements ICompute {
    @Override
    public int compute(int num1, int num2) {
        return num1 + num2;
    }
}
