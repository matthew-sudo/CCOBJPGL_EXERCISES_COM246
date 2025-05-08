public class App {
    public static void main(String[] args) throws Exception {
        hdmi hdmicable = new hdmi();

        vga vgacable = new hdmitovga(hdmicable);

        monitor Monitor = new monitor();
        Monitor.connect(vgacable);
    }
}
