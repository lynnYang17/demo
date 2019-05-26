import java.util.*;
class Learn {
	private static final String TAG = "Learn";
	public static void main(String[] args){
		Learn mLearn = new Learn();
		//Stack
		Stack<Integer> st = new Stack<Integer>();
		System.out.println("isStackEmpty: " + (st.empty() ? "empty" : st.size()));
		//Stack<Integer> st = {1, 2, 3, 4, 5, 6}; //error
		mLearn.showPush(st, 1209);
		System.out.println("isStackEmpty: " + (st.empty() ? "empty" : st.size()));
		mLearn.showPush(st, 100);
		mLearn.showPush(st, 1000);
		mLearn.showPush(st, 10000);
		mLearn.showPop(st);

		String str1 = "hello";
		String str2 = "hello";
		System.out.println("str1 == str2: " + (str1 == str2));
		String str3 = new String("hello");
		System.out.println("str3 == str1: " + (str3 == str1));
		String str4 = new String("hello");
		System.out.println("str3 == str4: " + (str3 == str4));
	}
	private void showPush(Stack<Integer> st, int a){
		//System.out.println(TAG +  ": showPush start");
		int retPush = st.push(new Integer(a));
		System.out.println("PUSH: a: " + a);
		System.out.println("PUSH: retPush: " + retPush);
		System.out.println("PUSH: st: " + st);
		//System.out.println(TAG + ": showPush end");
	}
	private void showPop(Stack<Integer> st){
		System.out.println("PEEK: st top before pop: " + st.peek());
		int retPop = st.pop();
		System.out.println("PEEK: st top after pop: " + st.peek());
		System.out.println("POP: retPop: " + retPop);
		System.out.println("POP: st: " + st);
	}
}