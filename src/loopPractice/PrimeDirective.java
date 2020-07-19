package loopPractice;

// Import statement:
import java.util.ArrayList;

class PrimeDirective {

    // Add your methods here:
    public boolean isPrime(int number){
        //2 is smallest prime
        //numbers smaller than 2 are not prime
        if(number == 2){
            return true;
        } else if (number < 2){
            return false;
        }

        //checks each number for any divisible numbers, if they exist it is not prime
        for(int i = 2; i < number; i++){
            if (number % i == 0){
                return false;
            }
        }
        //if it exits the loop without ever finding a number it was divisible by, it's prime
        return true;
    }

    //takes an array of ints, returns only the primes from that list
    public ArrayList<Integer> onlyPrimes(int[] numbers){
        ArrayList<Integer> primes = new ArrayList<Integer>();

        //checks each number in the int array if it's prime
        //if prime, adds to the primes ArrayList
        for(int number: numbers){
            if(isPrime(number)){
                primes.add(number);
            }
        }
        //returns ArrayList of primes
        return primes;
    }

    //runs the methods on various numbers/ arrays to be sure it's working
    public static void main(String[] args) {

        PrimeDirective pd = new PrimeDirective();
        int[] numbers = {6, 29, 28, 33, 11, 100, 101, 43, 89};

        System.out.println(pd.isPrime(7));
        System.out.println(pd.isPrime(28));
        System.out.println(pd.isPrime(2));
        System.out.println(pd.isPrime(0));

        System.out.println(pd.onlyPrimes(numbers));
    }

}