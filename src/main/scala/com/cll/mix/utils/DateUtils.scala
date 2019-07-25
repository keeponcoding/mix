package com.cll.mix.utils

import java.sql.Timestamp
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

import org.apache.commons.lang3.time.FastDateFormat

import scala.collection.mutable.ArrayBuffer

/**
  * @ClassName DateUtils
  * @Description 时间工具类
  * @Author cll
  * @Date 2019-07-25 14:47
  * @Version 1.0
  **/
object DateUtils {

  val formatPattern_yyyyMMddHH = "yyyyMMddHH"
  val formatPattern_yyyyMMdd = "yyyyMMdd"

  val TIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd HH:mm:ss")
  val TIME_FORMAT2 = FastDateFormat.getInstance("yyyy-MM-ddHH:mm:ss")
  val TIME_FORMAT3 = FastDateFormat.getInstance("yyyy-MM-dd HH:mm")
  val DATE_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd")
  val DATETIME_FORMAT = FastDateFormat.getInstance("yyyy-MM-dd 00:00:00")
  val HHMMSS_FORMAT = FastDateFormat.getInstance("HH:mm:ss")
  val TIMEASKEY_FORMAT = FastDateFormat.getInstance("yyyyMMddHHmmss")
  val HOURSASKEY_FORMAT = FastDateFormat.getInstance("yyyyMMddHH")
  val DATEASKEY_FORMAT = FastDateFormat.getInstance("yyyyMMdd")
  val MONTHASKEY_FORMAT = FastDateFormat.getInstance("yyyyMM")

  val TIME_REGEX = """\d{4}-\d{1,2}-\d{1,2}\s+\d{1,2}:\d{1,2}:\d{1,2}[.]?\d*""".r
  val TIME_REGEX2 = """\d{4}-\d{1,2}-\d{1,2}\d{1,2}:\d{1,2}:\d{1,2}""".r
  val TIME_REGEX3 = """\d{4}-\d{1,2}-\d{1,2}\s+\d{1,2}:\d{1,2}""".r
  val DATE_REGEX = """\d{4}-\d{1,2}-\d{1,2}""".r
  val TIMEASKEY_REGEX = """\d{4}\d{2}\d{2}\d{2}\d{2}\d{2}""".r
  val DATEASKEY_REGEX = """\d{4}\d{2}\d{2}""".r
  val YYYYMM_REGEX = """\d{4}\d{2}""".r
  val HHMM_REGEX = """\d{1,2}:\d{1,2}""".r//新增处理hh:mi格式的正则表达式
  val HHMMSS_REGEX = """\d{1,2}:\d{1,2}:\d{1,2}[.]?\d*""".r//新增处理hh:mi:ss格式的正则表达式
  /**
    * 将字符串转换为时间
    * @param text 源字符串
    *
    * @return
    */
  def parse(text: String): Date = {
    if(text != null && !"".equals(text)){
      val TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
      val TIME_FORMAT2 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss")
      val TIME_FORMAT3 = new SimpleDateFormat("yyyy-MM-dd HH:mm")
      val DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd")
      val HHMMSS_FORMAT = new SimpleDateFormat("HH:mm:ss")
      val HHMMSS_FORMAT2 = new SimpleDateFormat("HH:mm")
      val TIMEASKEY_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss")
      val DATEASKEY_FORMAT = new SimpleDateFormat("yyyyMMdd")
      val YYYYMM_FORMAT = new SimpleDateFormat("yyyyMM")
      text match {
        case TIME_REGEX(_*) => TIME_FORMAT.parse(text)
        case TIME_REGEX2(_*) => TIME_FORMAT2.parse(text)
        case TIME_REGEX3(_*) => TIME_FORMAT3.parse(text) //新增,处理yyyy-MM-dd HH:mm格式
        case DATE_REGEX(_*) => DATE_FORMAT.parse(text)
        case TIMEASKEY_REGEX(_*) => TIMEASKEY_FORMAT.parse(text)
        case DATEASKEY_REGEX(_*) => DATEASKEY_FORMAT.parse(text)
        case YYYYMM_REGEX(_*) => YYYYMM_FORMAT.parse(text)
        case HHMMSS_REGEX(_*) =>HHMMSS_FORMAT.parse(text)//新增,处理hh:mi:ss格式
        case HHMM_REGEX(_*) =>HHMMSS_FORMAT2.parse(text)//新增,处理hh:mi格式
        case _ => null
      }
    } else {null}
  }

