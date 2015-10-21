import static org.junit.Assert.*;

/**
 * Created by AlxEx on 21.10.2015.
 */
public class Probleml1Test {

    @org.junit.Test
    public void testCountByte() throws Exception {
        int counbByte = new Probleml1().countByte();
        assertEquals(8, counbByte);
    }

    @org.junit.Test
    public void testCountShort() throws Exception {
        int counbShort = new Probleml1().countShort();
        assertEquals(16, counbShort);
    }

    @org.junit.Test
    public void testCountInt() throws Exception {
        int counbInt = new Probleml1().countInt();
        assertEquals(32, counbInt);
    }

    @org.junit.Test
    public void testCountLong() throws Exception {
        int counbLong = new Probleml1().countLong();
        assertEquals(64, counbLong);
    }

    @org.junit.Test
    public void testChangeBitTo() throws Exception {
        int intValue = 120;                                          // 120 = 0b1111000

        assertEquals(Integer.toBinaryString(new Probleml1().changeBitTo(5, 0, intValue)), "1101000"); // 0b1101000
        assertEquals(Integer.toBinaryString(new Probleml1().changeBitTo(5, 1, intValue)), "1111000"); // 0b1111000
    }
}