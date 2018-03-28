package com.innerclass;

public class TestMain {

	public Animal voar(){
		return new Animal() {
			
			@Override
			void mover() {
				System.out.println("Voar");
			}
		};
	}
	
	public Animal nadar(){
		return new Animal() {
			
			@Override
			void mover() {
				System.out.println("Nadar");
			}
		};
	}
	
	public static void main(String[] args) {
		TestMain main = new TestMain();
		main.voar().mover();
		main.nadar().mover();
	}

}
