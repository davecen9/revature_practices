package bankservices;

public interface CanDeposit {
	default void Deposit(Integer amount){
		this.balance +=amount;
	};
}
