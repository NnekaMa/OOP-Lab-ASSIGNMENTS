// enum: a fixed set of constants, type-safe
enum Level { LOW, MEDIUM, HIGH }

class LevelDemo {
    static void advice(Level level) {
        // switch on an enum: no need to write Level.LOW, just LOW
        switch (level) {
            case LOW:
                System.out.println("LOW: relax, nothing to worry about");
                break;
            case MEDIUM:
                System.out.println("MEDIUM: stay alert and keep an eye on it");
                break;
            case HIGH:
                System.out.println("HIGH: act now, this needs urgent attention");
                break;
        }
    }

    public static void main(String[] args) {
        for (Level l : Level.values()) {   // values() returns all constants in order
            advice(l);
        }
    }
}
