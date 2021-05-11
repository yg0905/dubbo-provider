import java.util.Arrays;

public class No2_Stack_BasicCalculator {

    public static void main(String[] args) {
        String str = "300+20*6-10*1";
        ArrayNumStack numStack = new ArrayNumStack(5);
        ArrayOperStack operStack = new ArrayOperStack(5);
        int num = 0;
        // 具体计算
        int length = str.length();
        for (int index = 0; index < length; index++) {
            char param = str.charAt(index);
            // 判断是不是数字
            if ('0' <= param && param <= '9') {
                // 如果是数字
                num = num * 10 + param - 48;
                // 还需要往后判断一位，看看是数字还是符号，如果是符号就进栈，如果是数字就不急着进栈
                // 但是，需要首先看看后面还有没有数据了
                if (index + 1 < length) {
                    // 如果后面还有数据，就取出来看看是符号还是数字
                    char next = str.charAt(index + 1);
                    if (!(next >= '0' && next <= '9')) {
                        numStack.pushNum(num);
                        num = 0;    // 初始化
                    }
                } else {
                    // 如果后面没数据了，说明到了字符串最后了
                    numStack.pushNum(num);
                }
            } else {
                // 如果不是数字，就是符号
                // 如果符号栈为空，直接进栈
                if (operStack.isEmpty()) {
                    operStack.pushOper(param);
                } else {
                    // 符号优先级比较了，用于判断是否做运算
                    // 先判断将要进栈的符号的优先级和栈顶的符号优先级哪个高
                    int pri_param = getPriority(param);
                    int pri_top = getPriority(operStack.peek());
                    if (pri_param >= pri_top) {
                        // 如果要进栈的符号优先级大于等于栈顶的，则直接进栈
                        operStack.pushOper(param);
                    } else {
                        // 如果要进栈的符号优先级小于等于栈顶的，那么栈顶元素出栈进行运算
                        char oper = operStack.popOper();    // 符号栈出一个元素
                        int num_1 = numStack.popNum();        // 数字栈出两个元素
                        int num_2 = numStack.popNum();
                        int res = calculate(num_1, num_2, oper);    // 运算
                        numStack.pushNum(res);        // 运算结果进栈
                        operStack.pushOper(param);    // 运算符进栈
                    }
                }
            }
        }
        // 经过上面的操作，符号栈剩下的都是优先级相等的符号了，直接出栈做运算就可以啦
        // 如果符号栈为空，说明已经计算完了
        while (!operStack.isEmpty()) {
            char oper = operStack.popOper();
            int num_1 = numStack.popNum();
            int num_2 = numStack.popNum();
            int res = calculate(num_1, num_2, oper);
            numStack.pushNum(res);
        }
        // 这个时候，数字栈的最后一个元素，就是最后的计算结果
        System.out.println(str + " = " + numStack.popNum());
    }

    // 获取运算符优先级，数字越大，优先级越大
    private static int getPriority(char oper) {
        if (oper == '+' || oper == '-') {
            return 0;
        }
        if (oper == '*' || oper == '/') {
            return 1;
        }
        return -1;
    }

    // 给定两个数字以及运算符，计算出结果
    private static int calculate(int num_1, int num_2, char oper) {
        int result = 0;
        switch (oper) {
            case '+':
                result = num_1 + num_2;
                break;
            case '-':
                result = num_2 - num_1;
                break;
            case '*':
                result = num_1 * num_2;
                break;
            case '/':
                result = num_2 / num_1;
            default:
                break;
        }
        return result;
    }

}

/**
 * @Description 使用数组模拟数字栈
 */
class ArrayNumStack {
    private int maxSize;            // 栈的容量
    private int[] numStack;        // 存放数字的栈
    private int top;            // 数字栈的栈顶

    public ArrayNumStack(int maxSize) {
        this.maxSize = maxSize;
        numStack = new int[maxSize];
        top = -1;
    }

    // 数字入栈
    public void pushNum(int num) {
        if (isFull()) {
            System.out.println("数字栈满了！");
            return;
        }
        numStack[++top] = num;
    }

    // 数字出栈
    public int popNum() {
        if (isEmpty()) {
            throw new RuntimeException("数字栈为空！");
        }
        return numStack[top--];
    }

    // 判断数字栈是否满了
    private boolean isFull() {
        return top == maxSize - 1;
    }

    // 判断数字栈是否为空
    private boolean isEmpty() {
        return top == -1;
    }
}

/**
 * @Description 数组模拟运算符栈
 */
class ArrayOperStack {
    private int maxSize;    // 运算符栈的大小
    private char[] operStack;   // 模拟运算符栈
    private int top;        // 栈顶指针

    public ArrayOperStack(int maxSize) {
        this.maxSize = maxSize;
        operStack = new char[maxSize];
        top = -1;
    }

    // 看一下运算符栈栈顶元素是什么，用于比较运算符优先级
    public char peek() {
        return operStack[top];
    }

    // 运算符入栈
    public void pushOper(char val) {
        if (isFull()) {
            System.out.println("运算符栈满了！");
            return;
        }
        operStack[++top] = val;
    }

    // 运算符出栈
    public char popOper() {
        if (isEmpty()) {
            throw new RuntimeException("运算符栈为空！");
        }
        return operStack[top--];
    }

    // 判断运算符栈是否满了
    private boolean isFull() {
        return top == maxSize - 1;
    }

    // 判断运算符栈是否为空
    public boolean isEmpty() {
        return top == -1;
    }
}

enum Singleton {
    SINGLETON;

    public void getSingleton() {
        System.out.println("输出");
    }
}

//选择排序
class select {
    public static void main(String[] args) {
        int[] a = {98, 12, 1, 35, 45};
        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (min > a[j]) {
                    min = a[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                a[minIndex] = a[i];
                a[i] = min;
            }
        }
        for (int i : a) {
            System.out.println(i);
        }
    }
}

class insertion {
    public static void main(String[] args) {
        int[] a = {98, 12, 1, 35, 45};
        for (int i = 1; i < a.length; i++) {
            int num = a[i];
            int numIndex = i - 1;//a[i]前面数的下标
            while (numIndex >= 0 && num < a[numIndex]) {
                a[numIndex + 1] = a[numIndex];
                numIndex--;
            }
            //当下标和当前循环下标相同时 表示不需要赋值，因为这个数就在这个位置，反之相反
            if (numIndex + 1 != i) {
                a[numIndex + 1] = num;
            }

        }
        for (int i : a) {
            System.out.println(i);
        }
    }
}

class insertion1 {
    public static void main(String[] args) {
        int[] a = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
        int num = 0;
        for (int gap = a.length / 2; gap > 0; gap = gap / 2) {
            for (int i = gap; i < a.length; i++) {
                for (int j = i - gap; j >= 0; j = j - gap) {
                    if (a[j] > a[j + gap]) {
                        num = a[j];
                        a[j] = a[j + gap];
                        a[j + gap] = num;
                    }
                }
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
//快速排序
class speed{
    public static void main(String[] args) {
        int[] a = {98, 12, 1, 35, 164,45};
        int l=0;//左边最开始的下标
        int r=a.length-1;//右边最开始的下标
        quick_sort(a,l,r);
        System.out.println(Arrays.toString(a));
    }
   static void quick_sort(int[] s, int l, int r)
    {
        if (l < r)
        {
            //Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
            int i = l, j = r, x = s[l];
            while (i < j)
            {
                while(i < j && s[j] >= x) // 从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];

                while(i < j && s[i] < x) // 从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i - 1); // 递归调用
            quick_sort(s, i + 1, r);
        }
    }
}