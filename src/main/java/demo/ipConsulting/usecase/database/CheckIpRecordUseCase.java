package demo.ipConsulting.usecase.database;

import lombok.NonNull;

@FunctionalInterface
public interface CheckIpRecordUseCase {
    boolean checkIpExistence(@NonNull String ip);
}
