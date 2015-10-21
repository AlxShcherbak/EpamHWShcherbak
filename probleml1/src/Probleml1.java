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



}
