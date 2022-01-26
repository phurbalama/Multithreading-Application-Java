import java.util.concurrent.*;
import java.util.concurrent.locks.*;

public class AccountWithSyncUser {
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
	
		public synchronized void run() {
			userAccount.deposit(1);
		}
}
private static class Account{
	//ReentractLock is the concrete implementation, if it is true, the longest waiting thread will get the lock next or else it will be passed randomly
	private static Lock lock = new ReentrantLock(true);
	private int balance = 0;
	
	public void deposit(int amount) {
		//when we synchronize a section of code, each thread acquires a lock on the object or class, executes the code and releases the lock
		lock.lock();
		try {
			int newBalance = balance + amount;
			balance = newBalance;
		}
		finally {
			lock.unlock();
		}
		
		
		
	}
	public int getBalance() {
		return balance;
	}
	
}
}
