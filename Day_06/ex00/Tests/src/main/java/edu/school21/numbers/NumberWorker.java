package edu.school21.numbers;

public class NumberWorker {

    public boolean isPrime(int number){
        int step = 1;
        if (number < 2){
            throw new IllegalNumberException();
        }
        if (number % 2 == 0 && number != 2){
            return false;
        }
        for(int i = 3; i * i <= number; i += 2, step ++) {
            if(number % i == 0){
                return false;
            }
        }
        return true;
    }

    public int digitsSum(int number) {
        int i = 0;
        while (number != 0) {
            i += number % 10;
            number /= 10;
        }
        return i;
    }

    class IllegalNumberException extends RuntimeException{
        public String toString(){
            return ("Number < 2");
        }
    }
}
