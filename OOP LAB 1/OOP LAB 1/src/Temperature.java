public class Temperature {
    private final double celsius;  // stored internally in Celsius

    // Private constructor: outside code cannot call "new Temperature(...)"
    private Temperature(double celsius){
        this.celsius=celsius;
    }
    // Static factory method: the name says what the number means
    public static Temperature fromCelsius(double c ){
        return new Temperature(c);
    }
    //Static factory method:converts Fahrenheit to Celsius first
    public static Temperature fromFahrenheit(double f){
        return new Temperature((f-32) * 5/9);
    }
    public  double toFahrenheit(){
        return celsius* 9/5 + 32;
    }
    @Override
    public String toString(){
        return celsius+ " C / " +  toFahrenheit() + "F";
    }
    public  static  void main(String[] args){
        Temperature t1 = Temperature.fromCelsius(100);
        Temperature t2=Temperature.fromFahrenheit(32);
        System.out.println(t1);// 100.0 C / 212.0 F
        System.out.println(t2);// 0.0 C / 32.0 F
    }
}
