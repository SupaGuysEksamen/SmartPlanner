package dk.ek.smartplanner.repository;

import dk.ek.smartplanner.model.User;

public interface UserRepository {
    User findByEmail(String email);

    boolean emailExists(String email);
}
