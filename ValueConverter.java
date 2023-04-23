import java.util.Scanner; 

public class ValueConverter { 

    static Scanner input = new Scanner(System.in); 

    static int menuChoice2=0; // "convert to" menu 

    static int menuChoice3=0; // "convert something again" menu 

     

    //regular expression to prevent InputMismastchException and negative numbers 

    static String regExp="[0-9]+[a-zA-Z]+[0-9]|[0-9]+[a-zA-Z]+|[a-zA-Z]+[0-9]+|[a-zA-Z]+|[a-zA-Z]+[0-9]+[a-zA-Z]|\\D|[0-9]+[~`!@#$%^&()_={}\\[\\]\\:;,\\.\\/<>\\\\*\\-+\\?]+|[A-Za-z]+[~`!@#$%^&()_={}\\[\\]\\:;,\\.\\/<>\\\\*\\-+\\?]+|[~`!@#$%^&()_={}\\[\\]\\:;,\\.\\/<>\\\\*\\-+\\?]+[0-9]+|\\b[\\D]+\\b"; 

    public static void main(String[] args) { 

        int menuChoice=0; 

        menu(); 

        do{ 

            System.out.println("What number type do you want to convert?"); 

            System.out.println("I want to convert..."); 

            System.out.println("1. Decimal\t2. Binary\t3. Octal\t4. Hexadecimal\t5. Nevermind (Exit)"); 

            //checks if the value entered is a letter; if so, loops until user enters a number 

                while (input.hasNext(regExp)) {                     

                    System.out.println("Please enter a valid number"); 

                    input.next(); 

                } 

            menuChoice=input.nextInt();// main menu 

            switch (menuChoice) { 

                 

                // call respective methods that opens menu and ask the values to be converted 

                case 1: 

                    decimal();  

                    break; 

                case 2: 

                    binary(); 

                    break; 

                case 3: 

                    octal(); 

                    break; 

                case 4: 

                    hex();                     

                    break; 

                case 5: // option 5: exiting 

                    System.out.println("Exiting program... goodbye "); 

                    break; 

                     

                default: // unlisted options: loops again to the main menu 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println(); 

                    System.out.println(); 

                    menu(); //calls the logo function again  

            } 

        }while (menuChoice!=5); 

         

         

    } 

     

    // a simple function just to show a "logo" 

    public static void menu(){ 

        System.out.println("========================"); 

        System.out.println("NUMBER CONVERTER"); 

        System.out.println("========================"); 

    } 

     

    // functions for each individual format systems 

    public static void decimal(){  

         

        do {          

            System.out.println("Decimal to..."); 

            System.out.println("1. Binary\t2. Octal\t3. Hexadecimal\t4. Go Back"); 

                //checks if the value entered is a letter; if so, loops until user enters a number 

                while (input.hasNext(regExp)) {                     

                    System.out.println("Please enter a valid number"); 

                    input.next(); 

                } 

            menuChoice2=input.nextInt(); 

            int decNum = 0; 

            switch (menuChoice2) { 

            case 1: 

                System.out.println("DECIMAL: "); // enter a decimal 

                while (input.hasNext(regExp)) { // the value won't be accepted if it isn't a valid number     

                    System.out.println("Please enter a valid number"); 

                    input.next(); 

                } 

                decNum = input.nextInt(); 

                System.out.println("BINARY: "); 

                decToBinary(decNum); // call the function that converters decimal to binary 

                System.out.println(); 

 

                repOrEx(); // function that will ask if the user want to repeat or exit 

                if(menuChoice3==1){ 

                    menuChoice2=1; // repeat; go back to the previous menu 

                } else if (menuChoice3==2) { 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ // choosing unlisted options will make the user go to the previous menu 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=1; 

                } 

                break; 

            case 2: 

                System.out.println("DECIMAL: "); // enter a decimal 

                while (input.hasNext(regExp)) { // the value won't be accepted if it isn't a valid number                  

                    System.out.println("Please enter a valid number"); 

                    input.next(); 

                } 

                decNum = input.nextInt(); 

                System.out.println("OCTAL: ");  

                decToOctal(decNum); // call the function that converters decimal to octal 

                System.out.println(); 

 

                repOrEx();  

                if(menuChoice3==1){ 

                    menuChoice2=2; // repeat; go back to the previous menu 

                } else if (menuChoice3==2) { 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ // choosing unlisted options will make the user go to the previous menu 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=2; 

                } 

                break; 

            case 3: 

                System.out.println("DECIMAL: "); // enter a decimal 

                while (input.hasNext(regExp)) {  // the value won't be accepted if it isn't a valid number                     

                    System.out.println("Please enter a valid number"); 

                    input.next(); 

                } 

                decNum = input.nextInt(); 

                System.out.print("HEXA: "); 

                decToHex(decNum); 

                System.out.println(); 

 

                repOrEx(); // function that will ask if the user want to repeat or exit 

                if(menuChoice3==1){ // repeat; go back to the previous menu 

                    menuChoice2=3;  

                } else if (menuChoice3==2) { 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ // choosing unlisted options will make the user go to the previous menu 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=3; 

                } 

                break; 

            case 4: 

                System.out.println(); 

                menu(); 

                break; 

            default: 

                System.out.println("Please choose only from the displayed number..."); 

                System.out.println(); 

            } 

        } while (menuChoice2!=4); 

    } 

