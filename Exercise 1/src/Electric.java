interface Electric extends Engine {
    boolean electric = true; 
    String battery = "10Kwh"; 

    default String getBattery() {
        return battery;
    }
}