public class MinimumSegmentTreeByTree extends SegmentTreeByTree
{
    public MinimumSegmentTreeByTree(int[] arr)
    {
        super(arr);
    }
    @Override
    public int queryRange(int left, int right)
    {
        int Min= queryRangeHelper(root,left,right).getMin();
        return Min;
    }

    /**
     * prints the tree recursivly and that is why we need helping function.
     * using the_tostring helping function.
     * @return  string that represents the min tree as requested.
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
            return " "+node.getMin();
        }
        //defining current nodes left and right son
        SegmentTreeNode right_son=(SegmentTreeNode)node.getRight();
        SegmentTreeNode left_son=(SegmentTreeNode)node.getLeft();
        //printing the current min and calling recursively with left son and right son
        return " "+node.getMin()+the_tostring(left_son)+the_tostring(right_son);
    }
}


