package ua.opnu;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        // ======== Проверка Logical operations ========
        System.out.println(icyHot(-5, 120));
        System.out.println(in1020(12, 99));
        System.out.println(hasTeen(13, 20, 10));

        // ======== Проверка Boolean expressions ========
        System.out.println(sleepIn(false, false));
        System.out.println(monkeyTrouble(true, true));
        System.out.println(posNeg(1, -1, false));

        // ======== Проверка Loops and Arrays ========
        int[] arr = {1, 9, 9, 3, 9};
        System.out.println(arrayCount9(arr));
        System.out.println(arrayFront9(arr));
        System.out.println(array123(new int[]{1, 2, 3, 4}));

        // ======== Проверка Strings ========
        System.out.println(helloName("Dasha"));
        System.out.println(lastTwo("coding"));
        System.out.println(middleTwo("string"));
    }

    // ======== Logical operations ========
    public static boolean icyHot(int temp1, int temp2) {
        return (temp1 < 0 && temp2 > 100) || (temp1 > 100 && temp2 < 0);
    }

    public static boolean in1020(int a, int b) {
        return (a >= 10 && a <= 20) || (b >= 10 && b <= 20);
    }

    public static boolean hasTeen(int a, int b, int c) {
        return (a >= 13 && a <= 19) || (b >= 13 && b <= 19) || (c >= 13 && c <= 19);
    }

    // ======== Boolean expressions =========
    public static boolean sleepIn(boolean weekday, boolean vacation) {
        return !weekday || vacation;
    }

    public static boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        return aSmile == bSmile;
    }

    public static boolean posNeg(int a, int b, boolean negative) {
        if (negative) {
            return a < 0 && b < 0;
        } else {
            return (a < 0 && b > 0) || (a > 0 && b < 0);
        }
    }

    // ======== Loops and Arrays ========
    public static int arrayCount9(int[] nums) {
        int count = 0;
        for (int num : nums) {
            if (num == 9) {
                count++;
            }
        }
        return count;
    }

    public static boolean arrayFront9(int[] nums) {
        int length = Math.min(nums.length, 4);
        for (int i = 0; i < length; i++) {
            if (nums[i] == 9) {
                return true;
            }
        }
        return false;
    }

    public static boolean array123(int[] nums) {
        for (int i = 0; i < nums.length - 2; i++) {
            if (nums[i] == 1 && nums[i + 1] == 2 && nums[i + 2] == 3) {
                return true;
            }
        }
        return false;
    }

    // ======== Strings ========
    public static String helloName(String name) {
        return "Hello " + name + "!";
    }

    public static String lastTwo(String str) {
        if (str.length() < 2) {
            return str;
        }
        return str.substring(0, str.length() - 2) +
                str.charAt(str.length() - 1) +
                str.charAt(str.length() - 2);
    }

    public static String middleTwo(String str) {
        int mid = str.length() / 2;
        return str.substring(mid - 1, mid + 1);
    }
}