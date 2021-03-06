package com.hotyum.stars.dal.mapper;

import com.hotyum.stars.dal.model.ReferralInformation;
import com.hotyum.stars.dal.model.ReferralInformationExample.Criteria;
import com.hotyum.stars.dal.model.ReferralInformationExample.Criterion;
import com.hotyum.stars.dal.model.ReferralInformationExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class ReferralInformationSqlProvider {

    public String countByExample(ReferralInformationExample example) {
        SQL sql = new SQL();
        sql.SELECT("count(*)").FROM("referral_information");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String deleteByExample(ReferralInformationExample example) {
        SQL sql = new SQL();
        sql.DELETE_FROM("referral_information");
        applyWhere(sql, example, false);
        return sql.toString();
    }

    public String insertSelective(ReferralInformation record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("referral_information");
        
        if (record.getUsId() != null) {
            sql.VALUES("us_id", "#{usId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.VALUES("user_name", "#{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getStarDegree() != null) {
            sql.VALUES("star_degree", "#{starDegree,jdbcType=TINYINT}");
        }
        
        if (record.getSumMoney() != null) {
            sql.VALUES("sum_money", "#{sumMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getDirectRewardRate() != null) {
            sql.VALUES("direct_reward_rate", "#{directRewardRate,jdbcType=VARCHAR}");
        }
        
        if (record.getContractNumber() != null) {
            sql.VALUES("contract_number", "#{contractNumber,jdbcType=INTEGER}");
        }
        
        if (record.getReferralNumber() != null) {
            sql.VALUES("referral_number", "#{referralNumber,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.VALUES("gmt_create", "#{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.VALUES("gmt_modify", "#{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.VALUES("status", "#{status,jdbcType=TINYINT}");
        }
        
        if (record.getDirectRecommendationId() != null) {
            sql.VALUES("direct_recommendation_id", "#{directRecommendationId,jdbcType=INTEGER}");
        }
        
        if (record.getDirectRecommendationName() != null) {
            sql.VALUES("direct_recommendation_name", "#{directRecommendationName,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectRecommendationId() != null) {
            sql.VALUES("indirect_recommendation_id", "#{indirectRecommendationId,jdbcType=INTEGER}");
        }
        
        if (record.getIndirectRecommendationName() != null) {
            sql.VALUES("indirect_recommendation_name", "#{indirectRecommendationName,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(ReferralInformationExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("us_id");
        sql.SELECT("user_name");
        sql.SELECT("star_degree");
        sql.SELECT("sum_money");
        sql.SELECT("direct_reward_rate");
        sql.SELECT("contract_number");
        sql.SELECT("referral_number");
        sql.SELECT("gmt_create");
        sql.SELECT("gmt_modify");
        sql.SELECT("status");
        sql.SELECT("direct_recommendation_id");
        sql.SELECT("direct_recommendation_name");
        sql.SELECT("indirect_recommendation_id");
        sql.SELECT("indirect_recommendation_name");
        sql.FROM("referral_information");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        ReferralInformation record = (ReferralInformation) parameter.get("record");
        ReferralInformationExample example = (ReferralInformationExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("referral_information");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getUsId() != null) {
            sql.SET("us_id = #{record.usId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        }
        
        if (record.getStarDegree() != null) {
            sql.SET("star_degree = #{record.starDegree,jdbcType=TINYINT}");
        }
        
        if (record.getSumMoney() != null) {
            sql.SET("sum_money = #{record.sumMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getDirectRewardRate() != null) {
            sql.SET("direct_reward_rate = #{record.directRewardRate,jdbcType=VARCHAR}");
        }
        
        if (record.getContractNumber() != null) {
            sql.SET("contract_number = #{record.contractNumber,jdbcType=INTEGER}");
        }
        
        if (record.getReferralNumber() != null) {
            sql.SET("referral_number = #{record.referralNumber,jdbcType=INTEGER}");
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
        
        if (record.getDirectRecommendationId() != null) {
            sql.SET("direct_recommendation_id = #{record.directRecommendationId,jdbcType=INTEGER}");
        }
        
        if (record.getDirectRecommendationName() != null) {
            sql.SET("direct_recommendation_name = #{record.directRecommendationName,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectRecommendationId() != null) {
            sql.SET("indirect_recommendation_id = #{record.indirectRecommendationId,jdbcType=INTEGER}");
        }
        
        if (record.getIndirectRecommendationName() != null) {
            sql.SET("indirect_recommendation_name = #{record.indirectRecommendationName,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("referral_information");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("us_id = #{record.usId,jdbcType=INTEGER}");
        sql.SET("user_name = #{record.userName,jdbcType=VARCHAR}");
        sql.SET("star_degree = #{record.starDegree,jdbcType=TINYINT}");
        sql.SET("sum_money = #{record.sumMoney,jdbcType=DECIMAL}");
        sql.SET("direct_reward_rate = #{record.directRewardRate,jdbcType=VARCHAR}");
        sql.SET("contract_number = #{record.contractNumber,jdbcType=INTEGER}");
        sql.SET("referral_number = #{record.referralNumber,jdbcType=INTEGER}");
        sql.SET("gmt_create = #{record.gmtCreate,jdbcType=TIMESTAMP}");
        sql.SET("gmt_modify = #{record.gmtModify,jdbcType=TIMESTAMP}");
        sql.SET("status = #{record.status,jdbcType=TINYINT}");
        sql.SET("direct_recommendation_id = #{record.directRecommendationId,jdbcType=INTEGER}");
        sql.SET("direct_recommendation_name = #{record.directRecommendationName,jdbcType=VARCHAR}");
        sql.SET("indirect_recommendation_id = #{record.indirectRecommendationId,jdbcType=INTEGER}");
        sql.SET("indirect_recommendation_name = #{record.indirectRecommendationName,jdbcType=VARCHAR}");
        
        ReferralInformationExample example = (ReferralInformationExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(ReferralInformation record) {
        SQL sql = new SQL();
        sql.UPDATE("referral_information");
        
        if (record.getUsId() != null) {
            sql.SET("us_id = #{usId,jdbcType=INTEGER}");
        }
        
        if (record.getUserName() != null) {
            sql.SET("user_name = #{userName,jdbcType=VARCHAR}");
        }
        
        if (record.getStarDegree() != null) {
            sql.SET("star_degree = #{starDegree,jdbcType=TINYINT}");
        }
        
        if (record.getSumMoney() != null) {
            sql.SET("sum_money = #{sumMoney,jdbcType=DECIMAL}");
        }
        
        if (record.getDirectRewardRate() != null) {
            sql.SET("direct_reward_rate = #{directRewardRate,jdbcType=VARCHAR}");
        }
        
        if (record.getContractNumber() != null) {
            sql.SET("contract_number = #{contractNumber,jdbcType=INTEGER}");
        }
        
        if (record.getReferralNumber() != null) {
            sql.SET("referral_number = #{referralNumber,jdbcType=INTEGER}");
        }
        
        if (record.getGmtCreate() != null) {
            sql.SET("gmt_create = #{gmtCreate,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGmtModify() != null) {
            sql.SET("gmt_modify = #{gmtModify,jdbcType=TIMESTAMP}");
        }
        
        if (record.getStatus() != null) {
            sql.SET("status = #{status,jdbcType=TINYINT}");
        }
        
        if (record.getDirectRecommendationId() != null) {
            sql.SET("direct_recommendation_id = #{directRecommendationId,jdbcType=INTEGER}");
        }
        
        if (record.getDirectRecommendationName() != null) {
            sql.SET("direct_recommendation_name = #{directRecommendationName,jdbcType=VARCHAR}");
        }
        
        if (record.getIndirectRecommendationId() != null) {
            sql.SET("indirect_recommendation_id = #{indirectRecommendationId,jdbcType=INTEGER}");
        }
        
        if (record.getIndirectRecommendationName() != null) {
            sql.SET("indirect_recommendation_name = #{indirectRecommendationName,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, ReferralInformationExample example, boolean includeExamplePhrase) {
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