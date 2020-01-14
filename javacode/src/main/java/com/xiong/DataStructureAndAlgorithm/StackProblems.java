package com.xiong.DataStructureAndAlgorithm;

import java.util.LinkedList;
import java.util.Stack;

/**
 * @author ：xiongcong
 * @date ：Created in 2019/9/23 19:08
 * @description： 堆栈相关简单问题
 * @modified By：
 * @version: $
 */
public class StackProblems {

    /**
     *  @author: xiongcong
     *  @Date: 2019/10/28 14:28
     *  @Description: 数组实现 顺序栈
     */
    class StackBaseArray{
        private String[] dataArray;
        private int count;
        private int n;

        public StackBaseArray(int n){
            this.n= n;
            this.dataArray = new String[n];
            this.count =0;
        }
        //入栈
        public boolean push(String x){
            if(count == n){
                System.out.println("栈满");
                return false;
            }
            dataArray[count] = x;
            ++count;
            return true;
        }
        //出栈
        public String pop(){
            if(count == 0){
                return null;
            }
            String tmp = dataArray[count-1];
            --count;
            return tmp;
        }
    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/28 14:28
     *  @Description: 单链表实现 链式栈
     */
    class StackBaseLinkedList{
        private Node head;
        private int count;

        public StackBaseLinkedList(){}
        //入栈
        public boolean push(int item){
            Node node = new Node(item);
            if(count == 0){
                head = node;
            }
            node.next = head;
            head = node;
            count++;
            return true;
        }
        //删除
        public int pop(){
            if(count == 0){
                return -1;
            }
            int item = head.data;
            head = head.next;
            count--;
            return item;
        }

    }
    /**
     *  @author: xiongcong
     *  @Date: 2019/10/28 20:20
     *  @Description: 模拟浏览器向前向后跳转，通过两个栈来实现
     */
    public static void  browserStack(){
        SampleBrower browser = new SampleBrower();
        browser.open("http://www.baidu.com");
        browser.open("http://news.baidu.com/");
        browser.open("http://news.baidu.com/ent");
        browser.goBack();
        browser.goBack();
        browser.goForward();
        browser.open("http://www.qq.com");
        browser.goForward();
        browser.goBack();
        browser.goForward();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.goBack();
        browser.checkCurrentPage();
    }

   static class SampleBrower{
       private String currentPage;
       private Stack forwardStack;
       private Stack backStack;
       public SampleBrower(){
           this.forwardStack = new Stack();
           this.backStack = new Stack();
       }
       public void open(String url){
           if(this.currentPage != null) {
               backStack.push(this.currentPage);
               forwardStack.clear();//当访问一个新的页面时，清空当前向前跳转的页面
           }
           showUrl(url,"open");
       }

        public String goForward(){
            if(canGoforward()){
                backStack.push(this.currentPage);//当前页面保存到向后跳转的栈中
                String forwardurl = (String)forwardStack.pop();//从向前跳转的栈中弹出
                showUrl(forwardurl,"forward");
                return forwardurl;
            }
            System.out.println("* Cannot go forward, no pages ahead.");
            return null;
        }
        public String goBack(){
            if(canGoback()){
                forwardStack.push(this.currentPage);//当前页面保存到向前跳转的栈中
                String backurl = (String)backStack.pop();//从向后跳转的栈中弹出
                showUrl(backurl,"back");
                return backurl;
            }
            System.out.println("* Cannot go back, no pages behind.");
            return null;
        }
       public boolean canGoforward(){
            return forwardStack.size()>0;
       }
       public boolean canGoback(){
           return backStack.size()>0;
       }
       public void showUrl(String url, String prefix) {
           this.currentPage = url;
           System.out.println(prefix + " page == " + url);
       }

       public void checkCurrentPage() {
           System.out.println("Current page is: " + this.currentPage);
       }

    }


    public static void main(String[] args) {
    /*    char[][] maze ={
                {'1','1','1','1','1','1','1','1','1','1'},
                {'1','0','0','1','1','1','0','0','1','1'},
                {'1','0','0','1','1','0','0','1','0','1'},
                {'1','0','0','0','0','0','0','1','0','1'},
                {'1','0','0','0','0','1','1','0','0','1'},
                {'1','0','0','1','1','1','0','0','0','1'},
                {'1','0','0','0','0','1','0','1','0','1'},
                {'1','0','1','1','0','0','0','1','0','1'},
                {'1','1','0','0','0','0','1','0','0','1'},
                {'1','1','1','1','1','1','1','1','1','1'}
        };
        int start_x=8, start_y=8,end_x=1,end_y=7;
        mazeExit(maze, start_x, start_y, end_x, end_y);*/
        browserStack();
    }

