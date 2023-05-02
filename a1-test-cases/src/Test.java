/**
 * @description Program that test cases for a1.
 * @how-to-use Copy and paste your code into the appropriate classes in the source folder.
 */

import A1.*;
public class Test {
    public static void main(String[] args) {

        /* Singe Token */
        if ((Roman.romanToInt("I") != 1)) throw new AssertionError();
        if ((Roman.romanToInt("V") != 5)) throw new AssertionError();
        if ((Roman.romanToInt("X") != 10)) throw new AssertionError();
        if ((Roman.romanToInt("L") != 50)) throw new AssertionError();
        if ((Roman.romanToInt("C") != 100)) throw new AssertionError();
        if ((Roman.romanToInt("D") != 500)) throw new AssertionError();
        if ((Roman.romanToInt("M") != 1000)) throw new AssertionError();

        /* Multiple Tokens */
        if ((Roman.romanToInt("XV") != 15)) throw new AssertionError();
        if ((Roman.romanToInt("MCMLIV") != 1954)) throw new AssertionError();
        if ((Roman.romanToInt("MMMDCX") != 3610)) throw new AssertionError();
        if ((Roman.romanToInt("XX") != 20)) throw new AssertionError();
        if ((Roman.romanToInt("MCMXC") != 1990)) throw new AssertionError();

        /* Invalid Tokens */
        if ((Roman.romanToInt("        VII") != 7)) throw new AssertionError();
        if ((Roman.romanToInt("Xliv") != 44)) throw new AssertionError();


        }
    }
