package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.CustomerReferralInformation;
import com.hotyum.stars.dal.model.CustomerReferralInformationExample.Criteria;
import com.hotyum.stars.dal.model.CustomerReferralInformationExample.Criterion;
import com.hotyum.stars.dal.model.CustomerReferralInformationExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class CustomerReferralInformationSqlProvider {

    public String countByExample(CustomerReferralInformationExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("customer_referral_information");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(CustomerReferralInformationExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("customer_referral_information");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(CustomerReferralInformation record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("customer_referral_information");
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.VALUES("gmt_modify", "#{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getContractNum() != null) {
            sql.VALUES("contract_num", "#{contractNum,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.VALUES("type", "#{type,jdbcType=TINYINT}");
        }
        
        if (record.getRecommendationUsId() != null) {
            sql.VALUES("recommendation_us_id", "#{recommendationUsId,jdbcType=INTEGER}");
        }
        
        if (record.getRecommendationUserName() != null) {
            sql.VALUES("recommendation_user_name", "#{recommendationUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getUsId() != null) {
            sql.VALUES("us_id", "#{usId,jdbcType=INTEGER}");
        }
        
        return sql.toString();
    }

    public String selectByExample(CustomerReferralInformationExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.SELECT("status");
        sql.SELECT("contract_num");
        sql.SELECT("type");
        sql.SELECT("recommendation_us_id");
        sql.SELECT("recommendation_user_name");
        sql.SELECT("us_id");
        sql.FROM("customer_referral_information");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        CustomerReferralInformation record = (CustomerReferralInformation) parameter.get("record");
        CustomerReferralInformationExample example = (CustomerReferralInformationExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("customer_referral_information");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{record.status,jdbcType=TINYINT}");
        }
        
        if (record.getContractNum() != null) {
            sql.SET("contract_num = #{record.contractNum,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{record.type,jdbcType=TINYINT}");
        }
        
        if (record.getRecommendationUsId() != null) {
            sql.SET("recommendation_us_id = #{record.recommendationUsId,jdbcType=INTEGER}");
        }
        
        if (record.getRecommendationUserName() != null) {
            sql.SET("recommendation_user_name = #{record.recommendationUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getUsId() != null) {
            sql.SET("us_id = #{record.usId,jdbcType=INTEGER}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("customer_referral_information");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("contract_num = #{record.contractNum,jdbcType=INTEGER}");
        sql.SET("type = #{record.type,jdbcType=TINYINT}");
        sql.SET("recommendation_us_id = #{record.recommendationUsId,jdbcType=INTEGER}");
        sql.SET("recommendation_user_name = #{record.recommendationUserName,jdbcType=VARCHAR}");
        sql.SET("us_id = #{record.usId,jdbcType=INTEGER}");
        
        CustomerReferralInformationExample example = (CustomerReferralInformationExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(CustomerReferralInformation record) {
        SQL sql = new SQL();
        sql.UPDATE("customer_referral_information");
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getContractNum() != null) {
            sql.SET("contract_num = #{contractNum,jdbcType=INTEGER}");
        }
        
        if (record.getType() != null) {
            sql.SET("type = #{type,jdbcType=TINYINT}");
        }
        
        if (record.getRecommendationUsId() != null) {
            sql.SET("recommendation_us_id = #{recommendationUsId,jdbcType=INTEGER}");
        }
        
        if (record.getRecommendationUserName() != null) {
            sql.SET("recommendation_user_name = #{recommendationUserName,jdbcType=VARCHAR}");
        }
        
        if (record.getUsId() != null) {
            sql.SET("us_id = #{usId,jdbcType=INTEGER}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, CustomerReferralInformationExample example, boolean includeExamplePhrase) {
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