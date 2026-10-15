import java.util.ArrayList;
import java.util.List;

// enum with a field, a constructor and a method
enum Coin {
    // Constants are listed from largest to smallest, so the greedy method below works
    QUARTER(25), DIME(10), NICKEL(5), PENNY(1);

    private final int value;                // value in cents

    Coin(int value) { this.value = value; }   // enum constructors are always private

    int getValue() { return value; }

    // Returns the fewest coins for the amount (greedy: take the biggest coin that fits)
    static List<Coin> fewestCoins(int amount) {
        List<Coin> result = new ArrayList<>();
        for (Coin c : values()) {           // values() gives the constants in declared order
            while (amount >= c.value) {
                result.add(c);
                amount -= c.value;
            }
        }
        return result;
    }
}

class CoinDemo {
    public static void main(String[] args) {
        System.out.println(Coin.fewestCoins(41));   // [QUARTER, DIME, NICKEL, PENNY]
        System.out.println(Coin.fewestCoins(99));   // [QUARTER x3, DIME x2, PENNY x4]
    }
}