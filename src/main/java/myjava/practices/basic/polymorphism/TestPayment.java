package myjava.practices.basic.polymorphism;

import java.util.Random;

public class TestPayment {
    public static void main(String[] args) {
        Random random = new Random();

        // simulate getting payment method
        int paymentMethod = random.nextInt(2)+1;
        System.out.println(paymentMethod);

        Payment payment = null;

        switch(paymentMethod){
            case 1 -> payment = new PlatformPaymentImpl();
            case 2 -> payment = new BankcardPaymentImpl();
        }

        double money = 10.0;
        payment.pay(money);
    }
}
