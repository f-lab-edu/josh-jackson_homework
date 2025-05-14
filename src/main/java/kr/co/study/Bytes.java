package kr.co.study;

import java.util.Arrays;

public class Bytes {
    public static void main(String[] args) {
        // toLong
        byte[] input = new byte[]{0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00};
        long result = Bytes.toLong(input);
        System.out.println(result); // 출력: 256

        // toShort
        byte[] input2 = new byte[]{0x01, 0x02};
        short result2 = Bytes.toShort(input2);
        System.out.println(result2);

        // fromLong
        long value = 123456789L;
        byte[] result3 = Bytes.fromLong(value);
        System.out.println(Arrays.toString(result3));
        // 출력 : [0, 0, 0, 0, 7, 91, -51, 21]

    }

    private static byte[] fromLong(long value) {
        byte[] result = new byte[8];
        for (int i = 7; i >= 0; i--) {
            result[i] = (byte) (value & 0xFF);
            value >>= 8;
        }

        return result;
    }

    private static long toLong(byte[] bytes) {

        checkArrayLengthIs8(bytes);
        long result = 0;
        for (byte b : bytes) {
            result <<= 8;
            result |= (b & 0xFF);
        }
        return result;
    }

    private static short toShort(byte[] bytes) {
        checkArrayLengthIs2(bytes);
        int result = 0;
        for (byte b : bytes) {
            result <<= 8;
            result |= (b & 0xFF);
        }
        return (short) result;
    }

    private static void checkArrayLengthIs8(byte[] bytes) {
        if (bytes.length != 8) {
            throw new IllegalArgumentException("배열의 크기가 8이어야 합니다.");
        }
    }

    private static void checkArrayLengthIs2(byte[] bytes) {
        if (bytes.length != 2) {
            throw new IllegalArgumentException("배열의 크기가 2이어야 합니다.");
        }
    }
}
