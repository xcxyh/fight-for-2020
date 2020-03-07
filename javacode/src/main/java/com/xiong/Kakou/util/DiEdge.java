/**  
* @Title: DiEdge.java
* @Package:main.java.com.huawei
* @Description:(作用)
* @author: xcc 
* @date:2019年3月15日
* @version:V1.0  
*/
package com.xiong.Kakou.util;

/**  
* @Title: DiEdge.java
* @Package:main.java.com.huawei
* @Description:有向边
* @author: xcc 
* @date:2019年3月15日
* @version:V1.0  
*/
public class DiEdge {
	 private int from;
	    private int to;
	    private double weight;

	    public DiEdge(int from, int to, double weight) {
	        this.from = from;
	        this.to = to;
	        this.weight = weight;
	    }

	    public int from() {
	        return from;
	    }

	    public int to() {
	        return to;
	    }

	    public double weight() {
	        return weight;
	    }
	    
	    @Override
	    public String toString() {
	        return 
	                from +
	                "->" + to ;
	    }
}
