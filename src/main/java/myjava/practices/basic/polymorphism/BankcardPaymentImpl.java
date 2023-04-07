package myjava.practices.basic.polymorphism;

public class BankcardPaymentImpl implements Payment{
    @Override
    public void pay(double money) {
        System.out.println("Paid with card: $" + money);
    }
}
