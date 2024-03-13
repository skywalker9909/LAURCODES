/* 
 LAUREL RAEANNE TAY
 LTAY3@U.ROCHESTER.EDU
 */

package queue;

public class TheQueue<AnyType> implements Queue<AnyType> {

	public TheDoublyLinkedList<AnyType> list;
	
	public TheQueue() {
		list = new TheDoublyLinkedList<AnyType>();
	}
	
	@Override
	public void enqueue(AnyType x) {
		list.insertToEnd(x);
	}
	
	@Override
	public boolean isEmpty() {
		if (list.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public AnyType dequeue() {
		if (isEmpty()) {
			return null;
		} else {
			return list.deleteFromFront();
		}
	}

	@Override
	public AnyType peek() {
		return list.start.next.data;
	}

	
}
