/* 
 LAUREL RAEANNE TAY
 LTAY3@U.ROCHESTER.EDU
 */

package stack;

public interface SimpleLinkedList<AnyType> {
	public void insert(AnyType x);
	public void deleteItem(AnyType x);
	public boolean contains(AnyType x);
	public AnyType lookup(AnyType x);
	public boolean isEmpty();
	public void printList();
}
