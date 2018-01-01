package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.Product;
import com.hotyum.stars.dal.model.ProductExample.Criteria;
import com.hotyum.stars.dal.model.ProductExample.Criterion;
import com.hotyum.stars.dal.model.ProductExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ProductSqlProvider {

    public String countByExample(ProductExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("product");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ProductExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("product");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(Product record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("product");
        
        if (record.getProductType() != null) {
            sql.VALUES("product_type", "#{productType,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceTime() != null) {
            sql.VALUES("service_time", "#{serviceTime,jdbcType=TINYINT}");
        }
        
        if (record.getMonthRate() != null) {
            sql.VALUES("month_rate", "#{monthRate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableFlag() != null) {
            sql.VALUES("enable_flag", "#{enableFlag,jdbcType=TINYINT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.VALUES("gmt_modify", "#{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStauts() != null) {
            sql.VALUES("stauts", "#{stauts,jdbcType=TINYINT}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ProductExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("product_type");
        sql.SELECT("service_time");
        sql.SELECT("month_rate");
        sql.SELECT("enable_flag");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.SELECT("stauts");
        sql.FROM("product");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Product record = (Product) parameter.get("record");
        ProductExample example = (ProductExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getProductType() != null) {
            sql.SET("product_type = #{record.productType,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceTime() != null) {
            sql.SET("service_time = #{record.serviceTime,jdbcType=TINYINT}");
        }
        
        if (record.getMonthRate() != null) {
            sql.SET("month_rate = #{record.monthRate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableFlag() != null) {
            sql.SET("enable_flag = #{record.enableFlag,jdbcType=TINYINT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStauts() != null) {
            sql.SET("stauts = #{record.stauts,jdbcType=TINYINT}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("product_type = #{record.productType,jdbcType=VARCHAR}");
        sql.SET("service_time = #{record.serviceTime,jdbcType=TINYINT}");
        sql.SET("month_rate = #{record.monthRate,jdbcType=VARCHAR}");
        sql.SET("enable_flag = #{record.enableFlag,jdbcType=TINYINT}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        sql.SET("stauts = #{record.stauts,jdbcType=TINYINT}");
        
        ProductExample example = (ProductExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Product record) {
        SQL sql = new SQL();
        sql.UPDATE("product");
        
        if (record.getProductType() != null) {
            sql.SET("product_type = #{productType,jdbcType=VARCHAR}");
        }
        
        if (record.getServiceTime() != null) {
            sql.SET("service_time = #{serviceTime,jdbcType=TINYINT}");
        }
        
        if (record.getMonthRate() != null) {
            sql.SET("month_rate = #{monthRate,jdbcType=VARCHAR}");
        }
        
        if (record.getEnableFlag() != null) {
            sql.SET("enable_flag = #{enableFlag,jdbcType=TINYINT}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStauts() != null) {
            sql.SET("stauts = #{stauts,jdbcType=TINYINT}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ProductExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}