  /**
    * 将字符串转换为时间戳
    * @param text 源字符串
    * @return
    */
  def parseTimeStamp(text: String): Timestamp = {
    val TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    val TIME_FORMAT2 = new SimpleDateFormat("yyyy-MM-ddHH:mm:ss")
    val DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd")
    val HHMMSS_FORMAT = new SimpleDateFormat("HH:mm:ss")
    val TIMEASKEY_FORMAT = new SimpleDateFormat("yyyyMMddHHmmss")
    val DATEASKEY_FORMAT = new SimpleDateFormat("yyyyMMdd")
    text match {
      case TIME_REGEX(_*) => new Timestamp(TIME_FORMAT.parse(text).getTime)
      case TIME_REGEX2(_*) => new Timestamp(TIME_FORMAT2.parse(text).getTime)
      case DATE_REGEX(_*) => new Timestamp(DATE_FORMAT.parse(text).getTime)
      case TIMEASKEY_REGEX(_*) => new Timestamp(TIMEASKEY_FORMAT.parse(text).getTime)
      case DATEASKEY_REGEX(_*) => new Timestamp(DATEASKEY_FORMAT.parse(text).getTime)
      case _ => null
    }
  }

  /**
    * 将时间转换为字符串
    * @param date 时间
    * @param pattern 传入时间的模式:
    *                TIME-时间格式(YYYY-MM-DD HH:MM:SS)
    *                DATE-日期格式(YYYY-MM-DD)
    *                TIMEASKEY-时间作为KEY的格式(YYYYMMDDHHMMSS)
    *                DATEASKEY-日期作为KEY的格式(YYYYMMDD)
    *
    * @return
    */
  def format(date: Date,pattern: String):String = {
    pattern match {
      case "TIME" => TIME_FORMAT.format(date)
      case "DATE" => DATE_FORMAT.format(date)
      case "DATETIME" => DATETIME_FORMAT.format(date)
      case "HOURSASKEY" => HOURSASKEY_FORMAT.format(date)
      case "TIMEASKEY" => TIMEASKEY_FORMAT.format(date)
      case "DATEASKEY" => DATEASKEY_FORMAT.format(date)
      case "MONTHASKEY" => MONTHASKEY_FORMAT.format(date)
      case "HHMMSS" => HHMMSS_FORMAT.format(date)
      case "YMDHM" => TIME_FORMAT3.format(date)
      case _ => null
    }
  }

  /**
    * 依据出入的模式将时间转换为字符串
    * @param date 时间
    * @param pattern 传入时间的模式:
    *
    * @return
    */
  def formatByPattern(date: Date,pattern: String):String = {

    //最终结果
    var retTime = "";

    //格式化数据
    try{
      val format = FastDateFormat.getInstance(pattern)
      retTime =  format.format(date);
    }catch {
      case e: Throwable => { //do nothing
      }
    }

    //统一处理 "" 处理为null
    if("" == retTime){
      retTime = null;
    }
    retTime;
  }

  /**
    * 将时间转换为字符串
    * @param date1 时间字符串
    * @param pattern 传入时间的模式:
    *                TIME-时间格式(YYYY-MM-DD HH:MM:SS)
    *                DATE-日期格式(YYYY-MM-DD)
    *                TIMEASKEY-时间作为KEY的格式(YYYYMMDDHHMMSS)
    *                DATEASKEY-日期作为KEY的格式(YYYYMMDD)
    *
    * @return
    */
  def format(date1: String,pattern: String):String = {
    if(date1 != null){
      var date = parse(date1)
      if(date != null) {
        pattern match {
          case "TIME" => {date1.r match {
            case TIME_REGEX(_*) => TIME_FORMAT.format(date)
            case TIME_REGEX2(_*) => TIME_FORMAT2.format(date)
            case _ => null
          }
          }
          case "DATE" => DATE_FORMAT.format(date)
          case "DATETIME" => DATETIME_FORMAT.format(date)
          case "TIMEASKEY" => TIMEASKEY_FORMAT.format(date)
          case "HOURSASKEY" => HOURSASKEY_FORMAT.format(date)
          case "MONTHASKEY" => MONTHASKEY_FORMAT.format(date)
          case "DATEASKEY" => DATEASKEY_FORMAT.format(date)
          case "MONTHASKEY" => MONTHASKEY_FORMAT.format(date)
          case "HHMMSS" => HHMMSS_FORMAT.format(date)
          case _ => null
        }
      }else {null}
    }else {
      null
    }
  }

