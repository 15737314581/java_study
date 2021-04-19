package test;

public class DivideOper implements ICompute {
    @Override
    public int compute(int num1, int num2) {
        try {
            return num1/num2;
        }catch (Exception e){
            e.printStackTrace();
        }
        return -1;
    }
}
