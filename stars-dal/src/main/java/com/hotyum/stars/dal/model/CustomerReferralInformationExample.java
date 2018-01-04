package com.hotyum.stars.dal.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CustomerReferralInformationExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerReferralInformationExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNull() {
            addCriterion("gmt_create is null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIsNotNull() {
            addCriterion("gmt_create is not null");
            return (Criteria) this;
        }

        public Criteria andGmtCreateEqualTo(Date value) {
            addCriterion("gmt_create =", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotEqualTo(Date value) {
            addCriterion("gmt_create <>", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThan(Date value) {
            addCriterion("gmt_create >", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_create >=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThan(Date value) {
            addCriterion("gmt_create <", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateLessThanOrEqualTo(Date value) {
            addCriterion("gmt_create <=", value, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateIn(List<Date> values) {
            addCriterion("gmt_create in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotIn(List<Date> values) {
            addCriterion("gmt_create not in", values, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateBetween(Date value1, Date value2) {
            addCriterion("gmt_create between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtCreateNotBetween(Date value1, Date value2) {
            addCriterion("gmt_create not between", value1, value2, "gmtCreate");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNull() {
            addCriterion("gmt_modify is null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIsNotNull() {
            addCriterion("gmt_modify is not null");
            return (Criteria) this;
        }

        public Criteria andGmtModifyEqualTo(Date value) {
            addCriterion("gmt_modify =", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotEqualTo(Date value) {
            addCriterion("gmt_modify <>", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThan(Date value) {
            addCriterion("gmt_modify >", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyGreaterThanOrEqualTo(Date value) {
            addCriterion("gmt_modify >=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThan(Date value) {
            addCriterion("gmt_modify <", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyLessThanOrEqualTo(Date value) {
            addCriterion("gmt_modify <=", value, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyIn(List<Date> values) {
            addCriterion("gmt_modify in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotIn(List<Date> values) {
            addCriterion("gmt_modify not in", values, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyBetween(Date value1, Date value2) {
            addCriterion("gmt_modify between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andGmtModifyNotBetween(Date value1, Date value2) {
            addCriterion("gmt_modify not between", value1, value2, "gmtModify");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(Byte value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Byte value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Byte value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Byte value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Byte value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Byte value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Byte> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Byte> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Byte value1, Byte value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Byte value1, Byte value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdIsNull() {
            addCriterion("direct_recommendation_id is null");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdIsNotNull() {
            addCriterion("direct_recommendation_id is not null");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdEqualTo(Integer value) {
            addCriterion("direct_recommendation_id =", value, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdNotEqualTo(Integer value) {
            addCriterion("direct_recommendation_id <>", value, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdGreaterThan(Integer value) {
            addCriterion("direct_recommendation_id >", value, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("direct_recommendation_id >=", value, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdLessThan(Integer value) {
            addCriterion("direct_recommendation_id <", value, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdLessThanOrEqualTo(Integer value) {
            addCriterion("direct_recommendation_id <=", value, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdIn(List<Integer> values) {
            addCriterion("direct_recommendation_id in", values, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdNotIn(List<Integer> values) {
            addCriterion("direct_recommendation_id not in", values, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdBetween(Integer value1, Integer value2) {
            addCriterion("direct_recommendation_id between", value1, value2, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("direct_recommendation_id not between", value1, value2, "directRecommendationId");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameIsNull() {
            addCriterion("direct_recommendation_name is null");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameIsNotNull() {
            addCriterion("direct_recommendation_name is not null");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameEqualTo(String value) {
            addCriterion("direct_recommendation_name =", value, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameNotEqualTo(String value) {
            addCriterion("direct_recommendation_name <>", value, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameGreaterThan(String value) {
            addCriterion("direct_recommendation_name >", value, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameGreaterThanOrEqualTo(String value) {
            addCriterion("direct_recommendation_name >=", value, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameLessThan(String value) {
            addCriterion("direct_recommendation_name <", value, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameLessThanOrEqualTo(String value) {
            addCriterion("direct_recommendation_name <=", value, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameLike(String value) {
            addCriterion("direct_recommendation_name like", value, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameNotLike(String value) {
            addCriterion("direct_recommendation_name not like", value, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameIn(List<String> values) {
            addCriterion("direct_recommendation_name in", values, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameNotIn(List<String> values) {
            addCriterion("direct_recommendation_name not in", values, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameBetween(String value1, String value2) {
            addCriterion("direct_recommendation_name between", value1, value2, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andDirectRecommendationNameNotBetween(String value1, String value2) {
            addCriterion("direct_recommendation_name not between", value1, value2, "directRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdIsNull() {
            addCriterion("indirect_recommendation_id is null");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdIsNotNull() {
            addCriterion("indirect_recommendation_id is not null");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdEqualTo(Integer value) {
            addCriterion("indirect_recommendation_id =", value, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdNotEqualTo(Integer value) {
            addCriterion("indirect_recommendation_id <>", value, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdGreaterThan(Integer value) {
            addCriterion("indirect_recommendation_id >", value, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("indirect_recommendation_id >=", value, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdLessThan(Integer value) {
            addCriterion("indirect_recommendation_id <", value, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdLessThanOrEqualTo(Integer value) {
            addCriterion("indirect_recommendation_id <=", value, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdIn(List<Integer> values) {
            addCriterion("indirect_recommendation_id in", values, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdNotIn(List<Integer> values) {
            addCriterion("indirect_recommendation_id not in", values, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdBetween(Integer value1, Integer value2) {
            addCriterion("indirect_recommendation_id between", value1, value2, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationIdNotBetween(Integer value1, Integer value2) {
            addCriterion("indirect_recommendation_id not between", value1, value2, "indirectRecommendationId");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameIsNull() {
            addCriterion("indirect_recommendation_name is null");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameIsNotNull() {
            addCriterion("indirect_recommendation_name is not null");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameEqualTo(String value) {
            addCriterion("indirect_recommendation_name =", value, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameNotEqualTo(String value) {
            addCriterion("indirect_recommendation_name <>", value, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameGreaterThan(String value) {
            addCriterion("indirect_recommendation_name >", value, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameGreaterThanOrEqualTo(String value) {
            addCriterion("indirect_recommendation_name >=", value, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameLessThan(String value) {
            addCriterion("indirect_recommendation_name <", value, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameLessThanOrEqualTo(String value) {
            addCriterion("indirect_recommendation_name <=", value, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameLike(String value) {
            addCriterion("indirect_recommendation_name like", value, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameNotLike(String value) {
            addCriterion("indirect_recommendation_name not like", value, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameIn(List<String> values) {
            addCriterion("indirect_recommendation_name in", values, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameNotIn(List<String> values) {
            addCriterion("indirect_recommendation_name not in", values, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameBetween(String value1, String value2) {
            addCriterion("indirect_recommendation_name between", value1, value2, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andIndirectRecommendationNameNotBetween(String value1, String value2) {
            addCriterion("indirect_recommendation_name not between", value1, value2, "indirectRecommendationName");
            return (Criteria) this;
        }

        public Criteria andContractNumIsNull() {
            addCriterion("contract_num is null");
            return (Criteria) this;
        }

        public Criteria andContractNumIsNotNull() {
            addCriterion("contract_num is not null");
            return (Criteria) this;
        }

        public Criteria andContractNumEqualTo(Integer value) {
            addCriterion("contract_num =", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotEqualTo(Integer value) {
            addCriterion("contract_num <>", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumGreaterThan(Integer value) {
            addCriterion("contract_num >", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("contract_num >=", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLessThan(Integer value) {
            addCriterion("contract_num <", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumLessThanOrEqualTo(Integer value) {
            addCriterion("contract_num <=", value, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumIn(List<Integer> values) {
            addCriterion("contract_num in", values, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotIn(List<Integer> values) {
            addCriterion("contract_num not in", values, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumBetween(Integer value1, Integer value2) {
            addCriterion("contract_num between", value1, value2, "contractNum");
            return (Criteria) this;
        }

        public Criteria andContractNumNotBetween(Integer value1, Integer value2) {
            addCriterion("contract_num not between", value1, value2, "contractNum");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}