  /**
    * 将yyyy-MM-dd HH:mm:ss时间类型数据转变成integer类型的 yyyyMMdd
    * @param date1
    * @param pattern
    * @return
    */
  def format2Integer(date1: String,pattern: String):Integer = {
    if(date1 != null){
      var dateInt:Integer = 0
      var dateStr1 = format(date1,"DATE")
      var dateStr2 = dateStr1.replaceAll("-","")
      if("yyyyMMdd".equals(pattern)){
        dateInt = Integer.valueOf(dateStr2)
      }else if("yyyyMM".equals(pattern)){
        val monStr = dateStr2.substring(0,6)
        dateInt = Integer.valueOf(monStr)
      }
      dateInt
    }else{
      null
    }
  }

  /**
    * 判断时间time1是否在time2之前
    * @param time1 时间字符串
    * @param time2 时间字符串
    * @return 比较结果
    */
  def before(time1: String, time2:String):Boolean = {
    val dateTime1 = parse(time1);
    val dateTime2 = parse(time2);
    if(dateTime1.before(dateTime2)) true else false
  }

  /**
    * 判断时间time1是否在time2之
    * @param time1 时间字符串
    * @param time2 时间字符串
    * @return 比较结果
    */
  def before(time1: Date, time2:Date):Boolean = {
    if(time1.before(time2)) true else false
  }

  /**
    * 判断时间time1是否在time2之后
    * @param time1 时间字符串
    * @param time2 时间字符串
    * @return 比较结果
    */
  def after(time1: String, time2:String):Boolean = {
    val dateTime1 = parse(time1);
    val dateTime2 = parse(time2);
    if(dateTime1.after(dateTime2)) true else false
  }

  /**
    * 判断时间time1是否在time2之后
    * @param time1 时间字符串
    * @param time2 时间字符串
    * @return 比较结果
    */
  def after(time1: Date, time2:Date):Boolean = {
    if(time1.after(time2)) true else false
  }

  def getMin(time1: String, time2:String):String = {
    val dateTime1 = parse(time1);
    val dateTime2 = parse(time2);
    if(dateTime1.before(dateTime2)) time1 else time2
  }

  /**
    * 判断时间time1是否在time2之
    * @param time1 时间字符串
    * @param time2 时间字符串
    * @return 比较结果
    */
  def getMin(time1: Date, time2:Date):Date = {
    if(time1.before(time2)) time1 else time2
  }

  /**
    * 获取当前日期
    * @return 返回当天日期的字符串:YYYY-MM-DD
    */
  def getTodayDate(): String = {
    DATE_FORMAT.format(new Date())
  }

  /**
    * 获取当前日期
    * @return 返回当天日期的字符串:yyyy-MM-dd HH:mm:ss
    */
  def getTodayDateFormat(): String = {
    format(new Date(),"TIME")
  }

  /**
    * 计算时间差
    * @param time1 时间字符串
    * @param time2 时间字符串
    * @return  时间差的分钟数
    */
  def minus(time1: String, time2: String): java.lang.Double = {
    if(time1 != null && time2 != null) {
      val dateTime1 = parse(time1);
      val dateTime2 = parse(time2);
      if(dateTime1 != null && dateTime2 != null)
        ((dateTime1.getTime - dateTime2.getTime).toDouble/1000/60)
      else null
    }else {
      null
    }

  }

  /**
    * 计算时间差
    * @param time1
    * @param time2
    * @return 时间差秒值
    */
  def seconds(time1: String, time2: String): java.lang.Long ={
    if(time1 != null && time2 != null) {
      val minusD = minus(time1,time2);
      (minusD*60).toLong
    }else {
      null
    }
  }

  /**
    * 计算时间差
    * @param time1 时间字符串
    * @param time2 时间字符串
    * @return  时间差的毫秒数
    */
  def minus(time1: Date, time2: Date): java.lang.Double = {
    if(time1 != null && time2 != null)
      (time1.getTime - time2.getTime).toDouble
    else null

  }

  /**
    * 计算时间为该星期的第几天
    * @param time1 时间
    * @return 返回传入的日期为该星期的第几天:星期一:1,星期二:2，星期三:3，星期四:4，星期五:5，星期六:6，星期日:7
    */
  def dayofweek(time1: Date): Integer = {
    if(time1 != null) {
      var cal = Calendar.getInstance()
      cal.setTime(time1)
      cal.get(Calendar.DAY_OF_WEEK) - 1
    } else {
      null
    }
  }

