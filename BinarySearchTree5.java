import java.util.Scanner;
import java.io.*;

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
         public void deleteIsbn(int isbn){
	     
             if (isEmpty())
			System.out.println("\n\n\t\t!!!!!!There is no Books Available!!!!!!");

             else if (searchIsbn(isbn) == false)
                 	System.out.println("\n\t\t!!!!!Sorry "+ isbn +" is not present!!!!!");

             else{
                 root = deleteIsbn(root, isbn);
                 System.out.println("\n\t\t"+isbn+" Deleted From The Book Database");
             }
	    
         }

         private BSTNode deleteIsbn(BSTNode root, int isbn){

             BSTNode p, p2, n;

             if (root.getIsbn() == isbn)

             {

                 BSTNode lt, rt;
                 lt = root.getLeft();
                 rt = root.getRight();

                 if (lt == null && rt == null)
                     return null;

                 else if (lt == null){

                     p = rt;
                     return p;
                 }

                 else if (rt == null){

                     p = lt;
                     return p;
                 }

                 else{

                     p2 = rt;
                     p = rt;

                     while (p.getLeft() != null)
                         p = p.getLeft();

                     p.setLeft(lt);
                     return p2;

                 }

             }

             if (isbn < root.getIsbn()){

                 n = deleteIsbn(root.getLeft(), isbn);
                 root.setLeft(n);
             }

             else{

                 n = deleteIsbn(root.getRight(), isbn);
                 root.setRight(n);             
             }

             return root;

         }

	public boolean deleteString(String title){
	
		return deleteString(root,title);
	}
	public boolean deleteString(BSTNode node,String title){
	
	    boolean found=false;
	    String t="";
	    if (node != null){

                 deleteString(node.getLeft(),title);
		 t=node.getTitle();
		 if(title.equalsIgnoreCase(t)){
			System.out.println("\n\n\t\tThere is Book Available in Database");
		 	deleteIsbn(node.getIsbn());
			found=true; 
		 }
	   	 deleteString(node.getRight(),title);
        	     
	    }
	    return found;
	}

	public boolean searchIsbn(int isbn){

             return searchIsbn(root,isbn);

        }

         		/* Function to search for an element recursively */
         private boolean searchIsbn(BSTNode node , int isbn){

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
		 System.out.print("\n\t\tBook Title     : "+node.getTitle());
		 System.out.print("\n\t\tAuthor Name    : "+node.getAName());
		 System.out.print("\n\t\tAuthor Surname : "+node.getASName());
		 System.out.println("\n\t\tBook ISBN      : "+node.getIsbn());
		 return found;
	     }
	     else
	         return found;
             

         }

	public boolean searchString(String title){
	    
	    return searchString(root,title);
	}
	
	public boolean searchString(BSTNode node,String title){
	    boolean found=false;
	    String t="";
	    if (node != null){

                 searchString(node.getLeft(),title);
		 t=node.getTitle();
		 if(title.equalsIgnoreCase(t)){
			System.out.println("\n\n\t\tThere is Book Available in Database");
                 	System.out.println("\n\n\t\tBook Title   : "+node.getTitle());
		 	System.out.println("\t\tAuthor Name    : "+node.getAName());
		 	System.out.println("\t\tAuthor Surname : "+node.getASName());
		 	System.out.println("\t\tISBN           : "+node.getIsbn());
			found=true; 
		 }
	   	 searchString(node.getRight(),title);
        	     
	    }
	    return found;   
	}

         /* Function for inorder traversal */

         public void inorder(){
	
             inorder(root);
         }

         public void inorder(BSTNode r){

             if (r != null){

                 inorder(r.getLeft());

                 System.out.println("\n\n\t\tBook Title     : "+r.getTitle());
		 System.out.println("\t\tAuthor Name    : "+r.getAName());
		 System.out.println("\t\tAuthor Surname : "+r.getASName());
		 System.out.println("\t\tISBN           : "+r.getIsbn());
		 
                 inorder(r.getRight());
             }

         }

}

     /* Class BinarySearchTree */

public class BinarySearchTree5{

