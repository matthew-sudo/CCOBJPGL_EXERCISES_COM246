public class App {
    public static void main(String[] args) throws Exception {
        HybridVehicle Car1 = new HybridSedan();
        HybridVehicle Car2 = new HybridPickup();

        Car1.carname = "Lamborghini";
        System.out.println(Car1.carname);
        Car1.chargebattery();
        Car1.fillgas();

        Car2.carname = "Mercedez Benz";
        System.out.println(Car2.carname);
        Car2.chargebattery();
        Car2.fillgas();


        System.out.println("My " + Car1.carname + " can " + Car1.charge);
        System.out.println("My " + Car2.carname + " can " + Car2.gas);

        Carwash wash = new Carwash();
        wash.wash(Car1);
        wash.wash(Car2);
        
    }
}
