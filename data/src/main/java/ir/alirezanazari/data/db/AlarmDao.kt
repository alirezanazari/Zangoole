package ir.alirezanazari.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Observable
import ir.alirezanazari.data.entity.ALARM_TBL_NAME
import ir.alirezanazari.data.entity.AlarmModel

@Dao
interface AlarmDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(alarm: AlarmModel)

    @Query("select * from $ALARM_TBL_NAME")
    fun getAlarms(): Observable<List<AlarmModel>>

    @Query("select * from $ALARM_TBL_NAME where id = :id")
    fun getAlarmById(id: Int): Observable<AlarmModel>
}