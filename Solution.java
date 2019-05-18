class Solution {
    public static void main(String[] args){
        Solution s = new Solution();
        char[] letters = {'c', 'f', 'j'};
        char target = 'e';
        System.out.println(s.nextGreatestLetter(letters,target));
    }

    public char nextGreatestLetter(char[] letters, char target) {
        int locate = binarySearch(letters,target);
        System.out.println("locate: " + locate );
        char ans='A';
        if(letters[locate]>target){
            System.out.println("1");
            ans = letters[locate];
        }else if(letters[locate]==target){
            if(locate == letters.length -1){
                System.out.println("2");
                ans = letters[0];
            }else{
                System.out.println("3");
                int j=locate;
                while(true){
                    if(j>=letters.length-1){
                        ans = letters[0];
                        break;
                    }else if(letters[j+1]!=letters[j]){
                        ans = letters[j+1];
                        break;
                    }else{
                        j=j+1;
                    }
                }
                
            }
        }else if(letters[locate]<target){
            if(locate == letters.length -1){
                System.out.println("4");
                ans = letters[0];
            }else{
                System.out.println("5");
                int j=locate;
                while(true){
                    if(j>=letters.length-1){
                        ans = letters[0];
                        break;
                    }else if(letters[j+1]!=letters[j]){
                        ans = letters[j+1];
                        break;
                    }else{
                        j=j+1;
                    }
                }
            }
            
        }
        return ans;
    }

    public int binarySearch(char [] a, char key){
        int mid = 0;
        int left = 0;
        int right = a.length - 1;

        while(left <= right){
            mid = (left + right)/2;
            if(key == a[mid]){
                return mid;
            }
            if(key < a[mid]){
                right = mid -1;
            }else if(key > a[mid]){
                left = mid + 1;             
            }
        }
        //System.out.println("The key was not found. ");
        return mid;
    }
}