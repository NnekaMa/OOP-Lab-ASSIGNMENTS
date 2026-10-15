public class TemperatureK {
    // Internal unit is kelvin. It is private, so callers never see it.
    private final double kelvin;
    public TemperatureK(double kelvin){
        //Reject values below absolute zero (0 k)
        if (kelvin<0){
            throw new IllegalArgumentException("Below absolute zero:"  + kelvin);
        }
        this.kelvin=kelvin;
    }
    public double getCelsius(){
        return kelvin-273.15;

    }
    public double getFahrenheit(){
        return getCelsius()* 9/ 5 + 32;
    }
    public static  void main(String[] args){
        TemperatureK t = new TemperatureK(300);
        System.out.println(t.getCelsius());  // 26.850000000000023
        System.out.println(t.getFahrenheit()); // 80.330000000004

        try{
            new TemperatureK(-5);   //invalid,rejected
        }catch (IllegalArgumentException e) {
            System.out.println("Rejected:" + e.getMessage());
        }

    }

}
