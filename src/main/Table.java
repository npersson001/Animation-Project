package main;

import util.annotations.Tags;

@Tags("Table")
public interface Table<S,O> {
	public void put(S key, O val);
	public O get(String key);
}
