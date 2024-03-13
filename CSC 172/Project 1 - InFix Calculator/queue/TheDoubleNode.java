/* 
 LAUREL RAEANNE TAY
 LTAY3@U.ROCHESTER.EDU
 */

package queue;

public class TheDoubleNode<AnyType> {
	public AnyType data;
	public TheDoubleNode<AnyType> next;
	public TheDoubleNode<AnyType> previous;
	
	public TheDoubleNode(AnyType x, TheDoubleNode<AnyType> previous, TheDoubleNode<AnyType> next){
		this.data = x;
		this.next = next;
		this.previous = previous;
	}
}
