/* 
 LAUREL RAEANNE TAY
 LTAY3@U.ROCHESTER.EDU
 */

package queue;

public class TheDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType> {
	protected TheDoubleNode<AnyType> start;
	protected TheDoubleNode<AnyType> end;
	protected TheDoubleNode<AnyType> doubleNode;
	
	public TheDoublyLinkedList() {
		start = new TheDoubleNode<AnyType>(null, null, null);
		end = new TheDoubleNode<AnyType>(null, start, null);
		start.next = end;
	}
	
	@Override
	public void insertToEnd(AnyType x) {
		if (isEmpty()) {
			TheDoubleNode<AnyType> temp = new TheDoubleNode<AnyType>(x, start, end);
			
			doubleNode = temp;
			
			start.next = doubleNode;
			end.previous = doubleNode;
		} else {
			TheDoubleNode<AnyType> temp = new TheDoubleNode<AnyType>(x, end.previous, end);
		
			end.previous.next = temp;
			end.previous = temp;
		}
		
	}
	
	@Override
	public void insertToFront(AnyType x) {
		if (isEmpty()) {
			TheDoubleNode<AnyType> temp = new TheDoubleNode<AnyType>(x, start, end);
			
			doubleNode = temp;
			
			start.next = doubleNode;
			end.previous = doubleNode;
		} else {
			start.next.next = start.next;
			
			TheDoubleNode<AnyType> temp = new TheDoubleNode<AnyType>(x, start, start.next);
		
			start.next.previous = temp;
			start.next = temp;
		}
		
	}
	
	@Override
	public boolean isEmpty() {
		if (start.next == end && end.previous == start) {
			 return true;
		}
		return false;
	}
	
	@Override
	public void printList() {
		TheDoubleNode<AnyType> temp = start;
		
		while (temp.next.data != null) {
			System.out.println(temp.next.data);
			temp = temp.next;
		}
		
	}
	
	@Override
	public void printListRev() {
		TheDoubleNode<AnyType> temp = end;
		
		while (temp.previous.data != null) {
			System.out.println(temp.previous.data);
			temp = temp.previous;
		}
	}
	
	@Override
	public boolean contains(AnyType x) {
		if (isEmpty()) {
			return false;
		} else {
			TheDoubleNode<AnyType> temp = start;
			
			while (temp.next.data != null) {
				if (temp.next.data.equals(x)) {
					return true;
				}
				temp = temp.next;
			}
		}
		return false;
	}
	
	@Override
	public AnyType lookup(AnyType x) {
		if (contains(x)) {
			return x;
		} else {
			return null;
		}
	}
	
	@Override
	public void delete(AnyType x) {
		if (contains(x)) {
			TheDoubleNode<AnyType> temp = start;
			
			while (temp.next.data != null) {
				if (temp.next.data.equals(x)) {
					temp.next.next.previous = temp;
					
					temp.next = temp.next.next;
					
					break;
				}
				
				temp = temp.next;
			}
		}	
	}
	

	public AnyType deleteFromFront() {
		TheDoubleNode<AnyType> temp = start.next;
		
		start.next.next.previous = start;
		start.next = start.next.next;
		
		return temp.data;
	}
	
	public AnyType deleteFromEnd() {
		TheDoubleNode<AnyType> temp = end.previous;
		
		end.previous.previous.next = end;
		end.previous = end.previous.previous;
		
		return temp.data;
	}
	
	
}