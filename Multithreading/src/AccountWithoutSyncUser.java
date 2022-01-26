import java.util.concurrent.*;

public class AccountWithoutSyncUser {
	private static Account userAccount = new Account();
	public static void main(String[] args) {
		//Creates a thread pool that creates new threads as needed, but will reuse previously constructed threads when they are available. 
		ExecutorService executor =Executors.newCachedThreadPool();
		for(int i = 0;i< 100;i++) {
			//starts 100 threads of the addapenny object
			executor.execute(new AddAPenny());
		}
		//no new threads will be accepted
		executor.shutdown();
		while(!executor.isShutdown()) {
			
		}
		System.out.println("What is balance? " + userAccount.getBalance());
	}



private static class AddAPenny implements Runnable{
		public void run() {
			userAccount.deposit(1);
		}
}
private static class Account{
	private int balance = 0;
	
	public void deposit(int amount) {
		int newBalance = balance + amount;
		//since multiple threads can simultaneously run, the total balance will not be correct
		try {
			Thread.sleep(0);
		}
		catch(InterruptedException ex) {
			
		}
		balance = newBalance;
		
	}
	public int getBalance() {
		return balance;
	}
	
}
}
