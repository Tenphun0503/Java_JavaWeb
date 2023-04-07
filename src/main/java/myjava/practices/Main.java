package myjava.practices;
public class Main {
    public Main(){
        System.out.println("DE");
    }
    public Main(int i){
        System.out.println("Main");
    }

}

class Sub extends Main{
    public Sub(){
        System.out.println("de");
    }
    public Sub(int i){
        System.out.println("Sub");
    }
}

class MainTest{
    public static void main(String[] args) {
        Sub sub = new Sub(10);
    }

}