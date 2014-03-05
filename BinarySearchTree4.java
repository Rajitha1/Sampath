import java.util.Scanner;

/* Class BSTNode */
class BSTNode{

         private BSTNode left, right;
         private int isbn;
	 private String title,a_name,a_sname;

			         /* Constructor */
         public BSTNode(){

             left = null;
             right = null;
             isbn = 0;
         }

         			/* Constructor */
         public BSTNode(String title,String a_name,String a_sname,int isbn){

             left = null;
             right = null;
	     this.title=title;
	     this.a_name=a_name;
	     this.a_sname=a_sname;
             this.isbn = isbn;

         }

			         /* Function to set left node */
        public void setLeft(BSTNode left){
             this.left =left;
         }

			         /* Function to set right node */ 
        public void setRight(BSTNode right){
             this.right =right;
         }

			         /* Function to get left node */
        public BSTNode getLeft(){
             return left;
         }

			         /* Function to get right node */
        public BSTNode getRight(){
             return right;
         }

			         /* Function to set data to node */
	public void setIsbn(int isbn){
             this.isbn =isbn;
         }

			         /* Function to get data from node */
	public int getIsbn(){             
	     return isbn;
         }     
	
	public void setTile(String title){
	     this.title=title;
	}

	public String getTitle(){
	     return title;
	}

	public void setAName(String a_name){
	     this.a_name=a_name;
	}

	public String getAName(){
	     return a_name;
	}

	public void setASName(String a_sname){
	     this.a_sname=a_sname;
	}

	public String getASName(){
	     return a_sname;
	}

}

     


/* Class BST */
class BST{

         private BSTNode root;

     

			         /* Constructor */
         public BST(){

             root = null;
         }


         			/* Function to check if tree is empty */
         public boolean isEmpty(){

             return root == null;
         }


			         /* Functions to insert data */
          public void insert(String title,String a_name,String a_sname,int isbn){

             root = insert(root,title,a_name,a_sname,isbn);
         }

         
				/* Function to insert data recursively */
         private BSTNode insert(BSTNode node,String title,String a_name,String a_sname,int isbn){

             if (node == null)

                 node = new BSTNode(title,a_name,a_sname,isbn);

             else{

                 if (isbn <= node.getIsbn())

                     node.setLeft(insert(node.getLeft(),title,a_name,a_sname, isbn));

                 else

                     node.setRight(insert(node.getRight(),title,a_name,a_sname, isbn));

             }

             return node;

         }


         			/* Functions to delete data */
         public void delete(int isbn){

             if (isEmpty())
			System.out.println("Tree Empty");

             //else if (search(k) == false)
                 	//System.out.println("Sorry "+ isbn +" is not present");

             else{

                 root = delete(root, isbn);
                 System.out.println(isbn+ " deleted from the tree");

             }

         }

         private BSTNode delete(BSTNode root, int isbn){

             BSTNode p, p2, n;

             if (root.getIsbn() == isbn)

             {

                 BSTNode lt, rt;

                 lt = root.getLeft();

                 rt = root.getRight();

                 if (lt == null && rt == null)

                     return null;

                 else if (lt == null)

                 {

                     p = rt;

                     return p;

                 }

                 else if (rt == null)

                 {

                     p = lt;

                     return p;

                 }

                 else

                 {

                     p2 = rt;

                     p = rt;

                     while (p.getLeft() != null)

                         p = p.getLeft();

                     p.setLeft(lt);

                     return p2;

                 }

             }

             if (isbn < root.getIsbn())

             {

                 n = delete(root.getLeft(), isbn);

                 root.setLeft(n);

             }

             else

             {

                 n = delete(root.getRight(), isbn);

                 root.setRight(n);             

             }

             return root;

         }

	public void search(int isbn){

             search(root,isbn);

         }

         		/* Function to search for an element recursively */
         private void search(BSTNode node , int isbn){

             boolean found = false;

             while ((node != null) && !found){

                 int root_isbn = node.getIsbn();

                 if (isbn < root_isbn)

                     node = node.getLeft();

                 else if (isbn > root_isbn)

                     node = node.getRight();

                 else{

                     found = true;
                     break;
                 }

             }
	   
             if(found){
		 System.out.print("\nBook Title:"+node.getTitle());
		 System.out.print("\nAuthor Name:"+node.getAName());
		 System.out.print("\nAuthor Sure Name:"+node.getASName());
		 System.out.println("\nBook ISBN:"+node.getIsbn());
	     }
	     else
	         System.out.print("\nthere is no book");
             

         }

         /* Function for inorder traversal */

         public void inorder()

         {
	     System.out.println("\nroot:"+root.getIsbn());	
             inorder(root);

         }

         private void inorder(BSTNode r)

         {

             if (r != null)

             {

                 inorder(r.getLeft());

                 System.out.print("\n\nTitile: "+r.getTitle());
		 System.out.print("\tAuthor name: "+r.getAName());
		 System.out.print("\tAuthor sure name: "+r.getASName());
		 System.out.print("\tISBN: "+r.getIsbn());
		 
                 inorder(r.getRight());

             }

         }


}     

     /* Class BinarySearchTree */

public class BinarySearchTree4{

        public static void main(String[] args){                 

            Scanner scan = new Scanner(System.in);

            /* Creating object of BST */

            BST bst = new BST();          

            char ch;

            /*  Perform tree operations  */

            do    

            {

                System.out.print("\n------------------------------BOOKSHOP DATABASE-----------------------------\n\n\t\t*******************MENU********************\n");

                System.out.println("\t\t(1) Insert Book\t\t(2) Delete Book \n\t\t(3) Search Book\t\t(4) Print All Books");

                int choice = scan.nextInt();            

                switch (choice)

                {

                case 1 : 
		    System.out.print("\n\n\t\tEnter Book Title:");
		    String title=scan.next();

		    System.out.print("\n\t\tEnter Book Author Name:");
		    String a_name=scan.next();
		    
                    System.out.print("\n\t\tEnter Book Author Sure Name:");
		    String a_sname=scan.next();
                    
		    System.out.print("\n\t\tEnter Book ISBN:");
                    int isbn=scan.nextInt();                     
			
		    bst.insert(title,a_name,a_sname,isbn);
                    break;   
		case 2:
		    System.out.print("\n\n\t\tEnter Book ISBN:");
		    bst.delete(scan.nextInt());
                    break;                       
		case 3:
		    System.out.print("\n\n\t\tEnter Book ISBN:");
		    bst.search(scan.nextInt());
                    break;
		case 4:
		    bst.inorder();
		    break;
                default : 

                    System.out.println("\n\n\t!!!!!!!!!!!!!!!!!WRONG ENTRY!!!!!!!!!!!!!!!!! \n ");
		    break;   

                }

                System.out.println("\nDo you want to continue (Type y or n) \n");

                ch = scan.next().charAt(0);                        

            } while (ch == 'Y'|| ch == 'y');               

        }

     }