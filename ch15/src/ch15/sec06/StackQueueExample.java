package ch15.sec06;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class StackQueueExample {
	public static void main(String[] args) {
		//Stack 경우
		System.out.println("Coin Stack Case");
		Stack<Coin> coinBox = new Stack<>();
		coinBox.push(new Coin(100));
		coinBox.push(new Coin(50));
		coinBox.push(new Coin(500));
		coinBox.push(new Coin(10));
		while (!coinBox.isEmpty()) {
			Coin coin = coinBox.pop();
			System.out.println("꺼낸 동전: " + coin.getValue() + "원");
		}
		
		//Queue 경우
		System.out.println("Coin Queue Case");
		Queue<Coin> coinQueue = new LinkedList<>();
		coinQueue.offer(new Coin(100));
		coinQueue.offer(new Coin(50));
		coinQueue.offer(new Coin(500));
		coinQueue.offer(new Coin(10));
		while (!coinQueue.isEmpty()) {
			Coin coin = coinQueue.poll();
			System.out.println("꺼낸 동전: " + coin.getValue() + "원");
		}
	}
}
