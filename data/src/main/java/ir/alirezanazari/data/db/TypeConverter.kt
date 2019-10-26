package ir.alirezanazari.data.db

import androidx.room.TypeConverter
import ir.alirezanazari.domain.entity.enums.AlarmType


object TypeConverter {

    @TypeConverter
    @JvmStatic
    fun alarmTypeToString(alarmType: AlarmType?) = alarmType?.name

    @TypeConverter
    @JvmStatic
    fun stringToAlarmType(str: String): AlarmType {
        return AlarmType.valueOf(str)
    }


}