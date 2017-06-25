class PreorderTraversal
{

  static void path(BinaryTree root)
  {

    if(root != null)
    {
      System.out.print(" " + root.data);
      path(root.left);
      path(root.right);
    }
  }
  public static void main(String[] args){

   BinaryTree testTree=new BinaryTree("A");
   testTree.left = new BinaryTree("B");
   testTree.right = new BinaryTree("C");
   testTree.left.right = new BinaryTree("D");
   testTree.right.left = new BinaryTree("E");
   testTree.left.right.left = new BinaryTree("F");
   testTree.right.left.right = new BinaryTree("G");

   PreorderTraversal.path(testTree);

  }

}
