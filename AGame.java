import java.util.*;

// Melody Lam
// 2/27/23
// assignment 04. a game
// Allows user to play 


public class AGame {
    
    public static final int DROMSLOTT = 1;
    public static final int GULLIGAST = 2;
    public static final int UPPSTA = 3;
    public static final int PLUFSIG = 4;
    public static final int SOLSKUR = 5;
    
//starts the game
    static void intro(){

        System.out.println("Welcome! We are playing Blavingad!");
        System.out.println("Here are the rules\n");
        System.out.println("Dromslott beats Gulligast, Plufsig");
        System.out.println("Gulligast beats Uppsta, Solskur");
        System.out.println("Uppsta beats Dromslott, Plufsig");
        System.out.println("Plufsig Beats Solskur, Gulligast");
        System.out.println("Solskur beats Dromslott, Uppsta\n");
        System.out.println("Would you like to play? y/n?  ");
        //progresses with game, counter for wins, losses, rounds, injected and passed through as parameters
        onwards(0, 0, 0);
        }
    static void onwards(int wins, int losses, int rounds){

        Scanner start = new Scanner(System.in);
        String choice = start.nextLine();

        if((choice.equalsIgnoreCase("y"))){
            rounds++;
            symbol(wins, losses, rounds);
        }
        else if((choice.equalsIgnoreCase("n"))){
            System.out.println("Quitting.");
            System.out.println("You have played " + rounds + " rounds.");
            System.out.println("You have won " + wins + " rounds.");
            System.out.println("You have lost " + losses + " rounds.");
        }
        else if (!choice.equalsIgnoreCase("y")  && !choice.equalsIgnoreCase("n")) {
            while (!choice.equalsIgnoreCase("y") && !choice.equalsIgnoreCase("n")) {
                System.out.println("Invalid input '" + choice + "'\nPlease type a valid input (y/n)");
                choice = start.next();
                if (choice.equalsIgnoreCase("y")) {
                    rounds++;
                    symbol(wins, losses, rounds);
                 } else if (choice.equalsIgnoreCase("n")) {
                    System.out.println("Quitting.");
                    System.out.println("You have played " + rounds + " rounds.");
                    System.out.println("You have won " + wins + " rounds.");
                    System.out.println("You have lost " + losses + " rounds.");
                    break;
                 } 
            }
        }
    }
    
//asks if they want to continue, goes on to take user input to continue or quit game
    static void again(int wins, int losses, int rounds){
        System.out.println("Would you like to play another round? (y/n) ");
        onwards(wins, losses, rounds);
    }

//function allows user to represent relationship between variables(who beats who) and prints result of round
    static void meVsAi(String myPlay, String aiPlay, String x, String y, String z, String n, String m, int wins, int losses, int rounds){
        if((myPlay.equalsIgnoreCase(x)) && (aiPlay.equalsIgnoreCase(y)) || (aiPlay.equalsIgnoreCase(z))){
            System.out.println("You played " + myPlay);
            System.out.println("The ai played " + aiPlay);
            System.out.println(myPlay + " beats " + aiPlay + ". You win. ");
            wins++;
            again(wins, losses, rounds);
        }
        else if (((myPlay.equalsIgnoreCase(x) && (aiPlay.equalsIgnoreCase(n) || aiPlay.equalsIgnoreCase(m)))) || myPlay.equalsIgnoreCase(aiPlay)){
            System.out.println("You played " + myPlay);
            System.out.println("The ai played " + aiPlay);
            System.out.println(aiPlay + " beats " + myPlay + ". You lose. ");
            losses++;
            again(wins, losses, rounds);
        }
    }
// actual game is played and player input is compared to ai input
    static void symbol(int wins, int losses, int rounds){

        System.out.println("Play your move (Plufsig, Uppsta, Gulligast, Solskur, or Dromslott) ");
        Scanner play = new Scanner(System.in);
        String myPlay = play.nextLine();

        //computers move
        int aiNum = (int)(Math.random() * 5) + 1;
        String aiPlay = "";
        if(aiNum == DROMSLOTT){
            aiPlay = "Dromslott";
        }
        else if(aiNum == GULLIGAST){
            aiPlay = "Gulligast";
        }
        else if(aiNum == UPPSTA){
            aiPlay = "Uppsta";
        }
        else if(aiNum == PLUFSIG){
            aiPlay = "Plufsig";
        }
        else if(aiNum == SOLSKUR){
            aiPlay = "Solskur";
        }        
        
        //verify moves
        if(myPlay.equalsIgnoreCase("Dromslott")){
            meVsAi(myPlay, aiPlay, "Dromslott", "Gulligast", "Plufsig", "Uppsta", "Solskur", wins, losses, rounds);  
          }
          else if(myPlay.equalsIgnoreCase("Gulligast")){
              meVsAi(myPlay, aiPlay, "Gulligast", "Uppsta", "Solskur", "Dromslott", "Plufsig", wins, losses, rounds);
          }
          else if(myPlay.equalsIgnoreCase("Uppsta")){
              meVsAi(myPlay, aiPlay, "Uppsta", "Dromslott", "Plufsig", "Gulligast", "Solskur", wins, losses, rounds);       
          }
          else if(myPlay.equalsIgnoreCase("Plufsig")){
              meVsAi(myPlay, aiPlay, "Plufsig", "Solskur", "Gulligast", "Dromslott", "Uppsta", wins, losses, rounds);
          }
          else if(myPlay.equalsIgnoreCase("Solskur")){
              meVsAi(myPlay, aiPlay, "Solskur", "Dromslott", "Uppsta", "Gulligast", "Plufsig", wins, losses, rounds);
          }
        else if(!myPlay.equalsIgnoreCase("Dromslott") && !myPlay.equalsIgnoreCase("Gulligast") 
        && !myPlay.equalsIgnoreCase("Uppsta") && !myPlay.equalsIgnoreCase("Plufsig") 
        && !myPlay.equalsIgnoreCase("Solskur")){
            while(!myPlay.equalsIgnoreCase("Dromslott") && !myPlay.equalsIgnoreCase("Gulligast") 
        && !myPlay.equalsIgnoreCase("Uppsta") && !myPlay.equalsIgnoreCase("Plufsig") 
        && !myPlay.equalsIgnoreCase("Solskur")){
            System.out.println("Invalid move. Please try one of our valid options(Plufsig, Uppsta, Gulligast, Solskur, or Dromslott)");
            myPlay = play.next();
            if(myPlay.equalsIgnoreCase("Dromslott")){
                meVsAi(myPlay, aiPlay, "Dromslott", "Gulligast", "Plufsig", "Uppsta", "Solskur", wins, losses, rounds);  
              }
              else if(myPlay.equalsIgnoreCase("Gulligast")){
                  meVsAi(myPlay, aiPlay, "Gulligast", "Uppsta", "Solskur", "Dromslott", "Plufsig", wins, losses, rounds);
              }
              else if(myPlay.equalsIgnoreCase("Uppsta")){
                  meVsAi(myPlay, aiPlay, "Uppsta", "Dromslott", "Plufsig", "Gulligast", "Solskur", wins, losses, rounds);       
              }
              else if(myPlay.equalsIgnoreCase("Plufsig")){
                  meVsAi(myPlay, aiPlay, "Plufsig", "Solskur", "Gulligast", "Dromslott", "Uppsta", wins, losses, rounds);
              }
              else if(myPlay.equalsIgnoreCase("Solskur")){
                  meVsAi(myPlay, aiPlay, "Solskur", "Dromslott", "Uppsta", "Gulligast", "Plufsig", wins, losses, rounds);
              }
            }
        }
    }
    public static void main(String[] args){
    //function calls starting function that goes in a loop to call other functions as conditions are met
        intro();
    }          
}

/*  Outline!
 *  
 *  intro()
 *  states all the rules
 * 
 *  onwards()
 *  goes on to take input from user
 *  if user wants to start, they can start, if not then quit
 *  use if else statements to:
 *  start game when user enters y, and implement round counter(rounds++ for each y given)
 *  end game when user enters n, and print values of all variables(rounds, wins, losses)
 * 
 * `again()
 *  used when round ends to see if user wants to continue
 *  calls function Onwards() to take input and take action based on input
 * 
 *  meVsAi()
 *  compares relationship between the variables
 *  gives who beats who based on order of parameters
 *  take in parameters for all 5 variables, your own play, and the ai's play
 *  prints out plays of both ends, and gives who wins or loses based on relationship
 *  
 *  symbol()
 *  takes input from user and assigns to string variable
 *  use function that compares the user input and ai's play
 *  if else statements for each input option
 * 
 * since function calls functions in this code, put parameters for wins, losses, and rounds
 * to pass value, starting at 0 for all variables in the beginning
 */