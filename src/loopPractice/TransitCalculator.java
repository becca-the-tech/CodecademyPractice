package loopPractice;

/*
This project helps users calculate what type of transit membership they'd be best getting
based on the number of rides planned over the course of how many days

Calculates the price per ride on each of the plans and displays it in an easy reading format for users.
 */

//TODO: Refactor code to use the fields numDays/numRides in methods instead of listed parameters
//TODO: Refactor code to use Tampa Transit prices instead of stock prices
//TODO: Add comments to improve code readability

public class TransitCalculator{
    private int numberOfDays;
    private int numberOfRides;
    public double singleRideFare = 2.75;
    public double unlimited7DayFare = 33;
    public double unlimited30DayFare = 127;

    public TransitCalculator(int numberOfDays, int numberOfRides){
        this.numberOfDays = numberOfDays;
        this.numberOfRides = numberOfRides;
    }

    public String toString(){
        return "Will be riding " + numberOfRides + " times in " + numberOfDays + " days";
    }

    public double unlimited7Price(int numDays, int numRides){
        double numWeekPasses;
        double totalPriceForWeeks;
        double pricePerRide;

        //how many weekly passes needed
        if(numDays % 7 == 0){
            numWeekPasses = numDays / 7;
        } else {
            numWeekPasses = Math.floor(numDays / 7) + 1;
        }

        //cost for the number of weekly passes
        totalPriceForWeeks = unlimited7DayFare * numWeekPasses;

        //total price divided by ride number to get price per ride
        pricePerRide = totalPriceForWeeks / numRides;

        return pricePerRide;
    }

    public double[] getRidePrices(int numDays, int numRides){
        double[] ridePrices = new double[3];

        //calculate cost per ride of each option
        double singleCost = 2.75;
        double pricePerRide7Days = unlimited7Price(numDays, numRides);
        double pricePer30Days = unlimited30DayFare / numRides;

        //add each pricePerRide to the array
        ridePrices[0] = singleCost;
        ridePrices[1] = pricePerRide7Days;
        ridePrices[2] = pricePer30Days;

        return ridePrices;
    }

    public String getBestFare(int numDays, int numRides){
        double[] ridePrices = getRidePrices(numDays, numRides);
        double lowestPrice = ridePrices[0];
        int index = 0;
        String bestFare;

        for (int i = 1; i < ridePrices.length; i++){
            if(ridePrices[i] < lowestPrice){
                lowestPrice = ridePrices[i];
                index = i;
            }
        }

        switch(index){
            case 0:
                bestFare = "You should pay for single rides at $2.75/each for cheapest price.";
                break;
            case 1:
                bestFare = "You should pay for the 7-Day Unlimited option at $" + lowestPrice + "/each for cheapest price.";
                break;
            case 2:
                bestFare = "You should pay for the 30-Day Unlimited option at $" + lowestPrice + "/each for cheapest price.";
                break;
            default:
                bestFare = "Code broke somehow. Try again";
                break;
        }

        return bestFare;
    }


    public static void main(String[] args){
        TransitCalculator trip1 = new TransitCalculator(2, 7);
        System.out.println(trip1);

        //Testing to make sure output is as expected
        System.out.println(trip1.unlimited7Price(19,20));
        System.out.println(trip1.unlimited7Price(22, 50));
        System.out.println(trip1.getBestFare(5, 12));


    }
}