package ru.cos.sim.ras.duo.utils;

public class Pair<T1, T2> {
	public Pair(T1 first, T2 second) {
		this.first = first;
		this.second = second;
	}
	
	private T1 first;
	public T1 getFirst() {
		return first;
	}
	
	private T2 second;
	public T2 getSecond() {
		return second;
	}
}
