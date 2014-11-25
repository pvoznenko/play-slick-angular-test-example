package database

import dao.ReportsDAO._
import dto.Report
import org.joda.time.LocalDate
import play.api.db.slick.Config.driver.simple._
import play.api.db.slick._
import play.api.Play.current

object ReportsDatabase {
  val reports = TableQuery[Reports]

  implicit val session = DB.createSession()

  // test data
  reports ++= Seq(
    Report("de1", new LocalDate("2014-07-01"), 10, 4, 1),
    Report("de1", new LocalDate("2014-07-02"), 12, 2, 0),
    Report("en2", new LocalDate("2014-07-03"), 8, 1, 1),
    Report("en2", new LocalDate("2014-07-04"), 14, 5, 3),
    Report("ua", new LocalDate("2014-07-05"), 10, 3, 2),
    Report("ru", new LocalDate("2014-07-06"), 4, 0, 0),
    Report("dk", new LocalDate("2014-07-07"), 2, 2, 1))
}

class Reports(tag: Tag) extends Table[Report](tag, "report") {
  implicit val dateColumnType = MappedColumnType.base[LocalDate, String]({ dateFormatter.print(_) }, { dateFormatter.parseLocalDate })
  def world = column[String]("world", O.DBType("VARCHAR(5)"))
  def date = column[LocalDate]("date", O.DBType("DATE"))
  def detected = column[Int]("detected", O.Default(0))
  def banned = column[Int]("banned", O.Default(0))
  def deleted = column[Int]("deleted", O.Default(0))
  def pk = primaryKey("pk_entry", (world, date))
  def * = (world, date, detected, banned, deleted) <> (Report.tupled, Report.unapply)
}
