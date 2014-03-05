import java.util.Scanner;
import java.io.*;

/* Class BSTNode */
class BSTNode{

         private BSTNode left, right;
         private double isbn;
	 private String title,a_name,a_sname;

			         /* Constructor */
         public BSTNode(){

             left = null;
             right = null;
             isbn = 0;
         }

         			/* Constructor */
         public BSTNode(String title,String a_name,String a_sname,double isbn){

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
	public void setIsbn(double isbn){

             this.isbn =isbn;
         }

			         /* Function to get data from node */
	public double getIsbn(){
             
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
          public void insert(String title,String a_name,String a_sname,double isbn){

             root = insert(root,title,a_name,a_sname,isbn);
         }

         
				/* Function to insert data recursively */
         private BSTNode insert(BSTNode node,String title,String a_name,String a_sname,double isbn){

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
         /* Function for inorder traversal */

         public void inorder()

         {

             inorder(root);

         }

         private void inorder(BSTNode r)

         {

             if (r != null)

             {

                 inorder(r.getLeft());

                 System.out.println(r.getTitle() +" ");
		 System.out.println(r.getAName() +" ");
		 System.out.print(r.getASName() +" ");
		 System.out.println(r.getIsbn() +" ");

                 inorder(r.getRight());

             }

         }





	public void stringSearch(String del_title)
         {
             stringSearch(root,del_title);
         }
         private void stringSearch(BSTNode r,String del_title)
         {
             if (r != null)
             {
                 stringSearch(r.getLeft());

                 if(del_title==r.getTitle());
		 {
		 	System.out.println("Found"+r.getTitle());
		 }
                 stringSearch(r.getRight());
             }
         }	




}     

     /* Class BinarySearchTree */

public class BinarySearchTree3{

        public static void main(String[] args)throws IOException{                 

            Scanner scan = new Scanner(System.in);

            /* Creating object of BST */

            BST bst = new BST(); 

            System.out.println("Binary Search Tree Test\n");          

            char ch;

            /*  Perform tree operations  */

            do    

            {

                System.out.println("\nBinary Search Tree Operations\n");

                System.out.println("1. insert ");

                int choice = scan.nextInt(); 

		//BufferedReader br=new BufferedReader(new InputStreamReader(System.in));           

                switch (choice)

                {

                case 1 : 
		    System.out.println("Enter book title:");
		    //String title=scan.next();
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		    String title=br.readLine();

		    System.out.println("Enter book Author name:");
		    String a_name=scan.next();
		    
                    System.out.println("Enter book Author sure name:");
		    String a_sname=scan.next();
                    
		    System.out.println("Enter book ISBN:");
                    double isbn=scan.nextDouble();                     
			
		    bst.insert(title,a_name,a_sname,isbn);
                    break;                          

                default : 

                    System.out.println("Wrong Entry \n ");

                    break;   

                }

                /*  Display tree  */ 

                System.out.print("\nIn order : ");

                bst.inorder();




		System.out.println("Enter book title to delete:");
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
		String del_title=br.readLine();

		bst.stringSearch(del_title);

     



                System.out.println("\nDo you want to continue (Type y or n) \n");

                ch = scan.next().charAt(0);                        

            } while (ch == 'Y'|| ch == 'y');               

        }

     }