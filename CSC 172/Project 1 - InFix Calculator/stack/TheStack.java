/* 
 LAUREL RAEANNE TAY
 LTAY3@U.ROCHESTER.EDU
 */

 
package stack;

public class TheStack<AnyType> implements Stack<AnyType> {

	protected TheList<AnyType> list;
	
	public TheStack() {
		list = new TheList<AnyType>();
	}
	
	@Override
	public void push(AnyType x) {
		list.insert(x);
	}
	
	@Override
	public AnyType pop() {
		if (isEmpty())
		{
			return null;
		} else {
			return list.deleteLastIn();
		}
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
	public AnyType peek() {
		if (list.startOfList.next != null){
			return list.startOfList.next.data;
		} else {
			return null;
		}
	}

	
}
