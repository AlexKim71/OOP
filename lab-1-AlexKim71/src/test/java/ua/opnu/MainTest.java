package ua.opnu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class MainTest {

    // Тести для логічних операцій
    @ParameterizedTest
    @MethodSource("icyHotProvider")
    void icyHotTest(int first, int second, boolean expected) {
        assertEquals(expected, Main.icyHot(first, second));
    }

    static Stream<Arguments> icyHotProvider() {
        return Stream.of(
                arguments(120, -1, true),
                arguments(-1, 120, true),
                arguments(2, 120, false),
                arguments(-1, 100, false));
    }

    @ParameterizedTest
    @MethodSource("in1020Provider")
    void in1020Test(int first, int second, boolean expected) {
        assertEquals(expected, Main.in1020(first, second));
    }

    static Stream<Arguments> in1020Provider() {
        return Stream.of(
                arguments(12, 99, true),
                arguments(21, 12, true),
                arguments(8, 99, false),
                arguments(21, 21, false));
    }

    @ParameterizedTest
    @MethodSource("hasTeenProvider")
    void hasTeenTest(int a, int b, int c, boolean expected) {
        assertEquals(expected, Main.hasTeen(a, b, c));
    }

    static Stream<Arguments> hasTeenProvider() {
        return Stream.of(
                arguments(13, 20, 10, true),
                arguments(20, 19, 10, true),
                arguments(20, 10, 13, true),
                arguments(1, 20, 12, false));
    }

    // Тести для булевих виразів
    @ParameterizedTest
    @MethodSource("sleepInProvider")
    void sleepInTest(boolean weekday, boolean vacation, boolean expected) {
        assertEquals(expected, Main.sleepIn(weekday, vacation));
    }

    static Stream<Arguments> sleepInProvider() {
        return Stream.of(
                arguments(false, false, true),
                arguments(true, false, false),
                arguments(false, true, true),
                arguments(true, true, true));
    }

    @ParameterizedTest
    @MethodSource("monkeyTroubleProvider")
    void monkeyTroubleTest(boolean aSmile, boolean bSmile, boolean expected) {
        assertEquals(expected, Main.monkeyTrouble(aSmile, bSmile));
    }

    static Stream<Arguments> monkeyTroubleProvider() {
        return Stream.of(
                arguments(true, true, true),
                arguments(false, false, true),
                arguments(true, false, false),
                arguments(false, true, false));
    }

    @ParameterizedTest
    @MethodSource("posNegProvider")
    void posNegTest(int a, int b, boolean negative, boolean expected) {
        assertEquals(expected, Main.posNeg(a, b, negative));
    }

    static Stream<Arguments> posNegProvider() {
        return Stream.of(
                arguments(1, -1, false, true),
                arguments(-1, 1, false, true),
                arguments(-4, -5, true, true),
                arguments(-4, 5, false, true));
    }

    // Тести для циклів та масивів
    @ParameterizedTest
    @MethodSource("arrayCount9Provider")
    void arrayCount9Test(int[] nums, int expected) {
        assertEquals(expected, Main.arrayCount9(nums));
    }

    static Stream<Arguments> arrayCount9Provider() {
        return Stream.of(
                arguments(new int[]{1, 2, 9}, 1),
                arguments(new int[]{1, 9, 9}, 2),
                arguments(new int[]{1, 2, 3}, 0),
                arguments(new int[]{}, 0));
    }

    @ParameterizedTest
    @MethodSource("arrayFront9Provider")
    void arrayFront9Test(int[] nums, boolean expected) {
        assertEquals(expected, Main.arrayFront9(nums));
    }

    static Stream<Arguments> arrayFront9Provider() {
        return Stream.of(
                arguments(new int[]{1, 2, 9, 3, 4}, true),
                arguments(new int[]{1, 2, 3, 4, 9}, false),
                arguments(new int[]{9, 2, 3}, true),
                arguments(new int[]{1, 2, 3}, false));
    }

    @ParameterizedTest
    @MethodSource("array123Provider")
    void array123Test(int[] nums, boolean expected) {
        assertEquals(expected, Main.array123(nums));
    }

    static Stream<Arguments> array123Provider() {
        return Stream.of(
                arguments(new int[]{1, 1, 2, 3, 1}, true),
                arguments(new int[]{1, 1, 2, 4, 1}, false),
                arguments(new int[]{1, 2, 3, 1, 2, 3}, true),
                arguments(new int[]{1, 2}, false));
    }

    // Тести для рядків
    @ParameterizedTest
    @MethodSource("helloNameProvider")
    void helloNameTest(String name, String expected) {
        assertEquals(expected, Main.helloName(name));
    }

    static Stream<Arguments> helloNameProvider() {
        return Stream.of(
                arguments("Bob", "Hello Bob!"),
                arguments("Alice", "Hello Alice!"),
                arguments("X", "Hello X!"));
    }

    @ParameterizedTest
    @MethodSource("lastTwoProvider")
    void lastTwoTest(String str, String expected) {
        assertEquals(expected, Main.lastTwo(str));
    }

    static Stream<Arguments> lastTwoProvider() {
        return Stream.of(
                arguments("coding", "codign"),
                arguments("cat", "cta"),
                arguments("ab", "ba"),
                arguments("a", "a"),
                arguments("", ""));
    }

    @ParameterizedTest
    @MethodSource("middleTwoProvider")
    void middleTwoTest(String str, String expected) {
        assertEquals(expected, Main.middleTwo(str));
    }

    static Stream<Arguments> middleTwoProvider() {
        return Stream.of(
                arguments("string", "ri"),
                arguments("code", "od"),
                arguments("Practice", "ct"),
                arguments("ab", "ab"));
    }
}