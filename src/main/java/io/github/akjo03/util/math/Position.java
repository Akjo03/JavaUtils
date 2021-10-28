package io.github.akjo03.util.math;

import java.util.Objects;

/**
 * Defines a position on a map (latitude /longitude)
 *
 * @author Lukas Freckmann (Akjo03)
 * @since 2021-10-28
 * @version 0.1.0
 */
public class Position {
	protected final double latitude;
	protected final double longitude;

	public Position(double latitude, double longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double getLatitude() {
		return latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	@Override
	public String toString() {
		return "Position{" + "latitude=" + latitude + ", longitude=" + longitude + '}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Position position = (Position) o;
		return Double.compare(position.latitude, latitude) == 0 && Double.compare(position.longitude, longitude) == 0;
	}

	@Override
	public int hashCode() {
		return Objects.hash(latitude, longitude);
	}
}