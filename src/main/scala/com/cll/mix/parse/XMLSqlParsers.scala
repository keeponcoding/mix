package com.cll.mix.parse

import scala.collection.mutable
import scala.util.parsing.combinator.RegexParsers
import scala.xml.XML

/**
  * @ClassName XMLSqlParsers
  * @Description xml 解析类
  *             解析指定文件夹下面的xml文件
  *             根据 指定文件以及sqlid 获取对应的sql文本
  * @Author cll
  * @Date 2019-07-25 14:38
  * @Version 1.0
  **/
class XMLSqlParsers(filename:String)  extends RegexParsers with SqlParsers {

  override val whiteSpace = "".r

  /**
    * 该方法用于从配置文件中读取sql信息
    * @param source
    * @tparam U
    * @return
    */
  override def getSqlInfo[U](source: U): String = {
    val is = this.getClass.getClassLoader.getResourceAsStream("mapper-xml/" + filename)
    val xmlFile = XML.load(is)

    //获取所有"select"节点
    val selects = xmlFile \ "select"
    var sql = ""

    //获取指定编号的sql片段
    for(s <- selects if (s \ "@uniquifiedid").text == source )
      sql = s.child.text

    if(sql != null && sql != "") sql = sql.trim

    sql
  }

  /**
    * 解析sql文本并替换其中出现的变量
    * @param sqlId  sql编号
    * @param params 参数集合(参数名1->参数值1,参数名2->参数值2)
    * @return 返回解析后的sql
    */
  override def parserSql(sqlId: String, params:mutable.HashMap[String,String] = null): String = {
    var sql = getSqlInfo(sqlId)

    //定义正则表达式匹配的模式
    val words = "([\\d\\w\\s,<>=!)*.+|'(_:-]|[%/]|[（）]|[【】]|[、]|[\\u4E00-\\u9FFF]|[\"])+".r

    def expr:Parser[String] = factor ~ opt(expr) ^^ {
      case t ~ Some(e) => t + e
      case t ~ None => t
    }

    def term:Parser[String] = factor

    def factor:Parser[String] = words ^^ {x => x} | "{" ~ expr ~ "}" ^^ {
      case "{" ~ t ~ "}" => {if(params != null) params.getOrElse(t,"") else "''"}
    }

    val result = this.parseAll(expr,sql)

    result.successful match {
      case true => result.get
      case _ => "Parser sql from xml file Fail." + result.get
    }
  }
}

object XMLSqlParsers{
  def apply(filename: String): XMLSqlParsers = new XMLSqlParsers(filename)
}
