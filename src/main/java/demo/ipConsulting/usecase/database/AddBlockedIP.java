package demo.ipConsulting.usecase.database;

import lombok.NonNull;

@FunctionalInterface
public interface AddBlockedIP {
    void blockIP(@NonNull String ip);
}
