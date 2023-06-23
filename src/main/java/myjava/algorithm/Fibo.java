package myjava.algorithm;

public class Fibo {
    private static Integer fun(Integer n){
        if(n==1) return 0;
        if(n==2) return 1;
        else return fun(n-1) + fun(n-2);
    }

    public static void main(String[] args) {
        for (int i = 1; i < 10; i++) {
            System.out.println(fun(i));
        }
    }
}
