
public class LinkedList {
	Node head;

	public LinkedList() {
		this.head = null;
	}
	
	public void insert(int value) {
		Node tmp = new Node(value);
		
		if(this.head == null) {
			head = tmp;
		}else {
			tmp.next = head;
			head = tmp;
		}
		// tmp.next = head;
		// head = tmp;
	}
	
	public void append(int value) {
		Node tmp = new Node(value);
		
		if(this.head == null) {
			head = tmp;
		}else if(head.next == null){
			 head.next = null;
		}
		else {
			Node it = head.next;
			while(it.next != null) {
				it = it.next;
			}
			it.next = tmp;
		}
		
	}
	public void insertAtPos(int value, int pos) {
		int noOfNodes = findNoOfNodes();
		if(pos == 0) {
			insert(value);
		}else if(noOfNodes+1 == pos) {
			append(value);
		}else if(pos > 1 && pos < noOfNodes+1) {
			Node it = this.head;
			int x = pos;
			while(x != 0) {
				it = it.next;
				x--;
			}
			Node tmp = new Node(value);
			tmp.next = it.next;
			it.next = tmp;
		}else {
			System.out.println("INVALID POSITION");
		}
	}
	
	
	
	private int findNoOfNodes() {
		Node it = this.head;
		int counter = 0;
		while(it != null) {
			it = it.next;
			counter ++;
		}
		return counter;
	}

	public void deleteFirst() {
		if(this.head != null) {
			/*
			 * Node tmp = this.head; this.head = tmp.next;
			 * 
			 * tmp.next = null; tmp = null;
			 */
			if(this.head.next == null) {
				Node tmp = this.head;
				this.head = null;
				
				tmp.next = null;
				tmp = null;
			}else {
				Node tmp = this.head;
				this.head = tmp.next;
				
				tmp.next = null;
				tmp = null;
			}
		}
	}
	public void deleteLast() {
		if(this.head != null) {
			if(this.head.next == null) {
				Node tmp = this.head;
				this.head = null;
				
				tmp.next = null;
				tmp = null;
			}else {
				/*
				 * Node it = this.head; while(it.next != null) { it = it.next; } Node itp =
				 * this.head; while(itp.next != it) { itp = itp.next; } itp.next = null; it =
				 * null;
				 */
				/*
				 * Node it = this.head; while(it.next.next != null) { it = it.next; }
				 * it.next.next = null; it.next = null;
				 */
				Node it = this.head;
				Node itp = this.head;
				while(it.next != null) {
					it = it.next;
					if(it.next != null)
						itp = itp.next;
				}
				itp.next = null;
				it =null;
			}
		}
	}
	public void deleteAtPos( int pos) {
		int noOfNodes = findNoOfNodes();
		if(pos == 0) {
			deleteFirst();
		}else if(noOfNodes+1 == pos) {
			deleteLast();
		}else if(pos > 1 && pos < noOfNodes+1) {
			Node it = this.head;
			int x = pos;
			while(x != 0) {
				it = it.next;
				x--;
			}
			Node tmp = it.next;
			it.next = tmp.next;
			tmp.next = null;
			tmp = null;
		}else {
			System.out.println("INVALID POSITION");
		}
	}
	
	public void print() {
		if(this.head == null) {
			System.out.println("LL is Null");
		}else {
			Node it = head;
			while(it != null) {
				System.out.print(it.data + "-->");
				it = it.next;
			}
		}
	}

	public void reversePrint(Node it) {
		if(it != null && it.next != null) {
			reversePrint(it.next);
			
		}
		if(it != null) {
			System.out.print(it.data + "->");
		}	
	}
	
	public void reverse() {
		Node itp = null;
		Node it = head;
		Node itn = head;
		while(it != null) {
			itn = it.next;
			it.next = itp;
			itp = it;
			it = itn;
		}
		head = itp;
	}
}
