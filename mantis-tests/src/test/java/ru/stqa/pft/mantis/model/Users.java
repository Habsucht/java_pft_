package ru.stqa.pft.mantis.model;

import com.google.common.collect.ForwardingSet;
import ru.stqa.pft.mantis.data.UserData;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Users extends ForwardingSet<UserData> {

    private Set<UserData> delegate;

    public Users() {
        this.delegate = new HashSet<>();
    }

    public Users(Users users) {
        this.delegate = new HashSet<>(users.delegate);
    }

    public Users(Collection<UserData> users) {
        this.delegate = new HashSet<>(users);
    }

    @Override
    protected Set delegate() {
        return delegate;
    }

    public Users withAdded(UserData user) {
        Users users = new Users(this);
        users.add(user);
        return users;
    }

    public Users withOut(UserData user) {
        Users users = new Users(this);
        users.remove(user);
        return users;
    }
}
