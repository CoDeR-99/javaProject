package bank;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;
import java.util.Scanner;

public class optionMenu extends Account{
    Scanner menuInput= new Scanner(System.in);
    DecimalFormat moneyFormat= new DecimalFormat("'$'###,##0.00"); //define the pattern in which amount is printed.

    HashMap<Integer, Integer> data= new HashMap<Integer, Integer>(); //use to store user account number and password.

    public void getLogin() throws IOException{
        int x= 1;
        do{
            try{
                data.put(9876543, 9876);
                data.put(8967453, 1234);

                System.out.println("Welcome to the ATM Project!");
                
                System.out.println("Enter Your Customer Number: ");
                setCustomerNumber(menuInput.nextInt());

                System.out.println("Enter Your Pin Number: ");
                setPinNumber(menuInput.nextInt());
            }catch (Exception e){
                System.out.println("\n"+"Invalid character(s). Only numbers."+"\n");
                x= 2;
                continue;
            }
            Iterator it= data.entrySet().iterator();
            boolean flag= false;
            while(it.hasNext()){
                Map.Entry mp= (Map.Entry)it.next();
                if((int)mp.getKey()== getCustomerNumber() && (int)mp.getValue()==getPinNumber()){
                    flag= true;
                    getAccountType();
                }
            }
            if(flag==false){
                System.out.println("\n"+"Wrong Customer Number or Pin Number."+"\n");
            } 
        }while(x==1);
    }

    public void getAccountType(){
        System.out.println("Select the Account you want to access: ");
        System.out.println("Type 1- Checking Account");
        System.out.println("Type 2- Saving Account");
        System.out.println("Type 3- Exit");
        System.out.println("Choice: ");

        selection= menuInput.nextInt();

        switch(selection){
            case 1: getChecking();
            break;
            case 2: getSaving();
            break;
            case 3: System.out.println("Thank you for using this ATM, bye.");
            System.exit(0);
            break;
            default: System.out.println("\n"+"Invalid Choice."+"\n");
            getAccountType();
        }
    }

    public void getChecking(){
        System.out.println("Checking Account: ");
        System.out.println("Type 1- View Balance");
        System.out.println("Type 2- Withdraw Funds");
        System.out.println("Type 3- Deposit Finds");
        System.out.println("Type 4- Exit");
        System.out.println("Choice: ");

        selection= menuInput.nextInt();

        switch(selection){
            case 1: System.out.println("Checking Account Balance: "+ moneyFormat.format(getCheckingBalance()));
            getAccountType();
            break;
            case 2: getCheckingWithdrawInput();
            getAccountType();
            break;
            case 3: getCheckingDepositInput();
            getAccountType();
            break;
            case 4: System.out.println("Thank you for using this ATM, bye");
            System.exit(0);
            break;
            default: System.out.println("\n"+"Invalid choice."+"\n");
            getChecking();
        }
    }

    public void getSaving(){
        System.out.println("Saving Account: ");
        System.out.println("Type 1- View Balance");
        System.out.println("Type 2- Withdraw Funds");
        System.out.println("Type 3- Deposit Finds");
        System.out.println("Type 4- Exit");
        System.out.println("Choice: ");

        selection= menuInput.nextInt();

        switch(selection){
            case 1: System.out.println("Saving Account Balance: "+ moneyFormat.format(getSavingBalance()));
            getAccountType();
            break;
            case 2: getSavingWithdrawInput();
            getAccountType();
            break;
            case 3: getSavingDepositInput();
            getAccountType();
            break;
            case 4: System.out.println("Thank you for using this ATM, bye");
            System.exit(0);
            break;
            default: System.out.println("\n"+"Invalid choice."+"\n");
            getSaving();
        }
    }
    int selection;
}