        public static void main(String[] args)throws Exception{                 

            Scanner scan = new Scanner(System.in);
                 /* Creating object of BST */
            BST bst = new BST();          
            char ch;

		bst.insert("Java object oriented programming","Simon","Kendal",7854393);
		bst.insert("Java objects and classes","Steve","Cannon",2178436);
		bst.insert("Java classes in Java applications","Robert","Lafore",3938895);
		bst.insert("Java grphical user interfaces","David","Etheridge",6646487);
		bst.insert("Java network programming","Roberto","Tamassia",8543121);
		bst.insert("Java virtual machine","Laura","Thomson",1139079);
		bst.insert("Java secrets","Luke","Welling",2165462);
		bst.insert("Java Developers Resource","Anna","Harold",4879221);
		bst.insert("Java in a Nutshell","Bill","Joy",1456214);
		bst.insert("Java Handbook","Patrick","Naughton",7882100);
		bst.insert("Php comand line interfaces","Abdul","Rameh",1326743);
		bst.insert("Php GUI applications","Albert","Carlo",5621806);
		bst.insert("Php design patterns","Mathew","Hunt",4431077);
		bst.insert("Php for beginners","Chris","Synder",7423908);
		bst.insert("Php Object Oriented Solutions","Robin","Powers",4576135);


            /*  Perform tree operations  */

            do{

                System.out.print("\n\n\n\n-----------------------------BOOKSHOP DATABASE--------------------------------\n\n\n\t\t*******************MENU********************\n\n");
                System.out.println("\t\t(1) Insert Book\t\t(2) Delete Book \n\t\t(3) Search Book\t\t(4) Print All Books");
       		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 

		System.out.print("\n\n\t\tPlease Enter The Operation No : ");
		int choice=Integer.parseInt(br.readLine());
                  

                switch (choice){

                case 1 : 
		    System.out.print("\n\n\t\tEnter Book Title          : ");
		    String title=br.readLine();
		

		    System.out.print("\n\t\tEnter Book Author Name    : ");
		    String a_name=br.readLine();
	
		    
                    System.out.print("\n\t\tEnter Book Author Surname : ");
		    String a_sname=br.readLine();

		    System.out.print("\n\t\tEnter Book ISBN           : ");
		    int isbn=Integer.parseInt(br.readLine());
		
		    bst.insert(title,a_name,a_sname,isbn);
                    break; 
  
		case 2:
		    
		   
		    System.out.println("\n\n\t\t\t(1) Delete By ISBN\n\t\t\t(2) Delete by Title");
		    System.out.print("\n\t\t\tPlease Enter The Operation No : ");
		    int choice2=Integer.parseInt(br.readLine());

		    switch(choice2){
			
		    case 1:
			System.out.print("\n\n\t\tEnter Book ISBN   : ");
		        bst.deleteIsbn(Integer.parseInt(br.readLine()));
                    	break;

		    case 2:
		    	System.out.print("\n\n\t\tEnter Book Title   : ");
		    	boolean t=bst.deleteString(br.readLine());
			if(!t)
				System.out.println("\n\n\t\tThere is not Book in Database");
                    	break;

		    default : 
                    	System.out.println("\n\n\t\t\t!!!!!!!!!!!!!!!!WRONG ENTRY!!!!!!!!!!!!!!!! \n ");
		    	break;
		    }
		    break;
		        
		case 3:

		    System.out.println("\n\n\t\t\t(1) Search By ISBN\n\t\t\t(2) Search by Title");
		    System.out.print("\n\t\t\tPlease Enter The Operation No : ");
		    int choice1=Integer.parseInt(br.readLine());

		    switch(choice1){
			
		    case 1:
			System.out.print("\n\n\t\tEnter Book ISBN   : ");
		   	boolean t1=bst.searchIsbn(Integer.parseInt(br.readLine()));
			if(!t1)
				System.out.print("\n\t\t!!!!!This book is not available in database!!!!!");
                    	break;

		    case 2:
		    	System.out.print("\n\n\t\tEnter Book Title   : ");
		    	boolean t=bst.searchString(br.readLine());

		    	if(!t)
				System.out.println("\n\n\t\tThere is not Book in Database");
                    	break;

		    default : 
                    	System.out.println("\n\n\t\t\t!!!!!!!!!!!!!!!!WRONG ENTRY!!!!!!!!!!!!!!!! \n ");
		    	break;
		    }
		    break;
		case 4:
		    bst.inorder();
		    break;

                default : 
                    System.out.println("\n\n\t\t!!!!!!!!!!!!!!!!WRONG ENTRY!!!!!!!!!!!!!!!! \n ");
		    break;   

                }

                System.out.print("\n\n\t\tDo you want to continue (Type Y/N) : ");
                ch = scan.next().charAt(0);
		System.out.print("\n\n\n");                        

            } while (ch == 'Y' || ch == 'y');  

	    System.out.print("\n\n\n");	             

        }

     }