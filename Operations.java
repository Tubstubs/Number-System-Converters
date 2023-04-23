import java.util.*;

public class Operations {

    static Scanner input = new Scanner(System.in);
    static int menuChoice2 = 0; // "convert to" menu
    static int menuChoice3 = 0; // "convert something again" menu

    //regular expression to prevent InputMismastchException and negative numbers
    static String regExp = "[0-9]+[a-zA-Z]+[0-9]|[0-9]+[a-zA-Z]+|[a-zA-Z]+[0-9]+|[a-zA-Z]+|[a-zA-Z]+[0-9]+[a-zA-Z]|\\D|[0-9]+[~`!@#$%^&()_={}\\[\\]\\:;,\\.\\/<>\\\\*\\-+\\?]+|[A-Za-z]+[~`!@#$%^&()_={}\\[\\]\\:;,\\.\\/<>\\\\*\\-+\\?]+|[~`!@#$%^&()_={}\\[\\]\\:;,\\.\\/<>\\\\*\\-+\\?]+[0-9]+|\\b[\\D]+\\b";

    public static void main(String[] args) {
        mainMenu();
    }

    // a simple function just to show a "logo"
    public static void mainMenu() {
        int menuChoice = 0;
        menu();
        do {
            System.out.println("What number system do you want to compute?");
            System.out.println("I want to compute...");
            System.out.println("1. Binary\t2. Octal\t3. Hexadecimal\t4. Nevermind (Exit)");
            //checks if the value entered is a letter; if so, loops until user enters a number
            while (input.hasNext(regExp)) {
                System.out.println("Please enter a valid number");
                input.next();
            }
            menuChoice = input.nextInt();// main menu
            switch (menuChoice) {

                // call respective methods that opens menu and ask the values to be converted
                case 1:
                    menuBinary();
                    break;
                case 2:
                    menuOctal();
                    break;
                case 3:
                    menuHexa();
                    break;
                case 4: // option 4: exiting
                    System.out.println("Exiting program... goodbye ");
                    System.exit(0);
                    break;

                default: // unlisted options: loops again to the main menu
                    System.out.println("Please choose only from the displayed number...");
                    System.out.println();
                    System.out.println();
                    mainMenu(); //calls the logo function again
            }
        } while (menuChoice != 5);

    }

    // a menu function just for aesthetics and better readability
    public static void menu() {
        System.out.println("========================");
        System.out.println("ARITHMETIC OPERATIONS");
        System.out.println("========================");
    }

    // menu function used to ask user what arithmetic operation to use
    // displays the choices
    public static void menu2() {
        System.out.println("\nWhat arithmetic operations do you want to use? ");
        System.out.println("I want to use... ");
        System.out.println("1. Addition\t2. Subtraction\t3. Multiplication\t4. Division \t5. Try different numbers\t6. Go to Main Menu");
    }

