public class Game {
    private enum Type{
        VIRTUAL,
        PHYSICAL,
    };


    private final String name;
    private final String ganre;
    private final Type type;

    private Game(String name, String ganre, Type type) {
        this.name = name;
        this.ganre = ganre;
        this.type = type;
    }

    public static class GameDisk{
       private final String  description;
       private final Game data;

        private GameDisk(String name, String ganre, String description) {
            this.description = description;
            data = new Game(name, ganre, Type.PHYSICAL);
        }

        public String getDescription() {
            return description;
        }

        public Game getData() {
            return data;
        }
    }
    public static class VirtualGame{
        private double rating;
        private final Game data;

        private VirtualGame(String name, String ganre){
            data = new Game(name, ganre, Type.VIRTUAL);
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public Game getData() {
            return data;
        }
    }

    public static GameDisk getDisk(String name, String ganre, String description){
        return new GameDisk(name,ganre,description);
    }

    public static VirtualGame getVirtualGame(String name, String ganre){
        return new VirtualGame(name,ganre);
    }

    public String getName() {
        return name;
    }

    public String getGanre() {
        return ganre;
    }

    public Type getType() {
        return type;
    }
};
