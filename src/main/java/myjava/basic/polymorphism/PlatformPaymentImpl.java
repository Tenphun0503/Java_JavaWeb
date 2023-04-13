package myjava.basic.polymorphism;

public class PlatformPaymentImpl implements Payment{
    @Override
    public void pay(double money) {
        System.out.println("Paid with platform: $" + money);
    }
}
