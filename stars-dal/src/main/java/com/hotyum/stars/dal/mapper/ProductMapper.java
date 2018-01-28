package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.Product;
import com.hotyum.stars.dal.model.ProductExample;
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

public interface ProductMapper {
    @SelectProvider(type=ProductSqlProvider.class, method="countByExample")
    long countByExample(ProductExample example);

    @DeleteProvider(type=ProductSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProductExample example);

    @Delete({
        "delete from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into product (sequence_number, product_type_name, ",
        "service_time, month_rate, ",
        "enable_flag, gmt_create, ",
        "gmt_modify, stauts)",
        "values (#{sequenceNumber,jdbcType=INTEGER}, #{productTypeName,jdbcType=VARCHAR}, ",
        "#{serviceTime,jdbcType=TINYINT}, #{monthRate,jdbcType=VARCHAR}, ",
        "#{enableFlag,jdbcType=TINYINT}, #{gmtCreate,jdbcType=TIMESTAMP}, ",
        "#{gmtModify,jdbcType=TIMESTAMP}, #{stauts,jdbcType=TINYINT})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Product record);

    @InsertProvider(type=ProductSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Product record);

    @SelectProvider(type=ProductSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sequence_number", property="sequenceNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="product_type_name", property="productTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_time", property="serviceTime", jdbcType=JdbcType.TINYINT),
        @Result(column="month_rate", property="monthRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable_flag", property="enableFlag", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stauts", property="stauts", jdbcType=JdbcType.TINYINT)
    })
    List<Product> selectByExample(ProductExample example);

    @Select({
        "select",
        "id, sequence_number, product_type_name, service_time, month_rate, enable_flag, ",
        "gmt_create, gmt_modify, stauts",
        "from product",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="sequence_number", property="sequenceNumber", jdbcType=JdbcType.INTEGER),
        @Result(column="product_type_name", property="productTypeName", jdbcType=JdbcType.VARCHAR),
        @Result(column="service_time", property="serviceTime", jdbcType=JdbcType.TINYINT),
        @Result(column="month_rate", property="monthRate", jdbcType=JdbcType.VARCHAR),
        @Result(column="enable_flag", property="enableFlag", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="stauts", property="stauts", jdbcType=JdbcType.TINYINT)
    })
    Product selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Product record, @Param("example") ProductExample example);

    @UpdateProvider(type=ProductSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Product record);

    @Update({
        "update product",
        "set sequence_number = #{sequenceNumber,jdbcType=INTEGER},",
          "product_type_name = #{productTypeName,jdbcType=VARCHAR},",
          "service_time = #{serviceTime,jdbcType=TINYINT},",
          "month_rate = #{monthRate,jdbcType=VARCHAR},",
          "enable_flag = #{enableFlag,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP},",
          "stauts = #{stauts,jdbcType=TINYINT}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Product record);
}