/**
 * Created by AlxEx on 21.10.2015.
 */
public class Probleml1 {

    /**
     * counting number of bits in type Byte
     *
     * @return
     */
    public int countByte() {
        return counByte((byte) 1);
    }

    /**
     * recursive method of counting
     *
     * @param inputValue - 1
     * @return - number of bits in type Byte
     */
    private int counByte(byte inputValue) {
        inputValue = (byte) (inputValue << 1);
        if (inputValue < 0) {
            return 2;
        } else return counByte(inputValue) + 1;
    }

    public int countShort() {
        return counShort((short) 1);
    }

    private int counShort(short inputValue) {
        inputValue = (short) (inputValue << 1);
        if (inputValue < 0) {
            return 2;
        } else return counShort(inputValue) + 1;
    }

    public int countInt() {
        return counInt(1);
    }

    private int counInt(int inputValue) {
        inputValue = (int) (inputValue << 1);
        if (inputValue < 0) {
            return 2;
        } else return counInt(inputValue) + 1;
    }

    public int countLong() {
        return counLong(1l);
    }

    private int counLong(long inputValue) {

        inputValue = (long) (inputValue << 1);
        if (inputValue < 0) {
            return 2;
        } else return counLong(inputValue) + 1;
    }


    /**
     * @param bitPos     - position of bit
     * @param valueOfBit - value to that changed (value = 0/1)
     * @param value      - value that changed
     * @throws IllegalArgumentException
     */
    public int changeBitTo(int bitPos, int valueOfBit, int value) throws IllegalArgumentException {
        if (bitPos > 32 || bitPos <= 0) {
            throw new IllegalArgumentException("value of position bit to change not available");
        } else if (valueOfBit < 0 || valueOfBit > 1) {
            throw new IllegalArgumentException("value of bit to change not available");
        }

        // (1 << (bitPos - 1)) - mask to change bit
        if (valueOfBit == 0) {
            return value & ~(1 << (bitPos - 1));
        } else {
            return value | (1 << (bitPos - 1));
        }
    }

    public Integer karatsubaMultiplication(Integer inputValueFist, Integer inputValueSec) {
        if (inputValueFist < 10 || inputValueSec < 10) {
            return inputValueFist * inputValueSec;
        } else {
            int base = 10;
            int exp = Math.min((int) Math.log10(inputValueFist), (int) Math.log10(inputValueSec)),  // inpF = 56112, inpS = 126 -> exp = 2
                    basePowExp = (int) Math.pow(base, exp),     // exp = 2 -> basePowExp = 10^2 = 100
                    expBaseFirst = inputValueFist / basePowExp, // expBaseF = 561
                    expBaseSec = inputValueSec / basePowExp,    // expBaseS = 1
                    expResFirst = inputValueFist % basePowExp,  // expResF = 12
                    expRestSec = inputValueSec % basePowExp;    // expResS = 26
            int z2 = expBaseFirst * expBaseSec, // z2 = 561 * 1 = 561
                    z0 = karatsubaMultiplication(expResFirst, expRestSec),    // z0 = 12 * 26 = 312  !! recursive
                    z1 = karatsubaMultiplication(expBaseFirst + expResFirst, expBaseSec + expRestSec) -  z2 - z0; // z1 = 14598  !!recursive
            return (int) (z2 * Math.pow(10, 2 * exp) + z1 * Math.pow(10, exp) + z0);    // return inpF * inpS = 7070112
        }
    }


}
