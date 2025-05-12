package kr.co.study;

public class Bytes {
    public static void main(String[] args) {
        byte[] input = new byte[]{0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x01, 0x00};
        long result = Bytes.toLong(input);
        System.out.println(result); // 출력: 256
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

    private static void checkArrayLengthIs8(byte[] bytes) {
        if (bytes.length != 8) {
            throw new IllegalArgumentException("배열의 크기가 8이어야 합니다.");
        }
    }
}
