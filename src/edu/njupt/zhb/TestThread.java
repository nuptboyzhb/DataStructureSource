/*
 * $filename: TestThread.java,v $
 * $Date: 2014-3-16  $
 * Copyright (C) ZhengHaibo, Inc. All rights reserved.
 * This software is Made by Zhenghaibo.
 */
package edu.njupt.zhb;

import java.io.IOException;
import java.net.ServerSocket;

import javax.rmi.CORBA.Tie;

/*
 *@author: ZhengHaibo  
 *web:     http://blog.csdn.net/nuptboyzhb
 *mail:    zhb931706659@126.com
 *2014-3-16  Nanjing,njupt,China
 */
public class TestThread {
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Thread t1=new Thread(){
			@Override
			public void run(){
				try {
					int i=0;
					while (i++<100000000){
						//nothing
					}
					System.out.println("A1");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("B1");
				}
			}
		};
		t1.start();
		t1.interrupt();//无法中断正在运行的线程
		try {
			t1.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		Thread t2=new Thread(){
			@Override
			public void run(){
				try {
					Thread.sleep(5000);
					System.out.println("A2");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("B2 "+e.toString());
				}
			}
		};
		t2.start();
		t2.interrupt();//可以中断正在休眠的线程，并抛出异常
		try {
			t2.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
		Thread t3=new Thread(){
			@Override
			public void run(){
				try {
					this.wait(5000);
					System.out.println("A3");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("B3 "+e.toString());
				}
			}
		};
		t3.start();
		t3.interrupt();
		
		try {
			t3.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		Thread t4=new Thread(){
			@Override
			public void run(){
				try {
					synchronized (this) {
						this.wait(5000);
					}
					System.out.println("A4");
				} catch (Exception e) {
					// TODO: handle exception
					System.out.println("B4 "+e.toString());
				}
			}
		};
		t4.start();
		t4.interrupt();
		try {
			t4.join();
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			final ServerSocket serverSocket=new ServerSocket(8080);
			
			Thread t5=new Thread(){
				@Override
				public void run(){
					try {
						serverSocket.accept();
						System.out.println("A5");
					} catch (Exception e) {
						// TODO: handle exception
						System.out.println("B5 "+e.toString());
					}
				}
			};
			t5.start();
			t5.interrupt();//无法中断
			t5.stop();//线程停止
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			t4.start();
			System.out.println("A6");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("B6 "+ e.toString());
		}
	}

}
