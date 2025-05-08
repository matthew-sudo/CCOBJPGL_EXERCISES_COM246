class monitor {
    public void connect(vga connector) {
        System.out.println("Monitor should be VGA cable.");
        connector.connectvga();
        System.out.println("Monitor has displayed.");
    }
}
