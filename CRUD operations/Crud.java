import java.util.HashMap;
import java.util.Scanner;
class Bank{
    private int accId;
    private String accHolName;
    private float accBalance;
    public static String bankName="HDFC Bank";
    public Bank(int accId){
        this.accId=accId;
    }
    public Bank(int accId, String accHolName, float accBalance){
        this.accId=accId;
        this.accHolName=accHolName;
        this.accBalance=accBalance;
    }
    public int getAccId(){
        return accId;
    }
    public String getAccHolName(){
        return accHolName;
    }
    public float getAccBalance(){
        return accBalance;
    }
    public void setAccBalance(float accBalance){
        this.accBalance=accBalance;
    }
    public void setAccHolName(String accHolName){
        this.accHolName=accHolName;
    }
    public static String getBankName(){
        return bankName;
    }

}
public class Crud{
    public static void main(String[] args) {
        HashMap<Integer,Bank> hm=new HashMap<>();
        Scanner sc=new Scanner(System.in);
        int choice;
        do{
            System.out.println("Welcome to "+Bank.getBankName());
            System.out.println("1. Create Account");
            System.out.println("2. Display Account Details");
            System.out.println("3. Update Account Holder Name");
            System.out.println("4. Deposit Amount");
            System.out.println("5. Withdraw Amount");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            choice=sc.nextInt();
            switch(choice){
                case 1:
                    System.out.print("Enter Account ID: ");
                    int accId=sc.nextInt();
                    sc.nextLine(); 
                    System.out.print("Enter Account Holder Name: ");
                    String accHolName=sc.nextLine();
                    System.out.print("Enter Initial Balance: ");
                    float accBalance=sc.nextFloat();
                    Bank newAccount=new Bank(accId, accHolName, accBalance);
                    hm.put(accId, newAccount);
                    System.out.println("Account created successfully!");
                    System.out.println("");
                    break;
                case 2:
                    System.out.print("Enter Account ID to display details: ");
                    int displayId=sc.nextInt();
                    if(hm.containsKey(displayId)){
                        Bank account=hm.get(displayId);
                        System.out.println("Account ID: "+account.getAccId());
                        System.out.println("Account Holder Name: "+account.getAccHolName());
                        System.out.println("Account Balance: "+account.getAccBalance());
                        System.out.println("Bank Name: "+Bank.getBankName());
                        System.out.println("");
                    } else {
                        System.out.println("Account not found!");
                        System.out.println("");
                    }
                    break;
                case 3:
                    System.out.print("Enter Account ID to update name: ");
                    int updateId=sc.nextInt();
                    sc.nextLine(); 
                    if(hm.containsKey(updateId)){
                        System.out.print("Enter new Account Holder Name: ");
                        String newName=sc.nextLine();
                        hm.get(updateId).setAccHolName(newName);
                        System.out.println("Account holder name updated successfully!");
                        System.out.println("");
                    } else {
                        System.out.println("Account not found!");
                        System.out.println("");
                    }
                    break;
                case 4:
                    System.out.print("Enter Account ID to deposit amount: ");
                    int depositId=sc.nextInt();
                    if(hm.containsKey(depositId)){
                        System.out.print("Enter amount to deposit: ");
                        float depositAmount=sc.nextFloat();
                        Bank account=hm.get(depositId); 
                        account.setAccBalance(account.getAccBalance()+depositAmount);
                        System.out.println("Amount deposited successfully!");
                        System.out.println("");
                    } else {
                        System.out.println("Account not found!");
                        System.out.println("");
                    }
                    break;
                case 5:
                    System.out.print("Enter Account ID to withdraw amount: ");
                    int withdrawId=sc.nextInt();
                    if(hm.containsKey(withdrawId)){ 
                        System.out.print("Enter amount to withdraw: ");
                        float withdrawAmount=sc.nextFloat();
                        Bank account=hm.get(withdrawId); 
                        if(account.getAccBalance()>=withdrawAmount){
                            account.setAccBalance(account.getAccBalance()-withdrawAmount);
                            System.out.println("Amount withdrawn successfully!");
                            System.out.println("Remaining Balance: "+account.getAccBalance());
                            System.out.println("");
                        } else {
                            System.out.println("Insufficient balance!");
                            System.out.println("");
                        }
                    } else {
                        System.out.println("Account not found!");
                        System.out.println("");
                    }
                    break;
                case 6:
                    System.out.println("Exiting...");
                    System.out.println("");
                    break;
                default:
                    System.out.println("Invalid choice! Please try again.");
                    System.out.println("");
            }
        }while(choice!=6);
    }
}