package carloanConditionalPractice;


/*
This code takes the variables: car loan amount, loanLength (in yrs), interest rate, and down payment
to calculate the monthly loan amount to be paid
*/

//TODO: create CarLoan constructors and setters/getters
//TODO: create CarLoan methods and instance fields

public class CarLoan {
    public static void main(String[] args) {
        int carLoan = 10000;
        int loanLength = 3;
        int interestRate = 5;
        int downPayment = 2000;

        if(loanLength <= 0 || interestRate <= 0){
            System.out.println("Error! You must take out a valid car loan.");
        } else if(downPayment >= carLoan){
            System.out.println("If down payment is greater than the loan amount, car can be paid in full.");
        } else {
            int remainingBalance = carLoan - downPayment;
            int months = loanLength * 12;
            int monthlyBalance = remainingBalance / months;
            int interest = (monthlyBalance * interestRate) / 100;

            int monthlyPayment = monthlyBalance + interest;
            System.out.println(monthlyPayment);
        }

    }
}
