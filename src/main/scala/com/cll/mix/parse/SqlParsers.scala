package com.cll.mix.parse

import scala.collection.mutable

/**
  * @ClassName SqlParsers
  * @Description 该特质用于 {@link XMLSqlParsers}
  * @Author cll
  * @Date 2019-07-25 14:39
  * @Version 1.0
  **/
trait SqlParsers {

  // 直接获取sql信息
  def getSqlInfo[U](source: U): String

  // 获取sql信息 并且将sql中的参数填充进去
  def parserSql(sqlId: String, params:mutable.HashMap[String,String] = null): String

}
