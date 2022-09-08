package planilha.excel.apache.EstudoAlgoritmos;

public class Algoritmo_1_QuickSortSingleLinkedList {

	static class Node{
		int data;
		Node next;
		Node( int d ){
			this.data = d;
			this.next = next;
		}
		//Instancia da classe node
		Node head;
		
		//Metodo
		void addNode( int data ) {
			if( head == null ) {
				head = new Node(data);
				return;
			}
			Node curr = head;
			while( curr.next != null ) {
				curr = curr.next;
			
				Node newNode = new Node(data);
				curr.next = newNode;
			}
		}
		
		void printList( Node n ) {
			while( n != null ) {
				System.out.println( n.data );
				System.out.println(" ");
				n = n.next;
			}
		}
		
		Node paritionLast( Node start, Node end ){
			
			if( start == end || start == null || end == null) {
				return start;
			}
			
			Node pivot_prev = start;
	        Node curr = start;
	        int pivot = end.data;
			return end;		
			/*
			while (start != end) {
				int temp = curr.data;
		        curr.data = pivot;
		        end.data = temp;
		        
				if (start.data < pivot) {
					// keep tracks of last modified item
	                pivot_prev = curr;
	                int temp1 = curr.data;
	                curr.data = start.data;
	                start.data = temp1;
	                curr = curr.next;
				}
				start = start.next;
			}*/
			
	        
		}
		
		//return pivot_prev;
	}
	
	
	
	
	
	
	
	public static void main(String[] args) {

	}

}





















