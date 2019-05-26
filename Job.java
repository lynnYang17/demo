import java.util.*;
class Job{//To find a new job, Fighting!
	public static void main(String[] args){
		Job mJob = new Job();
		/* ---------- 1. find the first target in a int[] ------------- */
		int[] input1 = {2,3,4,5,5,5,6,7,8,9,10};
		//int[] input = {};
		int target = 5;
		int ret1 = mJob.binarySearch(input1, target);
		System.out.println("index of first target: " + ret1);

		/* ---------- 2. matches "{[()]}()[]{}" ------------- */
		String input2 = "{[()]}()[]{{}}";
		boolean ret2 =  mJob.matchesString(input2);
		System.out.println("isMatch: " + ret2);

		/* ---------- 3. calculate -----------*/
		String input3 = "1+2*3/2+4-1";
		System.out.println(input3);
		float ret3 = mJob.calculate(input3);
		System.out.println("calculate result: " + input3 + " = " + ret3);

		/* ---------- 4. bubble sort -----------*/
		int[] input4 = {1, 9, 3, 6, 7, 8, 0, 12};
		//System.out.println("input4" + input4.toString());//dont use
		mJob.bubbleSort(input4);
		//System.out.println("input4 after sort" + input4.toString()); //dont use
		for(int i = 0; i < input4.length; i++){
			System.out.print(input4[i] + " ");
		}
		System.out.println();
		/*--------- move the dumpliaction to the end ---------*/
		int[] input5 = {1, 1, 2, 2, 3, 3, 3, 4, 4, 5, 5, 6};
		System.out.print("move the dumplication to the end: ");
		int[] ret5 = mJob.moveTheDuplication(input5);
		for(int i = 0; i < input5.length; i++){
			System.out.print(input5[i] + " ");
		}
		System.out.println();
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
	//3. calculation
	public float calculate(String s){// 1+2*3/4+5*6+7/1-6+9
		//1. 使用栈，计算一个包含有+ - * /的计算式
		//2. 将第一个数字Push到栈中
		//3. 遇到+, 则将后边的数字push到栈中
		//4. 遇到-, 则将后边的数字值为相反数, push到栈中
		//5. 遇到*, 则将后边的数字和栈顶数字做乘法, push到栈中
		//6. 遇到/, 则将后边的数字和栈顶数字做除法, push到栈中
		String subStr = null;
		Stack<Float> st = new Stack<Float>();
		for(int i = 0; i < s.length(); ){//遍历字符串
			subStr = s.substring(i, i + 1);
			if(st.empty()){//将第一个数字push到栈中
				st.push(Float.parseFloat(subStr));
				//System.out.println("peek: " + Float.parseFloat(subStr));
				i += 1;
			}else if(subStr.equals("+")){// 加号，将后边的数字push到栈中
				//System.out.println("after +: " + Float.parseFloat(s.substring(i + 1, i + 2)));
				st.push(Float.parseFloat(s.substring(i + 1, i + 2)));
				//System.out.println("peek: " + Float.parseFloat(s.substring(i + 1, i + 2)));
				i += 2;
			}else if(subStr.equals("-")){//将后边的数字值为相反数, push到栈中
				float minus = (-1) * Float.parseFloat(s.substring(i + 1, i + 2));
				//System.out.println("minus: " + minus);
				st.push(minus);
				//System.out.println("peek: " + minus);
				i += 2;
			}else if(subStr.equals("*")){//将后边的数字和栈顶数字做乘法, push到栈中
				float multiply = st.pop() * Float.parseFloat(s.substring(i + 1, i + 2));
				//System.out.println("after *: " + Float.parseFloat(s.substring(i + 1, i + 2)));
				//System.out.println("multiply: " + multiply);
				st.push(multiply);
				//System.out.println("peek: " + multiply);
				i += 2;
			} else if(subStr.equals("/")){//将后边的数字和栈顶数字做除法, push到栈中
				float divide = st.pop() / Float.parseFloat(s.substring(i + 1, i + 2));
				//System.out.println("after /: " + Float.parseFloat(s.substring(i + 1, i + 2)));
				//System.out.println("divide: " + divide);
				st.push(divide);
				//System.out.println("peek: " + divide);
				i += 2;
			} else{
				System.out.println("Input string error");
			}
		}
		float ret = 0;
		int initSize = st.size();
		for(int j = 0; j < initSize; j++){
			System.out.println("st peek: " + st.peek());
			ret +=st.pop();
		}
		return ret;
	}
	// Bubble sort
	public void bubbleSort(int[] input){
		//从小到大排列，每轮结束后，最大的沉到最下边或者最小的浮到最上边
		for(int i = 0; i < input.length; i ++){
			for (int j = 0; j < input.length - 1 - i; j++){
				if(input[j] > input[j + 1]){
					int temp = input[j];
					input[j] = input[j + 1];
					input[j + 1] = temp;
				}
			}
		}
	}
	// Move duplication to the end
	public int[] moveTheDuplication(int[] input){
		//input: 1 1 2 2 3 3 3 4 4 5 5 6
		// i = 0, j = 0: 1 1 2 2 3 3 3 4 4 5 5 6
		// i = 0, j = 1: 1 1 2 2 3 3 3 4 4 5 5 6
		// i = 0, j = 2: 1 2 1 2 3 3 3 4 4 5 5 6
		// i = 1, j = 3: 1 2 1 2 3 3 3 4 4 5 5 6
		// i = 1, j = 4: 1 2 3 2 1 3 3 4 4 5 5 6
		// i = 2, j = 5: 1 2 3 2 1 3 3 4 4 5 5 6
		// i = 2, j = 6: 1 2 3 2 1 3 3 4 4 5 5 6
		// i = 2, j = 7: 1 2 3 4 1 3 3 2 4 5 5 6
		// i = 3, j = 8: 1 2 3 4 1 3 3 2 4 5 5 6
		// i = 3, j = 9: 1 2 3 4 5 3 3 2 4 1 5 6
		// i = 4, j = 10: 1 2 3 4 5 3 3 2 4 1 5 6
		// i = 4, j = 10: 1 2 3 4 5 6 3 2 4 1 5 3
		// i = 5, j = 11: 不进入j循环
		//目的是找到第一次出现的数，并且放到它该在的位置
		//1. 当遇到了和当前i位置不相同的数，就把它放到i位置，i++
		//2. 用j来控制遍历
		for(int i = 0; i < input.length; i++){
			int j = 0;
			for(j = 0; j < input.length; j++){
				if(input[j] > input[i]){
					int temp = input[i + 1];
					input[i + 1] = input[j];
					input[j] = temp;
					i++;
				};
			}
			if(j == input.length){
				break;
			}
		}
		return input;
	}

}