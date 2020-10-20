//栈排序。 编写程序，对栈进行排序使最小元素位于栈顶。最多只能使用一个其他的临时栈存放数据，但不得将元素复制到别的数据结构（如数组）中。该栈支持如下操作：pu
//sh、pop、peek 和 isEmpty。当栈为空时，peek 返回 -1。 
//
// 示例1: 
//
//  输入：
//["SortedStack", "push", "push", "peek", "pop", "peek"]
//[[], [1], [2], [], [], []]
// 输出：
//[null,null,null,1,null,2]
// 
//
// 示例2: 
//
//  输入： 
//["SortedStack", "pop", "pop", "push", "pop", "isEmpty"]
//[[], [], [], [1], [], []]
// 输出：
//[null,null,null,null,null,true]
// 
//
// 说明: 
//
// 
// 栈中的元素数目在[0, 5000]范围内。 
// 
// Related Topics 设计 
// 👍 23 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class SortedStack {
    Stack<Integer> s1 ;
    Stack<Integer> s2 ;

    public SortedStack() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int val) {
        while(!s1.empty() && s1.peek() < val){
            s2.push(s1.pop());
        }
        s1.push(val);
        while (!s2.empty()){
            s1.push(s2.pop());
        }
    }
    
    public void pop() {
        if(!s1.empty()){
            s1.pop();
        }
    }
    
    public int peek() {
        if(!s1.empty()){
            return s1.peek();
        }else{
            return -1;
        }
    }
    
    public boolean isEmpty() {
        return s1.empty();
    }
}

/**
 * Your SortedStack object will be instantiated and called as such:
 * SortedStack obj = new SortedStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.isEmpty();
 */
//leetcode submit region end(Prohibit modification and deletion)
