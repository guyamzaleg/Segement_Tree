public class MaximumSegmentTreeByTree extends SegmentTreeByTree
{

    /**
     * constructor using the super method and calls father constructor- (SegmentTreeByTree)
     * @param arr: the tree will be build from this array
     */
    public MaximumSegmentTreeByTree(int[] arr)
    {
        super(arr);
    }

    /**
     *
     * calling queryRangeHelper function with the root .the func implements in the fathers class(SegmentTreeByTree)
     * @param left Start index of the query range
     * @param right End index of the query range
     * @return the max number in the query range.
     */
    @Override
    public int queryRange(int left, int right)
    {
       int Max= queryRangeHelper(root,left,right).getMax();
       return Max;
    }

    /**
     * prints the tree recursively and that is why we need helping function.
     * using the_tostring helping function.
     * @return  string that represents the max tree as requested.
     */
    @Override
    public String toString()
    {
        return " [" + the_tostring(this.root)+ " ] ";
    }

    /**
     * print the tree nodes recursively.
     * @param node-current node
     * @return string that represents the tree as requested.
     */
    public String the_tostring(SegmentTreeNode node)
    {
        if (node.isLeaf())
        {
            //stop condition-if we are in a leaf-print its value
            return " "+node.getMax();
        }
        //defining current nodes left and right son
        SegmentTreeNode right_son=(SegmentTreeNode)node.getRight();
        SegmentTreeNode left_son=(SegmentTreeNode)node.getLeft();
        //printing the current max and calling recursively with left son and right son
        return " "+node.getMax()+the_tostring(left_son)+the_tostring(right_son);
    }
}
