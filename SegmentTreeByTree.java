/**
 * An abstract base class for a segment tree data structure implemented using a tree structure.
 * Subclasses must implement the {@code queryRange} method to provide specific range query functionality.
 */
public abstract class SegmentTreeByTree implements SegmentTree
{

    protected SegmentTreeNode root;
    protected int size;

    /**
     * Constructor for creating a Segment Tree from an input array
     * @param arr Input array for which Segment Tree needs to be constructed
     */
    public SegmentTreeByTree(int[] arr)
    {
        build(arr);
    }

    /**
     * Builds the segment tree from the given array of integers.
     * we need a recursive solution ,returning a Tree node-so we will use a helping function called the_build.
     * @param arr the array of integers to build the segment tree from
     */
    public void build(int[] arr)
    {
        this.root=the_build(arr, 0, arr.length-1);
        this.size= arr.length;
    }

    /**
     * building the tree using recursive calls and creating Segment tree nodes.
     * @param arr:the array we need to make the tree from
     * @param first: the first index in the array
     * @param last: the last index in the array
     * @return the root with updated children.
     */
    public SegmentTreeNode the_build(int[] arr,int first,int last)
    {
        int middle;
        if(first==last)
        {
            //we need to represent a leaf
            return new SegmentTreeNode(first,first,arr[first],arr[first],arr[first],null,null);
        }
        else
        {
            //defining the middle and call recursively twice to the_build
            // once for the left chunk of the array
            //second for the right chunk of the array
            middle=(first+last)/2;
            SegmentTreeNode leftSon=the_build(arr,first,middle);//creating the left son
            SegmentTreeNode rightSon=the_build(arr,middle+1,last);//creating the right son
            //calculating the current values of the new node
            int current_min= Math.min(leftSon.getMin(),rightSon.getMin());//calculate min using Math library
            int current_max= Math.max(leftSon.getMax(),rightSon.getMax());//calculate max using Math library
            int current_sum= leftSon.getSum()+ rightSon.getSum();//calculate sum of both sons
            //creating the new node with the current values
            return new SegmentTreeNode(first,last,current_min,current_max,current_sum,leftSon,rightSon);
        }
    }

    /**
     * Updates the element at the specified index in the original array and updates the segment tree accordingly.
     * using helping function-the_update
     * @param index the index of the element to update
     * @param value the new value of the element at the specified index
     */
    @Override
    public void update(int index, int value)
    {
        this.root=the_update(this.root,index,value);
    }

    /**
     * this recursive function find the course to the requested index,and do every necessary change in the values of the nodes in the course as well.
     * @param node-the current node on the way to the requested leaf.
     * @param index-the requested index we want to change.
     * @param value-the requested value we will change to.
     * @return finally the root with updated tree.
     */
    public SegmentTreeNode the_update(SegmentTreeNode node,int index,int value)
    {
        int start=node.getStart();
        int end=node.getEnd();
        int mid=(start+end)/2;
        if (node.isLeaf())
        {
            //reached to the requested leaf
            // update the values and return the updated leaf.
            node.setMax(value);
            node.setMin(value);
            node.setSum(value);
            return node;
        }
        else
        {
            if (index<=mid)
            {
                //we need the left child - which means we are going left
                // we will call recursively to the left child and compare its values to the right children
                // right child values stays without changing,and update values as well.
                SegmentTreeNode new_left_child=the_update((SegmentTreeNode)node.getLeft(),index,value);
                SegmentTreeNode right_son=(SegmentTreeNode)node.getRight();
                node.setMax(Math.max(new_left_child.getMax(),right_son.getMax()));
                node.setMin(Math.min(new_left_child.getMin(),right_son.getMin()));
                node.setSum(new_left_child.getSum()+right_son.getSum());
                return node;
            }
            else
            {
                //we need the right child - which means we are going right
                // we will call recursively to the right child and compare its values to the left children
                // left child values stays without changing,and update values as well.
                SegmentTreeNode new_right_child=the_update((SegmentTreeNode)node.getRight(),index,value);
                SegmentTreeNode left_son=(SegmentTreeNode)node.getLeft();
                node.setMax(Math.max(new_right_child.getMax(),left_son.getMax()));
                node.setMin(Math.min(new_right_child.getMin(),left_son.getMin()));
                node.setSum(new_right_child.getSum()+ left_son.getSum());
                return node;
            }
        }
    }

    /**
     * Returns the number of elements in the original array that the segment tree was built from.
     * @return the size of the original array
     */
    @Override
    public int size()
    {
        return this.size;
    }

    /**
     * Queries the Segment Tree for the requested value in the given range. to be implemented by subclasses.
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return requested value in the given range
     */
    @Override
    public abstract int queryRange(int left, int right);

    /**
     * Helper method for querying the Segment Tree 
     * @param node Current node of the Segment Tree
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return A SegmentTreeNode that contains the minimum, maximum and sum values for the given range
     */
    protected SegmentTreeNode queryRangeHelper(SegmentTreeNode node, int left, int right)
    {
        if (node.getStart() >= left && right >= node.getEnd())
        {
            //if the current node range is fully contained in the requested range
            return node;
        }
        else
        {
            int mid = (node.getStart() + node.getEnd()) / 2;
            if (right <= mid)
            {
                //we will call recursively on the left child
                return queryRangeHelper((SegmentTreeNode) node.leftChild, left, right);
            }
            else
                if (left > mid)
            {
                //we will call recursively on the right child
                return queryRangeHelper((SegmentTreeNode) node.rightChild, left, right);
            }
            else
            {   //current node contains only part of the requested range-split the route to 2 recursive calls
                SegmentTreeNode left_result = queryRangeHelper((SegmentTreeNode) node.leftChild, left, mid);
                SegmentTreeNode right_result = queryRangeHelper((SegmentTreeNode) node.rightChild, mid + 1, right);
                int current_min = Math.min(left_result.getMin(), right_result.getMin());
                int current_max = Math.max(left_result.getMax(), right_result.getMax());
                int current_sum = left_result.getSum() + right_result.getSum();

                return new SegmentTreeNode(left, right, current_min, current_max, current_sum, left_result, right_result);
            }
        }
    }
}
