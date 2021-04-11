package org.codepository.mytoko.repositories;

import java.util.Vector;

public abstract class Repository {
    public abstract Object get(String username);
    public abstract Object add(Object o);
}
