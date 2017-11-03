
import java.util.Scanner;

/*  Class Node  */
class Node
{
    protected int data;
    protected Node next;
 
    /*  Constructor  */
    public Node()
    {
        next = null;
        data = 0;
    }    
    /*  Constructor  */
    public Node(int d,Node n)
    {
        data = d;
        next = n;
    }    
    /*  Function to set link to next Node  */
    public void setLink(Node n)
    {
        next = n;
    }    
    /*  Function to set data to current Node  */
    public void setData(int d)
    {
        data = d;
    }    
    /*  Function to get link to next node  */
    public Node getNext()
    {
        return next;
    }    
    /*  Function to get data from current Node  */
    public int getData()
    {
        return data;
    }
}
 
/* Class linkedList */
class MyLinkedList
{
    protected Node start;
    protected Node end ;
    public int size ;
 
    /*  Constructor  */
    public MyLinkedList()
    {
        start = null;
        end = null;
        size = 0;
    }
    /*  Function to check if list is empty  */
    public boolean isEmpty()
    {
        return start == null;
    }
    /*  Function to get size of list  */
    public int getSize()
    {
        return size;
    }    
    /*  Function to insert an element at begining  */
    public void insertAtStart(int val)
    {
        Node nptr = new Node(val, null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            nptr.setLink(start);
            start = nptr;
        }
    }
    /*  Function to insert an element at end  */
    public void insertAtEnd(int val)
    {
        Node nptr = new Node(val,null);    
        size++ ;    
        if(start == null) 
        {
            start = nptr;
            end = start;
        }
        else 
        {
            end.setLink(nptr);
            end = nptr;
        }
    }
    /*  Function to insert an element at position  */
    public void insertAtPos(int val , int pos)
    {
        Node nptr = new Node(val, null);                
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getNext() ;
                ptr.setLink(nptr);
                nptr.setLink(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size++ ;
    }
    /*  Function to delete an element at position  */
    public void deleteAtPos(int pos)
    {        
        if (pos == 1) 
        {
            start = start.getNext();
            size--; 
            return ;
        }
        if (pos == size) 
        {
            Node s = start;
            Node t = start;
            while (s != end)
            {
                t = s;
                s = s.getNext();
            }
            end = t;
            end.setLink(null);
            size --;
            return;
        }
        Node ptr = start;
        pos = pos - 1 ;
        for (int i = 1; i < size - 1; i++) 
        {
            if (i == pos) 
            {
                Node tmp = ptr.getNext();
                tmp = tmp.getNext();
                ptr.setLink(tmp);
                break;
            }
            ptr = ptr.getNext();
        }
        size-- ;
    } 
    
    /*  Function to delete an element at from end  */
    public void deleteAtEnd()
    {        
    	 if (size == 1) 
         {
             start = null;
             end = null;
             size--; 
             return ;
         }
    	 else  
         {
             Node s = start;
             Node t = start;
             while (s != end)
             {
                 t = s;
                 s = s.getNext();
             }
             end = t;
             end.setLink(null);
             size --;
             return;
         }
    }  
    
    /*  Function to delete all element greater than given  */
    public void deleteDataGreaterData(int data)
    {        
    	 if (size == 0) 
         {
            return ;
         }
    	 if(size == 1 && start.getData() > data)
    	 {
    		start = null;
    	 	end = null;
    	 	return;
    	 }
    	 else  
         {
    		 Node s = start;
    		 
		    while (s != null)
            {
	           	if (s.getData() >= data) 
	       		 {
	           		//Node t = s;
	           		s = s.getNext(); 
	           		start = s;
	           		//t.setLink(null);
	            }
	           	else
	           		break;
    		}
    		 Node nodePrevious = start;
    		 Node ptr = start.getNext();
    	        while(ptr != null ) 
    	        {
    	            if (ptr.getData() >= data) 
    	            {
    	               nodePrevious.setLink(ptr.getNext());
    	               ptr = ptr.getNext();
    	                size-- ;
    	            }
    	            else
    	            {
    	            	ptr = ptr.getNext();
    	            	nodePrevious = nodePrevious.getNext();
    	            }
    	        }
    	        
         }
    }  
    
    
    /*  Function to display elements  */
    public void display()
    {
        System.out.print("\nSingly Linked List = ");
        if (size == 0) 
        {
            System.out.print("empty\n");
            return;
        }    
        if (start.getNext() == null) 
        {
            System.out.println(start.getData() );
            return;
        }
        Node ptr = start;
        System.out.print(start.getData()+ "->");
        ptr = start.getNext();
        while (ptr.getNext() != null)
        {
            System.out.print(ptr.getData()+ "->");
            ptr = ptr.getNext();
        }
        System.out.print(ptr.getData()+ "\n");
    }
}
 
/*  Class MyLinkedList  */
public class MyLinkedListTest
{    
    public static void main(String[] args)
    {             
        Scanner scan = new Scanner(System.in);
        /* Creating object of class linkedList */
        MyLinkedList list = new MyLinkedList(); 
        System.out.println("Singly Linked List Test\n");          
        char ch;
        /*  Perform list operations  */
        do
        {
            System.out.println("\nSingly Linked List Operations\n");
            System.out.println("1. insert at begining");
            System.out.println("2. insert at end");
            System.out.println("3. insert at position");
            System.out.println("4. delete at position");
            System.out.println("5. delete at last");
            System.out.println("6. delete data greater this data");
            System.out.println("7. check empty");
            System.out.println("8. get size");            
            int choice = scan.nextInt();            
            switch (choice)
            {
            case 1 : 
                System.out.println("Enter integer element to insert");
                list.insertAtStart( scan.nextInt() );                     
                break;                          
            case 2 : 
                System.out.println("Enter integer element to insert");
                list.insertAtEnd( scan.nextInt() );                     
                break;                         
            case 3 : 
                System.out.println("Enter integer element to insert");
                int num = scan.nextInt() ;
                System.out.println("Enter position");
                int pos = scan.nextInt() ;
                if (pos <= 1 || pos > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.insertAtPos(num, pos);
                break;                                          
            case 4 : 
                System.out.println("Enter position");
                int p = scan.nextInt() ;
                if (p < 1 || p > list.getSize() )
                    System.out.println("Invalid position\n");
                else
                    list.deleteAtPos(p);
                break;
            case 5 : 
                list.deleteAtEnd();
                break; 
            case 6 : 
            	System.out.println("Enter data delete more than this  : ");
                int data = scan.nextInt() ;
                list.deleteDataGreaterData(data);
                break;  
            case 7 : 
                System.out.println("Empty status = "+ list.isEmpty());
                break;                   
            case 8 : 
                System.out.println("Size = "+ list.getSize() +" \n");
                break;                         
             default : 
                System.out.println("Wrong Entry \n ");
                break;   
            }
            /*  Display List  */ 
            list.display();
            System.out.println("\nDo you want to continue (Type y or n) \n");
            ch = scan.next().charAt(0);                        
        } while (ch == 'Y'|| ch == 'y');               
    }
}