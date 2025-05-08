class hdmitovga implements vga {
    private hdmi hdmicable;

    public hdmitovga(hdmi hdmicable) {
        this.hdmicable = hdmicable;
    }

    @Override
    public void connectvga() {
        System.out.println("Converting HDMI to VGA...");
        hdmicable.connecthdmi();
    }
}
