package com.thr.action;

import org.apache.log4j.Logger;

public class test {

	 //ͨ��Logger��getLogger��ȡһ��Looggerʵ��
    public Logger lo=Logger.getLogger(test.class);
    public static void main(String[] args) {
       new test().ttt();
    }
    public void ttt(){
    	 try {
    		 lo.info("��������Ϊ0---------------");
             int result=5/0;//�����쳣
         } catch (Exception e) {
             System.out.println("��������Ϊ�㣡");
             lo.info("��������Ϊ0");//������־
         }
    }
}