    public static void binary(){ 

        do {          

            System.out.println("Binary to..."); 

            System.out.println("1. Decimal\t2. Octal\t3. Hexadecimal\t4. Go Back"); 

                while (input.hasNext(regExp)) {                     

                    System.out.println("Please enter a valid number "); 

                    input.next(); 

                } 

             

            menuChoice2=input.nextInt(); 

            int binNum = 0; 

            switch (menuChoice2) { 

            case 1: 

                System.out.println("BINARY: "); 

                while (input.hasNext(regExp)||input.hasNext("[2-9]+")) { // entered values are not accepted if it isn't a number a digit 0 and 1                   

                    System.out.println("Please enter a valid number and digits from 0-1"); 

                    input.next(); 

                } 

                binNum = input.nextInt(); 

                System.out.println("DECIMAL: "); 

                binToDecimal(binNum); // call the function that will convert binary to decimal 

                System.out.println(); 

 

                repOrEx(); // function that will ask if the user want to repeat or exit 

                if(menuChoice3==1){ // option 1: convert using the same number format 

                    menuChoice2=1; 

                } else if (menuChoice3==2) { // option 2: exit 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ // unlisted options: will go back to the previous menu like option 1 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=1; 

                } 

                break; 

            case 2: 

                System.out.println("BINARY: "); 

                while (input.hasNext(regExp)||input.hasNext("[2-9]+")) { // entered values are not accepted if it isn't a number a digit 0 and 1                        

                    System.out.println("Please enter a valid number and digits from 0-1"); 

                    input.next(); 

                } 

                binNum = input.nextInt(); 

                System.out.println("OCTAL: "); 

                binToOctal(binNum); // call the function that will convert binary to octal 

                System.out.println(); 

 

                repOrEx();  

                if(menuChoice3==1){ 

                    menuChoice2=2; 

                } else if (menuChoice3==2) { 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=2; 

                } 

                break; 

            case 3: 

                System.out.println("BINARY: "); 

                while (input.hasNext(regExp)||input.hasNext("[2-9]+")) {                     

                    System.out.println("Please enter a valid number and digits from 0-1"); 

                    input.next(); 

                } 

                binNum = input.nextInt(); 

                System.out.print("HEXA: "); 

                binToHex(binNum); // call the function that will convert binary to hexadecimal 

                System.out.println(); 

 

                repOrEx();  

                if(menuChoice3==1){ 

                    menuChoice2=3; 

                } else if (menuChoice3==2) { 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=3; 

                } 

                break; 

            case 4: 

                System.out.println(); 

                menu(); 

                break; 

            default: 

                System.out.println("Please choose only from the displayed number..."); 

                System.out.println(); 

            } 

        } while (menuChoice2!=4); 

    } 

    public static void octal(){ 

        do {          

            System.out.println("Octal to..."); 

            System.out.println("1. Decimal\t2. Binary\t3. Hexadecimal\t4. Go Back"); 

                while (input.hasNext(regExp)) {                     

                    System.out.println("Please enter a valid number"); 

                    input.next(); 

                } 

            menuChoice2=input.nextInt(); 

            int octNum = 0; 

            switch (menuChoice2) { 

            case 1: 

                System.out.println("OCTAL: "); 

                while (input.hasNext(regExp)||input.hasNext("[8-9]+")) {  // the user needs to input a number that is only from digits 0-7                   

                    System.out.println("Please enter a valid number and digits from 0-7"); 

                    input.next(); 

                } 

                octNum = input.nextInt(); 

                System.out.println("DECIMAL: "); 

                octToDecimal(octNum); // call the function that will convert octal to decimal 

                System.out.println(); 

 

                repOrEx();  

                if(menuChoice3==1){ // option 1: convert using the same number format 

                    menuChoice2=1; 

                } else if (menuChoice3==2) { // option 2: exit 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ // unlisted options: will go back to the previous menu like option 1 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=1; 

                } 

                break; 

            case 2: 

                System.out.println("OCTAL: "); 

                while (input.hasNext(regExp)||input.hasNext("[8-9]+")) { // the user needs to input a number that is only from digits 0-7                     

                    System.out.println("Please enter a valid number and digits from 0-7"); 

                    input.next(); 

                } 

                octNum = input.nextInt(); 

                System.out.println("BINARY: "); 

                octToBinary(octNum); // call the function that will convert octal to binary 

                System.out.println(); 

 

                repOrEx();  

                if(menuChoice3==1){ 

                    menuChoice2=2; 

                } else if (menuChoice3==2) { 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=2; 

                } 

                break; 

            case 3: 

                System.out.println("OCTAL: "); 

                while (input.hasNext(regExp)||input.hasNext("[8-9]+")) { // the user needs to input a number that is only from digits 0-7                     

                    System.out.println("Please enter a valid number and digits from 0-7"); 

                    input.next(); 

                } 

                octNum = input.nextInt(); 

                System.out.print("HEXA: "); 

                octToHex(octNum); // call the function that will convert octal to hexadecimal 

                System.out.println(); 

 

                repOrEx();  

                if(menuChoice3==1){ 

                    menuChoice2=3;  

                } else if (menuChoice3==2) { 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=3; 

                } 

                break; 

            case 4: 

                System.out.println(); 

                menu(); 

                break; 

            default: 

                System.out.println("Please choose only from the displayed number..."); 

                System.out.println(); 

            } 

        } while (menuChoice2!=4); 

    } 

