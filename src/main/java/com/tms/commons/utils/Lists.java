package com.tms.commons.utils;

import java.util.ArrayList;
import java.util.List;

public class Lists {
	
	public static <E> List<E> newArrayList() {
		 return new ArrayList<>();
	}
	
	public static <E> List<E> newArrayList(int capacity) {
		 return new ArrayList<>(capacity);
	}
}
