package ir.alirezanazari.domain.repository

import io.reactivex.Observable
import ir.alirezanazari.domain.entity.AlarmEntity


interface AlarmRepository {

    fun getAlarmById(id:Int) : Observable<AlarmEntity>

    fun getAlarms() : Observable<List<AlarmEntity>>

    fun upsertAlarm(alarm: AlarmEntity): Observable<Boolean>

}