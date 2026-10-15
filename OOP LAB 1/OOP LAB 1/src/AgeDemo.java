// Checked exception: extends Exception (not RuntimeException), so callers MUST handle it
class InvalidAgeException extends Exception {
    InvalidAgeException(String message) {
        super(message);
    }
}

class AgeDemo {
    // "throws" warns callers that this method may throw a checked exception
    static void validateAge(int age) throws InvalidAgeException {
        if (age < 0 || age > 120) {
            throw new InvalidAgeException("Invalid age " + age + ": must be between 0 and 120");
        }
        System.out.println("Age " + age + " is valid");
    }

    public static void main(String[] args) {
        try {
            validateAge(25);    // valid
            validateAge(150);   // throws the exception
        } catch (InvalidAgeException e) {
            System.out.println("Caught: " + e.getMessage());
        }
    }
}
