package wallet;

public class Wallet implements Observer {
  private static Wallet walletInstance;
  private int amount = 100;

  private Wallet() {
  }

  public static Wallet getInstance() {
    if (walletInstance == null) {
      walletInstance = new Wallet();
    }
    return walletInstance;
  }

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public void update(int paidAmount) {
    amount -= paidAmount;
    // System.out.println("Total amount: " + paidAmount);
  }
}
