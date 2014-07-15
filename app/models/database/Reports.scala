package models.database

import models.ReportEntry
import models.Reports._
import org.joda.time.LocalDate
import play.api.db.slick.Config.driver.simple._

class Reports(tag: Tag) extends Table[ReportEntry](tag, "report") {
  implicit val dateColumnType = MappedColumnType.base[LocalDate, String]({ dateFormatter.print(_) }, { dateFormatter.parseLocalDate })
  def world = column[String]("world", O.DBType("VARCHAR(5)"))
  def date = column[LocalDate]("date", O.DBType("DATE"))
  def detected = column[Int]("detected", O.Default(0))
  def banned = column[Int]("banned", O.Default(0))
  def deleted = column[Int]("deleted", O.Default(0))
  def pk = primaryKey("pk_entry", (world, date))
  def * = (world, date, detected, banned, deleted) <> (ReportEntry.tupled, ReportEntry.unapply)
}
