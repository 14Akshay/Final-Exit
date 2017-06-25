class SizeOfTree //number of nodes in tree
{

  static int findSize(BinaryTree root)
  {
    if(root==null)
      return 0;
    return 1 + findSize(root.left) + findSize(root.right);
  }
  public static void main(String[] args){

   BinaryTree testTree=new BinaryTree(1);
   testTree.left = new BinaryTree(2);
   testTree.right = new BinaryTree(3);
   testTree.left.left = new BinaryTree(4);
   testTree.left.right = new BinaryTree(5);
   testTree.right.left = new BinaryTree(6);
   testTree.right.right = new BinaryTree(7);

   System.out.println(SizeOfTree.findSize(testTree));

  }
}
