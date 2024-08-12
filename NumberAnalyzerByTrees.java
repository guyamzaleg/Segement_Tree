
import java.util.Iterator;

public class NumberAnalyzerByTrees extends NumberAnalyzer
{
    //defying the class trees and array
    private int[] numbers_as_int;
    SummationSegmentTreeByTree Sum_STBT;
    MaximumSegmentTreeByTree Max_STBT;
    MinimumSegmentTreeByTree Min_STBT;

    /**
     * constructor for the class-uses fathers constructor by the method super.
     * @param numbers-inserted array.
     */
    public NumberAnalyzerByTrees(Integer[] numbers)
    {
        super(numbers);
        //Our trees need to recieve array of int -so we will create one we can work with
        this.numbers_as_int=new int[numbers.length];
        for (int i=0;i< numbers.length;i++) {numbers_as_int[i]=numbers[i].intValue();}
        //defying and creating the trees-one for each kind of use.
        this.Sum_STBT=new SummationSegmentTreeByTree(numbers_as_int);
        this.Max_STBT=new MaximumSegmentTreeByTree(numbers_as_int);
        this.Min_STBT=new MinimumSegmentTreeByTree(numbers_as_int);

    }

    /**
     * Returns the maximum value in the given range.
     * @param left The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The maximum value in the range.
     */
    @Override
    public Integer  getMax(int left, int right)
    {
        //uses queryrange method implements in MaximumSegmentTreeByTree.
        return (Integer) Max_STBT.queryRange(left,right);
    }

    /**
     * Returns the minimum value in the given range.
     * @param left The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The minimum value in the range.
     */
    @Override
    public  Integer getMin(int left, int right)
    {
        //uses queryrange method implements in MinimumSegmentTreeByTree.
        return (Integer) Min_STBT.queryRange(left,right);
    }

    /**
     * Returns the sum of the values in the given range.
     * @param left The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The sum of the values in the range.
     */
    @Override
    public  Integer getSum(int left, int right)
    {
        //uses queryrange method implements in SummationSegmentTreeByTree.
        return (Integer) Sum_STBT.queryRange(left,right);
    }

    /**
     * Updates the value at the given index.
     * @param index The index of the value to be updated.
     * @param value The new value to be set at the given index.
     */
    @Override
    public  void update(int index, int value)
    {
        //updating the class arrays.
        this.numbers[index]=Integer.valueOf(value);
        this.numbers_as_int[index]=value;
        //updating the trees using update method implement in the SegmentTreeByTree
        this.Sum_STBT.update(index,value);
        this.Max_STBT.update(index,value);
        this.Min_STBT.update(index,value);
    }
}
