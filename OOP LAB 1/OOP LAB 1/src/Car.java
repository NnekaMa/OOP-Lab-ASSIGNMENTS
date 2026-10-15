class Car{
    String brand;
    int year;
    int mileage;


    void display(){
        System.out.println(brand + " - " + year + "-"  + "-" + mileage + "km");

    }
    boolean isAntique(){
        int currentYear = java.time.Year.now().getValue();
        return (currentYear-year)> 25;

    }

}
