public class GameConsole implements Powered {

    private final String brand;
    private String model;
    private final String serial;
    private Gamepad firstGamepad;
    private Gamepad secondGamepad;
    private boolean isOn;
    private Game activeGame;
    private int waitingCounter;

    public GameConsole(String brand, String serial) {
        this.brand = brand;
        this.serial = serial;
        this.firstGamepad = new Gamepad(this.brand, 1);
        this.secondGamepad = new Gamepad(this.brand, 2);
    }

    @Override
    public void powerOn() {
        this.isOn = true;
    }

    @Override
    public void powerOff() {
        this.isOn = false;
    }

    public void loadGame(Game game){
        activeGame = game;
        System.out.println("Игра " + game.getName() + " загружается...");
    }

    public void playGame(){
        checkStatus();
        System.out.println("Играем в " + activeGame.getName());

        if (firstGamepad.isOn){
            firstGamepad.chargeLevel -= 10;
        }
        if (secondGamepad.isOn){
            secondGamepad.chargeLevel -= 10;
        }

        if (firstGamepad.chargeLevel < 1){
            firstGamepad.setOn(false);
        }
        if (secondGamepad.chargeLevel < 1){
            secondGamepad.setOn(false);
        }
    }

    private void checkStatus() {

        try{
            if (waitingCounter > 5){
                throw new ActivityException("Приставка завершает работу из-за отсутствия активности");
            }
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }


        if (!firstGamepad.isOn && !secondGamepad.isOn){
            System.out.println("Подключите джостик");
            waitingCounter += 1;
        }
        if (firstGamepad.isOn || secondGamepad.isOn){
            waitingCounter = 0;
        }
    }

    public void ChangeGamepad(){
        if (!firstGamepad.isOn && secondGamepad.isOn){
            firstGamepad.setConnectedNumber(2);
            secondGamepad.setConnectedNumber(1);
        }
    }


    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getSerial() {
        return serial;
    }

    public Gamepad getFirstGamepad() {
        return firstGamepad;
    }

    public Gamepad getSecondGamepad() {
        return secondGamepad;
    }

    public boolean isOn() {
        return isOn;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setFirstGamepad(Gamepad firstGamepad) {
        this.firstGamepad = firstGamepad;
    }

    public void setSecondGamepad(Gamepad secondGamepad) {
        this.secondGamepad = secondGamepad;
    }

    public Game getActiveGame() {
        return activeGame;
    }

    public void setActiveGame(Game activeGame) {
        this.activeGame = activeGame;
    }

    public int getWaitingCounter() {
        return waitingCounter;
    }

    public void setWaitingCounter(int waitingCounter) {
        this.waitingCounter = waitingCounter;
    }

    private class Gamepad implements Powered {
        private final String brand;
        private final String consoleSerial;
        private int connectedNumber;
        private String color;
        private double chargeLevel = 100.0;
        private boolean isOn;

        public Gamepad(String brand, int connectedNumber) {
            this.brand = brand;
            this.connectedNumber = connectedNumber;
            this.consoleSerial = serial;
        }

        @Override
        public void powerOn() {
            this.isOn = true;
            GameConsole.this.powerOn();
        }

        @Override
        public void powerOff() {
            this.isOn = false;
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

        public void setConnectedNumber(int connectedNumber) {
            this.connectedNumber = connectedNumber;
        }
    };
};
