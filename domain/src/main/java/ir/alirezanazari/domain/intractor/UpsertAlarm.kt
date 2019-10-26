package ir.alirezanazari.domain.intractor

import io.reactivex.Observable
import io.reactivex.Scheduler
import ir.alirezanazari.domain.entity.AlarmEntity
import ir.alirezanazari.domain.repository.AlarmRepository


class UpsertAlarm(
    private val repo: AlarmRepository,
    io: Scheduler,
    ui: Scheduler
) : UseCase<Boolean, AlarmEntity>(io, ui) {

    override fun build(param: AlarmEntity): Observable<Boolean> {
        return repo.upsertAlarm(param)
    }

}