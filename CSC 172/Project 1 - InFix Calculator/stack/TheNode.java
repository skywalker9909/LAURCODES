/* 
 LAUREL RAEANNE TAY
 LTAY3@U.ROCHESTER.EDU
 */

package stack;

public class TheNode<AnyType> {
	
	public AnyType data;
	public TheNode<AnyType> next;
	
	public TheNode(AnyType x, TheNode<AnyType> next){
		this.data = x;
		this.next = next;
	}

}
