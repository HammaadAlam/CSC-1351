import java.util.Scanner;
import java.util.Random;

public class _RPG {
	public static void main(String[] args) {
		
		int pHP = 100;
		int mp = 50;
		int gHP = 80;
		int basicMin = 5;
		int basicMax = 10;
		int fireballMin = 10;
		int fireballMax = 25;
		int healMin = 20;
		int healMax = 30;
		
		int goblinMin = 10;
		int goblinMax = 20;
		int action;
		
		Scanner inputScanner = new Scanner(System.in);
		System.out.println("Start fight!");
		
		do {		
		// Start screen
			
		System.out.println("\nPlayer HP: " + pHP + "/100, MP: " + mp + "/50" );
		System.out.println("Goblin HP: " + gHP + "/80\n");
		
		System.out.println("Choose Action:\n1: Basic Attack\n2: Fireball\n3: Heal\n4: Empower\n5: Flee");
		System.out.print("Which action do you wish to choose: ");
		
		// Check input
		
		while (true) {
            if (inputScanner.hasNextInt()) {
                action = inputScanner.nextInt();
                if (action >= 1 && action <= 5) {
                    break;
                } 
                else {
                    System.out.println("Please choose a valid action: ");
                }
            } 
            else {
                System.out.println("Invalid input. Please choose a valid action: ");
                inputScanner.next();
            }
        }
		
		Random random = new Random();
		
		// Player
		
		if(action == 1) {
			if(mp >= 1) {
				mp -= 1;
				if (random.nextInt(10) < 8) {
					int bdamage = random.nextInt(basicMax - basicMin + 1) + basicMin;
					System.out.println("You used basic attack! It did " + bdamage + " damage!");
					gHP -= bdamage;
				}
				else {
				
					System.out.println("Your attack missed");
				}
			}
			else if(mp < 1) {
				System.out.println("You are out of mana points");
				System.out.println("You must flee");
				continue;
			}	
		}
		
		else if(action == 2) {
			if(mp >= 6) {
				mp -= 6;
			    int fdamage = random.nextInt(fireballMax - fireballMin + 1) + fireballMin;
			    gHP -= fdamage;
			    System.out.println("Player used fireball! It did " + fdamage + " damage to goblin!");
			}
			else if(mp < 6 && mp > 0) {
				System.out.println("Not enough mana points");
				continue;
			}	
			else {
				System.out.println("You are out of mana points");
				System.out.println("You must flee");
				continue;
			}
		}
		
		else if(action == 3) {
			if(mp >= 8) {
				mp -= 8;
				int heal = random.nextInt(healMax - healMin + 1) + healMin;
				pHP = Math.min(pHP + heal, 100);
				System.out.println("Player used heal! It restored " + heal + " HP");
			}
			else if(mp < 8 && mp > 0) {
				System.out.println("Not enough mana points");
				continue;
			}	
			else {
				System.out.println("You are out of mana points");
				System.out.println("You must flee");
				continue;
			}
			
		}
		
		else if(action == 4) {
			if(mp >= 10) {
				System.out.println("Player used empower");
				mp -= 10;
				basicMin += 1;
				basicMax += 2;
				fireballMin += 1;
				fireballMax += 2;
				healMin += 1;
				healMax += 2;
			}
			else if(mp < 10 && mp > 0) {
				System.out.println("Not enough mana points");
				continue;
			}	
			else {
				System.out.println("You are out of mana points");
				System.out.println("You must flee");
				continue;
			}
		}
		
		else if(action == 5) {
			System.out.println("Player has fled the encounter");
			System.out.println("You have escaped\n");
			break;
		}
		
		//Goblin
		
		if(gHP > 0) {
		int goblin1 = random.nextInt(goblinMax - goblinMin + 1) + goblinMin;
		
		if(random.nextInt(10) < 5) {
			pHP -= goblin1;
			System.out.println("Goblin's first attack did " + goblin1 + " damage!");
		}
		else {
			System.out.println("Goblin's first attack missed");
		}
		}
		
		if(gHP > 0 && pHP > 0) {
		int goblin2 = random.nextInt(goblinMax - goblinMin + 1) + goblinMin;
		
		if(random.nextInt(10) < 5) {
			pHP -= goblin2;
			System.out.println("Goblin's second attack did " + goblin2 + " damage!");
		}
		else {
			System.out.println("Goblin's second attack missed");
		}
		}
		}
		while (pHP > 0 && mp >= 0 && gHP > 0);
		
		//Ending
		
		if (gHP <= 0) {
			System.out.println("\nYou have defeated the goblin!");
			System.out.println("Player HP: " + pHP + "/100, MP: " + mp + "/50" );
			System.out.println("Goblin HP: " + 0 + "/80\n");
		}
		else if (pHP <= 0) {
			System.out.println("\nYou have been defeated!");
			System.out.println("Player HP: " + 0 + "/100, MP: " + mp + "/50" );
			System.out.println("Goblin HP: " + gHP + "/80\n");
		}
}
}
