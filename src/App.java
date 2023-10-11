import java.util.Random;

public class App {
    public static void main(String[] args) throws Exception {
        Game game = new Game();
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    
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