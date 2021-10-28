package io.github.akjo03.util.math.units;

import java.math.BigDecimal;

/**
 * Unit of length
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-28
 * @version 0.1.0
 */
@SuppressWarnings("unused")
public enum LengthUnit implements Unit {
	PLANCK(new BigDecimal("0.000000000000000000000000000000000016")),
	TWIP(new BigDecimal("0.000017638888888888")),
	ANGSTROEM(new BigDecimal("0.0000000001")),
	NANOMETER(new BigDecimal("0.000000001")),
	HU(new BigDecimal("0.000000333333333")),
	MICROMETER(new BigDecimal("0.000001")),
	SI(new BigDecimal("0.000003333333333")),
	THOU(new BigDecimal("0.0000254")),
	HAO(new BigDecimal("0.000033333333333")),
	CHARRIERE(new BigDecimal("0.000333333333333")),
	POINT(new BigDecimal("0.000352777777777")),
	MILLIMETER(new BigDecimal("0.001")),
	LINE(new BigDecimal("0.002116666666666")),
	FEN(new BigDecimal("0.003333333333333")),
	CENTIMETER(new BigDecimal("0.01")),
	INCH(new BigDecimal("0.0254")),
	CUN(new BigDecimal("0.033333333333333")),
	DECIMETER(new BigDecimal("0.1")),
	LINK(new BigDecimal("0.201168")),
	FEET(new BigDecimal("0.3048")),
	CHI(new BigDecimal("0.333333333333333")),
	YARD(new BigDecimal("0.9144")),
	METER(new BigDecimal("1.0")),
	BU(new BigDecimal("1.666666666666666")),
	FATHOM(new BigDecimal("1.8288")),
	ZHANG(new BigDecimal("3.333333333333333")),
	DECAMETER(new BigDecimal("10.0")),
	YIN(new BigDecimal("33.333333333333333")),
	HECTOMETER(new BigDecimal("100.0")),
	FURLONG(new BigDecimal("201.168")),
	LI(new BigDecimal("500")),
	KILOMETER(new BigDecimal("1000")),
	MILE(new BigDecimal("1609.344")),
	NAUTICAL_MILE(new BigDecimal("1852")),
	LIGHT_SECOND(new BigDecimal("299792458")),
	ASTRONOMICAL_UNIT(new BigDecimal("149597870700")),
	LIGHT_YEAR(new BigDecimal("9454254955488000")),
	PARSEC(new BigDecimal("30856776000000000"));

	/**
	 * METER / divisor = UNIT
	 */
	private final BigDecimal divisor;

	LengthUnit(BigDecimal divisor) {
		this.divisor = divisor;
	}

	@Override
	public BigDecimal getDivisor() {
		return divisor;
	}

	@Override
	public String toString() {
		return "LengthUnit." + name() + "{" + "divisor=" + divisor + '}';
	}
}