package com.gameutils.entity.script;

import com.gameutils.entity.EntityBase;

/**
 * Created by Nicolas Wiedel on 05.01.2019.
 */
public abstract class EntityScriptBase<T extends EntityBase> implements EntityScript<T> {

    // == attributes ==
    private boolean finished;

    protected T entity;

    // == public methods ==
    @Override
    public void added(T entity) {
        this.entity = entity;
    }

    @Override
    public void removed(T removed) {
        this.entity = null;
    }

    @Override
    public boolean isFinished() {
        return finished;
    }

    protected void finish() {
        finished = true;
    }
}
