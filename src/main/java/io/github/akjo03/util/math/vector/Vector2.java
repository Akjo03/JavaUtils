package io.github.akjo03.util.math.vector;

import lombok.Getter;
import lombok.Setter;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

public class Vector2 {
	@Getter @Setter
	private double x;
	@Getter @Setter
	private double y;

	public Vector2(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public Vector2(@NotNull Vector2 vector) {
		this.x = vector.getX();
		this.y = vector.getY();
	}

	public double getDistanceTo(@NotNull Vector2 vector) {
		return Math.sqrt(Math.pow(vector.getX() - x, 2) + Math.pow(vector.getY() - y, 2));
	}

	public double getDistanceTo(@NotNull Vector2 vector, @NotNull Vector2 origin) {
		return Math.sqrt(Math.pow(vector.getX() - origin.getX(), 2) + Math.pow(vector.getY() - origin.getY(), 2));
	}

	public Vector2 getMagnitude() {
		return new Vector2(Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2)), 0);
	}

	public Vector2 getNormalized() {
		return new Vector2(x / getMagnitude().getX(), y / getMagnitude().getY());
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		Vector2 vector2 = (Vector2) o;
		return x == vector2.x && y == vector2.y;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}
}