    public static void menuBinary() {
        System.out.println("Enter 1st Binary number: ");
        while (input.hasNext(regExp) || input.hasNext("[2-9]+")) { // entered values are not accepted if it isn't a number a digit 0 and 1                  
            System.out.println("Please enter a valid number and digits from 0-1");
            System.out.println("Enter 1st Binary number: ");
            input.next();
        }
        long n1 = input.nextInt();

        System.out.println("Enter 2nd Binary number: ");
        while (input.hasNext(regExp) || input.hasNext("[2-9]+")) { // entered values are not accepted if it isn't a number a digit 0 and 1 
            System.out.println("Please enter a valid number and digits from 0-1");
            System.out.println("Enter 2nd Binary number: ");
            input.next();
        }
        long n2 = input.nextInt();

        int ask = 0;

        do {
            menu2();
            while (input.hasNext(regExp)) {
                System.out.println("Please enter a valid number");
                input.next();
            }
            ask = input.nextInt();

            switch (ask) {
                case 1:
                    long sum = binaryAdd(n1, n2);
                    System.out.println("\nSum of Binary numbers : " + sum);
                    break;
                case 2:
                    long diff = binarySubtract(n1, n2);
                    System.out.println("\nDifference of Binary numbers : " + diff);
                    break;
                case 3:
                    long prod = binaryMultiply(n1, n2);
                    System.out.println("\nProduct of Binary numbers : " + prod);
                    break;
                case 4:
                    // error trapping method that prevents divisor being greater or being divided by zero; also catches other error
                    try{
                        long quo = binaryDivision(n1, n2);
                        System.out.println("\nProduct of Binary numbers : " + quo);
                    } catch (Exception e){
                        System.out.println("ERROR: Most likely divisor is greater than dividend or divided by zero, please try again");
                        System.out.println();
                        menuBinary();
                    }
                    break;
                case 5:
                    menuBinary();
                case 6:
                    System.out.println();
                    mainMenu();
                    break;
                default:
                    System.out.println("Please choose only from the displayed number...");
                    System.out.println();
            }

        } while (ask != 5);
    }
    public static void menuOctal() {
        System.out.println("Enter 1st Octal number: ");
        while (input.hasNext(regExp) || input.hasNext("[8-9]+")) {  // the user needs to input a number that is only from digits 0-7                  
            System.out.println("Please enter a valid number and digits from 0-7");
            input.next();
        }
        int n1 = input.nextInt();

        System.out.println("Enter 2nd Octal number: ");
        while (input.hasNext(regExp) || input.hasNext("[8-9]+")) {  // the user needs to input a number that is only from digits 0-7                  
            System.out.println("Please enter a valid number and digits from 0-7");
            input.next();
        }
        int n2 = input.nextInt();

        int ask = 0;

        do {
            menu2();
            while (input.hasNext(regExp)) {
                System.out.println("Please enter a valid number");
                input.next();
            }
            ask = input.nextInt();
            switch (ask) {
                case 1:
                    long sum = octalAdd(n1, n2);
                    System.out.println("\nSum of Octal numbers : " + sum);
                    break;
                case 2:
                    int diff = octalSubtract(n1, n2);
                    System.out.println("\nDifference of Octal numbers : " + diff);
                    break;
                case 3:
                    long prod = octalMultiply(n1, n2);
                    System.out.println("\nProduct of Octal numbers : " + prod);
                    break;
                case 4:
                    // error trapping method that prevents divisor being greater or being divided by zero; also catches other error
                    try{
                        int quo = octalDivision(n1, n2);
                        System.out.println("\nQuotient of Octal numbers : " + quo);
                    } catch (Exception e){
                        System.out.println("ERROR: Most likely divisor is greater than dividend or divided by zero, please try again");
                        System.out.println();
                        menuOctal();
                    }

                    break;
                case 5:
                    menuOctal();
                case 6:
                    System.out.println();
                    mainMenu();
                    break;
                default:
                    System.out.println("Please choose only from the displayed number...");
                    System.out.println();
            }

        } while (ask != 5);
    }
    public static void menuHexa() {
        System.out.println("Enter 1st Hexadecimal number: ");
                while (!input.hasNext("\\b[0-9A-Fa-f]+\\b")) { // use to validate if the entered value is a hexadecimal; if not, it will ask another value                     
                    System.out.println("Please enter a valid hexadecimal value");
                    input.next();
                }
        String n1 = input.next().toUpperCase();

        System.out.println("Enter 2nd Hexadecimal number: ");
                while (!input.hasNext("\\b[0-9A-Fa-f]+\\b")) { // use to validate if the entered value is a hexadecimal; if not, it will ask another value                     
                    System.out.println("Please enter a valid hexadecimal value");
                    input.next();
                }
        String n2 = input.next().toUpperCase();

        int ask = 0;

        do {
            menu2();
            while (input.hasNext(regExp)) {
                System.out.println("Please enter a valid number");
                input.next();
            }
            ask = input.nextInt();
            switch (ask) {
                case 1:
                    String sum = addHexadecimal(n1, n2);
                    System.out.println("\nSum of Hexadecimal numbers : " + sum);
                    break;
                case 2:
                    String diff = subHexadecimal(n1, n2);
                    System.out.println("\nDifference of Hexadecimal numbers : " + diff);
                    break;
                case 3:
                    String prod = hexaMultiply(n1, n2);
                    System.out.println("\nProduct of Hexadecimal numbers : " + prod);
                    break;
                case 4:
                    // error trapping method that prevents divisor being greater or being divided by zero; also catches other error
                    try{
                        String quo = hexaDivision(n1, n2);
                        System.out.println("\nQuotient of Hexadecimal numbers : " + quo);
                    } catch (Exception e){
                        System.out.println("ERROR: Most likely divisor is greater than dividend or divided by zero, please try again");
                        System.out.println();
                        menuHexa();
                    }
                    break;
                case 5:
                    menuHexa();
                case 6:
                    System.out.println();
                    mainMenu();
                    break;
                default:
                    System.out.println("Please choose only from the displayed number...");
                    System.out.println();
            }

        } while (ask != 5);
    }

