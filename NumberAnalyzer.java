import java.util.Comparator;
import java.util.Iterator;


/**
 The NumberAnalyzer class provides an abstract implementation for analyzing a collection of integers.
 It implements the Iterable interface to allow for iteration over the collection, and the Comparator interface
 to provide a default comparison method for integers.
 */
public abstract class NumberAnalyzer implements Iterable<Integer>, Comparator<Integer> {

    protected Integer[] numbers;
    int next_index=0;

    /**
     * Constructs a new NumberAnalyzer object with the given array of integers.
     * @param numbers The array of integers to be analyzed.
     */
    public NumberAnalyzer(Integer[] numbers) {
        this.numbers = numbers;
    }

    /**
     * implement the iterator for the array
     * @return iterator implement the methods hasNext,next.
     */
    @Override
    public Iterator<Integer> iterator()
    {
        return new Iterator<Integer>()
        {
            @Override
            public boolean hasNext()
            {
                return next_index < numbers.length;
            }

            @Override
            public Integer next()
            {
                if(!hasNext()){return null;}
                else
                {
                    Integer ans = numbers[next_index];
                    next_index+=1;
                    return ans;
                }
            }
        };
    }

    /**
     * implements the comparator for the array
     * @param o1 the first object to be compared.
     * @param o2 the second object to be compared.
     * @return  1 - if the bigger object by requested compare is the first one
     *         -1 - if the second is bigger
     *          0 - if both equal
     */
    @Override
    public int compare(Integer o1, Integer o2)
    {
        //checking cases
        if(o1==o2){return 0;}
        if(o1%2==0)
        {
            if(o2%2!=0){return 1;}
            else if(o1>o2){return 1;}
            else return -1;
        }
        if(o2%2==0||o2>o1){return -1;}
        else return 1;

    }


    /**
     * Returns the maximum value in the given range. This is an abstract function to be implemented by the subclasses
     * @param left The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The maximum value in the range.
     */
    public abstract Integer getMax(int left, int right);

    /**
     * Returns the minimum value in the given range. This is an abstract function to be implemented by the subclasses
     * @param left The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The minimum value in the range.
     */
    public abstract Integer getMin(int left, int right);

    /**
     * Returns the sum of the values in the given range. This is an abstract function to be implemented by the subclasses
     * @param left The left endpoint of the range (inclusive).
     * @param right The right endpoint of the range (inclusive).
     * @return The sum of the values in the range.
     */
    public abstract Integer getSum(int left, int right);

    /**
     * Updates the value at the given index. This is an abstract function to be implemented by the subclasses
     * @param index The index of the value to be updated.
     * @param value The new value to be set at the given index.
     */
    public abstract void update(int index, int value);



}