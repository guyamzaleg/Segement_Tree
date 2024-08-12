/**
 * This is a testing framework. Use it extensively to verify that your code is working
 * properly.
 */

public class Tester {

    private static boolean testPassed = true;
    private static int testNum = 0;

    /**
     * This entry function will test all classes created in this assignment.
     *
     * @param args command line arguments
     */

    public static void main(String[] args) {
        //
        /* TODO - write a function for each class separately */
        // Each function here should test a different class. you should test here every class you created.


        //SegmentTrees
        testMaximumSegmentTreeByTree();testMinimumSegmentTreeByTree();testSummationSegmentTreeByTree();
        testMaximumSegmentTreeByArray();testMinimumSegmentTreeByArray();testSummationSegmentTreeByArray();
        //NumberAnalyzers
        testNumberAnalyzerByTrees();
        testNumberAnalyzerByArrays();


        // Notifying the user that the code have passed all tests.
        if (testPassed)
        {
            System.out.println("All " + testNum + " tests passed!");
        }
    }

    /**
     * This utility function will count the number of times it was invoked.
     * In addition, if a test fails the function will print the error message.
     *
     * @param exp The actual test condition
     * @param msg An error message, will be printed to the screen in case the test fails.
     */
    private static void test(boolean exp, String msg) {
        testNum++;

        if (!exp) {
            testPassed = false;
            System.out.println("Test " + testNum + " failed: " + msg);
        }
    }


    //-----------------------SegmentTreeByTrees----------------------//

    /**
     * Checks the MaximumSegmentTreeByTree class.
     */
    private static void testMaximumSegmentTreeByTree()
    {
        //first array
        MaximumSegmentTreeByTree Maxstbt = new MaximumSegmentTreeByTree(new int[]{10, 15, 55, 15, 9, 12});
        //to string
        test(Maxstbt.toString().equals(" [ 55 55 15 10 15 55 15 15 15 9 12 ] "), "The toString of {10,15,55,15,9,12} should be ' [ 55 55 15 10 15 55 15 15 15 12 9 12 ] ' got: '" + Maxstbt.toString() + " '");
        //query range
        test(Maxstbt.queryRange(0, 1) == 15, "The max of {10,15,55,15,9,12} between indexes [0:1] should be 15");
        //update
        Maxstbt.update(0, 80);
        test(Maxstbt.queryRange(0, 3) == 80, "After update index 0 from {10,15,55,15,9,12} to 80, the max between indexes [0:3] should be 80");

        //second array
        MaximumSegmentTreeByTree Maxstbt2 = new MaximumSegmentTreeByTree(new int[]{6,4,2,1});
        //to string
        test(Maxstbt2.toString().equals(" [ 6 6 6 4 2 2 1 ] "), "The toString of {6,4,2,1} should be ' [ 6 6 6 4 2 2 1 ] ' got: '" + Maxstbt2.toString() + " '");
        //query range
        test(Maxstbt2.queryRange(1, 2) == 4, "The max of {6,4,2,1} between indexes [1:2] should be 4");
        //update
        Maxstbt2.update(2, 80);
        test(Maxstbt2.queryRange(0, 3) == 80, "After update index 2 from {6,4,2,1} to 80, the max between indexes [0:3] should be 80");

    }

    /**
     * Checks the MinimumSegmentTreeByTree class.
     */
    private static void testMinimumSegmentTreeByTree()
    {
        //first array
        MinimumSegmentTreeByTree Minstbt = new MinimumSegmentTreeByTree(new int[]{10, 15, 55, 15, 9, 12});
        //to string
        test(Minstbt.toString().equals(" [ 9 10 10 10 15 55 9 9 15 9 12 ] "), "The toString of {10,15,55,15,9,12} should be ' [ 9 10 10 10 15 55 9 9 15 9 12 ]  ' got: '" + Minstbt.toString() + " '");
        //query range
        test(Minstbt.queryRange(1, 3) == 15, "The min of {10,15,55,15,9,12} between indexes [1:3] should be 15");
        //update
        Minstbt.update(5, 80);
        test(Minstbt.queryRange(2, 5) == 9, "After update index 5 from {10,15,55,15,9,12} to 80, the min between indexes [2:5] should be 9");

        //second array
        MinimumSegmentTreeByTree Minstbt2 = new MinimumSegmentTreeByTree(new int[]{6,4,2,1});
        //to string
        test(Minstbt2.toString().equals(" [ 1 4 6 4 1 2 1 ] "), "The toString of {6,4,2,1} should be ' [ 1 4 6 4 1 2 1 ] ' got: '" + Minstbt2.toString() + " '");
        //query range
        test(Minstbt2.queryRange(1, 3) == 1, "The min of {6,4,2,1} between indexes [1:3] should be 1");
        //update
        Minstbt2.update(2, 0);
        test(Minstbt2.queryRange(0, 3) == 0, "After update index 2 from {6,4,2,1} to 0, the min between indexes [0:3] should be 0");
    }

