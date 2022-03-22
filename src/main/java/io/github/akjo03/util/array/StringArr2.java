package io.github.akjo03.util.array;

import java.util.Arrays;

/**
 * This class is used to store a 2 Strings in one array.
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-11-20
 * @version 1.0.0
 */
public class StringArr2 {
	private final String[] arr = new String[2];

	public StringArr2(String a, String b) {
        arr[0] = a;
        arr[1] = b;
    }

	public String getFirst() {
        return arr[0];
    }

	public String getSecond() {
        return arr[1];
    }

	@Override
	public String toString() {
		return "[1: " + arr[0] + ", 2: " + arr[1] + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		StringArr2 that = (StringArr2) o;
		return Arrays.equals(arr, that.arr);
	}

	@Override
	public int hashCode() {
		return Arrays.hashCode(arr);
	}
}