    static long binaryAdd(long binaryNum1, long binaryNum2) {
        int carry = 0;
        int length = 0;
        String total="";
        String num1 = new StringBuilder(Long.toString(binaryNum1)).reverse().toString(); //converting binaryNum1 to String data type in reverse
        String num2 = new StringBuilder(Long.toString(binaryNum2)).reverse().toString(); //converting binaryNum2 to String data type in reverse
        int value1=0, value2=0;

        if (num1.length() > num2.length()) //getting the length of the largest binary number for the loop
            length = num1.length() - 1;
        else
            length = num2.length() - 1;
        int c = 0;
        while(c<=length){ //the loop //the addition process
            if(num1.length()-1 < c) { //to check if num1 index is out of bound
                value1 = 0; //substitute if out of bound
            }else {
                value1 = Character.getNumericValue(num1.charAt(c));
            }
            if(num2.length()-1 < c) { //to check if num2 index is out of bound
                value2 = 0; //substitute if out of bound
            }else {
                value2 = Character.getNumericValue(num2.charAt(c));
            }
            int sum=0;
            sum = value1 + value2 + carry; // the operation
            //outcomes of the addition process per indexes //could be switchcase but im too lazy
            if (sum == 0){
                total+="0";
                carry=0; //reset the carry holder
            }
            if (sum == 1){
                total+="1";
                carry=0;
            }
            if (sum == 2){ //indication of the carry process
                total+="0";
                carry=1;
            }
            if (sum == 3){ //indication of the carry process
                total+="1";
                carry=1;
            }
            c++;
        }
        if (carry > 0) //to add the leftover carry value to the sum after the loop
            total+="1";
        total = new StringBuilder(total).reverse().toString(); //reverse the total holder
        return Long.parseLong(total); //converting total to long data type before returning
    }
    static long binarySubtract(long binaryNum1,long binaryNum2){//binaryNum1 = minuend binaryNum2 = subtrahend
        String total="";
        String binaryNum1Temp = String.valueOf(binaryNum1); //convert binaryNum1 to string

        ArrayList<Character> minuend = new ArrayList<Character>(); //minuend holder due to borrowing since string is immutable
        for(int c=String.valueOf(binaryNum1).length()-1;c>=0;c--){ //loop to add minuend characters as indexes in the arraylist
            minuend.add(binaryNum1Temp.charAt(c));
        }
        String subtrahend = new StringBuilder(Long.toString(binaryNum2)).reverse().toString(); // convert binaryNum2 in string in reverse
        int length,value1,value2,c=0,difference=0;
        if (minuend.size() > subtrahend.length()) //to get the length of the largest binary number
            length = minuend.size();
        else
            length = subtrahend.length() - 1;
        while(c<length) { //while loop, the calculation part
            if (minuend.size() < c) { //to check minuend if the index is out of bounds
                value1 = 0;
            } else {
                value1 = Character.getNumericValue(minuend.get(c));
            }
            if (subtrahend.length() - 1 < c) { //to check subtrahend if the index is out of bounds
                value2 = 0;
            } else {
                value2 = Character.getNumericValue(subtrahend.charAt(c));
            }
            difference = value1 - value2; // the subtraction process
            //outcomes of the subtraction process //could possibly be a switch case but im too lazy
            if (difference == 0) { // means subtraction process = 1-1
                total += "0";
            }
            if (difference == 1) { // means subtraction process = 1-0
                total += "1";
            }
            if (difference == -1) { // means the subtraction process need borrowing = 0-1 //the borrowing process
                total += "1"; // because of imagine borrowing 2-1 =1 //:P
                minuend.set(c+1,'0'); //set the next digit(arraylist index) to 0 since we borrowed
            }
            c++;
        }
        total = new StringBuilder(total).reverse().toString(); //reversing the total/difference
        return Long.parseLong(total); //converting the total to long data type
    }
    static long binaryMultiply(long binaryNum1, long binaryNum2){ //multiplicand = binaryNum1 multiplier = binaryNum2
        String multiplicand = new StringBuilder(Long.toString(binaryNum1)).reverse().toString(); //reverse of the binaryNum1 in string
        String multiplier = new StringBuilder(Long.toString(binaryNum2)).reverse().toString(); //reverse of the binaryNum2 in string

        ArrayList<Long> toAdd = new ArrayList<>(); //an array to hold the binary numbers to be added
        for (int m1 = 0;m1<multiplier.length();m1++){ //this is a 2D loop used for the process of multiplying each index
            String final_Product = "";
            if (m1 >0){//add "0" on the final product only at index 0 of the multiplicand
                for (int c=0;c<m1;c++){
                    final_Product +="0"; //this is to fix the indexes of the binary numbers during the addition in multiplication
                }
            }
            for(int m2 = 0;m2<multiplicand.length();m2++){ //multiply per index multiplicand[m2] * multiplier[m1]
                long product =0; // product holder
                product = (long) Character.getNumericValue(multiplier.charAt(m1)) * Character.getNumericValue(multiplicand.charAt(m2)); //the operation
                final_Product += Long.toString(product); //final product holder
            }
            final_Product = new StringBuilder(final_Product).reverse().toString(); //reverse the final_product
            toAdd.add(Long.parseLong(final_Product)); //add the final_product to the arraylist
            final_Product = ""; //empty final_product
        }
        int c=0; //count variable
        long total =0; // the total sum holder
        while(c< toAdd.size()){ //loop to add all the binary numbers within the arraylist
            total = binaryAdd(total,toAdd.get(c)); //adding the binary number to the next binary number within the arraylist
            c++;
        }
        return total;
    }
    static long binaryDivision(long binaryNum1, long binaryNum2){ //110111 / 101
        String dividend = Long.toString(binaryNum1); //dividend string
        String divisor = Long.toString(binaryNum2); //divisor string
        long remainder = 0;
        String temp = "";
        String quotient = "";
        String tempval1 = dividend.substring(0,divisor.length()); //get the same number of digits of divisor from the dividend
        long value1 = Long.parseLong(tempval1); // string to long

        for (int c = divisor.length()-1;c<=dividend.length()-1;c++){ //loop of the division
            if (value1 >= binaryNum2){ //check if the selected digit from the dividend >= divisor
                quotient=quotient+"1"; //add "1" to the quotient
                remainder = binarySubtract(value1,binaryNum2); //subtraction of dividend and divisor
                temp = String.valueOf(remainder); //hold the value of the remainder
            }
            else{
                quotient=quotient+"0"; //add "0" to the quotient
            }
            if (c<dividend.length()-1) { //check if there is still a digit to be brought down
                temp = temp + dividend.charAt(c + 1); //add the brought down digit to the temp
                value1 = Long.parseLong(temp); //update value1 with the value of temp
            }
        }
        return Long.parseLong(quotient); //converting quotient to long datatype
    }

