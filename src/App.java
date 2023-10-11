public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
        
        System.out.println(" __          __           _ _      ");
        System.out.println(" \\ \\        / /          | | |     ");
        System.out.println("  \\ \\  /\\  / /__  _ __ __| | | ___ ");
        System.out.println("   \\ \\/  \\/ / _ \\| '__/ _` | |/ _ \\");
        System.out.println("    \\  /\\  / (_) | | | (_| | |  __/");
        System.out.println("     \\/  \\/ \\___/|_|  \\__,_|_|\\___|");
        System.out.println("----------------------------------------");
        
        while (!game.isGameOver()){
            game.printBoard();
            System.out.println("");
            game.makeGuess();   

            System.out.print("\033[H\033[2J");  
            System.out.flush();  
        }

        game.printBoard();
        game.isWinner();
    }
}