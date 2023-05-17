package com.callor.controller;

public class ControllerC {
	
	public static void main(String[] args) {
		
		for(int i=0; i< 20 ; i++) {
			if(i % 2 == 1) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		for(int i=0; i< 20 ; i+=2) {
			System.out.print(i + 1 + " ");
		}
	}

}
