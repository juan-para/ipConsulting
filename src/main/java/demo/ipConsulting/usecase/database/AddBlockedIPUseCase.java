package demo.ipConsulting.usecase.database;

import demo.ipConsulting.model.dto.BlockIPResponse;
import lombok.NonNull;

@FunctionalInterface
public interface AddBlockedIPUseCase {
    BlockIPResponse blockIP(@NonNull String ip);
}