    /**
     * Checks the SummationSegmentTreeByTree class.
     */
    private static void testSummationSegmentTreeByTree()
    {
        //first array
        SummationSegmentTreeByTree Sumstbt = new SummationSegmentTreeByTree(new int[]{10, 15, 55, 15, 9, 12});
        //to string
        test(Sumstbt.toString().equals(" [ 116 80 25 10 15 55 36 24 15 9 12 ] "), "The toString of {10,15,55,15,9,12} should be ' [ 116 80 25 10 15 55 36 24 15 9 12 ]  ' got: '" + Sumstbt.toString() + " '");
        //query range
        test(Sumstbt.queryRange(1, 3) == 85, "The sum of {10,15,55,15,9,12} between indexes [1:3] should be 85");
        //update
        Sumstbt.update(4, 90);
        test(Sumstbt.queryRange(2, 5) == 172, "After update index 4 from {10,15,55,15,9,12} to 90, the sum between indexes [2:5] should be 172");
//
        //second array
        SummationSegmentTreeByTree Sumstbt2 = new SummationSegmentTreeByTree(new int[]{6,4,2,1});
        //to string
        test(Sumstbt2.toString().equals(" [ 13 10 6 4 3 2 1 ] "), "The toString of {6,4,2,1} should be ' [ 13 10 6 4 3 2 1 ] ' got: '" + Sumstbt2.toString() + " '");
        //query range
        test(Sumstbt2.queryRange(1, 3) == 7, "The sum of {6,4,2,1} between indexes [1:3] should be 7");
        //update
        Sumstbt2.update(2, 34);
        test(Sumstbt2.queryRange(0, 3) == 45, "After update index 2 from {6,4,2,1} to 34, the sum between indexes [0:3] should be 45");

    }

    //-----------------------SegmentTreeByArrays----------------------//

    /**
     * Checks the MaximumSegmentTreeByArray class.
     */
    private static void testMaximumSegmentTreeByArray()
    {
        //first array
        MaximumSegmentTreeByArray Maxstba = new MaximumSegmentTreeByArray(new int[]{10, 15, 55, 15, 9, 12});
        //to string
        test(Maxstba.toString().equals(" [ 55 55 15 15 55 15 12 10 15 - - 15 9 - - ] "), "The toString of {10,15,55,15,9,12} should be ' [ 55 55 15 15 55 15 12 10 15 - - 15 9 - - ] ' got: '" + Maxstba.toString() + " '");
        //query range
        test(Maxstba.queryRange(0, 1) == 15, "The max of {10,15,55,15,9,12} between indexes [0:1] should be 15");
        //update
        Maxstba.update(0, 80);
        test(Maxstba.queryRange(0, 3) == 80, "After update index 0 from {10,15,55,15,9,12} to 80, the max between indexes [0:3] should be 80");

        //second array
        MaximumSegmentTreeByArray Maxstba2 = new MaximumSegmentTreeByArray(new int[]{6,4,2,1});
        //to string
        test(Maxstba2.toString().equals(" [ 6 6 2 6 4 2 1 ] "), "The toString of {6,4,2,1} should be ' [ 6 6 2 6 4 2 1 ] ' got: '" + Maxstba2.toString() + " '");
        //query range
        test(Maxstba2.queryRange(1, 2) == 4, "The max of {6,4,2,1} between indexes [1:2] should be 4");
        //update
        Maxstba2.update(2, 80);
        test(Maxstba2.queryRange(0, 3) == 80, "After update index 2 from {6,4,2,1} to 80, the max between indexes [0:3] should be 80");

    }

    /**
     * Checks the MinimumSegmentTreeByArray class.
     */
    private static void testMinimumSegmentTreeByArray()
    {
        //first array
        MinimumSegmentTreeByArray Minstba = new MinimumSegmentTreeByArray(new int[]{10, 15, 55, 15, 9, 12});
        //to string
        test(Minstba.toString().equals(" [ 9 10 9 10 55 9 12 10 15 - - 15 9 - - ] "), "The toString of {10,15,55,15,9,12} should be ' [ 9 10 9 10 55 9 12 10 15 - - 15 9 - - ]  ' got: '" + Minstba.toString() + " '");
        //query range
        test(Minstba.queryRange(1, 3) == 15, "The min of {10,15,55,15,9,12} between indexes [1:3] should be 15");
        //update
        Minstba.update(5, 80);
        test(Minstba.queryRange(2, 5) == 9, "After update index 5 from {10,15,55,15,9,12} to 80, the min between indexes [2:5] should be 9");

        //second array
        MinimumSegmentTreeByArray Minstba2 = new MinimumSegmentTreeByArray(new int[]{6,4,2,1});
        //to string
        test(Minstba2.toString().equals(" [ 1 4 1 6 4 2 1 ] "), "The toString of {6,4,2,1} should be ' [ 1 4 1 6 4 2 1 ] ' got: '" + Minstba2.toString() + " '");
        //query range
        test(Minstba2.queryRange(1, 3) == 1, "The min of {6,4,2,1} between indexes [1:3] should be 1");
        //update
        Minstba2.update(2, 0);
        test(Minstba2.queryRange(0, 3) == 0, "After update index 2 from {6,4,2,1} to 0, the min between indexes [0:3] should be 0");
    }

