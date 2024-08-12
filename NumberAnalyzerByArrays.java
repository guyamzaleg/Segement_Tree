import java.util.Iterator;

public class NumberAnalyzerByArrays extends NumberAnalyzer
{
    //defying the class trees and array
    private int[] numbers_as_int;
    SummationSegmentTreeByArray Sum_STBA;
    MaximumSegmentTreeByArray Max_STBA;
    MinimumSegmentTreeByArray Min_STBA;

    /**
     * constructor for the class-uses fathers constructor by the method super.
     * @param numbers-inserted array.
     */
    public NumberAnalyzerByArrays(Integer[] numbers)
    {
        super(numbers);
        //Our trees need to recieve array of int -so we will create one we can work with
        this.numbers_as_int=new int[numbers.length];
        for (int i=0;i< numbers.length;i++) {numbers_as_int[i]=numbers[i].intValue();}
        //defying and creating the trees-one for each kind of use.
        this.Sum_STBA=new SummationSegmentTreeByArray(numbers_as_int);
        this.Max_STBA=new MaximumSegmentTreeByArray(numbers_as_int);
        this.Min_STBA=new MinimumSegmentTreeByArray(numbers_as_int);
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
        //uses queryrange method implements in MaximumSegmentTreeByArray.
        return (Integer) Max_STBA.queryRange(left,right);
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
        //uses queryrange method implements in MinimumSegmentTreeByArray.
        return (Integer) Min_STBA.queryRange(left,right);
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
        //uses queryrange method implements in the SummationSegmentTreeByArray.
        return (Integer) Sum_STBA.queryRange(left,right);
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
        //updating the trees using update method implement in the SegmentTreeByArray
        this.Sum_STBA.update(index,value);
        this.Max_STBA.update(index,value);
        this.Min_STBA.update(index,value);
    }

}