  /**
    * 计算时间为该星期的第几天
    * @param time1 时间或日期格式的字符串
    * @return 返回传入的日期为该星期的第几天:星期一:1,星期二:2，星期三:3，星期四:4，星期五:5，星期六:6，星期日:7
    */
  def dayofweek(time1: String): Integer = {
    if(time1 != null && !"".equals(time1)) {
      var date = parse(time1)
      if(date != null) {
        var cal = Calendar.getInstance()
        cal.setTime(date)
        cal.get(Calendar.DAY_OF_WEEK) match {
          case 1 => 7
          case x => x - 1
        }
      } else {
        null
      }
    } else {
      null
    }
  }

  /**
    * 对时间增加天数
    * @param time1
    * @param days
    * @return
    */
  def addDays(time1:Date,days:Integer,pattern: String):String = {
    if(time1 != null) {
      var cal = Calendar.getInstance()
      cal.setTime(time1)
      cal.add(Calendar.DATE, days)
      pattern match {
        case "DATE" => format(cal.getTime,"DATE")
        case _ => format(cal.getTime,"TIME")
      }
    } else {
      null
    }
  }

  /**
    * 对时间增加天数
    * @param time1
    * @param days
    * @return
    */
  def addDays(time1:String,days:Integer,pattern: String):String = {
    if(time1 != null && !"".equals(time1)) {
      var time2 = parse(time1)
      if(time2 != null) {
        var cal = Calendar.getInstance()
        cal.setTime(time2)
        cal.add(Calendar.DATE, if(days == null) 0 else days)
        pattern match {
          case "DATE" => format(cal.getTime,"DATE")
          case "DATETIME" => format(cal.getTime,"DATETIME")
          case "DATEASKEY" => format(cal.getTime,"DATEASKEY")
          case _ => format(cal.getTime,"TIME")
        }
      } else {
        null
      }
    }else {
      null
    }
  }

  /**
    * 对时间增加天数且天数为浮点数
    * @param time1
    * @param days
    * @return
    */
  def addDays(time1:String,days:java.lang.Double,pattern: String):String = {
    if(time1 != null && !"".equals(time1)) {
      var time2 = parse(time1)
      if(time2 != null) {
        var cal = Calendar.getInstance()
        cal.setTime(time2)
        cal.add(Calendar.MINUTE, if(days == null) 0 else (days*24*60).toInt)
        pattern match {
          case "DATE" => format(cal.getTime,"DATE")
          case "DATETIME" => format(cal.getTime,"DATETIME")
          case "DATEASKEY" => format(cal.getTime,"DATEASKEY")
          case "MONTHASKEY" => format(cal.getTime,"MONTHASKEY")
          case _ => format(cal.getTime,"TIME")
        }
      } else {
        null
      }
    }else {
      null
    }
  }

  /**
    * 对时间增加月份
    * @param time1
    * @param days
    * @return
    */
  def addMonths(time1:String,days:Integer,pattern: String):String = {
    if(time1 != null && !"".equals(time1)) {
      var time2 = parse(time1)
      if(time2 != null) {
        var cal = Calendar.getInstance()
        cal.setTime(time2)
        cal.add(Calendar.MONTH, if(days == null) 0 else days)
        pattern match {
          case "DATE" => format(cal.getTime,"DATE")
          case "DATEASKEY" => format(cal.getTime,"DATEASKEY")
          case "MONTHASKEY" => format(cal.getTime,"MONTHASKEY")
          case _ => format(cal.getTime,"TIME")
        }
      } else {
        null
      }
    }else {
      null
    }
  }

  /**
    * 对时间增加月份
    * @param time1
    * @param days
    * @return
    */
  def addMonths(time1:Date,days:Integer,pattern: String):String = {
    if(time1 != null && !"".equals(time1)) {
      var cal = Calendar.getInstance()
      cal.setTime(time1)
      cal.add(Calendar.MONTH, if(days == null) 0 else days)
      pattern match {
        case "DATE" => format(cal.getTime,"DATE")
        case "YYYYMM" => format(cal.getTime,"MONTHASKEY")
        case _ => format(cal.getTime,"TIME")
      }
    }else {
      null
    }
  }

