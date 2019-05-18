import java.util.*;
class Job{//To find a new job, Fighting!
	public static void main(String[] args){
		Job mJob = new Job();
		/* ---------- 1. find the first target in a int[] ------------- */
		int[] input = {2,3,4,5,5,5,6,7,8,9,10};
		//int[] input = {};
		int target = 5;
		int ret1 = mJob.binarySearch(input, target);
		System.out.println("index of first target: " + ret1);

		/* ---------- 2. matches "{[()]}()[]{}" ------------- */
		String str = "{[()]}()[]{{}}";
		boolean ret2 =  mJob.matchesString(str);
		System.out.println("isMatch: " + ret2);
	}
	//1. find the first target in a int[] by Binary_Search
	public int binarySearch(int[] input, int target){//2, 3, 4, 5, 5, 5, 6, 7, 8, 9, 10
		int left = 0;
		int right = input.length - 1;
		int mid = -1;
		while(left <= right){
			mid = (left + right) / 2;
			if(target == input[mid]){
				while(mid >= 1){
					if(target != input[mid - 1]){
						return mid;
					}
					mid -= 1;
				}
				return mid;
			} else if(target < input[mid]){
				right = mid - 1;
				mid = -1;
			} else {
				left = mid + 1;
				mid = -1;
			}
		}
		return mid;
	}
	//2. matches "{[()]}()[]{}" 
	public boolean matchesString(String s){
		boolean ret = false;
		// 方法一：
		// 1) 数组长度为奇数，不匹配
		// 2) 遍历字符串，遇到左括号：将其放入栈中
		// 3) 遇到右括号：判断其和栈顶此时的元素是否匹配，若匹配，则弹出栈顶；若不匹配，直接返回false
		// 4) true结束条件：字符串遍历结束，栈空
		String[] left = {"{", "[", "("}; 
		String[] right = {"}", "]", ")"};
		String subStr = null;
		Stack<String> st = new Stack<String>();
		if(s != null){//数组长度为奇数或数组为空串，不匹配
			if(s.length() % 2 != 0 || s.length() == 0){
				return ret;
			}else {
				for(int i = 0; i < s.length(); i++){//遍历字符串
					subStr = s.substring(i, i+1);
					if(isExist(left, subStr)){//当前字符为左括号，将当前字符加入栈中
						st.push(subStr);
					}else if((subStr.equals("}") && st.peek().equals("{")) || 
							(subStr.equals("]") && st.peek().equals("[")) || 
							(subStr.equals(")") && st.peek().equals("(")) ) {//当前字符和栈顶字符相匹配，弹出栈顶
						st.pop();
					}else {
						return ret;
					}
				}
				if(st.empty()){
					ret = true;
				}
			}
		}
		return ret;
	}
	public boolean isExist(String[] strs, String s){
		boolean ret = false;
		for(int i = 0; i < strs.length; i++){
			if(strs[i].indexOf(s) != -1) {
				ret = true;
			}
		}
		return ret;
	}
}