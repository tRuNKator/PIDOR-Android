package com.applepride.pidor.model.repository;

import com.applepride.pidor.model.object.TodoItem;

import java.util.ArrayList;
import java.util.List;

/**
 * Just an example stuff, lives in memory only
 * PLEASE DO NOT USE THIS IN ANY ACTUAL PROJECT
 */
public final class TodoRepository implements IExampleRepository {

    private static TodoRepository _instance;
    private List<RepositoryChangedListener> listeners = new ArrayList<>();
    private List<TodoItem> items;
    private int counter = 0;

    private TodoRepository() {
        items = new ArrayList<>();
        items.add(new TodoItem(counter++, "GET MILK"));
        items.add(new TodoItem(counter++, "PICK PAYCHECK"));
        items.add(new TodoItem(counter++, "UNCLE DAVE'S B DAY"));
        items.add(new TodoItem(counter++, "GO TO CLINIC"));
    }

    public static IExampleRepository instance() {
        // DO NOT DO THIS IN REAL CODE!!!!
        // DO NOT DO THIS IN REAL CODE!!!!
        // DO NOT DO THIS IN REAL CODE!!!!
        // DO NOT DO THIS IN REAL CODE!!!!
        if (_instance == null) {
            _instance = new TodoRepository();
        }
        return _instance;
        // DO NOT DO THIS IN REAL CODE!!!!
        // DO NOT DO THIS IN REAL CODE!!!!
        // DO NOT DO THIS IN REAL CODE!!!!
        // DO NOT DO THIS IN REAL CODE!!!!
    }

    @Override
    public List<TodoItem> getItems() {
        return items;
    }

    @Override
    public void addListener(RepositoryChangedListener listener) {
        listeners.add(listener);
    }

    @Override
    public void removeListener(RepositoryChangedListener listener) {
        if (listeners.contains(listener)) {
            listeners.remove(listener);
        }
    }

    @Override
    public void addItem(String value) {
        counter++;
        TodoItem todoItem = new TodoItem(counter, value);
        items.add(todoItem);
        for (RepositoryChangedListener listener : listeners) {
            listener.onChanged();
        }
    }

    @Override
    public TodoItem getItem(int id) {
        try {
            return items.get(id);
        } catch (Exception e) {
            return null;
        }
    }
}
