package pt.isel.daw.LI61N.g10.dawproject.Helpers

import java.time.ZoneId
import java.time.Instant
import java.time.LocalDateTime
import java.util.*


class TimeConverter {

    companion object {


        fun convertToLocalDateTimeViaInstant(dateToConvert: Date): LocalDateTime {
            return dateToConvert.toInstant()
                    .atZone(ZoneId.systemDefault())
                    .toLocalDateTime()
        }

        fun convertToDateViaInstant(dateToConvert: LocalDateTime): Date {
            return java.util.Date
                    .from(dateToConvert.atZone(ZoneId.systemDefault())
                            .toInstant())
        }
    }
}