  /**
    * 对时间增加小时
    * @param time1
    * @param hours
    * @return
    */
  def addHours(time1:Date,hours:Integer,pattern: String):String = {
    if(time1 != null) {
      var cal = Calendar.getInstance()
      cal.setTime(time1)
      cal.add(Calendar.HOUR, if(hours==null) 0 else hours)
      pattern match {
        case "DATE" => format(cal.getTime,"DATE")
        case _ => format(cal.getTime,"TIME")
      }
    } else {
      null
    }

  }

  /**
    * 对时间增加小时
    * @param time1
    * @param hours
    * @return
    */
  def addHours(time1:String,hours:String,pattern: String):String = {
    val hour = hours.toDouble
    addHours(time1,hour,pattern)
  }

  /**
    * 对时间增加小时
    * @param time1
    * @param hours
    * @return
    */
  def addHours(time1:String,hours:Integer,pattern: String):String = {
    if(time1 != null && !"".equals(time1)) {
      var cal = Calendar.getInstance()
      var time2 = parse(time1)
      cal.setTime(time2)
      cal.add(Calendar.HOUR, if(hours==null) 0 else hours)
      pattern match {
        case "DATE" => format(cal.getTime,"DATE")
        case _ => format(cal.getTime,"TIME")
      }
    } else {
      null
    }

  }
  /**
    * 对时间增加小时（小时的类型为浮点数）
    * @param time1 参数可以为 2018-03-23 12:00:00 [√] | 12:00:00 [√] | 120000[这种格式有问题]
    * @param hours
    * @return
    */

  def addHours(time1:String,hours:java.lang.Double,pattern: String):String = {
    if(time1 != null && !"".equals(time1)) {
      var cal = Calendar.getInstance()
      var time2 = parse(time1)
      cal.setTime(time2)
      cal.add(Calendar.SECOND, if(hours==null) 0 else Math.round(hours*60*60).toInt)
      pattern match {
        case "DATE" => format(cal.getTime,"DATE")
        case _ => format(cal.getTime,"TIME")
      }
    } else {
      null
    }

  }

  /**
    * 对时间增加秒（传入参数为小时，小时的类型为浮点数）
    * @param time1
    * @param hours
    * @return
    */

  def addSeconds(time1:String,hours:java.lang.Double,pattern: String):String = {
    if(time1 != null && !"".equals(time1)) {
      var cal = Calendar.getInstance()
      var time2 = parse(time1)
      cal.setTime(time2)
      cal.add(Calendar.SECOND, if(hours==null) 0 else (hours*3600).toInt)
      pattern match {
        case "DATE" => format(cal.getTime,"DATE")
        case _ => format(cal.getTime,"TIME")
      }
    } else {
      null
    }

  }

  /**
    * 对时间增加分钟
    * @param time1
    * @param minutes
    * @return
    */
  def addMinutes(time1:String,minutes:Integer,pattern: String):String = {
    if(time1 != null && !"".equals(time1)) {
      var cal = Calendar.getInstance()
      var time2 = parse(time1)
      cal.setTime(time2)
      cal.add(Calendar.MINUTE, if(minutes==null) 0 else minutes)
      pattern match {
        case "DATE" => format(cal.getTime,"DATE")
        case _ => format(cal.getTime,"TIME")
      }
    } else {
      null
    }

  }

  /**
    * 对时间增加秒
    * @param time1
    * @param seconds
    * @return
    */

  def addSeconds(time1:String,seconds:Integer,pattern: String):String = {
    if(time1 != null && !"".equals(time1)) {
      var cal = Calendar.getInstance()
      var time2 = parse(time1)
      cal.setTime(time2)
      cal.add(Calendar.SECOND, if(seconds==null) 0 else seconds)
      pattern match {
        case "DATE" => format(cal.getTime,"DATE")
        case _ => format(cal.getTime,"TIME")
      }
    } else {
      null
    }
  }

  /**
    * 求取时间的范围
    * @param startTime 开始时间
    * @param endTime 结束时间
    * @return 格式 '20170701','20170702','20170703'
    */
  def getTimeRange(startTime:String,endTime:String):String = {
    val timeRange = ArrayBuffer[String]()
    var v_startTime = parse(startTime)
    var v_endTime = parse(endTime)
    while (v_startTime!= null && v_endTime != null && minus(v_startTime,v_endTime) <= 0) {
      timeRange += "'"+format(v_startTime,"DATEASKEY")+"'"
      v_startTime = parse(addDays(v_startTime,1,"TIME"))
    }

    timeRange.mkString(",")
  }


