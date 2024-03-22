package com.github.zipcodewilmington.casino;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 * `ArcadeAccountManager` stores, manages, and retrieves `ArcadeAccount` objects
 * it is advised that every instruction in this class is logged
 */
public class CasinoAccountManager {
    /**
     * @param accountName     name of account to be returned
     * @param accountPassword password of account to be returned
     * @return `ArcadeAccount` with specified `accountName` and `accountPassword`
     */

    private final IOConsole console = new IOConsole(AnsiColor.BLUE);

    private ArrayList<CasinoAccount> accountList;

    //private List<CasinoAccount> accountList;

    public CasinoAccountManager() {
        this.accountList = new ArrayList<>();
    }


    public CasinoAccount getAccount(String accountName, String accountPassword) {

        for (CasinoAccount account : accountList) {
            if (account.getAccountName().equals(accountName) && account.getAccountPassword().equals(accountPassword)) {
                return account; // Found matching account
            }
        }
        return null; // Account not found
//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }

    /**
     * logs & creates a new `ArcadeAccount`
     *
     * @param accountName     name of account to be created
     * @param accountPassword password of account to be created
     * @return new instance of `ArcadeAccount` with specified `accountName` and `accountPassword`
     */
    public CasinoAccount createAccount(String accountName, String accountPassword) {

        CasinoAccount newAccount = new CasinoAccount(accountName, accountPassword);

        newAccount.depositToBalance(500.0);

        // log the creation of the new account

        return newAccount;

//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }

    /**
     * logs & registers a new `ArcadeAccount` to `this.getArcadeAccountList()`
     *
     * @param casinoAccount the arcadeAccount to be added to `this.getArcadeAccountList()`
     */
    public void registerAccount(CasinoAccount casinoAccount) {
        // Add the provided casino account to the accountList
        accountList.add(casinoAccount);

        // Optionally, you can log the registration of the account
        System.out.println("Account registered: " + casinoAccount.getAccountName());

//        String currentMethodName = new Object(){}.getClass().getEnclosingMethod().getName();
//        String currentClassName = getClass().getName();
//        String errorMessage = "Method with name [ %s ], defined in class with name [ %s ] has  not yet been implemented";
//        throw new RuntimeException(String.format(errorMessage, currentMethodName, currentClassName));
    }
}
