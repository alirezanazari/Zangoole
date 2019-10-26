package ir.alirezanazari.domain.entity

import ir.alirezanazari.domain.entity.enums.AlarmType


data class AlarmEntity (
    val id: Int? = null,
    val time : String,
    val dates: String,
    val name : String,
    val vibrate : Boolean,
    val sound : String,
    val snooze : SnoozeEntity,
    val type : AlarmType
)