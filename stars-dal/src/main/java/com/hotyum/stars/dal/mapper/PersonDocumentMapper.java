package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.PersonDocument;
import com.hotyum.stars.dal.model.PersonDocumentExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PersonDocumentMapper {
    @SelectProvider(type=PersonDocumentSqlProvider.class, method="countByExample")
    long countByExample(PersonDocumentExample example);

    @DeleteProvider(type=PersonDocumentSqlProvider.class, method="deleteByExample")
    int deleteByExample(PersonDocumentExample example);

    @Delete({
        "delete from person_document",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into person_document (document_code, customer_name, ",
        "trade_platform, trade_account, ",
        "wheather_get_money, get_money_date, ",
        "certificate_type, certificate_number, ",
        "contract_date, product_id, ",
        "product_type_name, product_rate, ",
        "service_date, buy_num, ",
        "investment_amount, estimated_earnings, ",
        "contract_income, contact_phone, ",
        "register_email, agent_code, ",
        "derect_recomand_person_id, derect_recomand_person_name, ",
        "inderect_recomand_person_id, inderect_recomand_person_name, ",
        "gmt_create, gmt_modify, ",
        "status, user_id, ",
        "document_index)",
        "values (#{documentCode,jdbcType=VARCHAR}, #{customerName,jdbcType=VARCHAR}, ",
        "#{tradePlatform,jdbcType=VARCHAR}, #{tradeAccount,jdbcType=VARCHAR}, ",
        "#{wheatherGetMoney,jdbcType=TINYINT}, #{getMoneyDate,jdbcType=TIMESTAMP}, ",
        "#{certificateType,jdbcType=TINYINT}, #{certificateNumber,jdbcType=VARCHAR}, ",
        "#{contractDate,jdbcType=TIMESTAMP}, #{productId,jdbcType=INTEGER}, ",
        "#{productTypeName,jdbcType=VARCHAR}, #{productRate,jdbcType=VARCHAR}, ",
        "#{serviceDate,jdbcType=TINYINT}, #{buyNum,jdbcType=INTEGER}, ",
        "#{investmentAmount,jdbcType=DECIMAL}, #{estimatedEarnings,jdbcType=DECIMAL}, ",
        "#{contractIncome,jdbcType=DECIMAL}, #{contactPhone,jdbcType=VARCHAR}, ",
        "#{registerEmail,jdbcType=VARCHAR}, #{agentCode,jdbcType=VARCHAR}, ",
        "#{derectRecomandPersonId,jdbcType=INTEGER}, #{derectRecomandPersonName,jdbcType=VARCHAR}, ",
        "#{inderectRecomandPersonId,jdbcType=INTEGER}, #{inderectRecomandPersonName,jdbcType=VARCHAR}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP}, ",
        "#{status,jdbcType=TINYINT}, #{userId,jdbcType=INTEGER}, ",
        "#{documentIndex,jdbcType=INTEGER})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(PersonDocument record);

    @InsertProvider(type=PersonDocumentSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(PersonDocument record);

    @SelectProvider(type=PersonDocumentSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="document_code", property="documentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_platform", property="tradePlatform", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_account", property="tradeAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="wheather_get_money", property="wheatherGetMoney", jdbcType=JdbcType.TINYINT),
        @Result(column="get_money_date", property="getMoneyDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="certificate_type", property="certificateType", jdbcType=JdbcType.TINYINT),
        @Result(column="certificate_number", property="certificateNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_date", property="contractDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_type_name", property="productTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_rate", property="productRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_date", property="serviceDate", jdbcType=JdbcType.TINYINT),
        @Result(column="buy_num", property="buyNum", jdbcType=JdbcType.INTEGER),
        @Result(column="investment_amount", property="investmentAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="estimated_earnings", property="estimatedEarnings", jdbcType=JdbcType.DECIMAL),
        @Result(column="contract_income", property="contractIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="register_email", property="registerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="derect_recomand_person_id", property="derectRecomandPersonId", jdbcType=JdbcType.INTEGER),
        @Result(column="derect_recomand_person_name", property="derectRecomandPersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="inderect_recomand_person_id", property="inderectRecomandPersonId", jdbcType=JdbcType.INTEGER),
        @Result(column="inderect_recomand_person_name", property="inderectRecomandPersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="document_index", property="documentIndex", jdbcType=JdbcType.INTEGER)
    })
    List<PersonDocument> selectByExample(PersonDocumentExample example);

    @Select({
        "select",
        "id, document_code, customer_name, trade_platform, trade_account, wheather_get_money, ",
        "get_money_date, certificate_type, certificate_number, contract_date, product_id, ",
        "product_type_name, product_rate, service_date, buy_num, investment_amount, estimated_earnings, ",
        "contract_income, contact_phone, register_email, agent_code, derect_recomand_person_id, ",
        "derect_recomand_person_name, inderect_recomand_person_id, inderect_recomand_person_name, ",
        "gmt_create, gmt_modify, status, user_id, document_index",
        "from person_document",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="document_code", property="documentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="customer_name", property="customerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_platform", property="tradePlatform", jdbcType=JdbcType.VARCHAR),
        @Result(column="trade_account", property="tradeAccount", jdbcType=JdbcType.VARCHAR),
        @Result(column="wheather_get_money", property="wheatherGetMoney", jdbcType=JdbcType.TINYINT),
        @Result(column="get_money_date", property="getMoneyDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="certificate_type", property="certificateType", jdbcType=JdbcType.TINYINT),
        @Result(column="certificate_number", property="certificateNumber", jdbcType=JdbcType.VARCHAR),
        @Result(column="contract_date", property="contractDate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="product_id", property="productId", jdbcType=JdbcType.INTEGER),
        @Result(column="product_type_name", property="productTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="product_rate", property="productRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_date", property="serviceDate", jdbcType=JdbcType.TINYINT),
        @Result(column="buy_num", property="buyNum", jdbcType=JdbcType.INTEGER),
        @Result(column="investment_amount", property="investmentAmount", jdbcType=JdbcType.DECIMAL),
        @Result(column="estimated_earnings", property="estimatedEarnings", jdbcType=JdbcType.DECIMAL),
        @Result(column="contract_income", property="contractIncome", jdbcType=JdbcType.DECIMAL),
        @Result(column="contact_phone", property="contactPhone", jdbcType=JdbcType.VARCHAR),
        @Result(column="register_email", property="registerEmail", jdbcType=JdbcType.VARCHAR),
        @Result(column="agent_code", property="agentCode", jdbcType=JdbcType.VARCHAR),
        @Result(column="derect_recomand_person_id", property="derectRecomandPersonId", jdbcType=JdbcType.INTEGER),
        @Result(column="derect_recomand_person_name", property="derectRecomandPersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="inderect_recomand_person_id", property="inderectRecomandPersonId", jdbcType=JdbcType.INTEGER),
        @Result(column="inderect_recomand_person_name", property="inderectRecomandPersonName", jdbcType=JdbcType.VARCHAR),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="user_id", property="userId", jdbcType=JdbcType.INTEGER),
        @Result(column="document_index", property="documentIndex", jdbcType=JdbcType.INTEGER)
    })
    PersonDocument selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PersonDocumentSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PersonDocument record, @Param("example") PersonDocumentExample example);

    @UpdateProvider(type=PersonDocumentSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PersonDocument record, @Param("example") PersonDocumentExample example);

    @UpdateProvider(type=PersonDocumentSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PersonDocument record);

    @Update({
        "update person_document",
        "set document_code = #{documentCode,jdbcType=VARCHAR},",
          "customer_name = #{customerName,jdbcType=VARCHAR},",
          "trade_platform = #{tradePlatform,jdbcType=VARCHAR},",
          "trade_account = #{tradeAccount,jdbcType=VARCHAR},",
          "wheather_get_money = #{wheatherGetMoney,jdbcType=TINYINT},",
          "get_money_date = #{getMoneyDate,jdbcType=TIMESTAMP},",
          "certificate_type = #{certificateType,jdbcType=TINYINT},",
          "certificate_number = #{certificateNumber,jdbcType=VARCHAR},",
          "contract_date = #{contractDate,jdbcType=TIMESTAMP},",
          "product_id = #{productId,jdbcType=INTEGER},",
          "product_type_name = #{productTypeName,jdbcType=VARCHAR},",
          "product_rate = #{productRate,jdbcType=VARCHAR},",
          "service_date = #{serviceDate,jdbcType=TINYINT},",
          "buy_num = #{buyNum,jdbcType=INTEGER},",
          "investment_amount = #{investmentAmount,jdbcType=DECIMAL},",
          "estimated_earnings = #{estimatedEarnings,jdbcType=DECIMAL},",
          "contract_income = #{contractIncome,jdbcType=DECIMAL},",
          "contact_phone = #{contactPhone,jdbcType=VARCHAR},",
          "register_email = #{registerEmail,jdbcType=VARCHAR},",
          "agent_code = #{agentCode,jdbcType=VARCHAR},",
          "derect_recomand_person_id = #{derectRecomandPersonId,jdbcType=INTEGER},",
          "derect_recomand_person_name = #{derectRecomandPersonName,jdbcType=VARCHAR},",
          "inderect_recomand_person_id = #{inderectRecomandPersonId,jdbcType=INTEGER},",
          "inderect_recomand_person_name = #{inderectRecomandPersonName,jdbcType=VARCHAR},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "status = #{status,jdbcType=TINYINT},",
          "user_id = #{userId,jdbcType=INTEGER},",
          "document_index = #{documentIndex,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PersonDocument record);
}