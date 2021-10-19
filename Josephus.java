import java.util.*;

public class Josephus {
	

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		int numOfMembers, numToSkip, result;
		String again;
		
		
		System.out.println("Josephus -- Bryce Perez");
		do {
			System.out.print("How many members of the group? ");
			if(keyboard.hasNextInt()) {
				numOfMembers = keyboard.nextInt();
			}else {
				System.out.println("Enter an integer please.");
				numOfMembers = keyboard.nextInt();
			}
			
			System.out.print("What is the skip count? " );
			if(keyboard.hasNextInt()) {
				numToSkip = keyboard.nextInt();
			}else {
				System.out.println("Please enter an integer");
				numToSkip = keyboard.nextInt();
			}
			
			result = 0;
			//code for result
			LinkedQueue<Integer> members = new LinkedQueue<Integer>();
			for(int i = 1; i <= numOfMembers; i++) {
				members.enqueue(i);
			}
			
			int pos = 1;
			while(members.size() > 1) {
				
				int temp = members.first();
				if(pos++ % numToSkip != 0) {
					members.enqueue(temp);
					members.dequeue();
				}else {
					members.dequeue();
				}
				
				if(members.size() == 1) {
					result = members.first();
					
				}
				
			}
			
			
			System.out.println(members.toString());
			
			System.out.println("You want to be in position #" + result);
			System.out.println();
			System.out.print("Again [Y/N]? ");
			again = keyboard.next();
			System.out.println();
			
		}while(again.toLowerCase().equals("y"));
		
		keyboard.close();
	}
}
	


