import java.util.*;
class QueueStack{
	Stack<Integer> stA = new Stack<Integer>();
	Stack<Integer> stB = new Stack<Integer>();
	public static void main(String[] args){
		QueueStack mQueueStack = new QueueStack();
		mQueueStack.queuePush(1);
		mQueueStack.queuePush(2);
		mQueueStack.queuePush(3);
		System.out.println("pop: " + mQueueStack.queuePop());
		mQueueStack.queuePush(4);
		System.out.println("pop: " + mQueueStack.queuePop());
	}

	private void queuePush(int a){
		if(!stB.empty()){
			int stBInitSize = stB.size();
			for(int i = 0; i < stBInitSize; i++){
				stA.push(stB.pop());
				//System.out.println("move stB to stA");
			}
		} else {
			stA.push(a);
			//System.out.println("push " + a + " to stA");
		}
	}

	private int queuePop(){
		int ret = 3982730;
		if(!stA.empty()){
			int stAInitSize = stA.size();
			for(int i = 0; i < stAInitSize; i++){
				//System.out.println("move stA " + stA.peek() + " to stB");
				stB.push(stA.pop());
			}
			ret = stB.pop();
			//System.out.println("pop stB ");
			return ret;
		}else{
			System.out.println("Queue can't pop, it's empty");
		}
		return ret;
	}
}