    static long octalAdd(long n1, long n2) {

        long sum = 0;    // stores the final answer
        long carry = 0;  // stores the carry 
        long power = 1;  // 10^0; power of tem

        while (n1 > 0 || n2 > 0 || carry > 0) {   // until it doesn't have anything to iterate to

            long digit1 = n1 % 10;   //get the last number; ex. 467%10 = 7
            n1 = n1 / 10;           //get the number without the last digit; ex. 467/10=46

            long digit2 = n2 % 10;
            n2 = n2 / 10;

            long digit = digit1 + digit2 + carry;    //get the overall addition first 
            /* for example in:
                                                           467
                                                         +  24
                                                        ---------
                                                             
                                                        first step is you'll add the 7 and 4 before doing anything;
                                                        if there's a carry number(from previous calculation), we'll also add that 
             */

            carry = digit / 8;  //after getting the overall addition of two numbers (i.e. 7+4+0 = 11) we'll divide it to 8 to get the carry

            digit = digit % 8;  //to get the remainder
            /*
                                   1    <-- carries
                                  467
                                +  24
                                --------
                                    3   <-- remainders
                                            
             */

            sum = sum + digit * power;  // the power of ten puts the digit to where it should belong
            /* ex. 0 + 3*1  = 3  <-- once       // 13
                                               3 + 1 *10 = 13 <-- tens; because of the power the 10 is inserted in the tens; 3+10
                                              13 + 5*100= 513<-- hundreds; 13+500
                                             
             */

            power = power * 10; // increase the power each iteration
        }

        return sum;
    }
    public static long octalMultiply(long num1, long num2) {
        long product = 0;
        int power = 1;
        int EIGHT = 8;
        long n1 = num1; // multiplicand
        long n2 = num2; // multiplier

        ArrayList<Long> toAdd = new ArrayList<>();

        // get the length of the 2 values for looping
        int length1 = String.valueOf(n1).length();
        int length2 = String.valueOf(n2).length();

        long digit = 0;
        long digit1 = 0;
        long n1Temp = n1;

        // will first mulitply the first digit of 2nd value to each 1st values
        // 246*4
        for (int i = length2; i > 0; i--) {

            long digit2 = n2 % 10;  // get the last digit
            n2 = n2 / 10;           // get the digits without the last digit
            // ex for 24
            // 4
            // 2

            n1 = n1Temp;
            power = 1; // reset power
            product = 0;
            long carry = 0;

            // nested for loop for the first value (multiplicand)
            for (int j = length1; j > 0; j--) {

                                    // ex. for 467
                digit1 = n1 % 10;   //7
                n1 = n1 / 10;       //46
                                                    // ex. 467*4
                digit = digit2 * digit1 + carry;    //0=4*7+0 =28 
                carry = digit / EIGHT; //carry
                digit = digit % EIGHT; //remainder

                product = product + digit * power;  //0+0+28*1=28
                                                    // ex. if the product is 10, the operation will be: 28+10*10 = 290
                                                    // the power variable places the values by ones, tens, hundreds,...

                power = power * 10;
            }
            // if theres a carry at the end of operation, it will be placed at the end of the line
            // simulates a drop down
            if (carry > 0) {
                product = product + carry * power;
            }

            // adds the "line" in an arraylist; will be used to add each values
            //
            toAdd.add(product);
        }

        // adding the zeroes at the end of each item
        // simulates:
        /*      178
        *      1780
        *     17800
        *    178000
        * */
        long numAddZero = 0;
        long numAddZeroFinal = 0;
        int powerAddZero = 1;
        for (int i = 0; i < toAdd.size(); i++) {
            numAddZero = toAdd.get(i);
            numAddZeroFinal = numAddZero * powerAddZero; // 1 as starting value because we don't shift the place of the first line, when adding product values
            powerAddZero = powerAddZero * 10;
            toAdd.set(i, numAddZeroFinal);
        }

        // add zeroes at the start(left side) of each item
        // prevents out of bounds error
        // simulates:
        /*       00000000178
         *      000000001680
         *     0000000019800
         */
        ArrayList<String> stringToAdd = new ArrayList<>();
        for (int i = 0; i < toAdd.size(); i++) {
            String formatted = String.format("%08d", toAdd.get(i));
            stringToAdd.add(formatted); // add each formatted values to a List
        }

        // getting the last digits of each item in ArrayList(i.e toAdd)
        ArrayList<Integer> lastDigits = new ArrayList<>();
        ArrayList<Integer> finalSum = new ArrayList<>();
        int counter = 1; // to know what index to get (right to left)
        int carry = 0;

        String str = "";
        int last = 0;
        int sumOfLastDigits = 0;
        int power2 = 1;

        // used for checking and also transfer the values to another array
        for (int j = 0; j < stringToAdd.size(); j++) {

            str = stringToAdd.get(j);   // get the first index; ex: 00000000178
            last = Character.getNumericValue(str.charAt(str.length() - counter)); // get the digit

            finalSum.add(Integer.parseInt(str)); //
            sumOfLastDigits = sumOfLastDigits + last + carry;
            /*              11     <--- carry
             *       00000000178
             *      000000001680
             *     0000000019800
             */
            lastDigits.clear();
        }

        long sumFin = 0;    // stores the final answer
        long carryFin = 0;  // stores the carry 
        long powerFin = 1;  // 10^0; power of tem

        long[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

        // transfer to an array every values
        for (int i = 0; i < finalSum.size(); i++) {
            arr[i] = finalSum.get(i);
        }
        // 178
        // 1780
        /*       12
        * 123456789
        * */
        while (arr[0] > 0 || arr[1] > 0 || arr[2] > 0 || arr[3] > 0 || arr[4] > 0 || arr[5] > 0 || arr[6] > 0 || arr[7] > 0 || arr[8] > 0 || arr[9] > 0 || carryFin > 0) {   // until it doesn't have anything to iterate to

            long digit1Fin = arr[0] % 10;   //get the last number; ex. 467%10 = 7
            arr[0] = arr[0] / 10;           //get the number without the last digit; ex. 467/10=46

            long digit2Fin = arr[1] % 10;
            arr[1] = arr[1] / 10;

            long digit3Fin = arr[2] % 10;
            arr[2] = arr[2] / 10;

            long digit4Fin = arr[3] % 10;
            arr[3] = arr[3] / 10;

            long digit5Fin = arr[4] % 10;
            arr[4] = arr[4] / 10;

            long digit6Fin = arr[5] % 10;
            arr[5] = arr[5] / 10;

            long digit7Fin = arr[6] % 10;
            arr[6] = arr[6] / 10;

            long digit8Fin = arr[7] % 10;
            arr[7] = arr[7] / 10;

            long digit9Fin = arr[8] % 10;
            arr[8] = arr[8] / 10;

            long digit10Fin = arr[9] % 10;
            arr[9] = arr[9] / 10;

            long digitFin = digit1Fin + digit2Fin + digit3Fin + digit4Fin + digit5Fin + digit6Fin + digit7Fin + digit8Fin + digit9Fin + digit10Fin + carryFin;    //get the overall addition first 
            /* for example in:
                                                           467
                                                         +  24
                                                        ---------
                                                             
                                                        first step is you'll add the 7 and 4 before doing anything;
                                                        if there's a carry number(from previous calculation), we'll also add that 
             */

            carryFin = digitFin / 8;  //after getting the overall addition of two(or more) numbers (i.e. 7+4 = 11) we'll divide it to 8 to get the carry

            digitFin = digitFin % 8;  //to get the remainder
            /*
                                   1    <-- carries
                                  467
                                +  24
                                --------
                                    3   <-- remainders
                                            
             */

            sumFin = sumFin + digitFin * powerFin;  // the power of ten puts the digit to where it should belong
            /* ex. 0 + 3*1  = 3  <-- once
                                               3 + 1*10 = 13 <-- tens; because of the power the 10 is inserted in the tens; 3+10
                                              13 + 5*100= 513<-- hundreds; 13+500
                                             
             */

            powerFin = powerFin * 10; // increase the power each iteration
        }
        return sumFin;
    }
    public static int octalSubtract(int n1, int n2) {
        int diff = 0;
        int power = 1;
        int str = 0;

        while (n1 > 0 || n2 > 0) {

            int digit1 = n1 % 10;
            n1 = n1 / 10;

            int digit2 = n2 % 10;
            n2 = n2 / 10;

            if (digit2 > digit1) {

                int num1 = n1;   // get the latest value without the last digit on the right
                int newN1 = 0;   // stores the new "n1" value
                int pow = 1;

                while (num1 > 0) { // iterate until each digit is changed, it only happen when "digit1" needs to borrow a value of 8.
                    // the value of "digit1" is excluded in "num1"

                    int num2 = num1 % 10;
                    num1 = num1 / 10;

                    if (num2 == 0 && str == 0) {              //change 0 to 7 in number line
                        newN1 = newN1 + 7 * pow;
                    } else if (num2 > 0 && str == 0) {        //minus 1 to the original value  
                        newN1 = newN1 + (num2 - 1) * pow;
                        str = 1;                            //it stops changing the values of the rest digit in number line 

                    } else if (str == 1) {                    //to copy the rest of the digit in number line
                        newN1 = newN1 + num2 * pow;
                    }

                    pow = pow * 10;
                }

                digit1 = digit1 + 8; // add 8 to the last digit on the right, 
                n1 = newN1;          // "n1" is changed by the value of "newN1",
                // all conditions with "n1" global variable will be changed
                // including the "n1" in the first while loop condition.

                str = 0;             // reset the value to 0 in case nested while loop starts to iterate

            }

            diff = diff + (digit1 - digit2) * power;
            power = power * 10;

        }

        return diff;
    }
    static int octalDivision(int dividend, int divisor){
        String S_dividend = String.valueOf(dividend); //convert int to string
        String S_divisor = String.valueOf(divisor); // convert int to string
        int remainder = 0;
        String temp = "";
        String quotient = "";
        int length = 0;
        String tempS_dividend = S_dividend.substring(0, S_divisor.length()); //get the substring with the same string length of the divisor
        int tempI_dividend = Integer.parseInt(tempS_dividend); //converting string to int
        length = S_dividend.length()-1;
        int multi = 1;
        long L_product = 0;

        for(int c = S_divisor.length()-1;c<=length;c++){ // the main loop of the calculation

                while(true){ //to multiply the to an incrementing integer
                    L_product =  octalMultiply(multi, divisor);
                    if(L_product > tempI_dividend) //bool check to break out of the loop after product is greater than divisor
                        break;
                    multi++;
                }
                multi=multi -1; //to make the multiplier less than the dividend but not greater than dividend when multiplied
                L_product = octalMultiply(multi,divisor); //update the new product which is not > dividend and <
                int difference = octalSubtract(tempI_dividend,(int)L_product);//process of getting the difference
                if ( difference>= 0){ // to check in case of negative values
                    quotient = quotient+multi; //adding value for the final result
                    remainder = difference;
                }
                if (c<length){ //to check if there is still a number to bring down
                    temp = String.valueOf(remainder) + S_dividend.charAt(c+1); // adding the bring down value
                    tempI_dividend = Integer.parseInt(temp);
                }


        }

        if(quotient.length() <= 0){
            return 0;
        } else
            return Integer.parseInt(quotient); //return the final quotient
    }

    static String addHexadecimal(String a, String b){
        int n = a.length();
        int m = b.length();
        int i = n-1;
        int j = m-1;
        int temp = 0;
        int carry = 0;
        String result = "";

        char[] hexaValue = {'0','1','2','3','4','5','6',
                '7','8','9','A','B','C','D','E','F'};

        while(i > 0 || j > 0)
        {                                           //while loop to add every index
            if(i > 0 && j > 0)
            {
                temp = decimalValue(a.charAt(i)) +      //temp temporarily holds the value of the addend plus the addend plus the carry
                        decimalValue(b.charAt(j)) + carry;

                i--;
                j--;
            }
            else if(i > 0)
            {
                temp = decimalValue(a.charAt(i)) +  carry;      //if i or the addend is greater than 0 then it will add the caryy
                i--;
            }
            else
            {
                temp = decimalValue(b.charAt(j)) + carry; //if j or the addend is less greater than 0 then it will add the caryy
                j--;
            }

            result = hexaValue[(temp % 16)] + result;       //result will hold the hexadecumal value plus the result then carry will be divided into 16
            carry = temp / 16;
        }

        if(carry!=0)
        {                                               //if carry is not equal to zero then print the result into converted hexadecimal value
            result = hexaValue[carry] + result;
        }


        return result;

    }
    public static String hexaMultiply(String num1, String num2) {

        int EIGHT = 16;


        // getting all characters in each hex 
        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<Character> chars2 = new ArrayList<>();
        ArrayList<Long> charsLong = new ArrayList<>();
        ArrayList<Long> chars2Long = new ArrayList<>();
        String hex1 = num1;
        String hex2 = num2;
        for (char ch : hex1.toCharArray()) {
            chars.add(ch);
        }
        for (char ch : hex2.toCharArray()) {
            chars2.add(ch);
        }

        // converting each character to Long and putting it to new list
        for (int i = 0; i < chars.size(); i++) {
            if (chars.get(i) == 'A' || chars.get(i) == 'B' || chars.get(i) == 'C' || chars.get(i) == 'D' || chars.get(i) == 'E' || chars.get(i) == 'F') {
                charsLong.add(hexToDecimal(Character.toString(chars.get(i))));
            } else {
                charsLong.add(Long.valueOf(Character.toString(chars.get(i))));
            }
            
        }
        for (int i = 0; i < chars2.size(); i++) {
            if (chars2.get(i) == 'A' || chars2.get(i) == 'B' || chars2.get(i) == 'C' || chars2.get(i) == 'D' || chars2.get(i) == 'E' || chars2.get(i) == 'F') {
                chars2Long.add(hexToDecimal(Character.toString(chars2.get(i))));
            } else {
                chars2Long.add(i, Long.valueOf(Character.toString(chars2.get(i))));
            }
            
        }

        int lengthChar = charsLong.size(); // get the length of the two values for looping
        int lengthChar2 = chars2Long.size();
        long digit = 0;
        long multiplied = 0;

        ArrayList<Long> toAdd = new ArrayList<>();
        ArrayList<Long> toAdd2 = new ArrayList<>();
        ArrayList<Long> toAdd3 = new ArrayList<>();
        ArrayList<Long> toAdd4 = new ArrayList<>();
        ArrayList<Long> toAdd5 = new ArrayList<>();
        ArrayList<Long> toAdd6 = new ArrayList<>();
//        ArrayList<Long> toAdd7 = new ArrayList<>();
//        ArrayList<Long> toAdd8 = new ArrayList<>();
//        ArrayList<Long> toAdd9 = new ArrayList<>();
        for (int i = lengthChar2 - 1; i >= 0; i--) {

            long digit2 = chars2Long.get(i);


            long carry = 0;
            for (int j = lengthChar - 1; j >= 0; j--) {

                multiplied = charsLong.get(j);

                digit = digit2 * multiplied + carry;
                
                carry = digit / EIGHT; //carry
                digit = digit % EIGHT; //remainder

                if (i == lengthChar2 - 1) {
                    toAdd.add(digit);
                } else if (i == lengthChar2 - 2) {
                    toAdd2.add(digit);
                } else if (i == lengthChar2 - 3) {
                    toAdd3.add(digit);
                } else if (i == lengthChar2 - 4) {
                    toAdd4.add(digit);
                } else if (i == lengthChar2 - 5) {
                    toAdd5.add(digit);
                } else if (i == lengthChar2 - 6) {
                    toAdd6.add(digit);
                }

            }
            if (i == lengthChar2 - 1) {
                if (carry > 0) {
                    toAdd.add(carry);
                }
            } else if (i == lengthChar2 - 2) {
                if (carry > 0) {
                    toAdd2.add(carry);
                }
            } else if (i == lengthChar2 - 3) {
                if (carry > 0) {
                    toAdd3.add(carry);
                }
            } else if (i == lengthChar2 - 4) {
                if (carry > 0) {
                    toAdd4.add(carry);
                }
            } else if (i == lengthChar2 - 5) {
                if (carry > 0) {
                    toAdd5.add(carry);
                }
            } else if (i == lengthChar2 - 6) {
                if (carry > 0) {
                    toAdd6.add(carry);
                }
            } 

        }

        // 000100
        // 001110
        // 011100
        // 111000
        // add zeroes at the start of each element
        toAdd2.add(0,Long.valueOf(0));
        toAdd3.add(0,Long.valueOf(0));toAdd3.add(1,Long.valueOf(0));
        toAdd4.add(0,Long.valueOf(0));toAdd4.add(1,Long.valueOf(0));toAdd4.add(2,Long.valueOf(0));
        toAdd5.add(0,Long.valueOf(0));toAdd5.add(1,Long.valueOf(0));toAdd5.add(2,Long.valueOf(0));toAdd5.add(3,Long.valueOf(0));
        toAdd6.add(0,Long.valueOf(0));toAdd5.add(1,Long.valueOf(0));toAdd5.add(2,Long.valueOf(0));toAdd5.add(3,Long.valueOf(0));toAdd5.add(4,Long.valueOf(0));

        // add zeroes at the end of each element
        toAdd.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        toAdd2.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        toAdd3.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        toAdd4.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        toAdd5.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));
        toAdd6.addAll(Arrays.asList(Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0), Long.valueOf(0)));


        long[] arr = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        
        long carry2=0;
        long digitFin =0;
        ArrayList<Long> finalSum = new ArrayList<>();
        for (int i = 0; i < 9; i++) {
            // add all digits that are allined
            /*               <----
            *   00001101
            *   00011010
            *   00110100
            * ------------
            *
            */
            arr[i] = toAdd.get(i)+toAdd2.get(i)+toAdd3.get(i)+toAdd4.get(i)+toAdd5.get(i)+toAdd6.get(i);
            digitFin =   carry2+arr[i] ;
            carry2 = digitFin / EIGHT; //carry
            digitFin = digitFin % EIGHT;  //remainder
            
            finalSum.add(digitFin);
        }
        if(carry2>0){
            finalSum.add(carry2);
        }

        
        String finalString = "";
        for (int i = 0; i <  finalSum.size(); i++) {
            if (finalSum.get(i)==10) {
                finalString=finalString+"A";
            } else if (finalSum.get(i)==11) {
                finalString=finalString+"B";
            } else if (finalSum.get(i)==12) {
                finalString=finalString+"C";
            } else if (finalSum.get(i)==13) {
                finalString=finalString+"D";
            } else if (finalSum.get(i)==14) {
                finalString=finalString+"E";
            } else if (finalSum.get(i)==15) {
                finalString=finalString+"F";
            } else{
                finalString=finalString+finalSum.get(i);
            }
            
        }

        // ABC
        // CBA
        // ABC
        String reverse = new StringBuffer(finalString).reverse().toString();
        String noZero =reverse.replaceFirst("^0+(?!$)", "");
        return noZero;
    }
    static String subHexadecimal(String paraminuend, String subtrahend){
        int i = paraminuend.length()-1;
        int j = subtrahend.length()-1;
        int temp = 0;
        int borrow = 16;
        String difference = "";
        int tempMin = 0;
        int tempSubtra = 0;

        ArrayList<Integer> minuend = new ArrayList<>();

        for (int c = 0;c<paraminuend.length();c++){ //loop adding while converting letters of the minuend to decimal values to the arraylist
            if (paraminuend.toLowerCase().charAt(c) >='a' && paraminuend.toLowerCase().charAt(c) <='z'){ // converting letters to decimal
                minuend.add(decimalValue(paraminuend.toLowerCase().charAt(c)));
            }else {
                minuend.add(Character.getNumericValue(paraminuend.charAt(c)));
            }

        }
        if (i>=j){ // check if the minuend is greater than subtrahend
            while(i >= 0){ //main loop for the calculation
                if (j>=0){
                    if (subtrahend.toLowerCase().charAt(j) >= 'a' && subtrahend.toLowerCase().charAt(j) <='z'){// converting subtrahend letters to decimal values
                        tempSubtra = decimalValue(subtrahend.charAt(j));
                    }
                    tempSubtra = Character.getNumericValue(subtrahend.charAt(j));
                }else{
                    tempSubtra = 0; // in instances where j is less than zero
                }
                tempMin = minuend.get(i);

                if((tempMin - tempSubtra) < 0) { //to check if the difference will be negative number
                    int temp1 = minuend.get(i-1)-1 ;
                    int temp2 = minuend.set(i-1, temp1); //subtracting 1 to the next digit because of borrowing
                    tempMin = borrow + tempMin; // the calculation of the borrowing process

                }
                int i_difference = tempMin - tempSubtra; // the final subtraction process
                if (i_difference >9){
                    difference = String.valueOf(HextoDec(i_difference)) + difference;
                }else {
                    difference = String.valueOf(i_difference)+ difference; //arranging the difference it proper order
                }
                /*
                System.out.println(tempMin+"<");
                System.out.println(tempSubtra+">");
                System.out.println(i_difference);
                */
                i--; // loop counting
                j--; //loop counting
            }
        }
//        System.out.println(difference);
        return difference; //returns the final difference
    }
    public static String hexaDivision (String num1, String num2){

        String hex1 = num1; // dividend
        long divisor = hexToDecimal (num2); // divisor

        String dividend = "";
        String quotient = "";
        String quoTimesDivisor = "";
        String subtracted ="";
        int indexStart = 0;


        // to know where to start
        // ex. in BABE/11, the division should start from BA
        int i = 0;
        while (hexToDecimal(dividend)<divisor){
            char dividendChar  = hex1.charAt(i);
            dividend = dividend+dividendChar; //BA
            indexStart = i; // index 1
            i++;
        }


        // 0 1 2 3 4  < index
        // B 3 6 D E
        ArrayList<String> finalQuotient = new ArrayList<>(); // List to store final quotient values
        String finalString ="";
        // it will start at the index that the divisor can be divided to
        for (int j = indexStart; j < hex1.length(); j++){
            if (hexToDecimal(dividend)>=divisor){
                // "10"
                quotient = Long.toString(hexToDecimal(dividend)/divisor); // divide the dividend to devisor to get the quotient
                // if the quotient character is greater than 9
                if (quotient.equals("10")||quotient.equals("11")||quotient.equals("12")||quotient.equals("13")||quotient.equals("14")||quotient.equals("15")) {
                    switch (quotient) {
                        case "10":
                            quotient = "A";
                            break;
                        case "11":
                            quotient= "B";
                            break;
                        case "12":
                            quotient= "C";
                            break;
                        case "13":
                            quotient= "D";
                            break;
                        case "14":
                            quotient= "E";
                            break;
                        case "15":
                            quotient = "F";
                            break;
                    }
                }
                finalQuotient.add(quotient);


                quoTimesDivisor=hexaMultiply(quotient,num2);
                //System.out.println(quoTimesDivisor);

                // if j is at the last digit
                if(j == hex1.length()-1){
                    subtracted = subHexadecimal(dividend,quoTimesDivisor);

                }else{
                    // if not, bring down
                    subtracted = subHexadecimal(dividend,quoTimesDivisor) + hex1.charAt(j+1);
                }



                dividend = subtracted;
                finalString+=quotient;

            }
            // if the dividend is less than the divisor
            else{
                quotient = Long.toString(hexToDecimal(dividend)/divisor); //ba
                if (quotient.equals("10")||quotient.equals("11")||quotient.equals("12")||quotient.equals("13")||quotient.equals("14")||quotient.equals("15")) {
                    switch (quotient) {
                        case "10":
                            quotient = "A";
                            break;
                        case "11":
                            quotient= "B";
                            break;
                        case "12":
                            quotient= "C";
                            break;
                        case "13":
                            quotient= "D";
                            break;
                        case "14":
                            quotient= "E";
                            break;
                        case "15":
                            quotient = "F";
                            break;
                    }
                }
                finalQuotient.add(quotient);


                quoTimesDivisor=hexaMultiply(quotient,num2);
                //System.out.println(quoTimesDivisor);

                if(j == hex1.length()-1){
                    subtracted = subHexadecimal(dividend,quoTimesDivisor);

                }else{
                    subtracted = subHexadecimal(dividend,quoTimesDivisor)+hex1.charAt(j+1);
                }


                dividend = subtracted;
                finalString+=quotient;

            }

        }

        return finalString;
    }


    // other methods needed in hexadecimal functions
    public static String decToHex(long num){
        long i;
        String hexVal="";
        // choose the value relative to the array index
        char[] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};

        while(num > 0){
            i=num%16; // get remainder
            hexVal = hex[Math.toIntExact(i)]+hexVal; //concatonate string
            num=num/16; // to move to the next value
        }
        return hexVal;
    }
    public static long hexToDecimal(String hex) {
        int decVal=0;
        int count=hex.length();

        // base value as 1; 16^0=1; because we need something to multiply it to, instead
        int base=1;

        //counts how many digits; length
        int i=count-1;
        while (i>=0) {

            // converts ASCII to numerical/integral values
            // if you subtract 48 from a character you will get its equivalent integer
            // the '0' char is 48 in decimal, and if you subtract 48 you will get the decimal 0 and hex value 0
            if (hex.charAt(i)>= '0' && hex.charAt(i) <='9') {
                decVal += ((hex.charAt(i)-48)*base);

                base*=16;

                // the 'A' char is 65 in decimal, and if you subtract 55 you will get the decimal 10
                // which means the hex value A
            } else if(hex.charAt(i)>= 'A' && hex.charAt(i) <='F'){
                decVal += ((hex.charAt(i)-55)*base);

                base*=16;
            } else if(hex.charAt(i)>= 'a' && hex.charAt(i) <='f'){
                decVal += ((hex.charAt(i)-87)*base);

                base*=16;
            } else {
                System.out.println("Not a HEXADECIMAL number");
            }


            i--;
        }

        return decVal;
    }
    static int decimalValue(char x){
        if(x=='A' || x == 'a')
        {
            return 10;
        }
        if(x == 'B' || x == 'b')
        {
            return 11;
        }
        if(x == 'C' || x == 'c')
        {
            return 12;
        }
        if(x == 'D' || x == 'd')
        {
            return 13;
        }
        if(x == 'E' || x == 'e')
        {
            return 14;
        }
        if(x == 'F' || x == 'f')
        {
            return 15;
        }

        return  x - '0';
    }
    static char HextoDec(int x){
        if(x==10) { return 'A'; }
        if(x==11) { return 'B'; }
        if(x==12) { return 'C'; }
        if(x==13) { return 'D'; }
        if(x==14) { return 'E'; }
        if(x==15) { return 'F'; }
        return 0;
    }

}

