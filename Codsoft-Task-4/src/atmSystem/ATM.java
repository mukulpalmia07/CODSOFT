package atmSystem;

public class ATM {
	private double balance;
	private double amountDeposit;
	private double amountWithdrawn;
	
	public ATM() {
		
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getAmountDeposit() {
		return amountDeposit;
	}

	public void setAmountDeposit(double amountDeposit) {
		this.amountDeposit = amountDeposit;
	}

	public double getAmountWithdrawn() {
		return amountWithdrawn;
	}

	public void setAmountWithdrawn(double amountWithdrawn) {
		this.amountWithdrawn = amountWithdrawn;
	}
	
}
