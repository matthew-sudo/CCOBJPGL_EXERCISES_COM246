class Hybrid implements Electric, InternalCombustion {
    boolean gas = true;
    boolean electric = true;

    public String getBatteryCount() {
        return getBattery();
    }

    public int getCylindersCount() {
        return getCylinders();
    }
}