  /**
    * 求取时间的范围
    * @param startTime 开始时间
    * @param endTime 结束时间
    * @return 格式 '20170701','20170702','20170703'
    */
  def getMonthRange(startTime:String,endTime:String):String = {
    val timeRange = ArrayBuffer[String]()
    var v_startTime = parse(startTime)
    var v_endTime = parse(endTime)
    while (v_startTime!= null && v_endTime != null && minus(v_startTime,v_endTime) <= 0) {
      timeRange += "'"+format(v_startTime,"MONTHASKEY")+"'"
      v_startTime = parse(addMonths(v_startTime,1,"YYYYMM"))
    }

    timeRange.mkString(",")
  }

  /**
    * 取给定月份的第一天
    * @param year_month_day 给定的年月日 格式 '2017-08-01'
    * @return 格式 '2017-08-01'
    */
  def getFirstDayOfMonth(year_month_day: String): String = {
    if(year_month_day != null && !"".equals(year_month_day)){
      year_month_day.substring(0,8)+"01"
    }else{
      null
    }
  }

  /**
    * 取给定月份的最后一天
    * @param year_month_day 给定的年月日
    * @return 格式 '2017-08-31'
    */
  def getLastDayOfMonth(year_month_day: String): String = {
    if(year_month_day != null && !"".equals(year_month_day)){
      var firstDayOfMonth = getFirstDayOfMonth(year_month_day)
      var dt_firstDayOfMonth = parse(firstDayOfMonth)
      var dt_firstDayOfNextMonth = addMonths(dt_firstDayOfMonth,1,"DATE")
      addDays(parse(dt_firstDayOfNextMonth),-1,"DATE")
    }else{
      null
    }
  }

  def getWeekOfDate(date: Date): String = {
    if(null == date){
      ""
    }else{
      val calendar = Calendar.getInstance()
      calendar.setTime(date)
      val weekDay = calendar.get(Calendar.DAY_OF_WEEK)
      if(Calendar.MONDAY == weekDay) {
        "MONDAY"
      }else if(Calendar.TUESDAY == weekDay) {
        "TUESDAY"
      }else if(Calendar.WEDNESDAY == weekDay) {
        "WEDNESDAY"
      }else if(Calendar.THURSDAY == weekDay) {
        "THURSDAY"
      }else if(Calendar.FRIDAY == weekDay) {
        "FRIDAY"
      }else if(Calendar.SATURDAY == weekDay) {
        "SATURDAY"
      }else if(Calendar.SUNDAY == weekDay) {
        "SUNDAY"
      }else{
        ""
      }
    }

  }
  //获取时间戳
  def getTimeStamp(time:String): String ={
    val format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    if(time != null && !"".equals(time)){
      val tt = format.parse(time).getTime
      tt.toString
    }else{
      null
    }
  }

  /**
    * 给出秒值 转换成对应的 时分秒 字符串
    * @param sec
    * @return
    */
  def secondsToHHMMSS(sec: Double): String ={
    if(null != sec){
      val seconds = Math.round(sec)
      //取余
      val leaveSec = seconds % 3600
      val lastSec = leaveSec % 60
      val hour = (seconds - leaveSec) / 3600
      val minus = (leaveSec - lastSec) / 60
      numToTimeStr(hour) + ":" + numToTimeStr(minus) + ":" + numToTimeStr(lastSec)
    }else{
      null
    }

  }

  /**
    * 数值转时间点字符串 个位数前+0
    * @param time
    * @return
    */
  def numToTimeStr(time: Long): String = {
    if(time != null){
      if(time.toString.toCharArray.size == 1){
        "0" + time.toString
      }else{
        time.toString
      }
    }else{
      null
    }
  }

  /**
    * 给出时分秒字符串 转换成对应的秒值
    * @param hhmmss
    * @return
    */
  def hhmmssToSeconds(hhmmss: String): Long ={
    if(null != hhmmss && !"".equals(hhmmss) && !"-".equals(hhmmss)){
      val hmsArr = hhmmss.split(":")
      val hhSeconds = Integer.valueOf(hmsArr(0))*3600
      val mmSeconds = Integer.valueOf(hmsArr(1))*60
      val ssSeconds = Integer.valueOf(hmsArr(2))
      (hhSeconds + mmSeconds + ssSeconds).toLong
    }else{
      0
    }

  }

  def main(args: Array[String]) {
    //    println(seconds("2019-03-11 12:00:00", ""))
    println(hhmmssToSeconds("01:01:01"))
  }

}
