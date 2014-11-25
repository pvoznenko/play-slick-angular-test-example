package controllers

import dao.ReportsDAO
import dto.Report
import play.api.Routes
import play.api.mvc._
import play.api.mvc.Action
import play.api.libs.json._

object Reports extends Controller {

  def index = Action(Ok(views.html.index()))

  /**
   * Method return rows from DB for reports with specified limit, and filters like from date, to date, which world and how to sort
   */
  def reports(offset: Int, limit: Int, fromDate: Option[String], toDate: Option[String], world: Option[String], field: Option[String], sort: Option[String]) = Action { implicit request =>
    implicit val reportEntryWrites = Json.writes[Report]

    Ok(Json.obj(
      "rows" -> Json.toJson(ReportsDAO.getReports(offset, limit, fromDate, toDate, world, field, sort)),
      "totalRows" -> Json.toJson(ReportsDAO.getTotalReports(fromDate, toDate, world)),
      "totalDetected" -> Json.toJson(ReportsDAO.getSumDetected(fromDate, toDate, world)),
      "totalBanned" -> Json.toJson(ReportsDAO.getSumBanned(fromDate, toDate, world)),
      "totalDeleted" -> Json.toJson(ReportsDAO.getSumDeleted(fromDate, toDate, world))))
  }

  /**
   * Method returns distinct list of worlds in report table in DB, like: de2, dk1, en8, etc
   */
  def worldsList = Action { request => Ok(Json.toJson(ReportsDAO.getWorldsList)) }

  def jsRoutes(varName: String = "jsRoutes") = Action { implicit request =>
    Ok(Routes.javascriptRouter(varName)(
      routes.javascript.Report.reports,
      routes.javascript.Report.worldsList
    )).as(JAVASCRIPT)
  }
}