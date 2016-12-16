package com.maedi.user.godok.v1.utils;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

import android.support.v4.app.FragmentActivity;

public class TaskHelper {
	public final WeakHashMap<String, WeakReference<BaseTask>> tasks = new WeakHashMap<String, WeakReference<BaseTask>>();
	private static TaskHelper instance;

	public static TaskHelper getInstance() {
		if (instance == null) {
			synchronized (TaskHelper.class) {
				if (instance == null) {
					instance = new TaskHelper();
				}
			}
		}
		return instance;
	}

	public void attachActivity(String key, FragmentActivity o) {
		BaseTask task = getTask(key);
		if (task != null) {
			task.attachActivity(o);
		}
	}

	public void detachActivity(String key) {
		if (tasks.containsKey(key) && tasks.get(key) != null
				&& tasks.get(key).get() != null) {
			tasks.get(key).get().detachActivity();
		}
	}

	public void addTask(String key, BaseTask task, FragmentActivity o) {
		detachActivity(key);
		tasks.put(key, new WeakReference<BaseTask>(task));
		if (o != null) {
			attachActivity(key, o);
		}
	}
	
	public BaseTask getTask(String key) {
		return tasks.get(key) == null ? null : tasks.get(key).get();
	}

	 public void removeTask(String key)
	 {
		 detachActivity(key);
		 tasks.remove(key);
	 }
}
