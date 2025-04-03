interface InternalCombustion extends Engine {
    boolean gas = true; 
    int cylinders = 6; 

    default int getCylinders() {
        return cylinders;
    }
}