package ir.alirezanazari.domain.intractor

import io.reactivex.Observable
import io.reactivex.Scheduler
import ir.alirezanazari.domain.entity.AlarmEntity
import ir.alirezanazari.domain.repository.AlarmRepository


class GetAlarm(
    private val repo: AlarmRepository,
    io: Scheduler,
    ui: Scheduler
) : UseCase<AlarmEntity, Int>(io, ui) {

    override fun build(param: Int): Observable<AlarmEntity> {
        return repo.getAlarmById(param)
    }

}