    /**
     * Checks the SummationSegmentTreeByArray class.
     */
    private static void testSummationSegmentTreeByArray()
    {
        //first array
        SummationSegmentTreeByArray Sumstba = new SummationSegmentTreeByArray(new int[]{10, 15, 55, 15, 9, 12});
        //to string
        test(Sumstba.toString().equals(" [ 116 80 36 25 55 24 12 10 15 - - 15 9 - - ] "), "The toString of {10,15,55,15,9,12} should be ' [ 116 80 36 25 55 24 12 10 15 - - 15 9 - - ]  ' got: '" + Sumstba.toString() + " '");
        //query range
        test(Sumstba.queryRange(1, 3) == 85, "The sum of {10,15,55,15,9,12} between indexes [1:3] should be 85");
        //update
        Sumstba.update(4, 90);
        test(Sumstba.queryRange(2, 5) == 172, "After update index 4 from {10,15,55,15,9,12} to 90, the sum between indexes [2:5] should be 172");

        //second array
        SummationSegmentTreeByArray Sumstba2 = new SummationSegmentTreeByArray(new int[]{6,4,2,1});
        //to string
        test(Sumstba2.toString().equals(" [ 13 10 3 6 4 2 1 ] "), "The toString of {6,4,2,1} should be ' [ 13 10 3 6 4 2 1 ] ' got: '" + Sumstba2.toString() + " '");
        //query range
        test(Sumstba2.queryRange(1, 3) == 7, "The sum of {6,4,2,1} between indexes [1:3] should be 7");
        //update
        Sumstba2.update(2, 34);
        test(Sumstba2.queryRange(0, 3) == 45, "After update index 2 from {6,4,2,1} to 34, the sum between indexes [0:3] should be 45");
    }

    /**
     * Checks the NumberAnalyzerByTrees class and the comparing.
     */
    private static void testNumberAnalyzerByTrees() {

        Integer[] arr = {10,30,50};
        NumberAnalyzerByTrees nabt = new NumberAnalyzerByTrees(arr);

        //Trees Analyzer
        test(nabt.getMax(0,1) == 30, "The max of {10,30,50} between indexes [0:1] should be 30");
        test(nabt.getMin(0,1) == 10, "The min of {10,30,50} between indexes [0:1] should be 10");
        test(nabt.getSum(0,1) == 40, "The sum of {10,30,50} between indexes [0:1] should be 40");
        //updating Trees Analyzer
        nabt.update(1,100);
        test(nabt.getMax(0,1) == 100, "The max of {10,30,50} between indexes [0:1] after update should be 100");
        test(nabt.getMin(1,2) == 50, "The min of {10,30,50} between indexes [1:2] after update should be 50");
        test(nabt.getSum(0,2) == 160, "The sum of {10,30,50} between indexes [0:1] after update should be 160");

        //compare method
        test(nabt.compare(3,7) == -1, "The compare result between 3,7 should be: -1");
        test(nabt.compare(8,2) == 1, "The compare result between 8,2 should be: 1");
        test(nabt.compare(4,4) == 0, "The compare result between 4,4 should be: 0");
    }

    //    /**
//     * Checks the NumberAnalyzerByArrays class and the comparing.
//     */
    private static void testNumberAnalyzerByArrays()
    {
        Integer[] arr = {10,30,50};
        NumberAnalyzerByArrays naba = new NumberAnalyzerByArrays(arr);
        //Arrays Analyzer
        test(naba.getMax(0,1) == 30, "The max of {10,30,50} between indexes [0:1] should be 30");
        test(naba.getMin(0,1) == 10, "The min of {10,30,50} between indexes [0:1] should be 10");
        test(naba.getSum(0,1) == 40, "The sum of {10,30,50} between indexes [0:1] should be 40");


        //updating Arrays Analyzer
        naba.update(2,0);
        test(naba.getMax(0,1) == 30, "The max of {10,30,0} between indexes [0:1] after update should be 30");
        test(naba.getMin(1,2) == 0, "The min of {10,30,0} between indexes after update [1:2] should be 0");
        test(naba.getSum(0,2) == 40, "The sum of {10,30,0} between indexes [0:2] after update should be 40");

        //compare method
        test(naba.compare(29,92) == -1, "The compare result between 29,92 should be: -1");
        test(naba.compare(18,10) == 1, "The compare result between 18,10 should be: 1");
        test(naba.compare(9,9) == 0, "The compare result between 9,9 should be: 0");


        //55 tests for Good luck.
        test(0==0,"always true - 55 is a number of good luck");


    }
}
