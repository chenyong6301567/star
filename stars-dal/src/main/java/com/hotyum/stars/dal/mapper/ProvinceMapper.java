package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.Province;
import com.hotyum.stars.dal.model.ProvinceExample;
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

public interface ProvinceMapper {
    @SelectProvider(type=ProvinceSqlProvider.class, method="countByExample")
    long countByExample(ProvinceExample example);

    @DeleteProvider(type=ProvinceSqlProvider.class, method="deleteByExample")
    int deleteByExample(ProvinceExample example);

    @Delete({
        "delete from province",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into province (province_name, jianpin, ",
        "quanpin, status, ",
        "gmt_create, gmt_modify)",
        "values (#{provinceName,jdbcType=VARCHAR}, #{jianpin,jdbcType=VARCHAR}, ",
        "#{quanpin,jdbcType=VARCHAR}, #{status,jdbcType=TINYINT}, ",
        "#{gmtCreate,jdbcType=TIMESTAMP}, #{gmtModify,jdbcType=TIMESTAMP})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Province record);

    @InsertProvider(type=ProvinceSqlProvider.class, method="insertSelective")
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insertSelective(Province record);

    @SelectProvider(type=ProvinceSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="jianpin", property="jianpin", jdbcType=JdbcType.VARCHAR),
        @Result(column="quanpin", property="quanpin", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    List<Province> selectByExample(ProvinceExample example);

    @Select({
        "select",
        "id, province_name, jianpin, quanpin, status, gmt_create, gmt_modify",
        "from province",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="province_name", property="provinceName", jdbcType=JdbcType.VARCHAR),
        @Result(column="jianpin", property="jianpin", jdbcType=JdbcType.VARCHAR),
        @Result(column="quanpin", property="quanpin", jdbcType=JdbcType.VARCHAR),
        @Result(column="status", property="status", jdbcType=JdbcType.TINYINT),
        @Result(column="gmt_create", property="gmtCreate", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="gmt_modify", property="gmtModify", jdbcType=JdbcType.TIMESTAMP)
    })
    Province selectByPrimaryKey(Integer id);

    @UpdateProvider(type=ProvinceSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Province record, @Param("example") ProvinceExample example);

    @UpdateProvider(type=ProvinceSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Province record, @Param("example") ProvinceExample example);

    @UpdateProvider(type=ProvinceSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Province record);

    @Update({
        "update province",
        "set province_name = #{provinceName,jdbcType=VARCHAR},",
          "jianpin = #{jianpin,jdbcType=VARCHAR},",
          "quanpin = #{quanpin,jdbcType=VARCHAR},",
          "status = #{status,jdbcType=TINYINT},",
          "gmt_create = #{gmtCreate,jdbcType=TIMESTAMP},",
          "gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Province record);
}