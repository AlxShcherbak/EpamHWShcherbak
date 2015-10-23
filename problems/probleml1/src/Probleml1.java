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
        int sign = 1;
        if ((inputValueFist < 0 && inputValueSec > 0) || (inputValueSec < 0 && inputValueFist > 0)) {
            sign = -1;
        }

        int inpVF = Math.abs(inputValueFist.intValue()),
                inpVS = Math.abs(inputValueSec.intValue());

        /*
        if (inpVF < 10 || inpVS < 10) {
            return inpVF * inpVS;
        } else {
            int base = 10;
            int exp = Math.min((int) Math.log10(inpVF), (int) Math.log10(inpVS)),  // inpF = 56112, inpS = 126 -> exp = 2
                    basePowExp = (int) Math.pow(base, exp),     // exp = 2 -> basePowExp = 10^2 = 100
                    expBaseFirst = inpVF / basePowExp, // expBaseF = 561
                    expBaseSec = inpVS / basePowExp,    // expBaseS = 1
                    expResFirst = inpVF % basePowExp,  // expResF = 12
                    expRestSec = inpVS % basePowExp;    // expResS = 26
            int z2 = expBaseFirst * expBaseSec, // z2 = 561 * 1 = 561
                    z0 = karatsubaMultiplication(expResFirst, expRestSec),    // z0 = 12 * 26 = 312  !! recursive
                    z1 = karatsubaMultiplication(expBaseFirst + expResFirst, expBaseSec + expRestSec) - z2 - z0; // z1 = 14598  !!recursive
            return (int) (sign * (z2 * Math.pow(10, 2 * exp) + z1 * Math.pow(10, exp) + z0));    // return inpF * inpS = 7070112
         */


        if (inpVF < 16 || inpVS < 16) {
            return inpVF * inpVS;
        } else {
            int inpVFBin = inpVF,
                    inpVSBin = inpVS;
            int base = 16,
                    exp = 0;

            while (inpVFBin > 0 & inpVSBin > 0) {
                exp++;
                inpVFBin = inpVFBin >> 4;
                inpVSBin = inpVSBin >> 4;
            }
            exp--;

            int basePowExp = 1 << (exp * 4),
                    expBaseFirst = inpVF / basePowExp,
                    expBaseSec = inpVS / basePowExp,
                    expResFirst = inpVF % basePowExp,
                    expRestSec = inpVS % basePowExp;
            int z2 = expBaseFirst * expBaseSec,
                    z0 = karatsubaMultiplication(expResFirst, expRestSec),
                    z1 = karatsubaMultiplication(expBaseFirst + expResFirst, expBaseSec + expRestSec) - z2 - z0;
            return (int) (sign * (z2 * (1 << (exp * 4 * 2)) + z1 * (1 << (exp * 4)) + z0));
        }
    }


}
