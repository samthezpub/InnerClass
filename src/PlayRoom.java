import java.lang.reflect.Array;

public class PlayRoom {
    public static void main(String[] args) {
        Game.GameDisk[] Disks = new Game.GameDisk[4];
        Disks[0] = Game.getDisk("Dishonored", "Stealth", "Dishonored is a game that will tell you a confusing and dark story about a city called Dunwall, which is a huge industrial center where everything is filled with magic. You have to take on the role of a bodyguard, who is obliged to do everything possible to protect his empress. It will take a little time and you will realize that the empress has said goodbye to her life and now everyone around believes that it was you who killed her. Now you have to prove your case and embark on the path of truth to fight for justice. At first, you will constantly have to hide on the streets of the city, exploring its locations and finding useful items. But the most successful thing in this whole story is that a terrible plague has overturned on the city, which takes the lives of thousands of people. Everything was plunged into darkness, and people became evil, mean and indifferent towards each other.");
        Disks[1] = Game.getDisk("Minecraft", "Sandbox", "Minecraft is a game for fans of putting blocks on top of each other and finding adventures on their head.");
        Disks[2] = Game.getDisk("Garry's Mod", "Sandbox", "Fairly large-scale sandbox in size and capabilities, which is a constructor with elements of madness.");
        Disks[3] = Game.getDisk("Streets of Rogue", "Rogue-like", "Bagel in the style of games from the 80s and 90s. The main emphasis in the game is on building an action plan and a strategic component. The development and outcome of events will depend on your choice.");

        Game.VirtualGame[] VirtualGames = new Game.VirtualGame[4];
        VirtualGames[0] = Game.getVirtualGame("Dishonored", "Stealth");
        VirtualGames[1] = Game.getVirtualGame("Minecraft", "Sandbox");
        VirtualGames[2] = Game.getVirtualGame("Garry's Mod", "Sandbox");
        VirtualGames[3] = Game.getVirtualGame("Streets of Rogue", "Rogue-like");

        GameConsole xbox = new GameConsole("Xbox", "XC123QeWR");

    }
}
