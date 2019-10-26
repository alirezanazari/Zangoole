package ir.alirezanazari.data.entity

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.alirezanazari.domain.entity.SnoozeEntity
import ir.alirezanazari.domain.entity.enums.AlarmType

const val ALARM_TBL_NAME = "ALARM_TABLE"

@Entity(tableName = ALARM_TBL_NAME)
data class AlarmModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int? = null,
    val time: String,
    val dates: String, // split it with ','
    val name: String,
    val vibrate: Boolean,
    val sound: String,
    @Embedded(prefix = "snooze_")
    val snooze: SnoozeEntity,
    val type: AlarmType
)