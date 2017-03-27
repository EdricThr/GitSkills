package com.thr.action;

import org.apache.log4j.Logger;

public class test {

	 //通过Logger的getLogger获取一个Loogger实例
    public Logger lo=Logger.getLogger(test.class);
    public static void main(String[] args) {
       new test().ttt();
    }
    public void ttt(){
    	 try {
    		 lo.info("除数不能为0---------------");
             int result=5/0;//出现异常
         } catch (Exception e) {
             System.out.println("除数不能为零！");
             lo.info("除数不能为0");//保存日志
         }
    }
}
