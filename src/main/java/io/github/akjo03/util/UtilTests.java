package io.github.akjo03.util;

import io.github.akjo03.util.math.Length;
import io.github.akjo03.util.math.units.LengthUnit;

public class UtilTests {
	public static void main(String[] args) {
		System.out.println(new Length(3.1, LengthUnit.METER).convert(LengthUnit.FEET).convert(LengthUnit.CENTIMETER).compareTo(new Length(3.0, LengthUnit.METER)));
		System.out.println(new Length(3.1, LengthUnit.METER).convert(LengthUnit.FEET).convert(LengthUnit.CENTIMETER).compareTo(new Length(3.1, LengthUnit.METER)));
		System.out.println(new Length(3.1, LengthUnit.METER).convert(LengthUnit.FEET).convert(LengthUnit.CENTIMETER).compareTo(new Length(3.2, LengthUnit.METER)));
	}
}