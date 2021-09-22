package CounterStriker.repositories;

import CounterStriker.models.guns.Gun;

import java.util.Collection;

import static CounterStriker.common.ExceptionMessages.INVALID_GUN_REPOSITORY;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> models;

    @Override
    public Collection<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(INVALID_GUN_REPOSITORY);
        }
        this.models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return this.models.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        return this.models.stream()
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElse(null);
    }
}