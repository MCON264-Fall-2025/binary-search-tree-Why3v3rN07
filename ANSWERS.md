1. Why does inorder traversal of a BST return elements in sorted order?
> Because binary sorted trees are sorted, and inorder traversal gives you the elements in order. 

2. Give an example of an insertion order that produces a highly unbalanced BST.
What does the inorder traversal look like for that tree?
> 1 2 3 4 5 6 7 8 9   
> Inorder still goes in order

3. In your own words, explain the differences between:
   - Recursive vs iterative traversal
   - Depth-first vs breadth-first traversal
> Recursive uses recursion, treating each branch as a small tree and putting it on a stack, while iterative uses while 
loops to go all the way one way, then the other.  
> Depth first you go all the way down one path, then back up to the next; breadth first you one step down one path, 
then back up and one step down the other, then back to the first, keeping them even. 

4. When might you prefer a breadth-first traversal in a real application?
> I suppose if I were doing something like a family tree and wanted to see the nodes by generation?