package ir.alirezanazari.data.repository

import io.reactivex.Observable
import ir.alirezanazari.data.db.AlarmDao
import ir.alirezanazari.data.entity.AlarmModel
import ir.alirezanazari.domain.entity.AlarmEntity
import ir.alirezanazari.domain.repository.AlarmRepository

class AlarmRepositoryImpl(
    private val alarmDb: AlarmDao
) : AlarmRepository {

    override fun getAlarmById(id: Int): Observable<AlarmEntity> {
        return alarmDb.getAlarmById(id).map {
            convertAlarm(it)
        }
    }

    override fun getAlarms(): Observable<List<AlarmEntity>> {
        return alarmDb.getAlarms().map {
            it.map { entity ->
                convertAlarm(entity)
            }
        }
    }

    override fun upsertAlarm(alarm: AlarmEntity): Observable<Boolean> {
        return alarmDb.upsert(convertAlarmForDb(alarm))
    }

    //helpers
    private fun convertAlarm(alarm: AlarmModel): AlarmEntity {
        return AlarmEntity(
            alarm.id, alarm.time, alarm.dates, alarm.name,
            alarm.vibrate, alarm.sound, alarm.snooze, alarm.type
        )
    }

    private fun convertAlarmForDb(alarm: AlarmEntity): AlarmModel {
        return AlarmModel(
            alarm.id, alarm.time, alarm.dates, alarm.name,
            alarm.vibrate, alarm.sound, alarm.snooze, alarm.type
        )
    }

}