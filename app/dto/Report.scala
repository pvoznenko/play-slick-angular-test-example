package dto

import org.joda.time.LocalDate

case class Report(world: String, date: LocalDate, detected: Int, banned: Int, deleted: Int)
