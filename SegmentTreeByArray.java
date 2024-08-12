/**
 * This abstract class represents a segment tree implementation using an array
 * and provides methods to build, update, and query the tree.
 */
public abstract class SegmentTreeByArray implements SegmentTree {

    protected int[] tree;
    protected int size;

    /**
     * Constructor for initializing the segment tree with the given input array.
     * @param arr the input array
     */
    public SegmentTreeByArray(int[] arr)
    {
        this.size= arr.length;

        int power=(int)Math.ceil(Math.log(size)/Math.log(2));
        int tree_size=(2*(int)Math.pow(2,power))-1;
        this.tree=new int[tree_size];
        for (int i=0;i< tree.length;i++)
        {
            tree[i]=Integer.MIN_VALUE;
        }
        build(arr);

    }

    /**
     * Builds the segment tree from the input array.
     * @param arr the input array
     */
    @Override
    public void build(int[] arr)
    {
        the_build(arr,0,0, arr.length-1);
    }
    void the_build(int[] arr, int curr, int left, int right)
    {
        if(left == right)
        {
            tree[curr]=arr[left];
        }
        else
        {
            int mid = (left + right)/2;
            the_build(arr, 2*curr+1, left, mid);
            the_build(arr, 2*curr+2, mid+1, right);
            tree[curr]=Calculation(tree[2*curr+1],tree[2*curr+2]);
        }
    }

    /**
     * abstract method-used several times in this class
     * execute the kind of calculations we want to do between the nodes.
     * this method defying the difference between the different trees.
     * implement differently in each one of the subclasses.
     * @param left_son-the left element we want to compare
     * @param right_son-the right element we want to compare
     * @return the matching value between both(bigger,smaller,sum of both)-depends on the subclass.
     */
    public abstract int Calculation(int left_son,int right_son);
    /**
     * Updates the value at the specified index and updates the segment tree accordingly.
     * Uses the_update helping method for the recursive implement.
     * @param index the index of the element to update in the array
     * @param value the new value to replace the existing value
     */

    @Override
    public void update(int index, int value) {int updated=the_update(0,0,size-1,index,value);}

    /**
     * execute the Update of the value at the specified index.
     * Uses Calculation method.
     * @param curr-current node
     * @param start-The start index of the segment this node represent.
     * @param end-The end index of the segment this node represent.
     * @param index-requested index for insert
     * @param value-requested value for insert.
     * @return the updated value.
     */
    public int the_update(int curr,int start,int end,int index,int value)
    {
        if(start==index && end==index) //reached the requested leaf-update and return its value
        {
           tree[curr]=value;
           return tree[curr];
        }
        // define the middle and check conditions
        // if the requested index smaller or equals to middle - we need to go left(left sub array)
        // call recursively to the_update and update left son.
        //the right son stays unchanged.
        int mid=(start+end)/2;
        if(index<=mid)
        {
            int new_left=the_update(curr*2+1,start,mid,index,value);
            int right_son=tree[curr*2+2];
            tree[curr]=Calculation(new_left,right_son);
            return tree[curr];
        }
        // else: if the requested index bigger than middle - we need to go right(right sub array)
        // call recursively to the_update and update right son.
        //the left son stays unchanged.
        else
        {
            int new_right=the_update(curr*2+2,mid+1,end,index,value);
            int left_son=tree[curr*2+1];
            tree[curr]=Calculation(left_son,new_right);
            return tree[curr];
        }

    }
//
//
//    /**
//     * Queries the segment tree for a range of elements.
//     * Uses query function implements in each subclass
//     * @param left the left index of the range
//     * @param right the right index of the range
//     * @return the result of the query operation
//     */
    @Override
    public int queryRange(int left, int right)
    {
        int ans=query(0,0,size-1,left,right);
        return ans;
    }

//    /**
//     * Abstract method for query operation, to be implemented by subclasses.
//     * @param node the current node
//     * @param start the start index
//     * @param end the end index
//     * @param left the left index
//     * @param right the right index
//     * @return the result of the query operation
//     */
    protected abstract int query(int node, int start, int end, int left, int right);
//
//
//    /**
//     * The members inside the array representing the segment tree are printed according to their indexes in the array.
//     * When the members are surrounded by "[ ]" and exactly one space between each number and between the brackets.
//     * For example, for the tree [10,4,6,1,3,2,4] " [ 10 4 6 1 3 2 4 ] " will be returned
//     */
    @Override
    public String toString()
    {
        String S1=" [";
        for (int i=0;i< tree.length;i++)
        {
            if (tree[i]==Integer.MIN_VALUE){S1=S1+" -";}
            else{S1+=" "+tree[i];}
        }
        return S1+" ] ";
    }

//    /**
//     * Returns the number of elements in the original array that the segment tree was built from.
//     * @return the size of the original array
//     */
    @Override
    public int size() {return this.size;}
}