    public static void hex(){ 

        do {          

            System.out.println("Hexadecimal to..."); 

            System.out.println("1. Decimal\t2. Binary\t3. Octal\t4. Go Back"); // user needs to enter a valid option or it won't be accepted and will result in a loop 

                while (input.hasNext(regExp)) {                     

                    System.out.println("Please enter a valid number"); 

                    input.next(); 

                } 

            menuChoice2=input.nextInt(); 

            String hexNum=" "; 

            switch (menuChoice2) { 

            case 1: 

                System.out.println("HEXADECIMAL: "); 

                while (!input.hasNext("\\b[0-9A-Fa-f]+\\b")) { // use to validate if the entered value is a hexadecimal; if not, it will ask another value                      

                    System.out.println("Please enter a valid hexadecimal value"); 

                    input.next(); 

                } 

                hexNum = input.next(); 

                System.out.println("DECIMAL: "); 

                hexToDecimal(hexNum); 

                System.out.println(); 

 

                repOrEx();  

                if(menuChoice3==1){ 

                    menuChoice2=1; // option 1: convert using the same number format 

                } else if (menuChoice3==2) { // option 2: exit 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ // unlisted options: will go back to the previous menu like option 1 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=1; 

                } 

                break; 

            case 2: 

                System.out.println("HEXADECIMAL: "); 

                while (!input.hasNext("\\b[0-9A-Fa-f]+\\b")) {                     

                    System.out.println("Please enter a valid hexadecimal value"); 

                    input.next(); 

                } 

                hexNum = input.next(); 

                System.out.println("BINARY: "); 

                hexToBinary(hexNum); 

                System.out.println(); 

 

                repOrEx();  

                if(menuChoice3==1){ 

                    menuChoice2=2; 

                } else if (menuChoice3==2) { 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=2; 

                } 

                break; 

            case 3: 

                System.out.println("HEXADECIMAL: "); 

                while (!input.hasNext("\\b[0-9A-Fa-f]+\\b")) {                     

                    System.out.println("Please enter a valid hexadecimal value"); 

                    input.next(); 

                } 

                hexNum = input.next(); 

                System.out.print("OCTAL: "); 

                hexToOctal(hexNum); 

                System.out.println(); 

 

                repOrEx();  

                if(menuChoice3==1){ 

                    menuChoice2=3; 

                } else if (menuChoice3==2) { 

                    System.out.println("Exiting program... goodbye "); 

                    System.exit(0); 

                } else{ 

                    System.out.println("Please choose only from the displayed number..."); 

                    System.out.println("Returning to the same number system..."); 

                    menuChoice2=3; 

                } 

                break; 

            case 4: 

                System.out.println(); 

                menu(); 

                break; 

            default: 

                System.out.println("Please choose only from the displayed number..."); 

                System.out.println(); 

            } 

        } while (menuChoice2!=4); 

    } 

     

    public static void repOrEx(){ //method that ask if the user want to use the same conversion again or close the program 

        System.out.println("Done converting, what would you like to do?"); 

        System.out.println("1. Do the same number system"); 

        System.out.println("2. Exit"); 

                while (input.hasNext(regExp)) {                     

                    System.out.println("Please enter a valid number"); 

                    input.next(); 

                } 

        menuChoice3=input.nextInt(); 

    } 

     

     

    // methods to convert decimal into different formats  

    public static void decToBinary(int num){ 

        int binary[] = new int[40]; 

        int i=0; // for remainders 

        while(num > 0){ // 0 is the last dividend 

            binary[i++] = num%2; //array to store remainder values of the decimal when divided by 2 

            num = num/2; //divides the num by 2 

            // this simulates how we convert decimal to binary 

            //dividing by 2, then getting the remainder 

        } 

 

        //looping backward; from Most Significant Bit to Least 

        for (int j = i - 1; j >= 0; j--) 

            System.out.print(binary[j]); 

    } 

