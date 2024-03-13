/* 
 LAUREL RAEANNE TAY
 LTAY3@U.ROCHESTER.EDU
 */

package stack;

public class TheList<AnyType> implements SimpleLinkedList<AnyType>{

	public TheNode<AnyType> startOfList;
	public TheNode<AnyType> node;
	
	public TheList() {
		startOfList = new TheNode<AnyType>(null, null);
	}

	@Override
	public boolean isEmpty() {
		if(startOfList.next == null) {
			return true;
		} else {
			return false;
		}
	}
	
	@Override
	public void insert(AnyType x) {		
		if(node != null) {
			TheNode<AnyType> newNode = new TheNode<AnyType>(x, node);
			
			startOfList.next = newNode;
			node = newNode;
		} else if(node == null){
			startOfList.next = new TheNode<AnyType>(x, null);
			node = startOfList.next;
		}
	}

	
	public void printStack() {
		if (!isEmpty()) {
			TheNode<AnyType> temp = startOfList.next;
			
			while (temp.next != null) {
				System.out.println(temp.data.toString());
				temp = temp.next;
			}
			System.out.println(temp.data.toString());
		}
	}
	
	@Override
	public void printList() {
		if (!isEmpty()) {
			TheNode<AnyType> temp = startOfList.next;
			
			String stackInOrder = "";
			
			while (temp.next != null) {
				stackInOrder = "\n" + temp.data.toString() + stackInOrder;
				
				temp = temp.next;
			}
			
			stackInOrder = temp.data.toString() + stackInOrder;
			
			System.out.println(stackInOrder);
		}
	}
	
	@Override
	public boolean contains(AnyType x) {
	
		TheNode<AnyType> temp = startOfList.next;

		while(temp != null) {
			if (temp.data.equals(x)) {
				return true;
			}
			temp = temp.next;
		}

		return false;
	}
	
	@Override
	public AnyType lookup(AnyType x) {
		if(contains(x)) {
			return x;
		} else {
			return null;
		}
	}
	
	@Override
	public void deleteItem(AnyType x) {
		if (contains(x)) {
			TheNode<AnyType> temp = startOfList.next;
			
			while (temp.next != null) {
				
				if(temp == startOfList.next && temp.data.equals(x)) {
					
					while(temp.next != null) {
						temp.data = temp.next.data;
						
						temp = temp.next;
					}
					
					deleteItem(temp.data);
					break;
					
				} 
				
				if(temp.next.data.equals(x)) {
					
					temp.next = temp.next.next;
						
					break;
				}
				
				temp = temp.next;
			}
		}
	}


	public AnyType deleteLastIn() {
		TheNode<AnyType> temp = startOfList.next;
		
		startOfList.next = startOfList.next.next;
		node = startOfList.next;
		
		return temp.data;
	}

}
