public class GameConsole {

    private final String brand;
    private String model;
    private final String serial;
    private Gamepad firstGamepad;
    private Gamepad secondGamepad;
    private boolean isOn;

    public GameConsole(String brand, String serial) {
        this.brand = brand;
        this.serial = serial;
        this.firstGamepad = new Gamepad(this.brand, 1);
        this.secondGamepad = new Gamepad(this.brand, 2);
    }

    private class Gamepad {
        private final String brand;
        private final String consoleSerial;
        private final int connectedNumber;
        private String color;
        private double chargeLevel = 100.0;
        private boolean isOn;

        public Gamepad(String brand, int connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            this.consoleSerial = serial;
        }

        public String getBrand() {
            return brand;
        }

        public String getConsoleSerial() {
            return consoleSerial;
        }

        public int getConnectedNumber() {
            return connectedNumber;
        }

        public double getChargeLevel() {
            return chargeLevel;
        }

        public String getColor() {
            return color;
        }

        public void setColor(String color) {
            this.color = color;
        }

        public void setChargeLevel(double chargeLevel) {
            this.chargeLevel = chargeLevel;
        }

        public boolean isOn() {
            return isOn;
        }

        public void setOn(boolean on) {
            isOn = on;
        }


    };
};
