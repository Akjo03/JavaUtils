package io.github.akjo03.util.error;

import io.github.akjo03.util.logging.Logger;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class ExceptionCollection extends AbstractList<Exception> {
	private final List<Exception> exceptions;

	public ExceptionCollection() {
		this.exceptions = new ArrayList<>();
	}

	@Override
	public boolean add(Exception e) {
		return exceptions.add(e);
	}

	public void throwAll() throws Exception {
		for (Exception t : this.exceptions) {
			throw t;
		}
	}

	public void throwAll(Logger logger) throws Exception {
		if (exceptions.size() == 0) {
			return;
		}
		for (Exception t : this.exceptions) {
			logger.log(t, "Exception collected!");
		}
		throw this.exceptions.get(0);
	}

	@Override
	public int size() {
		return exceptions.size();
	}

	@Override
	public Exception get(int index) {
		return exceptions.get(index);
	}
}