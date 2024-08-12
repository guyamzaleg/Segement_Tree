/**
 * This class represents a Minimum segment tree extends from SegmentTreeByArray
 * implementation using an array and provides methods to build, update, and query the tree.
 */
public class MinimumSegmentTreeByArray extends SegmentTreeByArray
{
    /**
     * constructor-calls the father's constructor.
     * @param arr the original array we will turn to the tree.
     */
    public  MinimumSegmentTreeByArray(int[] arr)
    {
        super(arr);
    }

    /**
     * execute the kind of calculations we want to do between the nodes.
     * @param left_son-the left element we want to compare
     * @param right_son-the right element we want to compare
     * @return the smaller value between both.
     */
    @Override
    public int Calculation(int left_son, int right_son)
    {
        return Math.min(left_son,right_son);
    }

    /**
     * Queries the Segment Tree for the Minimum value in the given range.
     * @param node-current node
     * @param start-The start index of the segment this node represent.
     * @param end-The end index of the segment this node represent.
     * @param left - Start index of the query range
     * @param right- End index of the query range
     * @return requested value in the query range
     */
    protected  int query(int node, int start, int end,int left, int right)
    {
        {
            //if the current node range is fully contained in the requested range-return the current value.
            if (left <= start && right >= end)
            {
                return tree[node];
            }
            else
            {
                //defying middle
                int mid = (start + end) / 2;
                //right<=mid -->requested range fully contained in the left son range
                //we will return a  recursive call to the function on the left child
                if(right<=mid)
                {
                    return query(2 * node + 1, start, mid, left, right);
                }
                //left>mid -->requested range fully contained in the right son range
                //we will return a  recursive call to the function on the right child
                if (left>mid)
                {
                    return query(2 * node + 2, mid + 1, end, left, right);
                }
                // reached here means requested range split between the right and left son range .
                // we will call recursively to the function on the right and left child and keep the values.
                // finally return the Minimum value between both results.
                else
                {
                    int left_split = query(2 * node + 1, start, mid, left, right);
                    int right_split = query(2 * node + 2, mid + 1, end, left, right);
                    return Math.min(left_split, right_split);
                }
            }
        }
    }


}