    /**
     * @author: xiongcong
     * @Date: 2019/9/23 19:14
     * @Description: 进制转换
     */
    public static void baseConversion(int number, int ary) {

        Stack stack = new Stack();

        while (number > 0) {
            stack.push(number % ary);//取余数
            number = number / ary;
        }
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    /**
     * @author: xiongcong
     * @Date: 2019/9/23 19:15
     * @Description: 括号匹配检测
     */
    public static boolean bracketMatch(String str) {

        Stack stack = new Stack();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            switch (c) {
                //左括号压栈
                case '{':
                case '[':
                case '(':
                    stack.push(c);
                    break;
                case '}':
                    if (!stack.isEmpty() && (char) stack.peek() == '{') {
                        stack.pop();
                        break;
                    } else
                        return false;
                case ']':
                    if (!stack.isEmpty() && (char) stack.peek() == '[') {
                        stack.pop();
                        break;
                    } else
                        return false;
                case ')':
                    if (!stack.isEmpty() && (char) stack.peek() == '(') {
                        stack.pop();
                        break;
                    } else
                        return false;
            }
        }
        //判断为栈空了才返回true
        if (stack.isEmpty()) {
            return true;
        } else
            return false;
    }

    /**
     * @author: xiongcong
     * @Date: 2019/9/23 19:41
     * @Description: 迷宫求解
     *
     *   char[][] maze ={
     *                 {'1','1','1','1','1','1','1','1','1','1'},
     *                 {'1','0','0','1','1','1','0','0','1','1'},
     *                 {'1','0','0','1','1','0','0','1','0','1'},
     *                 {'1','0','0','0','0','0','0','1','0','1'},
     *                 {'1','0','0','0','0','1','1','0','0','1'},
     *                 {'1','0','0','1','1','1','0','0','0','1'},
     *                 {'1','0','0','0','0','1','0','1','0','1'},
     *                 {'1','0','1','1','0','0','0','1','0','1'},
     *                 {'1','1','0','0','0','0','1','0','0','1'},
     *                 {'1','1','1','1','1','1','1','1','1','1'}
     *         };
     *         int start_x=8, start_y=8,end_x=1,end_y=7;
     */
    public static void mazeExit(char[][] maze, int start_x, int start_y, int end_x, int end_y) {
        Cell[][] cellmaze = createMaze(maze);
        printMaze(cellmaze);
        Cell startCell = cellmaze[start_x][start_y];
        Cell endCell = cellmaze[end_x][end_y];

        Stack stack = new Stack();

        stack.push(startCell);
        startCell.isVisited=true;
        while (!stack.isEmpty()) {
            Cell currentCell = (Cell) stack.peek();

            if (currentCell == endCell) {
                System.out.println("找到了从起点到终点的路径：");
                while (!stack.isEmpty()) {//此时堆栈中的即为最后的路径，全部弹出即可
                    Cell cell = (Cell) stack.pop();
                    cell.c = '*';
                    //堆栈中还有记录下来的未继续向下探索的单元  直接弹出
                    while (!stack.isEmpty() && !isAdjoinCell(cell,(Cell)stack.peek())){//不是与当前元素相邻，就直接弹出，避免走弯路
                        stack.pop();
                   }
                }
                printMaze(cellmaze);
            } else {
                int x = currentCell.x;
                int y = currentCell.y;
                int count = 0;
                if (isValidWayCell(cellmaze[x - 1][y])) { //左
                    cellmaze[x - 1][y].isVisited = true;
                    stack.push(cellmaze[x - 1][y]); //入栈
                    count++;
                }
                if (isValidWayCell(cellmaze[x][y - 1])) { //上
                    cellmaze[x][y - 1].isVisited = true;
                    stack.push(cellmaze[x][y - 1]);
                    count++;
                }
                if (isValidWayCell(cellmaze[x + 1][y])) { //右
                    cellmaze[x + 1][y].isVisited = true;
                    stack.push(cellmaze[x + 1][y]);
                    count++;
                }
                if (isValidWayCell(cellmaze[x][y + 1 ])) { //下
                    cellmaze[x][y + 1].isVisited = true;
                    stack.push(cellmaze[x][y + 1]);
                    count++;
                }
                if(count==0) stack.pop();
            }
        }
        if(stack.isEmpty() && !endCell.isVisited){
                    System.out.println("没有路径");
        }
    }
    //判断是否与当前节点相邻  防止走弯路
    public static boolean isAdjoinCell(Cell cell1, Cell cell2) {
        if (cell1.x == cell2.x && Math.abs(cell1.y - cell2.y) < 2) return true;
        if (cell1.y == cell2.y && Math.abs(cell1.x - cell2.x) < 2) return true;
        return false;
    }

    public static boolean isValidWayCell(Cell cell) {
        return (!cell.isVisited) && cell.c == '0';

    }

    //单元格属性
    public static class Cell {
        int x;
        int y;
        char c = ' ';
        boolean isVisited;

        public Cell(int x, int y, char c, boolean isVisited) {
            this.x = x;
            this.y = y;
            this.c = c;
            this.isVisited = isVisited;
        }

    }

    //将二维数组内部元素封装成Cell对象
    public static Cell[][] createMaze(char[][] maze) {
        Cell[][] cell = new Cell[maze.length][];

        for (int i = 0; i < maze.length; i++) {
            char[] row = maze[i]; //hang
            cell[i] = new Cell[row.length];// 每行的长度  迷宫可能不规则
            for (int j = 0; j < row.length; j++) {

                cell[i][j] = new Cell(i, j, maze[i][j], false);
            }
        }
        return cell;
    }

    //print maze
    public static void printMaze(Cell[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                System.out.print(maze[i][j].c+" ");
            }
            System.out.println();
        }
    }

}
