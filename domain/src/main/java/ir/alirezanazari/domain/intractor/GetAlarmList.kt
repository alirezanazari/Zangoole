package ir.alirezanazari.domain.intractor

import io.reactivex.Observable
import io.reactivex.Scheduler
import ir.alirezanazari.domain.entity.AlarmEntity
import ir.alirezanazari.domain.repository.AlarmRepository


class GetAlarmList(
    private val repo: AlarmRepository,
    io: Scheduler,
    ui: Scheduler
) : UseCaseNoParam<List<AlarmEntity>>(io, ui) {

    override fun build(): Observable<List<AlarmEntity>> {
        return repo.getAlarms()
    }

}