import java.util.Scanner;
import java.util.Random;

public class Typo {
    public static void main(String args[]) {
      // Scanner object
      Scanner scnr = new Scanner(System.in);
      // Randomization object
      Random rand = new Random();
      
      // Enemy variables
      String[] enemyname = {"Misclick", "Runtime Error", "404 Error", "Pop-Up", "Blue Screen"};
      int enemyHealth = 300;
      int enemyDamage = 200;
      
      //Typo variables
      int health = 200; // Typo health
      int damage = 300; // Typo damage
      int hPotions = 5; // # of potions
      int healAmt = 50; // How much health restored by potions
      int hDrops = 50; // Drop chance for health pots
      
      // Boolean variable for running in-game
      boolean run = true;
      
      // Welcome the player
      System.out.println("Welcome to Typo: A Keyboard Adventure!\n");
      // Give the game some context
      System.out.print("You are a lonely typo, deleted from an essay to be forgotten forever.\n" 
      + "Lost and confused, you must navigate this dangerous, unfamiliar world of\n"
      + "of forgotten errors and make it back to the research paper you were deleted from.\n"
      + "Be careful out there Typo! Good luck!\n\n");
      
      // Now to code the game
      // Label the game
      GAME:
      // While loop to get the game up and running
      while (run) {
          // This will work as a separator for important text
          System.out.println("----------------------------------------------");

          // Randomly choose an enemy to spawn
          String enemy = enemyname[rand.nextInt(enemyname.length)];
          
          // Set enemy health according to enemy type
          // Sets enemy health
          if (enemy == "Misclick") {
              // Set health to 100
              enemyHealth = 100;
          }
          // Sets enemy health
          else if (enemy == "Runtime Error") {
              // Set health to 150
              enemyHealth = 150;
          }
          // Sets enemy health
          else if (enemy == "404 Error") {
              // Set health to 200
              enemyHealth = 200;
          }
          // Sets enemy health
          else if (enemy == "Pop-Up") {
              // Set health to 250
              enemyHealth = 250;
              
          }
          // Sets enemy health
          else if (enemy == "Blue Screen") {
              // Set health to 300;
              enemyHealth = 300;
          }
          // Spawn a random enemy
          System.out.println("\tA " + enemy + " appeared! \n");
          
          // Next loop for the rest of the game..
          while (enemyHealth > 0) {
              // Tell the player Typo's HP...
              System.out.println("\tTypo's HP: " + health);
              // Tell the player the enemy's HP...
              System.out.println("\t" + enemy + "'s HP: " + enemyHealth);
              // Prompt the player to make an action...
              System.out.println("\n\tWhat will Typo do?");
              // Give the player the option to attack...
              System.out.println("\t1. Attack!");
              // Give the player the option to heal...
              System.out.println("\t2. Heal Typo!");
              // Give the player the option to escape...
              System.out.println("\t3. Escape!");
              
              // Prompt the player to choose...
              System.out.print("\t\nTypo will: ");
              
              // Get the player's input...
              String input = scnr.nextLine();
              
              // If the player chooses to attack...
              if (input.equals("1") || input.equalsIgnoreCase("attack")) {
                  // Attack variables...
                  // Randomize Typo's damange...
                  int dmgDealt = rand.nextInt(damage);
                  // Randomize enemy damage...
                  int dmgTanked = rand.nextInt(enemyDamage);
                  
                  // Update enemy health...
                  enemyHealth -= dmgDealt;
                  // Update Typo health...
                  health-= dmgTanked;
                  
                  // Tell the player how much damage they did...
                  System.out.println("\n\tTypo did " + dmgDealt + " damage to the " + enemy + "!");
                  // Tell the player how much damage they received...
                  System.out.println("\tThe " + enemy + " did " + dmgTanked + " to Typo!");
                  
                  // If the player dies...
                  if (health < 1) {
                      // Tell the user they've been defeated...
                      System.out.println("\tTypo has been defeated! He can't go on!");
                      // Break from the loop...
                      break;
                  }
                  // If the player was one shotted...
                  else if (health < 1 && dmgTanked == 200) {
                      // Tell the player they got one shotted...
                      System.out.println("\tTypo just got one shotted! He can't go on!");
                  }
              }
              // If the player chooses to heal...
              else if (input.equals("2") || input.equalsIgnoreCase("heal")) {
                  // If the player has potions left...
                  if (hPotions > 0) {
                      // Heal the player...
                      health += healAmt;
                      
                      // Update potion amount...
                      hPotions --;
                      
                      // Tell the user they've been healed...
                      System.out.println("\t\nTypo drank a health potion and healed " + healAmt + " HP!");
                      // Tell the user how many potions they have left...
                      System.out.println("\tTypo has " + hPotions + " potions left.");
                  }
                  // If the player has no potions...
                  else {
                      // Tell the player they've ran out of potions...
                      System.out.println("\tTypo is out of potions! He can't heal! Typo must defeat more enemies for a chance to get more potions!");
                  }
              }
              // If the player chooses to escape...
              else if (input.equals("3") || input.equalsIgnoreCase("escape")) {
                  // Tell the user they escaped...
                  System.out.println("\t\nTypo escaped the " + enemy + " and continues on!\n");
                  // Reiterate the loop...
                  continue GAME;
              }
              // If the player doesn't give valid input...
              else {
                  System.out.println("\t\nOops! Typo didn't understand that! Please try again!");
                  
              }
          }
         // If the player died...
         if (health < 1) {
            // This will work as a separator for important text
             System.out.println("\n----------------------------------------------");
             // Tell the user they've failed and the game ends...
             System.out.println("\tTypo fails to survive and disappears to be forgotten forever...\n\tGAME OVER");
             // Break out of the loop...
             break;
         }

         // Drop chance for the health pots
         if (rand.nextInt(100) > hDrops) {
             // Increment the # of health pots...
             hDrops++;
             // Tell the user the enemy dropped a health potion...
             System.out.println("\tThe " + enemy + " dropped a health potion!");
             // Tell the user how many health potions they have...
             System.out.println("\tTypo has " + hPotions + " health potion(s) left!");
         }
         // This will work as a separator for important text
         System.out.println("----------------------------------------------");
         // Prompt the user for their next action...
         System.out.println("What will Typo do now?");
         // Will Typo keep fighting?
         System.out.println("1. Continue the fight?");
         // Will Typo leave?
         System.out.println("2. Give up the fight?");
         // Typo will...
         System.out.print("\nTypo will: ");
         // String variable for input...
         String input = scnr.nextLine();
         
          // While loop for user input after recceiving a potion...
          while (!input.equals("1") && !input.equals("2") && !input.equalsIgnoreCase("Continue") && !input.equalsIgnoreCase("Give Up")){
              // Tell the user they've entered invalid input...
              System.out.println("Typo didn't understand that! Try again.");
              // Get the user's input once again...
              input = scnr.nextLine();
          }
          
          // If the user entered valid input...
          if (input.equals("1") || input.equalsIgnoreCase("Continue")) {
              // Typo will continue the fight...
              System.out.println("Typo continues fighting!");
          }
          //  User chose the second option...
          else if (input.equals("2") || input.equalsIgnoreCase("Give Up")) {
              // Typo gave up the fight...
              System.out.println("Typo gives up the fight! Thanks for playing!");
              break;
          }
      }
      
      
    }
}