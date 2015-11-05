package no.nith.pg5100.infrastructure.user;

import no.nith.pg5100.dto.User;

import java.util.List;

public class JpaUserDao implements UserDao {
    @Override
    public User persist(User user) {
        return null;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return null;
    }

    @Override
    public boolean remove(User user) {
        return false;
    }
}