    public static void decToHex(int num){ 

        int i;  

        String hexVal=""; 

        // choose the value relative to the array index  

        char[] hex = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'}; 

         

        while(num > 0){ 

            i=num%16; // get remainder 

            hexVal = hex[i]+hexVal; //concatonate string  

            num=num/16; // to move to the next value 

        } 

        System.out.print(hexVal); 

    }   

    public static void decToOctal(int num){ 

        int i; 

        String octVal=""; 

        // choose the value relative to the array index  

        char[] octal={'0','1','2','3','4','5','6','7'}; 

         

        while(num >0){ 

            i=num%8; // get remainder 

            octVal = octal[i]+octVal; //concatonate string  

            num=num/8; // to move to the next value 

        } 

        System.out.print(octVal); 

    } 

       

    // methods to convert binary into different formats  

    public static void binToDecimal(int num) { 

        int decVal=0; 

        int i=1, rem; //remainder; starts at 1 because is simulates the num raise to 0 which means 1 

                        // because it starts with multiplying the numbers so we need a non zero number 

        while (num!=0) { 

            rem=num%10; // get last digit 

            decVal = decVal+rem*i; // add the values with the remainder and multiply the the power 

            i=i*2; // power by 2's 

            num = num/10; // to divide the binary then move to the next calculation (the previuos last digit is removed) 

        } 

        System.out.println(decVal); 

    } 

    public static void binToOctal(int num) { 

         

        int decVal=0; 

        int i=1, rem; //remainder 

        while (num!=0) { 

            rem=(int)num%10; // get first the remainder 

            decVal = decVal+rem*i; // add the values with the remainder and multiply the the power 

            i=i*2; // power by 2's 

            num = num/10; // to divide the binary then move to the next calculation 

        } 

        

        decToOctal(decVal); 

    }   

    public static void binToHex(int num){ 

        int decVal=0; 

        int i=1, rem; //remainder 

        while (num!=0) { 

            rem=(int)num%10; // get first the remainder 

            decVal = decVal+rem*i; // add the values with the remainder and multiply the the power 

            i=i*2; // power by 2's 

            num = num/10; // to divide the binary then move to the next calculation 

        } 

         

        decToHex(decVal); 

    } 

     

    // methods to convert octal into different formats  

    public static void octToBinary(int num){  

        int decVal=0; 

        int i=1; //remainder; starts at 1 because is simulates the num raise to 0 which means 1 

                 // because it starts with multiplying the numbers so we need a non zero number 

        int temp=num; //temp because we need to get the original number 

        while (temp>0) { 

            int ldigit=temp%10; // get last digit 

            temp=temp/10;       // to divide the binary then move to the next calculation (the previuos last digit is removed) 

            decVal+=ldigit*i;   // add the values with the remainder and multiply the the power 

            i=i*8;  

         } 

         

        decToBinary(decVal); 

    } 

    public static void octToHex(int num){  

        int decVal=0; 

        int base=1; 

        int temp=num; 

        while (temp>0) { 

            int ldigit=temp%10; 

            temp=temp/10; 

            decVal+=ldigit*base; 

            base=base*8;  

         } 

         

        decToHex(decVal); 

    } 

    public static void octToDecimal(int num){ //sumation of digits myltiplied by 8 raise to i 

        int decVal=0; 

         

        // base value as 1; 8^0=1 

        int i=1; 

         

        int temp=num; 

        while (temp>0) { 

            // get the last digit 

            int rem=temp%10; 

            temp=temp/10; 

             

            // the extracted digit is multiplied to the base 

            decVal+=rem*i; 

             

            i=i*8; // each raise is by 8; 8^1(1*8=8), 8^2(8*8=64)  

         } 

        System.out.println(decVal); 

    } 

     

    // methods to convert hexadecimal into different formats  

    public static void hexToDecimal(String hex) { 

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

        System.out.println(decVal); 

    } 

    public static void hexToBinary(String hex) { 

        int decVal=0; 

        int count=hex.length(); 

         

        // base value as 1; 16^0=1 

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

        decToBinary(decVal); 

    } 

    public static void hexToOctal(String hex) { 

        int decVal=0; 

        int count=hex.length(); 

         

        // base value as 1; 16^0=1 

        int base=1; 

         

        //counts how many digits; length 

        int i=count-1; 

        while (i>=0) { 

             

            if (hex.charAt(i)>= '0' && hex.charAt(i) <='9') { 

                decVal += ((hex.charAt(i)-48)*base); 

                 

                base*=16; 

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

        decToOctal(decVal); 

    } 

} 