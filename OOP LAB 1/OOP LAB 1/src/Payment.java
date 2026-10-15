public class Payment {
    void process() {
        System.out.println("Generic");
    }
}
class CardPayment extends   Payment {
    @Override
    void process() {
        System.out.println("Card processed");
    }
}

class MobileMoneyPayment extends Payment {
    @Override
    void process() {
        System.out.println("Mobile money processed");
    }
}
 class PaymentProcessor {
    // BEFORE: instanceof pattern matching
    static void payOld(Payment p) {
        if (p instanceof CardPayment c) System.out.println(" Card handled");
        else if (p instanceof MobileMoneyPayment m) System.out.println("Mobile money handled");
    }

    // AFTER: refactored to use polymorphic process()
    static void pay(Payment p) {
        p.process();
    }

    public static void main(String[] args) {
        Payment[] list = {new CardPayment(), new MobileMoneyPayment()};
        for (Payment p : list) payOld(p);
        for (Payment p : list) pay(p);
    }
}


