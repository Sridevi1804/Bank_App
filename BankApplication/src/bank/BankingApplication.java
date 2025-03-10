package bank;
import java.util.Scanner;

public class BankingApplication {

	public static void main(String[] args) {
		BankAccount obj = new BankAccount("Sri Devi","21AUCS47");
		obj.showMenu();
	}
}

class BankAccount{
		int balance;
		int previousTransaction;
		String customerName;
		String customerId;
		
		
		BankAccount(String cname, String cid){
			customerName = cname;
			customerId = cid;
		}
		
		public void deposit(int amount) {
			if(amount !=0) {
				balance = balance + amount;
				previousTransaction = amount;
			}
		}
		
		public void withdraw(int amount) {
			if(amount !=0) {
				balance = balance - amount;
				previousTransaction = -amount;
			}
		}
		
		public void getPreviousTransaction() {
			if(previousTransaction>0) {
				System.out.println("Deposited:" + previousTransaction);
			}
			else if(previousTransaction<0) {
				System.out.println("Withdraw:" +Math.abs(previousTransaction));
			}
			else {
				System.out.println("No Transition occured");
			}
		}
		
		public void showMenu() {
			char option = '\0';
			Scanner scanner = new Scanner(System.in);
			System.out.println("Welcome " +customerName);
			System.out.println("Your ID " +customerId);
			System.out.println("\n");
			
			System.out.println("A : Check your Balance");
			System.out.println("B : Deposit");
			System.out.println("C : Withdraw");
			System.out.println("D : Previous Transaction");
			System.out.println("E : Exit the System");
			
			do {
				System.out.println("********************************************************************************");
				System.out.println("Enter your Option:");
				System.out.println("******************************************************************************");
				option = scanner.next().charAt(0);
				System.out.println("\n");
				
				switch(option) {
				case 'A':
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("Balance = "+balance);
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("\n");
					break;
					
				case 'B':
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("Enter an amount to deposit ");
					System.out.println("---------------------------------------------------------------------------");
					
					int amount = scanner.nextInt();
					deposit(amount);
					System.out.println("\n");
					break;
					
				case 'C':
					System.out.println("---------------------------------------------------------------------------");
					System.out.println("Enter an amount to withdraw ");
					System.out.println("---------------------------------------------------------------------------");
					
					int amount2 = scanner.nextInt();
					withdraw(amount2);
					System.out.println("\n");
					break;
					
				case 'D':
					System.out.println("---------------------------------------------------------------------------");
					getPreviousTransaction();
					System.out.println("----------------------------------------------------------------------------");
					System.out.println("\n");
					break;
					
				case 'E':
					System.out.println("---------------------------------------------------------------------------");
					break;
					
					
				default:
					System.out.println("Invalid Option! Please Enter Correct Option..");
					break;
				}

			}
			while(option !='E');
				System.out.println("Thank you for using our services...!");
			
		}	
	}
